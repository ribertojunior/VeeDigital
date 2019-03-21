package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ribertojunior <br>
 * Classe contendo as respostas aos testes da Vee Digital, sendo o Teste 1 chamado de A, o Teste 2 chamado de B e o Teste 3 chamado de C.<br>
 * <p>Para escolher qual teste rodar usa-se como primeito argumento o número equivalante de cada teste, 1 para o Teste 1, 2 para o Teste 2, 3 para o Teste 3.</p>
 * 
 * <p>Para o teste <b>1</b> deve-se fornecer mais três argumentos: a palavra que se deseja testar, <b>true</b> ou <b>false</b> para ignorar espaços (false ignora), true ou false para ignorar caixa do texto (false ignora).</p>
 * 
 * <p>Os parâmetros do Teste <b>2</b> são possíveis em duas versões:
 * - Na primeira, são dois parâmetros o número para qual se deve encontrar o complementar no array e o arquivo texto onde se encontra o array (em uma linha, com os elemntos separados por espaço).
 * - Na segunda, temos o temos o mesmo parâmetro da primeira e em seguida <b>k parâmetros</b>, sendo cada um elemento do array.</p>
 * 
 * <p>Para o Teste <b>3</b> temos apenas um parâmetro com o endereço local do arquivo a ser analisado.</p>
 */
public class TesteJava {

	public static void main(String[] args) {
		if (args.length>0) {
			int met = Integer.parseInt(args[0]);
			switch (met) {
			case 1: {
				String ret = " não é ";
				boolean space = false;
				;
				boolean cS = false;
				try {
					space = Boolean.parseBoolean(args[2].trim().toLowerCase());
					cS = Boolean.parseBoolean(args[3].trim().toLowerCase());
				} catch (Exception e) {
					System.out.println("Parâmetro inválido para Teste 1.");
					break;
				}

				if (A(args[1], space, cS)) {
					ret = " é ";
				}
				System.out.println(args[1] + ret + "um palíndromo.");
				break;
			}
			case 2: {
				try {
					int k = Integer.parseInt(args[1]);
					int[] a = {};

					if (args.length > 3) {
						a = new int[args.length - 2];
						for (int i = 0; i < args.length - 2; i++) {
							a[i] = Integer.parseInt(args[i + 2]);
						}
					} else if (args.length == 3) {
						String file = args[2];
						if (!file.contains("\\\\")) {
							file.replace("\\", "\\\\");
						}
						try (BufferedReader b = new BufferedReader(new FileReader(new File(file)))) {
							String line = "";
							String[] aS;
							while ((line = b.readLine()) != null) {
								aS = line.split(" ");
								a = new int[aS.length];
								int i = 0;
								for (String s : aS) {
									a[i] = Integer.parseInt(s);
									i++;
								}
							}

						} catch (FileNotFoundException e) {
							System.out.println("Parâmetro inválido para Teste 2: "+e.getMessage());
							break;
						}

					} else {
						throw new Exception();
					}
					List<Par> p = B(a, k);
					if (p.size()>0) {
						for (Par i : p) {
							System.out.println(i.getI() + " - " + i.getJ());
						} 
					} else {
						System.out.print("Não há pares para "+k+ " em [ ");
						for(int i : a) {
							System.out.print(i+ " ");
						}
						System.out.println("]");
					}
					break;

				} catch (Exception e) {
					System.out.println("Parâmetro inválido para Teste 2.");
					break;
				}

			}
			case 3: {

				if (args.length>1) {
					HashMap<String, Integer> ret = C(args[1]);
					for (String name : ret.keySet()) {

						String key = name.toString();
						String value = ret.get(name).toString();
						System.out.println(key + " " + value);
					} 
				}else {
					System.out.println("Parâmetro inválido para Teste 3.");
				}
				break;
			}
			default: {
				System.out.println("Erro de parâmetro.");
			}

			}
		} else {
			System.out.println("Erro de parâmetro.");
		}

	}


	/**
	 * Test 1 - Verifica se uma string é um palíndromo
	 * @param a String s ser testada
	 * @param space se verdadeiro aceita espaços; se falso os remove da string.
	 * @param caseSensitive se falso ignora diferenças de caixa.
	 * @return  true se a for um palíndromo.
	 */
	public static boolean A(String a, boolean space, boolean caseSensitive) {
		int half = 0;		
		int half2 = 0;

		if (!space) {
			a = a.trim();
			a = a.replaceAll("\\s+","");
		}

		if (!caseSensitive)
			a = a.toLowerCase();

		if (a.length() % 2 == 0) {
			half = a.length() / 2;
			half2 = half;	
		} else {
			half = (a.length()-1) / 2;
			half2 = half + 1;
		}

		List<Character> aList1 = a.substring(0,half).chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		List<Character> aList2 = a.substring(half2,a.length()).chars().mapToObj(e -> (char) e).collect(Collectors.toList());
		for (Character c : aList1) {
			if (aList2.contains(c)) {
				aList2.remove(c);
			}
		}

		if (aList2.size()==0) {
			return true;
		}


		return false;
	}




	/**Test 2 - Encontra os k-complementary pairs.
	 * Esse método implementa um algoritmo O(nLogn), pela ordenação. @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(int[],%20int,%20int)">Arrays.sort(int[])</a>
	 * @param  a arrays de inteiros.
	 * @param k  - inteiro a ser encontrado complementares no array.
	 * @return List de Par - uma lista dos pares complementares.
	 */
	public static List<Par> B(int[] a, int k) {
		Arrays.sort(a);
		int i = 0;
		int j = a.length - 1;
		int soma = 0;
		List<Par> ret = new ArrayList<Par>();		
		while ( i < j) {
			soma  = a[i] + a[j];
			if (soma == k) {
				ret.add(new Par(a[i], a[j]));
				i++;
				j--;
			} else if (soma < k) {
				i++;
			} else {
				j--;
			}
		}
		return ret;
	}	


	/**
	 * Test 3 - Encontra as 50 mil frases mais comuns em um arquivo texto grande.
	 * @param file - arquivo para procura.
	 * @return Um HashMap com as frases e o número de reoetições.
	 */
	public static HashMap<String, Integer> C(String file) {		
		HashMap<String, Integer> pHM = new HashMap<String, Integer>();
		if (!file.contains("\\\\")) {
			file.replace("\\", "\\\\");
		}
		try (BufferedReader b = new BufferedReader(new FileReader(new File(file)))) { 
			String line = "";
			String[] phrases;

			while ((line = b.readLine()) != null) { 
				phrases = line.split("\\|");
				pHM = arrayAsMap(pHM, phrases);

				pHM = pHM.entrySet().stream()
						.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
						.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) ->
						e2,LinkedHashMap::new));


				if (pHM.size()>50000) {
					pHM.keySet().removeAll(Arrays.asList(pHM.keySet().toArray()).subList(50, pHM.size()));


				}


			}

		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado.");
		} catch (IOException e) {
			System.out.println("Erro de IO.");
		}

		return pHM;
	}


	/**
	 * Método que transforma um array de string em um HashMap
	 * @param ret HashMap que irá receber o array.
	 * @param array array a ser adicionado.
	 * @return Um HashMap com as frases e o número de reoetições.
	 */
	protected static HashMap<String, Integer> arrayAsMap( HashMap<String, Integer> ret, String[] array) {
		//HashMap<String, Integer> ret = new HashMap<String, Integer>();
		for (int i = 0; i<array.length; i++) {
			if (ret.containsKey(array[i])){
				ret.replace(array[i], ret.get(array[i])+1);
			} else {
				ret.put(array[i], 1);
			}
		}
		return ret;
	}

}






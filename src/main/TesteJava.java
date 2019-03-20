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
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author @see <a href="github.com/ribertojunior">ribertojunior</a>
 * Classe contendo as respostas aos testes da Vee Digital, sendo o Teste 1 chamado de A, o Teste 2 chamado de B e o Teste 3 chamado de C.
 * Para escolher qual teste rodar usa-se como primeito argumento o n�mero equivalante de cada teste, 1 para o Teste 1, 2 para o Teste 2, 3 para o Teste 3.
 * 
 * Para o teste 1 deve-se fornecer mais tr�s argumentos: a palavra que se deseja testar, true ou false para ignorar espa�os (false ignora), true ou false para ignorar caixa do texto (false ignora).
 * 
 * Os par�metros do Teste 2 s�o poss�veis em duas vers�es:
 * - Na primeira, s�o dois par�metros o n�mero de elementos no array e o arquivo texto onde se encontra o array (em uma linha, com os elemntos separados por espa�o).
 * - Na segunda, temos o primeiro par�metro com o n�meros de elementos no array (ex: k) e em seguida k parametros, sendo cada um elemento do array.
 * 
 * Para o Teste 3 temos apenas um par�metro com o endere�o local do arquivo a ser analisado.
 */
public class TesteJava {

	public static void main(String[] args) {
		int met = Integer.parseInt(args[0]);

		switch (met) {
			case 1 : {
				String ret = " n�o � ";
				boolean space = false;;
				boolean cS =  false;
				try {
					space = Boolean.parseBoolean(args[2].trim().toLowerCase());
					cS = Boolean.parseBoolean(args[3].trim().toLowerCase());
				} catch (Exception e) {
					System.out.println("Par�metro inv�lido para Teste 1.");
					break;
				}
				
				if (A(args[1],space,cS)) {
					ret = " � ";
				}
				System.out.println(args[1] +  ret + "um pal�ndromo.");
				break;
			}
			case 2 : {
				try {
					int k = Integer.parseInt(args[1]);
					int [] a = new int[k];
					
					if (args.length > 3) {
						for (int i = 0; i < k; i++) {
							a[i] = Integer.parseInt(args[i + 2]);
						} 
					} else if (args.length == 3) {
						try (BufferedReader b = new BufferedReader(new FileReader(new File(args[2])))) { 
							String line = "";							
							String[] aS;							
							while ((line = b.readLine()) != null) {
								aS = line.split(" ");
								int i = 0;
								for (String s : aS) {
									a[i] = Integer.parseInt(s);
									i++;
								}
							} 
								
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						
					} else {						
						throw new Exception();
					}
					List<Par> p = B(a,k);
					for (Par i : p) {
						System.out.println(i.getI() + " - " + i.getJ());
					}
					break;
					
				} catch (Exception e) {
					System.out.println("Par�metro inv�lido para Teste 2.");
					break;
				}				
				
			}
			case 3 : {
				
				HashMap<String, Integer> ret = C(args[1]);;
				for (String name: ret.keySet()){

					String key =name.toString();
					String value = ret.get(name).toString();  
					System.out.println(key + " " + value);
				}
				break;
			}
			default : {
				System.out.println("Erro de par�metro.");
			}
			
		}

	}


	/**
	 * Test 1 - Verifica se uma string � um pal�ndromo
	 * @param a - String s ser testada
	 * @param space - boolean; se verdadeiro aceita espa�os; se falso os remove da string.
	 * @param caseSensitive  boolean; se falso ignora diferen�as de caixa.
	 * @return boolean retorna true se a for um pal�ndromo.
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




	/**Test 2 - Encontra os k-complementary paris.
	 * Esse m�todo implementa um algoritmo O(nLogn), pela ordena��o. @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(int[],%20int,%20int)">Arrays.sort(int[])</a>
	 * @param a int[] - arrays de inteiros.
	 * @param k int - inteiro a ser encontrado complementares no array.
	 * @return List<Par> - uma lista dos pares complementares.
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


	/*
	 * 3. Dado um arquivo texto muito grande, que n�o caiba na mem�ria � exemplo: 10GB , encontre as 50 mil frases mais frequentes.
	 * O formato do arquivo s�o Linhas com at� 50 frases divididas por pipe ( �|� ). */



	/**
	 * Test 3 - Encontra as 50 mil frases mais comuns em um arquivo texto grande
	 * @param file - arquivo para procura
	 * @return Um HashMap com as frases e o n�mero de reoeti��es
	 */
	public static HashMap<String, Integer> C(String file) {		
		HashMap<String, Integer> pHM = new HashMap<String, Integer>();
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
			System.out.println("Arquivo n�o encontrado.");
		} catch (IOException e) {
			System.out.println("Erro de IO.");
		}

		return pHM;
	}


	/**
	 * M�todo que transforma um array de string em um HashMap
	 * @param ret
	 * @param array
	 * @return Um HashMap com as frases e o n�mero de reoeti��es
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






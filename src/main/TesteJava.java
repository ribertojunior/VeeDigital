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
 * @author riberto junior
 * Classe contendo as respostas aos testes da Vee Digital,
 * sendo o Teste 1 chamado de A, o Teste 2 chamado de B e o Teste 3 chamado de C.
 *
 */
public class TesteJava {

	public static void main(String[] args) {
		System.out.println("A");
		System.out.println(A("abba", true, true));
		System.out.println(A("abbba", true, true));
		System.out.println(A("abbbA", true, true));
		System.out.println(A("abbbA", true, false));
		System.out.println(A("ab bba", true, true));
		System.out.println(A("ab bba", false, true));
		System.out.println("B");
		List<Par> lp = B(new int[]{0,-1,2,3,4,5,6,7,8,9},5);
		for (Par p : lp) {
			System.out.println(p.getI()+" - "+p.getJ());
		}
	}
	
	
	/**
	 * Test 1 - Verifica se uma string é um palíndromo
	 * @param a - String s ser testada
	 * @param space - boolean; se verdadeiro aceita espaços; se falso os remove da string.
	 * @param caseSensitive  boolean; se falso ignora diferenças de caixa.
	 * @return boolean retorna true se a for um palíndromo.
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
	 * Esse método implementa um algoritmo O(nLogn), pela ordenação. @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(int[],%20int,%20int)">Arrays.sort(int[])</a>
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
	 * 3. Dado um arquivo texto muito grande, que não caiba na memória – exemplo: 10GB , encontre as 50 mil frases mais frequentes.
	 * O formato do arquivo são Linhas com até 50 frases divididas por pipe ( “|” ). */
	
	
	
	public static HashMap<String, Integer> C(String file) {		
		HashMap<String, Integer> pHM = new HashMap<String, Integer>();
		try (BufferedReader b = new BufferedReader(new FileReader(new File(file)))) { 
		   String line = "";
		   String[] phrases;
		   
		   while ((line = b.readLine()) != null) { 
			   phrases = line.split("\\|");
			   pHM.putAll(arrayAsMap(phrases));
				
			   pHM = pHM.entrySet().stream()
				  .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				  .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) ->
				  e2,LinkedHashMap::new));
				 
				
				  if (pHM.size()>5) {
					  pHM.keySet().removeAll(Arrays.asList(pHM.keySet().toArray()).subList(5, pHM.size()));
				  
				  
				  }
				 
		     
		   }
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pHM;
	}
	
	protected static HashMap<String, Integer> arrayAsMap(String[] array) {
        HashMap<String, Integer> ret = new HashMap<String, Integer>();
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






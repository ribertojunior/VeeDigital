package main;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author riber
 *
 */
public class TesteJava {

	public static void main(String[] args) {
		System.out.println(A("abba", true, true));
		System.out.println(A("abbba", true, true));
		System.out.println(A("abbbA", true, true));
		System.out.println(A("abbbA", true, false));
		System.out.println(A("ab bba", true, true));
		System.out.println(A("ab bba", false, true));
	}
	
	
	/**
	 * Testa se uma string é um palíndromo
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
	

}

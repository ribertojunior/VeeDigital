package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

import main.Par;
import main.TesteJava;


class TesteJavaUnitTest  {	
	

	@Test
	void testAWord() {
		
		String pal[] = {
				"aibohphobia",
				"alula",
				"cammac",
				"civic",
				"deified",
				"deleveled",
				"detartrated",
				"devoved",
				"a a"
		};
		for (String s : pal) {
			assertTrue(TesteJava.A(s, true, true));
		}
		
		String pal2[] = {
				"aiboxphobia",
				"aluva",
				"aammac",
				"ccvic",
				"dexfied",
				"delvveled",
				"detgrtrated",
				"devovez"				
		};
		for (String s : pal2) {
			assertFalse(TesteJava.A(s, true, true));
		}
		
	}
	
	@Test
	void testAPhrase() {
		String f1[] = {
				"Able was I ere I saw Elba",
				"Bombard a drab mob",
				"Delia saw I was ailed",
				"Denim axes examined",
				"Lepers repel"				
		};
		for (String s : f1) {
			assertTrue(TesteJava.A(s, false, false));
		}
		
		String f2[] = {
				"Able was I ere I saw Elba",
				"Bombard a drab mob",
				"Delia saw I was ailed",
				"Denim axes examined",
				"Lepers repel"				
		};
		for (String s : f2) {
			assertFalse(TesteJava.A(s, false, true));
		}
	}
	
	@Test
	void testACase() {
		
		String pal[] = {
				"AibohphobiA",
				"alula",
				"caMMac",
				"civic",
				"deIfIed",
				"deleVeled",
				"deTartraTed",
				"deVOVed"				
		};
		for (String s : pal) {
			assertTrue(TesteJava.A(s, true, false));
		}
		
		String pal2[] = {
				"aibohphobiA",
				"aluLa",
				"camMac",
				"civIc",
				"deifIed",
				"deLeVeled",
				"detartraTed",
				"deVOved"				
		};
		for (String s : pal2) {
			assertFalse(TesteJava.A(s, true, true));
		}
	}

	@Test
	void testB() {
		int l = 100;
		int l2 = 10;
		Random r = new Random();
		int k;
		int[] a = new int[l];
		
		for (int j = 0; j < l2; j++) {
			k = r.ints(0, (11)).findFirst().getAsInt();		
			for (int i = 0; i<l; i++) {			
				a[i] = r.ints(0, (k + 1)).findFirst().getAsInt();
			}
			
			List<Par> ret = TesteJava.B(a, k);
			for (Par p : ret) {
				System.out.println(p.getI() + " - " + p.getJ());
			}
		}
		
	}

	@Test
	void testC() {
		String file = "C:\\Users\\riber\\git\\VeeDigital\\src\\file\\arq_c.txt";
		HashMap<String, Integer> ret = TesteJava.C(file);
		for (String name: ret.keySet()){

            String key =name.toString();
            String value = ret.get(name).toString();  
            System.out.println(key + " " + value);
		}
	}
	
	@Test
	void testCNoFile() {		
		
	}
	
	
	
}



package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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


/**
 * @author riber
 * Classes de teste para TesteJava
 *
 */
class TesteJavaUnitTest  {	


	/**
	 * Teste o metodo que resolve a quest�o 1 apenas com palavras
	 */
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
		//createFileC(file, false);
		createFileC(file, true);
		HashMap<String, Integer> ret = TesteJava.C(file);
		for (String name: ret.keySet()){

			String key =name.toString();
			String value = ret.get(name).toString();  
			System.out.println(key + " " + value);
		}
	}

	@Test
	void testCNoFile() {		
		HashMap<String, Integer> ret = stubTesteJava.C("");
	}
	
	private static void createFileC(String file, boolean del) {
		try {
			File f = new File(file);
			if(f.exists() && !del) {				
				return;
			}
			f.delete();
			PrintWriter writer = 
					new PrintWriter(new BufferedWriter(new OutputStreamWriter
							(new FileOutputStream(file), "UTF-8")), false);
			String line = "";
			String pos = '|'+"";
			
			for (int j = 0; j < 100000; j++) {
				line = "";
				pos = '|'+"";
				for (int i = 0; i < 50; i++) {
					if (i == 49) {
						pos = "";
					}
					if (i%2 == 0 && j>10000) {
						line = line + "2-";
					}
					if (i%3 == 0 && j>40000) {
						line = line + "3-";
					} 
					line = line + i + pos;
				}
				writer.println(line);
			}
			writer.close();
			
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	public static class stubTesteJava extends TesteJava{


		public static HashMap<String, Integer> C(String file) {
			HashMap<String, Integer> pHM = new HashMap<String, Integer>();

			String line;
			String pos = '|'+"";
			String[] phrases;
			int i = 0;
			int leftLimit = 32; // space
			int rightLimit = 122; // z
			int targetStringLength = 100;
			Random random = new Random();
			StringBuilder buffer;
			while (i<60000) { 
				line = "";
				pos = '|'+"";
				for (int k = 0; k< 50; k++) {
					buffer = new StringBuilder(targetStringLength);
					
					for (int j = 0; j < targetStringLength; j++) {
						int randomLimitedInt = leftLimit + (int) 
								(random.nextFloat() * (rightLimit - leftLimit + 1));
						buffer.append((char) randomLimitedInt);
					}
					
					if (k==49) {
						pos = "";
					}
					line = line + buffer.toString() + pos;
				}
				//line = line.trim();
				phrases = line.split("\\|");
				pHM = arrayAsMap(pHM, phrases);

				pHM = pHM.entrySet().stream()
						.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
						.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) ->
						e2,LinkedHashMap::new));


				if (pHM.size()>50000) {
					pHM.keySet().removeAll(Arrays.asList(pHM.keySet().toArray()).subList(500, pHM.size()));


				}

				i++;
			}



			return pHM;
		}
	}

}



package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.TesteJava;

class TesteJavaJavaUnitTest {	

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

}

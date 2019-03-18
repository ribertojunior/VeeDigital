package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TesteJavaUnitTest {	

	@Test
	void testAWord() {
		TesteJava test = new TesteJava();
		String pal[] = {
				"aibohphobia",
				"alula",
				"cammac",
				"civic",
				"deified",
				"deleveled",
				"detartrated",
				"devoved"				
		};
		for (String s : pal) {
			assertTrue(teste.A(s));
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
			assertFalse(teste.A(s));
		}
		
	}
	
	@Test
	void testAPhrase() {
		TesteJava test = new TesteJava();
		String f1[] = {
				"aibohphobia alula",
				"cammac civic deified",
				"deleveled cammac civic deified",
				"detartrated",
				"devoved"				
		};
		for (String s : pal) {
			assertTrue(teste.A(s));
		}
		
		String f2[] = {
				"aibo alula",
				"cammacivic deified",
				"deleveledac civified",
				"detaated",
				"deved"				
		};
		for (String s : pal) {
			assertFalse(teste.A(s));
		}
	}
	
	@Test
	void testACase() {
		TesteJava test = new TesteJava();
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
			assertTrue(teste.A(s));
		}
		
		String pal2[] = {
				"aibohphobiA",
				"alula",
				"camMac",
				"civic",
				"deifIed",
				"deLeVeled",
				"detartraTed",
				"deVOved"				
		};
		for (String s : pal2) {
			assertFalse(teste.A(s));
		}
	}

}

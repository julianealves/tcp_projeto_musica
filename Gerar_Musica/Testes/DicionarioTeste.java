import static org.junit.Assert.*;

import org.junit.Test;

import main.Dicionario;

public class DicionarioTeste {

	@Test
	public void test() {
		Dicionario Dicionario = new Dicionario();
		assertEquals("A", Dicionario.traduzirCaractere("A"));
		assertEquals("B", Dicionario.traduzirCaractere("B"));
		assertEquals("C", Dicionario.traduzirCaractere("C"));
		assertEquals("D", Dicionario.traduzirCaractere("D"));
		assertEquals("E", Dicionario.traduzirCaractere("E"));
		assertEquals("F", Dicionario.traduzirCaractere("F"));
		assertEquals("G", Dicionario.traduzirCaractere("G"));
		assertEquals("VOLU_2.0_", Dicionario.traduzirCaractere(" "));
		assertEquals("INSTRUMENTO_6_", Dicionario.traduzirCaractere("!"));
		assertEquals("VOLU_1.1_", Dicionario.traduzirCaractere("I"));
		assertEquals("VOLU_1.1_", Dicionario.traduzirCaractere("i"));
		assertEquals("VOLU_1.1_", Dicionario.traduzirCaractere("O"));
		assertEquals("VOLU_1.1_", Dicionario.traduzirCaractere("o"));
		assertEquals("VOLU_1.1_", Dicionario.traduzirCaractere("U"));
		assertEquals("VOLU_1.1_", Dicionario.traduzirCaractere("u"));
		assertEquals("INSTRUMENTO_14_", Dicionario.traduzirCaractere("\r\n"));
		assertEquals("INSTRUMENTO_14_", Dicionario.traduzirCaractere("\n"));
		assertEquals("INSTRUMENTO_75_", Dicionario.traduzirCaractere(";"));
		assertEquals("INSTRUMENTO_19_", Dicionario.traduzirCaractere(","));
		
		assertEquals("INSTRUMENTOF_9_", Dicionario.traduzirCaractere("9"));
		assertEquals("INSTRUMENTOF_1_", Dicionario.traduzirCaractere("1"));
		assertEquals("INSTRUMENTOF_19_", Dicionario.traduzirCaractere("19"));
		assertEquals("INSTRUMENTOF_257_", Dicionario.traduzirCaractere("257"));
		
		assertEquals("none", Dicionario.traduzirCaractere("ss"));
		assertEquals("none", Dicionario.traduzirCaractere("s1"));
		assertEquals("none", Dicionario.traduzirCaractere("1s"));
		assertEquals("none", Dicionario.traduzirCaractere("12s"));
		
		assertEquals("none", Dicionario.traduzirCaractere("a"));
	}

}

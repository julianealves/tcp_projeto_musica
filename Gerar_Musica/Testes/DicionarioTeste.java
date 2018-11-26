import static org.junit.Assert.*;

import org.junit.Test;

import main.Dicionario;

public class DicionarioTeste {

	@Test
	public void test() {
		Dicionario Dicionario = new Dicionario();
		assertEquals("A", Dicionario.TraduzirCaractere("A"));
		assertEquals("B", Dicionario.TraduzirCaractere("B"));
		assertEquals("C", Dicionario.TraduzirCaractere("C"));
		assertEquals("D", Dicionario.TraduzirCaractere("D"));
		assertEquals("E", Dicionario.TraduzirCaractere("E"));
		assertEquals("F", Dicionario.TraduzirCaractere("F"));
		assertEquals("G", Dicionario.TraduzirCaractere("G"));
		assertEquals("VOLU_2.0_", Dicionario.TraduzirCaractere(" "));
		assertEquals("INSTRUMENTO_6_", Dicionario.TraduzirCaractere("!"));
		assertEquals("VOLU_1.1_", Dicionario.TraduzirCaractere("I"));
		assertEquals("VOLU_1.1_", Dicionario.TraduzirCaractere("i"));
		assertEquals("VOLU_1.1_", Dicionario.TraduzirCaractere("O"));
		assertEquals("VOLU_1.1_", Dicionario.TraduzirCaractere("o"));
		assertEquals("VOLU_1.1_", Dicionario.TraduzirCaractere("U"));
		assertEquals("VOLU_1.1_", Dicionario.TraduzirCaractere("u"));
		assertEquals("INSTRUMENTO_14_", Dicionario.TraduzirCaractere("\r\n"));
		assertEquals("INSTRUMENTO_14_", Dicionario.TraduzirCaractere("\n"));
		assertEquals("INSTRUMENTO_75_", Dicionario.TraduzirCaractere(";"));
		assertEquals("INSTRUMENTO_19_", Dicionario.TraduzirCaractere(","));
		
		assertEquals("INSTRUMENTOF_9_", Dicionario.TraduzirCaractere("9"));
		assertEquals("INSTRUMENTOF_1_", Dicionario.TraduzirCaractere("1"));
		assertEquals("INSTRUMENTOF_19_", Dicionario.TraduzirCaractere("19"));
		assertEquals("INSTRUMENTOF_257_", Dicionario.TraduzirCaractere("257"));
		
		assertEquals("none", Dicionario.TraduzirCaractere("ss"));
		assertEquals("none", Dicionario.TraduzirCaractere("s1"));
		assertEquals("none", Dicionario.TraduzirCaractere("1s"));
		assertEquals("none", Dicionario.TraduzirCaractere("12s"));
		
		assertEquals("none", Dicionario.TraduzirCaractere("a"));
	}

}

import static org.junit.Assert.*;

import org.junit.Test;

import main.OitavaMusical;
import main.TradutorDeTextoEmMusica;

public class TradutorDeTextoEmMusicaTeste {

	@Test
	public void test() {
		TradutorDeTextoEmMusica TradutorDeTexto = new TradutorDeTextoEmMusica();
		OitavaMusical oitava = new OitavaMusical(5);
		
		TradutorDeTexto.setTextoBruto("ABCDEFGabcdefg");
		assertEquals("ABCDEFGabcdefg", TradutorDeTexto.getTextoBruto());
		assertEquals("", TradutorDeTexto.getTextoTraduzido());
		assertEquals("A5 B5 C5 D5 E5 F5 G5 G5 R R R R R R", TradutorDeTexto.TraduzirTextoEmMusica(oitava));
		assertEquals("A5 B5 C5 D5 E5 F5 G5 G5 R R R R R R", TradutorDeTexto.getTextoTraduzido());
		
		oitava.incrementaOitava();
		TradutorDeTexto.setTextoBruto("ABCDEFGabcdefg");
		assertEquals("ABCDEFGabcdefg", TradutorDeTexto.getTextoBruto());
		assertEquals("A6 B6 C6 D6 E6 F6 G6 G6 R R R R R R", TradutorDeTexto.TraduzirTextoEmMusica(oitava));
		assertEquals("A6 B6 C6 D6 E6 F6 G6 G6 R R R R R R", TradutorDeTexto.getTextoTraduzido());
		
		TradutorDeTexto.setTextoBruto("!OIUoiu ");
		assertEquals("!OIUoiu ", TradutorDeTexto.getTextoBruto());
		assertEquals("INSTRUMENTO_6_ VOLU_1.1_ VOLU_1.1_ VOLU_1.1_ VOLU_1.1_ VOLU_1.1_ VOLU_1.1_ VOLU_2.0_", TradutorDeTexto.TraduzirTextoEmMusica(oitava));
		assertEquals("INSTRUMENTO_6_ VOLU_1.1_ VOLU_1.1_ VOLU_1.1_ VOLU_1.1_ VOLU_1.1_ VOLU_1.1_ VOLU_2.0_", TradutorDeTexto.getTextoTraduzido());
		
		TradutorDeTexto.setTextoBruto("LKNmtrw.");
		assertEquals("LKNmtrw.", TradutorDeTexto.getTextoBruto());
		assertEquals("R R R R R R R", TradutorDeTexto.TraduzirTextoEmMusica(oitava));
		assertEquals("R R R R R R R", TradutorDeTexto.getTextoTraduzido());
		
		TradutorDeTexto.setTextoBruto("1234567.");
		assertEquals("1234567.", TradutorDeTexto.getTextoBruto());
		assertEquals("INSTRUMENTOF_1_ INSTRUMENTOF_2_ INSTRUMENTOF_3_ INSTRUMENTOF_4_ INSTRUMENTOF_5_ INSTRUMENTOF_6_ INSTRUMENTOF_7_", TradutorDeTexto.TraduzirTextoEmMusica(oitava));
		assertEquals("INSTRUMENTOF_1_ INSTRUMENTOF_2_ INSTRUMENTOF_3_ INSTRUMENTOF_4_ INSTRUMENTOF_5_ INSTRUMENTOF_6_ INSTRUMENTOF_7_", TradutorDeTexto.getTextoTraduzido());
		
		TradutorDeTexto.setTextoBruto("890?A");
		assertEquals("890?A", TradutorDeTexto.getTextoBruto());
		assertEquals("INSTRUMENTOF_8_ INSTRUMENTOF_9_ INSTRUMENTOF_0_ A9", TradutorDeTexto.TraduzirTextoEmMusica(oitava));
		assertEquals("INSTRUMENTOF_8_ INSTRUMENTOF_9_ INSTRUMENTOF_0_ A9", TradutorDeTexto.getTextoTraduzido());
		
		TradutorDeTexto.setTextoBruto(";,=_)*");
		assertEquals(";,=_)*", TradutorDeTexto.getTextoBruto());
		assertEquals("INSTRUMENTO_75_ INSTRUMENTO_19_ R R R R", TradutorDeTexto.TraduzirTextoEmMusica(oitava));
		assertEquals("INSTRUMENTO_75_ INSTRUMENTO_19_ R R R R", TradutorDeTexto.getTextoTraduzido());
				
	}

}
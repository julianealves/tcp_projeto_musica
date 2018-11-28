import static org.junit.Assert.*;

import org.junit.Test;

import main.InstrumentoMusical;

public class InstrumentoMusicalTeste {

	@Test
	public void test() {
		InstrumentoMusical InstrumentoMusical = new InstrumentoMusical();
		assertEquals("0", InstrumentoMusical.getInstrumentoMusicalAtual());
		
		InstrumentoMusical.setInstrumentoMusicalAtual(128);
		assertEquals("127", InstrumentoMusical.getInstrumentoMusicalAtual());
		
		InstrumentoMusical.setInstrumentoMusicalAtual(120);
		InstrumentoMusical.somarFatorInstrumentoAtual(10);
		assertEquals("120", InstrumentoMusical.getInstrumentoMusicalAtual());
		
		InstrumentoMusical.setInstrumentoMusicalAtual(100);
		InstrumentoMusical.somarFatorInstrumentoAtual(10);
		assertEquals("110", InstrumentoMusical.getInstrumentoMusicalAtual());
		
		InstrumentoMusical.setInstrumentoMusicalAtual(0);
		InstrumentoMusical.somarFatorInstrumentoAtual(-1);
		assertEquals("0", InstrumentoMusical.getInstrumentoMusicalAtual());
		
		InstrumentoMusical.setInstrumentoMusicalAtual(54);
		InstrumentoMusical.somarFatorInstrumentoAtual(-4);
		assertEquals("50", InstrumentoMusical.getInstrumentoMusicalAtual());
		
		InstrumentoMusical.setInstrumentoMusicalAtual(-1);
		assertEquals("0", InstrumentoMusical.getInstrumentoMusicalAtual());
	}

}

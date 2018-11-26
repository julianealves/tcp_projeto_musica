import static org.junit.Assert.*;

import org.junit.Test;

import main.InstrumentoMusical;

public class InstrumentoMusicalTeste {

	@Test
	public void test() {
		InstrumentoMusical InstrumentoMusical = new InstrumentoMusical();
		assertEquals("0", InstrumentoMusical.getIntrumentoMusicalAtual());
		
		InstrumentoMusical.setIntrumentoMusicalAtual(128);
		assertEquals("127", InstrumentoMusical.getIntrumentoMusicalAtual());
		
		InstrumentoMusical.setIntrumentoMusicalAtual(120);
		InstrumentoMusical.AtualizarIntrumentoMusical(10);
		assertEquals("120", InstrumentoMusical.getIntrumentoMusicalAtual());
		
		InstrumentoMusical.setIntrumentoMusicalAtual(100);
		InstrumentoMusical.AtualizarIntrumentoMusical(10);
		assertEquals("110", InstrumentoMusical.getIntrumentoMusicalAtual());
		
		InstrumentoMusical.setIntrumentoMusicalAtual(0);
		InstrumentoMusical.AtualizarIntrumentoMusical(-1);
		assertEquals("0", InstrumentoMusical.getIntrumentoMusicalAtual());
		
		InstrumentoMusical.setIntrumentoMusicalAtual(54);
		InstrumentoMusical.AtualizarIntrumentoMusical(-4);
		assertEquals("50", InstrumentoMusical.getIntrumentoMusicalAtual());
		
		InstrumentoMusical.setIntrumentoMusicalAtual(-1);
		assertEquals("0", InstrumentoMusical.getIntrumentoMusicalAtual());
	}

}
import static org.junit.Assert.*;

import org.junit.Test;

import main.OitavaMusical;

public class OitavaMusicalTeste {

	@Test
	public void test() {
		OitavaMusical OitavaMusical_teste1 = new OitavaMusical(5);
		assertEquals(5, OitavaMusical_teste1.getOitavaMusical());
		
		OitavaMusical_teste1.decrementaOitava();
		assertEquals(4, OitavaMusical_teste1.getOitavaMusical());
	
		OitavaMusical_teste1.decrementaOitava();
		assertEquals(3, OitavaMusical_teste1.getOitavaMusical());
		
		OitavaMusical_teste1.decrementaOitava();
		assertEquals(2, OitavaMusical_teste1.getOitavaMusical());
		
		OitavaMusical_teste1.decrementaOitava();
		assertEquals(1, OitavaMusical_teste1.getOitavaMusical());
		
		OitavaMusical_teste1.decrementaOitava();
		assertEquals(0, OitavaMusical_teste1.getOitavaMusical());
		
		OitavaMusical_teste1.decrementaOitava();
		assertEquals(0, OitavaMusical_teste1.getOitavaMusical());
		
		OitavaMusical OitavaMusical_teste2 = new OitavaMusical(5);
		assertEquals(5, OitavaMusical_teste2.getOitavaMusical());
		
		OitavaMusical_teste2.incrementaOitava();
		assertEquals(6, OitavaMusical_teste2.getOitavaMusical());
		
		OitavaMusical_teste2.incrementaOitava();
		assertEquals(7, OitavaMusical_teste2.getOitavaMusical());
		
		OitavaMusical_teste2.incrementaOitava();
		assertEquals(8, OitavaMusical_teste2.getOitavaMusical());
		
		OitavaMusical_teste2.incrementaOitava();
		assertEquals(9, OitavaMusical_teste2.getOitavaMusical());
		
		OitavaMusical_teste2.incrementaOitava();
		assertEquals(10, OitavaMusical_teste2.getOitavaMusical());
		
		OitavaMusical_teste2.incrementaOitava();
		assertEquals(5, OitavaMusical_teste2.getOitavaMusical());
		
		OitavaMusical OitavaMusical_teste3 = new OitavaMusical(-1);
		assertEquals(0, OitavaMusical_teste3.getOitavaMusical());
		
		OitavaMusical OitavaMusical_teste4 = new OitavaMusical(11);
		assertEquals(10, OitavaMusical_teste4.getOitavaMusical());
		
		OitavaMusical_teste4.setOitavaDefault();
		assertEquals(5, OitavaMusical_teste4.getOitavaMusical());
	}

}

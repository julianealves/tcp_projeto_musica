import static org.junit.Assert.*;

import org.junit.Test;

import main.OitavaMusical;

public class OitavaMusicalTeste {

	@Test
	public void test() {
		OitavaMusical OitavaMusical = new OitavaMusical(5);
		assertEquals(5, OitavaMusical.getOitavaMusical());
		
		OitavaMusical.decrementaOitava();
		assertEquals(4, OitavaMusical.getOitavaMusical());
	
		OitavaMusical.decrementaOitava();
		assertEquals(3, OitavaMusical.getOitavaMusical());
		
		OitavaMusical.decrementaOitava();
		assertEquals(2, OitavaMusical.getOitavaMusical());
		
		OitavaMusical.decrementaOitava();
		assertEquals(1, OitavaMusical.getOitavaMusical());
		
		OitavaMusical.decrementaOitava();
		assertEquals(0, OitavaMusical.getOitavaMusical());
		
		OitavaMusical.decrementaOitava();
		assertEquals(0, OitavaMusical.getOitavaMusical());
		
		OitavaMusical OitavaMusical2 = new OitavaMusical(5);
		assertEquals(5, OitavaMusical2.getOitavaMusical());
		
		OitavaMusical2.incrementaOitava();
		assertEquals(6, OitavaMusical2.getOitavaMusical());
		
		OitavaMusical2.incrementaOitava();
		assertEquals(7, OitavaMusical2.getOitavaMusical());
		
		OitavaMusical2.incrementaOitava();
		assertEquals(8, OitavaMusical2.getOitavaMusical());
		
		OitavaMusical2.incrementaOitava();
		assertEquals(9, OitavaMusical2.getOitavaMusical());
		
		OitavaMusical2.incrementaOitava();
		assertEquals(10, OitavaMusical2.getOitavaMusical());
		
		OitavaMusical2.incrementaOitava();
		assertEquals(5, OitavaMusical2.getOitavaMusical());
		
		OitavaMusical OitavaMusical3 = new OitavaMusical(-1);
		assertEquals(0, OitavaMusical3.getOitavaMusical());
		
		OitavaMusical OitavaMusical4 = new OitavaMusical(11);
		assertEquals(10, OitavaMusical4.getOitavaMusical());
	}

}

import static org.junit.Assert.*;

import org.junit.Test;

import main.Ritmo;

public class RitmoTeste {

	@Test
	public void test() {
		Ritmo ritmo = new Ritmo(10);
		assertEquals("Vivace", ritmo.getRitmoAtual());
		
		ritmo.aumentaRitmo();
		assertEquals("Presto", ritmo.getRitmoAtual());
		
		ritmo.aumentaRitmo();
		assertEquals("Pretissimo", ritmo.getRitmoAtual());
		
		ritmo.aumentaRitmo();
		assertEquals("Pretissimo", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Presto", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Vivace", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Allegro", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Moderato", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Andantino", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Andante", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Adagietto", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Adagio", ritmo.getRitmoAtual());	
		
		ritmo.diminuiRitmo();
		assertEquals("Lento", ritmo.getRitmoAtual());	
		
		ritmo.diminuiRitmo();
		assertEquals("Larghetto", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Largo", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Grave", ritmo.getRitmoAtual());
		
		ritmo.diminuiRitmo();
		assertEquals("Grave", ritmo.getRitmoAtual());	
		
		Ritmo ritmo2 = new Ritmo(13);
		assertEquals("Pretissimo", ritmo2.getRitmoAtual());
		
		Ritmo ritmo3 = new Ritmo(-1);
		assertEquals("Grave", ritmo3.getRitmoAtual());
	}

}

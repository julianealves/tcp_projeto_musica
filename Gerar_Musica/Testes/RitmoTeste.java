import static org.junit.Assert.*;

import org.junit.Test;

import main.Ritmo;

public class RitmoTeste {

	@Test
	public void test() {
		Ritmo ritmo_teste1 = new Ritmo(10);
		assertEquals("Vivace", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.aumentaRitmo();
		assertEquals("Presto", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.aumentaRitmo();
		assertEquals("Pretissimo", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.aumentaRitmo();
		assertEquals("Pretissimo", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Presto", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Vivace", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Allegro", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Moderato", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Andantino", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Andante", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Adagietto", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Adagio", ritmo_teste1.getRitmoAtual());	
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Lento", ritmo_teste1.getRitmoAtual());	
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Larghetto", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Largo", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Grave", ritmo_teste1.getRitmoAtual());
		
		ritmo_teste1.diminuiRitmo();
		assertEquals("Grave", ritmo_teste1.getRitmoAtual());	
		
		Ritmo ritmo_teste2 = new Ritmo(13);
		assertEquals("Pretissimo", ritmo_teste2.getRitmoAtual());
		
		Ritmo ritmo_teste3 = new Ritmo(-1);
		assertEquals("Grave", ritmo_teste3.getRitmoAtual());
	}

}

import static org.junit.Assert.*;

import org.junit.Test;

import main.Musica;
import main.TradutorDeTextoEmMusica;

public class MusicaTeste {

	@Test
	public void test() {
		Musica musica = new Musica("ABCDEFG");
		TradutorDeTextoEmMusica tradutor = new TradutorDeTextoEmMusica();
		
		assertEquals("", musica.getCodificacaoJFugue());
		
		musica.recodificacaoJFugue(tradutor);
		assertEquals("A5 B5 C5 D5 E5 F5 G5", musica.getCodificacaoJFugue());		
		
		musica.setTextoBruto("ABCDEFGabcdefg");
		assertEquals("", musica.getCodificacaoJFugue());
		musica.recodificacaoJFugue(tradutor);
		assertEquals("A5 B5 C5 D5 E5 F5 G5 G5 R R R R R R", musica.getCodificacaoJFugue());
		
		musica.setTextoBruto("LKNmtrw.");
		musica.recodificacaoJFugue(tradutor);
		assertEquals("R R R R R R R", musica.getCodificacaoJFugue());
		
		musica.setTextoBruto("ABCDEFG");
		musica.recodificacaoJFugue(tradutor);
		assertEquals("A6 B6 C6 D6 E6 F6 G6", musica.getCodificacaoJFugue());
		
		musica.setTextoBruto("1234567");
		musica.recodificacaoJFugue(tradutor);
		assertEquals("I1 I3 I6 I10 I15 I21 I28", musica.getCodificacaoJFugue());
		
		musica.setTextoBruto(";,=_)*");
		musica.recodificacaoJFugue(tradutor);
		assertEquals("I75 I19 R R R R", musica.getCodificacaoJFugue());
		
		musica.setTextoBruto("!Oi ");
		musica.recodificacaoJFugue(tradutor);
		assertEquals("I6 X[Volume]=1100 X[Volume]=1210 X[Volume]=2420", musica.getCodificacaoJFugue());
	}

}

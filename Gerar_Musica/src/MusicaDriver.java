
public class MusicaDriver {

	
	public static void main(String[] args) {
		Musica musica = new Musica("CGC222;;;OCD",1000,0,6);
		TradutorDeTextoEmMusica tradutor = new TradutorDeTextoEmMusica();
		musica.recodificacaoJFugue(tradutor);
		
		System.out.println(musica.getCodificacaoJFugue());
	}

}

//import org.jfugue.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class AudioPlayer {
	private static Musica Musica;
	
	public AudioPlayer() {
		Musica = new Musica();	
	}
	
	public void setMusica(String MusicaParaTocar) {
		Musica.ComporMusica(MusicaParaTocar);
	}
	
	public void TocarMusica() {
		Player player = new Player();
		String PadraoDaMusica = Musica.getMusicaString();
		Pattern padraoMusical = new Pattern(PadraoDaMusica); 
		player.play(padraoMusical);
	}
}

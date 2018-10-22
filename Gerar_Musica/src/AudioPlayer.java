//import org.jfugue.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class AudioPlayer {
	private static Musica Musica;
	
	public AudioPlayer(String MusicaParaTocar) {
		Musica = new Musica(MusicaParaTocar);		
	}
	
	public void TocarMusica() {
		Player player = new Player();
		String PadraoDaMusica = Musica.getMusicaString();
		Pattern padraoMusical = new Pattern(PadraoDaMusica); 
		player.play(padraoMusical);
	}
}

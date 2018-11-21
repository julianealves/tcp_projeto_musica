//import org.jfugue.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class AudioPlayer {
	private Musica Musica;
	
	public AudioPlayer(Musica Musica) {
		this.Musica = Musica;	
	}
	
	public void TocarMusica() {
		Player player = new Player();
		String PadraoDaMusica = Musica.getCodificacaoJFugue();
		Pattern padraoMusical = new Pattern(PadraoDaMusica); 
		player.play(padraoMusical);
	}
}

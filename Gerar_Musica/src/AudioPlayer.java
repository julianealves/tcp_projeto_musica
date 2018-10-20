//import org.jfugue.*;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class AudioPlayer {
	private String Musica;
	
	public AudioPlayer(String Musica) {
		this.Musica = Musica;		
	}
	
	public void TocarMusica() {
		Player player = new Player();
		Pattern padraoMusical = new Pattern(this.Musica); 
		player.play(padraoMusical);
	}

}

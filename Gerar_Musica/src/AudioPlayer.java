//import org.jfugue.*;
import java.io.File;
import java.io.IOException;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.jfugue.midi.MidiFileManager;

public class AudioPlayer {
	private Musica Musica;
	private Player player;
	private Pattern musicaPadronizada;
	
	public AudioPlayer(Musica Musica) {
		this.Musica = Musica;	
	}
	
	public void TocarMusica() {
		player = new Player();
		String musica = Musica.getCodificacaoJFugue();
		musicaPadronizada = new Pattern(musica); 
		player.play(musicaPadronizada);
	}
	
	public void SalvarMusica() {
		try {
			MidiFileManager.savePatternToMidi(musicaPadronizada, new File("MinhaMusica.midi"));
			System.out.println("Arquivo salvo");
		} catch (IOException e)
		{
			System.out.println("Nao foi possivel salvar o arquivo");
		}
	}
}

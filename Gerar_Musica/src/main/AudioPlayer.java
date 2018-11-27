package main;
//import org.jfugue.*;
import java.io.File;
import java.io.IOException;

import org.jfugue.pattern.Pattern;
import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.Player;
import org.jfugue.midi.MidiFileManager;

public class AudioPlayer {
	private Musica Musica;
	private Player player;
	private Pattern musicaPadronizada;
	
	public AudioPlayer(Musica Musica) {
		this.Musica = Musica;
		player = new Player();
		String musica = this.Musica.getCodificacaoJFugue();
		musicaPadronizada = new Pattern(musica); 
	}
	
	public void TocarMusica() {
		ManagedPlayer controle = player.getManagedPlayer();
		
		if (controle.isPaused()) {
			controle.resume();
		}
		
		else if (!controle.isStarted()) {
			player.play(musicaPadronizada);
		}
		
		else if (controle.isFinished()) {
			controle.reset();
		}
		
	}
	
	public void PausaMusica() {
		ManagedPlayer controle = player.getManagedPlayer();
		if (controle.isPlaying()) {
			controle.pause();
		}
		
	}
	
	public void SalvarMusica() {
		try {
			MidiFileManager.savePatternToMidi(musicaPadronizada, new File("MinhaMusica.midi"));
			System.out.println("--->Arquivo salvo");
		} catch (IOException e)
		{
			System.out.println("--->Nao foi possivel salvar o arquivo");
		}
	}
}

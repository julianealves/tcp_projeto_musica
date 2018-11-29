package main;
//import org.jfugue.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

import javax.sound.midi.InvalidMidiDataException;

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
	
	public void tocarMusica() {
		ManagedPlayer controle = player.getManagedPlayer();
		
		if (controle.isPaused()) {
			controle.resume();
		}
		
		else if (!controle.isStarted()) {
			player.play(musicaPadronizada);
		}
		
		else {
			player = new Player();
			player.play(musicaPadronizada);
		}
		
		
		
	}
	
	public void pausaMusica() {
		ManagedPlayer controle = player.getManagedPlayer();
		if (controle.isPlaying()) {
			controle.pause();
		}
		
	}

	public void SalvarMusica(File arquivo) {
		try {
			MidiFileManager.savePatternToMidi(musicaPadronizada, arquivo);
			System.out.println("Arquivo salvo");
		} catch (IOException e)
		{
			System.out.println("--->Nao foi possivel salvar o arquivo");
		}
	}
	
	public boolean isPlaying() {
		ManagedPlayer playerControl = player.getManagedPlayer();
		
		return playerControl.isPlaying();
	}
	
	public ManagedPlayer getManagedPlayer() {
		return player.getManagedPlayer();
	}
}

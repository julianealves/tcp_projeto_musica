package main;

import org.jfugue.Player;

import java.io.File;
import java.io.IOException;


public class AudioPlayer {
	private Musica Musica;
	private Player player;
	private String musicaPadronizada;
	
	public AudioPlayer(Musica Musica) {
		this.Musica = Musica;
		player = new Player();
		String musica = this.Musica.getCodificacaoJFugue();
		musicaPadronizada = new String(musica); 
	}
	
	public void tocarMusica() {
		
		if (player.isPaused()) {
			player.resume();
		}
		
		else if (!player.isStarted()) {
			player.play(musicaPadronizada);
		}
		
		else {
			player = new Player();
			player.play(musicaPadronizada);
		}
	}
	
	public void pausaMusica() {
		
		if (player.isPlaying()) {
			player.pause();
		}
		
	}

	public void SalvarMusica(File arquivo) {
		try {
			player.saveMidi(musicaPadronizada, arquivo);
			System.out.println("Arquivo salvo");
		} catch (IOException e)
		{
			System.out.println("--->Nao foi possivel salvar o arquivo");
		}
	}
	
	public boolean isPlaying() {
	
		return player.isPlaying();
	}
	
	public Player getPlayer () {
		return player;
	}
	
	
}

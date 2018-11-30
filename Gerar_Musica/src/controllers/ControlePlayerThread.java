package controllers;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import main.AudioPlayer;


public class ControlePlayerThread implements Runnable{
	
	private AudioPlayer player;
	private FontAwesomeIconView iconeASerTrocado;
	
	public ControlePlayerThread(AudioPlayer playerControlado, FontAwesomeIconView iconePausarPlay) {
		player = playerControlado;
		iconeASerTrocado = iconePausarPlay;
	}
	
	@Override
	public void run() {
		//Player fica tocando a música
		player.tocarMusica();
		
		//Quando acaba de tocar ou é pausado.
		if(player.getPlayerJFugue().isFinished()) {
			iconeASerTrocado.setGlyphName("PLAY");
		}
		
		
	}

}

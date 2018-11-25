package controllers;

import main.AudioPlayer;
import main.Musica;

public class ControlePlayerThread implements Runnable{
	
	private AudioPlayer player;
	private String actionToPerform;
	
	public ControlePlayerThread(AudioPlayer playerControlado, String Action) {
		player = playerControlado;
		actionToPerform = Action;
	}
	
	@Override
	public void run() {
		switch(actionToPerform) {
			case "PLAY"	: player.TocarMusica();
						  break;
			case "PAUSE": player.PausaMusica();
						  break;
		    default:	break;
						 
		}
	
	}

}

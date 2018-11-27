package controllers;

import main.AudioPlayer;

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
			case "PLAY"	: player.tocarMusica();
						  break;
			case "PAUSE": player.pausaMusica();
						  break;
		    default:	break;
						 
		}
	
	}

}

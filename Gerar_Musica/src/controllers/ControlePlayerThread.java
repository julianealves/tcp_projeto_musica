package controllers;

import main.AudioPlayer;


public class ControlePlayerThread implements Runnable{
	
	private AudioPlayer player;
	private String actionToPerform;
	
	public ControlePlayerThread(AudioPlayer playerControlado) {
		player = playerControlado;
		
	}
	
	@Override
	public void run() {
		//Enquanto a musica não acaba, player fica pendurado na thread
		player.tocarMusica();
		
		//TODO:Implementar a troca de ui quando a música acaba (AQUI)
		//iconePausarPlay.setGlyphName("PLAY");
		
	}

}

package controllers;

import java.util.HashMap;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.AudioPlayer;
import main.Musica;
import main.TradutorDeTextoEmMusica;

public class DadosModel {
	
	private Stage janela;
	public HashMap<TelasID, Scene> telas = new HashMap<TelasID, Scene>();
	
	private final StringProperty textoOriginal = new SimpleStringProperty("");
	private final StringProperty textoTraduzido = new SimpleStringProperty("");
	
	private Musica musica;
	
	public enum TelasID {
		TELA_ENTRADA, TELA_RESULTADO;
	}
	
	DadosModel() {}
	
	public Stage getJanela() {
		return this.janela;
	}

	public void setJanela(Stage janela) {
		this.janela = janela;
	}
	
	public void addTela(TelasID idTela, Scene tela) {
		this.telas.put(idTela, tela);
	}
	
	public final StringProperty getTextoOriginalProperty() {
		return this.textoOriginal;
	}
	
	public final void setTextoOriginal(String texto) {
		textoOriginal.set(texto);
	}
	
	public final StringProperty getTextoTraduzidoProperty() {
		return this.textoTraduzido;
	}

	private final void setTextoTraduzido(String texto) {
		textoTraduzido.set(texto);
	}
	
	public final Musica getMusica() {
		return this.musica;
	}
	
	public final void setMusica(String textoOriginal) {
		this.musica = new Musica(textoOriginal);
		TradutorDeTextoEmMusica tradutor = new TradutorDeTextoEmMusica();
		musica.recodificacaoJFugue(tradutor);
		
		setTextoTraduzido(musica.getCodificacaoJFugue());
		System.out.println(getTextoTraduzidoProperty().toString());
	}

}

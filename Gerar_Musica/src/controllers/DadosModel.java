package controllers;

import java.util.HashMap;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DadosModel {
	
	public enum TelasID {
		TELA_ENTRADA, TELA_RESULTADO;
	}
	
	private Stage janela;
	public HashMap<TelasID, Scene> telas = new HashMap<TelasID, Scene>();
	
	private final StringProperty textoOriginal = new SimpleStringProperty("");
	
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
	
	public final String getTextoOriginal() {
		return textoOriginal.get();
	}

}

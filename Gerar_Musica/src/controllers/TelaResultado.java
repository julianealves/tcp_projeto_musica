package controllers;

import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXScrollPane;

import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class TelaResultado implements Initializable {
	
	private DadosModel dadosModel;
	
	@FXML StackPane stackPane;
	@FXML Tab tabTextoOriginal;
	
	Text textoOriginal;
	Text textoTraduzido;
	
	public TelaResultado() {}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textoOriginal = new Text();
		criarConteudoTab(textoOriginal, tabTextoOriginal);
		
		
		System.out.println("--> TelaResultado inicializada!");
	}
	
	public void setDadosModel(DadosModel dadosModel) {
		this.textoOriginal.textProperty().unbind();
		this.dadosModel = dadosModel;
		this.textoOriginal.textProperty().bind(dadosModel.getTextoOriginalProperty());
	}
	
	private void criarConteudoTab(Text texto, Tab tab) {
		StackPane paneTexto = new StackPane(texto);
		StackPane.setMargin(textoOriginal, new Insets(15.0));
		
		ScrollPane scrollPane = new ScrollPane();
		
		scrollPane.setContent(paneTexto);
		scrollPane.setFitToWidth(true);
		scrollPane.setStyle("-fx-background-color: #FFFFFF;");
		texto.wrappingWidthProperty().bind(scrollPane.widthProperty().add(-50));
		tab.setContent(scrollPane);
	}
	
	public void salvarMusica(ActionEvent event) {
		
	}
	
	public void inicioMusica(ActionEvent event) {
		
	}
	
	public void fimMusica(ActionEvent event) {
		
	}
	
	public void tocarMusica(ActionEvent event) {
		
	}
	
	public void voltarTelaEntrada(ActionEvent event) {
		dadosModel.getJanela().setScene(dadosModel.telas.get(DadosModel.TelasID.TELA_ENTRADA));
		dadosModel.getJanela().show();
	}
	
}

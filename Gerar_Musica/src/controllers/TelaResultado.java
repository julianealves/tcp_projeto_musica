package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import main.AudioPlayer;

public class TelaResultado implements Initializable {
	
	private DadosModel dadosModel;
	
	@FXML private StackPane stackPane;
	@FXML private Tab tabTextoOriginal;
	@FXML private Tab tabTextoTraduzido;
	@FXML private FontAwesomeIconView iconePausarPlay;
	
	private Text textoOriginal;
	private Text textoTraduzido;
	
	public TelaResultado() {}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textoOriginal = new Text();
		criarConteudoTab(textoOriginal, tabTextoOriginal);
		
		textoTraduzido = new Text();
		criarConteudoTab(textoTraduzido, tabTextoTraduzido);
		
		System.out.println("--> TelaResultado inicializada!");
	}
	
	public void setDadosModel(DadosModel dadosModel) {
		this.textoOriginal.textProperty().unbind();
		this.textoTraduzido.textProperty().unbind();
		this.dadosModel = dadosModel;
		this.textoOriginal.textProperty().bind(dadosModel.getTextoOriginalProperty());
		this.textoTraduzido.textProperty().bind(dadosModel.getTextoTraduzidoProperty());
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
		AudioPlayer audioPlayer = dadosModel.getAudioPlayer();
		audioPlayer.SalvarMusica();		
	}
	
	public void inicioMusica(ActionEvent event) {
		
	}
	
	public void fimMusica(ActionEvent event) {
		
	}
	
	public void tocarMusica(ActionEvent event) {
		Runnable controleMusica;
		
		if (iconePausarPlay.getGlyphName() == "PAUSE") {
			iconePausarPlay.setGlyphName("PLAY");
			controleMusica = new ControlePlayerThread(dadosModel.getAudioPlayer(),"PAUSE");
		} else {
			iconePausarPlay.setGlyphName("PAUSE");
			controleMusica = new ControlePlayerThread(dadosModel.getAudioPlayer(),"PLAY");
		}
		
		new Thread(controleMusica).start();	
	}
	
	public void voltarTelaEntrada(ActionEvent event) {
		dadosModel.getJanela().setScene(dadosModel.telas.get(DadosModel.TelasID.TELA_ENTRADA));
		dadosModel.getJanela().show();
	}
	
}

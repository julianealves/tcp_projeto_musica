package controllers;



import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import javax.sound.midi.Sequence;

import org.jfugue.midi.MidiDefaults;
import org.jfugue.player.ManagedPlayer;
import org.jfugue.player.ManagedPlayerListener;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
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
		StackPane.setMargin(texto, new Insets(15.0));
		
		ScrollPane scrollPane = new ScrollPane();
		
		scrollPane.setContent(paneTexto);
		scrollPane.setFitToWidth(true);
		scrollPane.setStyle("-fx-background-color: #FFFFFF;");
		texto.wrappingWidthProperty().bind(scrollPane.widthProperty().add(-50));
		tab.setContent(scrollPane);
	}
	
	public void salvarMusica(ActionEvent event) {
		FileChooser janelaSalvar = new FileChooser();
		
		janelaSalvar.setTitle("Salvar arquivo MIDI");
		janelaSalvar.setInitialDirectory(new File(System.getProperty("user.home")));
		janelaSalvar.getExtensionFilters().add(new FileChooser.ExtensionFilter(".MIDI", "*.midi"));
	
		File arquivo = janelaSalvar.showSaveDialog(dadosModel.getJanela());
		
		if (arquivo != null) {
            dadosModel.getAudioPlayer().SalvarMusica(arquivo);
        }
	}
	
	public void inicioMusica(ActionEvent event) {
		
	}
	
	public void fimMusica(ActionEvent event) {
		
	}
	
	public void tocarMusica(ActionEvent event) {
		AudioPlayer player = dadosModel.getAudioPlayer();
		Runnable controleMusica = new ControlePlayerThread(player);
		
		ManagedPlayer controladorPlayer = player.getManagedPlayer();
		controladorPlayer.addManagedPlayerListener(new ManagedPlayerListener() {
			@Override
			public void onFinished() {
				trocarIcone(iconePausarPlay, "PLAY");
			}

			@Override public void onPaused() {}
			@Override public void onReset() {}
			@Override public void onResumed() {}
			@Override public void onSeek(long arg0) {}
			@Override public void onStarted(Sequence arg0) {}
		});
		
		if(iconePausarPlay.getGlyphName() == "PAUSE") {
			trocarIcone(iconePausarPlay, "PLAY");
			player.pausaMusica();
		} else { // iconePausarPlay.getGlyphName() == "PLAY"
			trocarIcone(iconePausarPlay, "PAUSE");
			if (!player.isPlaying()) {
				Thread thread = new Thread(controleMusica);
				thread.setDaemon(true);
				thread.start();
			}
		}	
	}
	
	public void voltarTelaEntrada(ActionEvent event) {
		trocarIcone(iconePausarPlay, "PLAY"); //garantir botao de play na proxima vez
		
		AudioPlayer toBeFinished = dadosModel.getAudioPlayer();
		
		dadosModel.getJanela().setScene(dadosModel.telas.get(DadosModel.TelasID.TELA_ENTRADA));
		dadosModel.getJanela().show();
		toBeFinished.getManagedPlayer().finish();
	}
	
	private void trocarIcone(FontAwesomeIconView icone, String nomeIcone) {
		icone.setGlyphName(nomeIcone);
	}
}

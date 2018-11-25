package controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextArea;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;

public class TelaEntrada implements Initializable {
	
	private DadosModel dadosModel;
	
	@FXML private JFXTextArea caixaTexto;
    @FXML private StackPane stackPane;
    @FXML private Label labelArquivo;
    @FXML public JFXButton gerarMusicaButton;
    
    private File arquivo;
	
    public TelaEntrada() {}
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("--> TelaEntrada inicializada!");
	}
    
    public void setDadosModel(DadosModel dadosModel) {
    	this.dadosModel = dadosModel;
    }

	private boolean caixaTextoVazia(String texto) {
		return (texto == null || texto.isEmpty());
	}
	
	private boolean arquivoVazio(File arquivo) {
		return (arquivo == null || arquivo.isFile() == false || arquivo.length() == 0);
	}

	public void carregarArquivo() {
		FileChooser janelaArquivo = new FileChooser();
		janelaArquivo.setTitle("Carregar arquivo de texto");
		janelaArquivo.setInitialDirectory(new File(System.getProperty("user.home")));
		janelaArquivo.getExtensionFilters().add(new FileChooser.ExtensionFilter(".TXT", "*.txt"));
		arquivo = janelaArquivo.showOpenDialog(dadosModel.getJanela());
		
		labelArquivo.setText("");
		if (!arquivoVazio(arquivo)) {
			labelArquivo.setText(arquivo.getName());
		}
	}
	
	private void gerarMusica() {
		String texto = new String("ERRO: Não conseguiu buscar o texto!");
		if (caixaTextoVazia(caixaTexto.getText())) {
			byte[] textoCodificado;
			try {
				textoCodificado = Files.readAllBytes(Paths.get(arquivo.getAbsolutePath()));
				texto = new String(textoCodificado, Charset.defaultCharset());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			texto = caixaTexto.getText();
		}
		
		dadosModel.setTextoOriginal(texto);
		
		dadosModel.getJanela().setScene(dadosModel.telas.get(DadosModel.TelasID.TELA_RESULTADO));
		dadosModel.getJanela().show();
		
	}
	
	private JFXDialogLayout configurarDialog(JFXButton botaoFechar, JFXButton botaoConfirmar) {
		JFXDialogLayout conteudoDialog = new JFXDialogLayout();
		String titulo;
		String conteudo;
		
		conteudoDialog.setActions(botaoFechar);
		if (!caixaTextoVazia(caixaTexto.getText()) && !arquivoVazio(arquivo)) {
			titulo = "Oops! Entradas duplicadas.";
			conteudo = "Você inseriu um texto através da caixa de texto e de um arquivo."
					+ "\nInsira apenas uma forma de entrada, por favor!";
		} else if (caixaTextoVazia(caixaTexto.getText()) && arquivoVazio(arquivo)){
			titulo = "Oops! Faltou o texto.";
			conteudo = "Para gerar a música é necessário digitar um texto ou, se preferir, carregar um arquivo de texto!";
		} else {
			titulo = "Tudo pronto?";
			conteudo = "Tem certeza de que está tudo pronto para gerar música?";
			conteudoDialog.setActions(botaoConfirmar,botaoFechar);
		}
		
		conteudoDialog.setHeading(new Text(titulo));
		conteudoDialog.setBody(new Text(conteudo));
		
		return conteudoDialog;
	}
	
	public void abrirDialog(ActionEvent event) {
		System.out.println(dadosModel.telas.toString());
		JFXButton botaoConfirmar = new JFXButton("Sim");
		botaoConfirmar.setButtonType(JFXButton.ButtonType.RAISED);
		botaoConfirmar.setTextFill(Paint.valueOf("WHITE"));
		botaoConfirmar.setStyle("-fx-background-color: #6200EA;");
		
		JFXButton botaoFechar = new JFXButton("Fechar");
		botaoFechar.setButtonType(JFXButton.ButtonType.RAISED);
		botaoFechar.setStyle("-fx-background-color: #ffffff;");
		
		
		JFXDialogLayout conteudoDialog = configurarDialog(botaoFechar, botaoConfirmar);
		JFXDialog dialog = new JFXDialog(stackPane, conteudoDialog, JFXDialog.DialogTransition.CENTER);
		
		botaoConfirmar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent __) {
				gerarMusica();
				dialog.close();
			}
		});
		
		botaoFechar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent __) {
				dialog.close();
			}
		});
		
		dialog.show();
		
	} 
	
}

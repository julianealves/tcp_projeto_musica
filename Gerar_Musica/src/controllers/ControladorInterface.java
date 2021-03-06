package controllers;

import java.io.IOException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class ControladorInterface extends Application {
	
	private Stage janela;
	private TelaEntrada telaEntradaController;
	private TelaResultado telaResultadoController;
	
	private final DadosModel dadosModel = new DadosModel();
	
	public ControladorInterface() {}
	
	@Override
	public void start(Stage primaryStage) {
		this.janela = primaryStage;
        this.janela.setTitle("Bach - Crie m�sica!");
        
        dadosModel.setJanela(janela);
        
        janela.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
                System.exit(0);
			}
        });
        
        try {
			// TELA ENTRADA
			FXMLLoader loader = carregaTela("telaEntrada.fxml");
        	Scene telaEntrada = new Scene((AnchorPane) loader.load());
			telaEntradaController = loader.getController();

			// TELA RESULTADO
			loader = carregaTela("telaResultado.fxml");
			Scene telaResultado = new Scene((AnchorPane) loader.load());
			telaResultado.getStylesheets().add("view/style.css");
			telaResultadoController = loader.getController();
			
			telaEntradaController.setDadosModel(dadosModel);
			telaResultadoController.setDadosModel(dadosModel);
			
			
			dadosModel.addTela(DadosModel.TelasID.TELA_ENTRADA, telaEntrada);
			dadosModel.addTela(DadosModel.TelasID.TELA_RESULTADO, telaResultado);
			
			janela.setScene(telaEntrada);
			janela.setY(0);
			janela.show();
        } catch (IOException e) {
			e.printStackTrace();
		}
        
	}
	
	private FXMLLoader carregaTela(String nome) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ControladorInterface.class.getResource("../view/" + nome));
        
        return loader;
	}

	public void iniciarUI(String[] args) {
		launch(args);
	}
}

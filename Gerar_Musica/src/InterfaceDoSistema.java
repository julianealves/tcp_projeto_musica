import java.util.Scanner;

public class InterfaceDoSistema {
	private static AudioPlayer PlayerDeAudio;
	private static TradutorDeTextoEmMusica TradutorDeTexto;
	
	public InterfaceDoSistema() {
		// TODO Auto-generated constructor stub
	}
	
	public void CriarInterface() {
		//TODO implementar a construcao da interface
		
		System.out.println("Digite o texto: ");
		Scanner LerDoTeclado = new Scanner(System.in);
		
		String TextoDigitado = LerDoTeclado.nextLine();
		LerDoTeclado.close();
		
		TradutorDeTexto = new TradutorDeTextoEmMusica(TextoDigitado);
		String TextoTraduzido = TradutorDeTexto.TraduzirTextoEmMusica();
		
		System.out.println("Texto traduzido: ");
		System.out.println(TextoTraduzido);
		
		PlayerDeAudio = new AudioPlayer(TextoTraduzido);
		PlayerDeAudio.TocarMusica();
		
	}
	
	public void TocarMusica() {
		//TODO implementar o metodo
	}

}

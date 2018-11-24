import java.util.Scanner;

public class InterfaceDoSistema {
	private static AudioPlayer PlayerDeAudio;
	private static TradutorDeTextoEmMusica TradutorDeTexto;
	private static Musica musica;
	
	public InterfaceDoSistema() {
		// TODO Auto-generated constructor stub
	}
	
	public void CriarInterface() {
		//TODO implementar a construcao da interface
		
		System.out.println("Digite o texto: ");
		Scanner LerDoTeclado = new Scanner(System.in);
		
		String TextoDigitado = LerDoTeclado.nextLine();
		LerDoTeclado.close();
		
		TradutorDeTexto = new TradutorDeTextoEmMusica();
		musica = new Musica(TextoDigitado, 1000, 0, 5);
		musica.recodificacaoJFugue(TradutorDeTexto);
		
		String traducao = musica.getCodificacaoJFugue();
		
		System.out.println("Traducao: " + traducao);
		
		PlayerDeAudio = new AudioPlayer(musica);
		PlayerDeAudio.TocarMusica();
		PlayerDeAudio.SalvarMusica();
		
	}
	
	public void TocarMusica() {
		//TODO implementar o metodo
	}

}

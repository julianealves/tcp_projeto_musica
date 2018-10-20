import java.util.HashMap; 
import java.util.Map;


public class TradutorDeTextoEmMusica {
	private String TextoBruto;
	private String TextoTraduzido;
	private Map<String, String> DicionarioDeNotas = new HashMap<String, String>();

	public TradutorDeTextoEmMusica(String TextoBruto) {
		this.TextoBruto = TextoBruto.toUpperCase();
		this.TextoTraduzido = "";
		
		/* Inicializacao do dicionario com as notas musicais.
		 Os caraceteres correspondem as chaves e as notas 
		 correspondem aos valores das chaves.		 
		*/
		DicionarioDeNotas.put( "A", new String( "A" )); //Nota La
		DicionarioDeNotas.put( "B", new String( "B" )); //Nota Si
		DicionarioDeNotas.put( "C", new String( "C" )); //Nota Do
		DicionarioDeNotas.put( "D", new String( "D" )); //Nota Re
		DicionarioDeNotas.put( "E", new String( "E" )); //Nota Mi
		DicionarioDeNotas.put( "F", new String( "F" )); //Nota Fa
		DicionarioDeNotas.put( "G", new String( "G" )); //Nota Sol
		DicionarioDeNotas.put( " ", new String( "R" )); //Silencio/pausa		
	}
	
	public String TraduzirTextoEmMusica() {
		int TamanhoDoTexto;
		String NotaMusical;
		char caractere;
		
		TamanhoDoTexto = this.TextoBruto.length();
		for (int indice = 0; indice < TamanhoDoTexto; indice++) {
			caractere = this.TextoBruto.charAt(indice);
			NotaMusical = DicionarioDeNotas.get(String.valueOf(caractere));
			
			if (this.TextoTraduzido.isEmpty()) {
				this.TextoTraduzido = NotaMusical;
				System.out.println(this.TextoTraduzido);
			}
			else {
				//Eh necessario ter um espaco entre as notas musicais
				this.TextoTraduzido = this.TextoTraduzido + " " + NotaMusical; 
			}
		}
		
		return this.TextoTraduzido;
	}

}

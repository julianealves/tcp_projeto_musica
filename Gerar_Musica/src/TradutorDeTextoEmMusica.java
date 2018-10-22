
public class TradutorDeTextoEmMusica {
	private String TextoBruto;
	private String TextoTraduzido;
	private static Dicionario DicionarioDeNotas;
	

	public TradutorDeTextoEmMusica(String TextoBruto) {
		this.TextoBruto = TextoBruto.toUpperCase();
		this.TextoTraduzido = "";	
		DicionarioDeNotas = new Dicionario();
	}
	
	public String TraduzirTextoEmMusica() {
		int TamanhoDoTexto;
		String NotaMusical;
		char caractere;
		
		TamanhoDoTexto = this.TextoBruto.length();
		for (int indice = 0; indice < TamanhoDoTexto; indice++) {
			caractere = this.TextoBruto.charAt(indice);
			NotaMusical = DicionarioDeNotas.TraduzirCaractere(String.valueOf(caractere));
			
			if (this.TextoTraduzido.isEmpty()) {
				this.TextoTraduzido = NotaMusical;
			}
			else {
				//Eh necessario ter um espaco entre as notas musicais
				this.TextoTraduzido = this.TextoTraduzido + " " + NotaMusical; 
			}
		}
		
		return this.TextoTraduzido;
	}

}

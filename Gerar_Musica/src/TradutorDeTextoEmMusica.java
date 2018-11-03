
public class TradutorDeTextoEmMusica {
	private String TextoBruto;
	private String TextoTraduzido;
	private static Dicionario DicionarioDeNotas;
	

	public TradutorDeTextoEmMusica() {
		this.TextoBruto = "";
		this.TextoTraduzido = "";	
		DicionarioDeNotas = new Dicionario();
	}
	
	public void setTextoBruto(String TextoBruto) {
		this.TextoBruto = TextoBruto.toUpperCase();		
	}
	
	public String getTextoBruto() {
		return this.TextoBruto;
	}
	
	public String getTextoTraduzido() {
		return this.TextoTraduzido;
	}
	
	public String TraduzirTextoEmMusica() {
		int TamanhoDoTexto;
		String NotaMusical;
		char caractere;
		
		TamanhoDoTexto = this.TextoBruto.length();
		for (int indice = 0; indice < TamanhoDoTexto; indice++) {
			caractere = this.TextoBruto.charAt(indice);
			NotaMusical = DicionarioDeNotas.TraduzirCaractere(String.valueOf(caractere));
			
			if (!NotaMusical.equals("none")) {
				if (this.TextoTraduzido.isEmpty()) {
					this.TextoTraduzido = NotaMusical;
				}
				else {
					//Eh necessario ter um espaco entre as notas musicais
					this.TextoTraduzido = this.TextoTraduzido + " " + NotaMusical; 
				}
			}
		}
		
		return this.TextoTraduzido;
	}

}

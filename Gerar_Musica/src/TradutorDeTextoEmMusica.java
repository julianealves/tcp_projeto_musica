
public class TradutorDeTextoEmMusica {
	private String TextoBruto;
	private String TextoTraduzido;
	private static Dicionario DicionarioDeNotas;
	private final char NOTA_MUSICAL_SOL = 'G';
	private final char NOTA_MUSICAL_LA = 'A';
	private final String SILENCIO = "R";

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
	
	private boolean DigitoPar(int digito) {
		if (digito % 2 == 0) {
			return true;
		}
		return false;
	}
	
	private void InserirNotaMusical(String NotaMusical) {
		if (this.TextoTraduzido.isEmpty()) {
			this.TextoTraduzido = NotaMusical;
		}
		else {
			//Eh necessario ter um espaco entre as notas musicais
			this.TextoTraduzido = this.TextoTraduzido + " " + NotaMusical; 
		}
	}
	
	private boolean CaractereAnteriorEraNotaMusical(char CaractereAnterior) {
		if (CaractereAnterior >= NOTA_MUSICAL_LA && CaractereAnterior <= NOTA_MUSICAL_SOL) {
			return true;
		}
		return false;
	}
	
	public String TraduzirTextoEmMusica() {
		int TamanhoDoTexto;
		String NotaMusicalAtual, NotaMusicalAnterior;
		char CaractereAtual, CaractereAnterior;
		
		NotaMusicalAnterior = "";
		CaractereAnterior = 0;
		
		TamanhoDoTexto = this.TextoBruto.length();
		for (int indice = 0; indice < TamanhoDoTexto; indice++) {
			CaractereAtual = this.TextoBruto.charAt(indice);
			NotaMusicalAtual = DicionarioDeNotas.TraduzirCaractere(String.valueOf(CaractereAtual));
			
			if (!NotaMusicalAtual.equals("none")) {
				this.InserirNotaMusical(NotaMusicalAtual);
			}
			else {
				if(Character.isDigit(CaractereAtual)) {
					if(this.DigitoPar(Character.getNumericValue(CaractereAtual))) {
						NotaMusicalAtual = "AUMENTAROITAVA";
					}
					else {
						NotaMusicalAtual = "DIMINUIROITAVA";
					}
				}
				else if(CaractereAtual > NOTA_MUSICAL_SOL) {
					if(this.CaractereAnteriorEraNotaMusical(CaractereAnterior)) {
						NotaMusicalAtual = NotaMusicalAnterior;
					}
					else {
						NotaMusicalAtual = SILENCIO;
					}
				}
				else {
					NotaMusicalAtual = NotaMusicalAnterior;
				}
				this.InserirNotaMusical(NotaMusicalAtual);
			}
			NotaMusicalAnterior = NotaMusicalAtual;
			CaractereAnterior = CaractereAtual;
		}
		
		return this.TextoTraduzido;
	}

}

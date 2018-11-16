
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
	
	private String AlterarOitavaMusical(char CaractereAtual) {
		if(this.DigitoPar(Character.getNumericValue(CaractereAtual))) {
			return "AUMENTAROITAVA";
		}
		return "DIMINUIROITAVA";
	}
	
	private String DeterminarNotaMusical(String NotaMusicalAnterior, char CaractereAnterior) {
		if(this.CaractereAnteriorEraNotaMusical(CaractereAnterior)) {
			return NotaMusicalAnterior;
		}
		return SILENCIO;
	}
	
	private String DefinirNotaMusicalAtual(String NotaMusicalAnterior, char CaractereAtual, char CaractereAnterior) {
		String NotaMusicalAtual;
		if(Character.isDigit(CaractereAtual)) {
			NotaMusicalAtual = AlterarOitavaMusical(CaractereAtual);
		}
		else if(CaractereAtual > NOTA_MUSICAL_SOL) {
			NotaMusicalAtual = DeterminarNotaMusical(NotaMusicalAnterior, CaractereAnterior);
		}
		else {
			NotaMusicalAtual = NotaMusicalAnterior;
		}
		return NotaMusicalAtual;
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
			
			if (NotaMusicalAtual.equals("none")) {
				NotaMusicalAtual = DefinirNotaMusicalAtual(NotaMusicalAnterior, CaractereAtual, CaractereAnterior);
			}
			
			this.InserirNotaMusical(NotaMusicalAtual);
			NotaMusicalAnterior = NotaMusicalAtual;
			CaractereAnterior = CaractereAtual;
		}
		
		return this.TextoTraduzido;
	}
}

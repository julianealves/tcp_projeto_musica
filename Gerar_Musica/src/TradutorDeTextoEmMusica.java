
public class TradutorDeTextoEmMusica {
	private String TextoBruto;
	private String TextoTraduzido;
	private static Dicionario DicionarioDeNotas;
	private final char NOTA_MUSICAL_SOL = 'G';
	private final char NOTA_MUSICAL_LA = 'A';
	private final String SILENCIO = "R";
	Volume configVolume;
	OitavaMusical configOitava;
	Ritmo  configRitmo;
	
	public TradutorDeTextoEmMusica() {
		this.TextoBruto = "";
		this.TextoTraduzido = "";	
		DicionarioDeNotas = new Dicionario();
	}
	
	public void setConfiguracaoPadrao (Volume volumePadrao, OitavaMusical oitavaPadrao, Ritmo ritmoPadrao) {
		configVolume = volumePadrao;
		configOitava = oitavaPadrao;
		configRitmo = ritmoPadrao;
	}
	
	public void setTextoBruto(String TextoBruto) {
		this.TextoBruto = TextoBruto;		
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
	
	private void AlterarOitavaMusical(char CaractereAtual) {
		configOitava.incrementaOitava();
	}
	
	private String DeterminarNotaMusical(String NotaMusicalAnterior, char CaractereAnterior) {
		if(this.CaractereAnteriorEraNotaMusical(CaractereAnterior)) {
			return NotaMusicalAnterior;
		}
		return SILENCIO;
	}
	
	private String DefinirNotaMusicalAtual(String NotaMusicalAnterior, char CaractereAtual, char CaractereAnterior) {
		String NotaMusicalAtual = "";
		if(CaractereAtual == '?' || CaractereAtual == '.') {
			AlterarOitavaMusical(CaractereAtual);
		}
		else if(CaractereAtual > NOTA_MUSICAL_SOL || Character.isDigit(CaractereAtual)) {
			NotaMusicalAtual = DeterminarNotaMusical(NotaMusicalAnterior, CaractereAnterior);
		}
		else {
			NotaMusicalAtual = NotaMusicalAnterior;
		}
		return NotaMusicalAtual;
	}
	
	private boolean isMudancaDePropriedade(String NotaMusical) {
		return NotaMusical.isEmpty();
		
	}
	
	private boolean isNotaMusicalPura(String NotaMusical) {
		return NotaMusical.length() == 1;
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
			else {
				if (isNotaMusicalPura(NotaMusicalAtual)) {
					NotaMusicalAtual += configOitava.getOitavaMusical();
				}
			}
			
			if (! isMudancaDePropriedade(NotaMusicalAtual)) {
				this.InserirNotaMusical(NotaMusicalAtual);
				NotaMusicalAnterior = NotaMusicalAtual;
				CaractereAnterior = CaractereAtual;
			}
		}
		
		return this.TextoTraduzido;
	}
}

package main;

public class TradutorDeTextoEmMusica {
	private String TextoBruto;
	private String TextoTraduzido = "";
	private static Dicionario DicionarioDeNotas;
	private final char NOTA_MUSICAL_SOL = 'G';
	private final char NOTA_MUSICAL_LA = 'A';
	private final char NOTA_MUSICAL_DO = 'B';
	private final String SILENCIO = "R";
	OitavaMusical configOitava;
	
	public TradutorDeTextoEmMusica() {
		this.TextoBruto = "";
		limparTextoTraduzido();	
		
		DicionarioDeNotas = new Dicionario();
	}
	
	private void limparTextoTraduzido() {
		this.TextoTraduzido = "";
	}
	
	public void setTextoBruto(String TextoBruto) {
		this.TextoBruto = TextoBruto;	
		limparTextoTraduzido();
	}
	
	public String getTextoBruto() {
		return this.TextoBruto;
	}
	
	public String getTextoTraduzido() {
		return this.TextoTraduzido;
	}
	
	private void inserirNotaMusical(String NotaMusical) {
		if (this.TextoTraduzido.isEmpty()) {
			this.TextoTraduzido = NotaMusical;
		}
		else {
			//Eh necessario ter um espaco entre as notas musicais
			this.TextoTraduzido = this.TextoTraduzido + " " + NotaMusical; 
		}
	}
	
	private boolean caractereAnteriorEraNotaMusical(char CaractereAnterior) {
		if (CaractereAnterior >= NOTA_MUSICAL_LA && CaractereAnterior <= NOTA_MUSICAL_SOL) {
			return true;
		}
		return false;
	}
	
	private void alterarOitavaMusical(char CaractereAtual) {
		configOitava.incrementaOitava();
	}
	
	private String determinarNotaMusical(String NotaMusicalAnterior, char CaractereAnterior) {
		if(this.caractereAnteriorEraNotaMusical(CaractereAnterior)) {
			return NotaMusicalAnterior;
		}
		return SILENCIO;
	}
	
	private String definirNotaMusicalAtual(String NotaMusicalAnterior, char CaractereAtual, char CaractereAnterior) {
		String NotaMusicalAtual = "";
		if(CaractereAtual == '?' || CaractereAtual == '.') {
			alterarOitavaMusical(CaractereAtual);
		}
		else if(CaractereAtual > NOTA_MUSICAL_SOL || CaractereAtual < NOTA_MUSICAL_LA) {
			NotaMusicalAtual = determinarNotaMusical(NotaMusicalAnterior, CaractereAnterior);
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
	
	private boolean notaMusicalAceitaOitava(String NotaMusical, int oitavaMusical) {
		boolean aceitaOitava = true;
		if(NotaMusical.charAt(0) == NOTA_MUSICAL_LA || NotaMusical.charAt(0) == NOTA_MUSICAL_DO) {
			if (oitavaMusical == 10) {
				aceitaOitava = false;
			}
		}
		return aceitaOitava;
	}
	
	private String adicionarOitavaMusical(String NotaMusicalAtual) {
		if(notaMusicalAceitaOitava(NotaMusicalAtual, configOitava.getOitavaMusical())) {
			NotaMusicalAtual += configOitava.getOitavaMusical();
		}
		else {
			configOitava.setOitavaDefault();
			NotaMusicalAtual += configOitava.getOitavaMusical();
			
		}
		return NotaMusicalAtual;
	}
	
	public String TraduzirTextoEmMusica(OitavaMusical oitavaPadrao) {
		int TamanhoDoTexto;
		String NotaMusicalAtual, NotaMusicalAnterior;
		char CaractereAtual, CaractereAnterior;
		
		configOitava = oitavaPadrao;
		
		NotaMusicalAnterior = "";
		CaractereAnterior = 0;
		
		TamanhoDoTexto = this.TextoBruto.length();
		for (int indice = 0; indice < TamanhoDoTexto; indice++) {
			CaractereAtual = this.TextoBruto.charAt(indice);
			NotaMusicalAtual = DicionarioDeNotas.traduzirCaractere(String.valueOf(CaractereAtual));
			
			if (NotaMusicalAtual.equals("none")) {
				NotaMusicalAtual = definirNotaMusicalAtual(NotaMusicalAnterior, CaractereAtual, CaractereAnterior);
			}
			else {
				if (isNotaMusicalPura(NotaMusicalAtual)) {
					NotaMusicalAtual = adicionarOitavaMusical(NotaMusicalAtual);
				}
			}
			
			if (! isMudancaDePropriedade(NotaMusicalAtual)) {
				this.inserirNotaMusical(NotaMusicalAtual);
				NotaMusicalAnterior = NotaMusicalAtual;
				CaractereAnterior = CaractereAtual;
			}
		}
		
		return this.TextoTraduzido;
	}
}

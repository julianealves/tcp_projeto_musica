
public class InstrumentoMusical {
	private int InstrumentoMusicalAtual;
	private final int INSTRUMENTO_NUMERO_0 = 0; //PIANO
	private final int INSTRUMENTO_NUMERO_127 = 127; //GUNSHOT

	public InstrumentoMusical() {
		InstrumentoMusicalAtual = INSTRUMENTO_NUMERO_0;
	}
	
	public void setIntrumentoMusicalAtual(int NumeroDoInstrumento) {
		InstrumentoMusicalAtual = NumeroDoInstrumento;
	}
	
	public String getIntrumentoMusicalAtual() {
		return Integer.toString(InstrumentoMusicalAtual);
	}
	
	public void AtualizarIntrumentoMusical(int FatorDeSoma) {
		if (InstrumentoMusicalAtual + FatorDeSoma <= INSTRUMENTO_NUMERO_127) {
			InstrumentoMusicalAtual = InstrumentoMusicalAtual + FatorDeSoma;
		}
	}

}

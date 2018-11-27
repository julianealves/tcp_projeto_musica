package main;

public class InstrumentoMusical {
	private int InstrumentoMusicalAtual;
	private final int INSTRUMENTO_NUMERO_0 = 0; //PIANO
	private final int INSTRUMENTO_NUMERO_127 = 127; //GUNSHOT

	public InstrumentoMusical() {
		InstrumentoMusicalAtual = INSTRUMENTO_NUMERO_0;
	}
	
	public void setIntrumentoMusicalAtual(int NumeroDoInstrumento) {
		if (NumeroDoInstrumento > INSTRUMENTO_NUMERO_127) {
			InstrumentoMusicalAtual = INSTRUMENTO_NUMERO_127;
		}
		else if(NumeroDoInstrumento < INSTRUMENTO_NUMERO_0) {
			InstrumentoMusicalAtual = INSTRUMENTO_NUMERO_0;
		}
		else {
			InstrumentoMusicalAtual = NumeroDoInstrumento;
		}
	}
	
	public String getIntrumentoMusicalAtual() {
		return Integer.toString(InstrumentoMusicalAtual);
	}
	
	public void atualizarIntrumentoMusical(int FatorDeSoma) {
		if (InstrumentoMusicalAtual + FatorDeSoma >= INSTRUMENTO_NUMERO_0 && InstrumentoMusicalAtual + FatorDeSoma <= INSTRUMENTO_NUMERO_127) {
			InstrumentoMusicalAtual = InstrumentoMusicalAtual + FatorDeSoma;
		}
	}

}

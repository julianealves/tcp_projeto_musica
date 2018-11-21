
public class OitavaMusical {
	private final int OITAVA_MAXIMA = 10;
	private final int OITAVA_DEFAULT = 5;
	private final int OITAVA_MINIMA = 0;
	private int oitavaAtual;
	
	
	public OitavaMusical(int oitavaDefault) {
		oitavaAtual = oitavaDefault;
	}
	
	private boolean isOitavaMaxima() {
		return oitavaAtual == OITAVA_MAXIMA;
	}

	public void incrementaOitava() {
		if (!isOitavaMaxima()) {
			oitavaAtual++;
		}
		else {
			oitavaAtual = OITAVA_DEFAULT;
		}
	}
	
	private boolean isOitavaMinima() {
		return oitavaAtual == OITAVA_MINIMA;
	}
	
	public void decrementaOitava() {
		if (!isOitavaMinima()) {
			oitavaAtual--;
		}
	}
	
	public int getOitavaMusical() {
		return oitavaAtual;
	}
	
}

public class Volume {
	private final int VOLUME_MAXIMO = 16383;
	private int volumeAtual;
	
	
	public Volume(int volumePadrao) {
		volumeAtual = volumePadrao;
	}
	
	
	
	//Volume satura no volume Máximo
	public void multiplicaVolume(int fator) {
		if (volumeAtual * fator <= VOLUME_MAXIMO) {
			volumeAtual *= fator;
		}
	
	}
	public void divideVolume(int fator) {
		volumeAtual /= fator;
	}
	
	public int getVolume() {
		return volumeAtual;
	}
	
	public void setVolume(int novoVolume) {
		volumeAtual = novoVolume;
	}

	

}

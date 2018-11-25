package main;
public class Volume {
	private final int VOLUME_MAXIMO = 16383;
	private int volumeAtual;
	
	
	public Volume(int volumePadrao) {
		volumeAtual = volumePadrao;
	}
	
	//Volume satura no volume maximo
	public void multiplicaVolume(float fator) {
		if ((int) (volumeAtual * fator) <= VOLUME_MAXIMO) {
			volumeAtual = (int) (volumeAtual*fator);
		}
	
	}
	public void divideVolume(float fator) {
		volumeAtual = (int) (volumeAtual/fator);
	}
	
	public int getVolume() {
		return volumeAtual;
	}
	
	public void setVolume(int novoVolume) {
		volumeAtual = novoVolume;
	}
}

package main;
public class Volume {
	private final int VOLUME_MAXIMO = 16383;
	private final int VOLUME_MINIMO = 0;
	private int volumeAtual;
	
	
	public Volume(int volumePadrao) {
		if (volumePadrao > VOLUME_MAXIMO) {
			volumeAtual = VOLUME_MAXIMO;
		}
		else if (volumePadrao < VOLUME_MINIMO) {
			volumeAtual = VOLUME_MINIMO;
		}
		else {
			volumeAtual = volumePadrao;
		}		
	}
	
	//Volume satura no volume maximo
	public void multiplicaVolume(float fator) {
		if (fator >= 0 && (int) (volumeAtual * fator) <= VOLUME_MAXIMO) {
			volumeAtual = (int) (volumeAtual*fator);
		}
		else {
			volumeAtual = VOLUME_MAXIMO;
		}
	}
	
	public void divideVolume(float fator) {
		if (fator > 0) {
			volumeAtual = (int) (volumeAtual/fator);
		}
	}
	
	public int getVolume() {
		return volumeAtual;
	}
	
	public void setVolume(int novoVolume) {
		if (novoVolume > VOLUME_MAXIMO) {
			volumeAtual = VOLUME_MAXIMO;
		}
		else if(novoVolume < VOLUME_MINIMO){
			volumeAtual = VOLUME_MINIMO;
		}
		else {
			volumeAtual = novoVolume;
		}
		
	}
}

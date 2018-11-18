
public class Musica {
	private String textoBruto;
	private String codificacaoJFugue;
	
	private Volume volume;
	private Ritmo ritmo;
	private OitavaMusical oitava;
	
	public Musica(String textoACodificar,int volumePadrao, int ritmoPadrao, int oitavaPadrao) {
		volume =  new Volume(volumePadrao);
		ritmo  =  new Ritmo(ritmoPadrao);
		oitava =  new OitavaMusical(ritmoPadrao);
		
		textoBruto = textoACodificar;
	}
	
	public void setTextoBruto(String textoACodificar) {
		textoBruto = textoACodificar;
	}
	
	public String getCodificacaoJFugue() {
		return codificacaoJFugue;
	}
	
	private boolean aindaHaRitmos(String codificacaoJFugue) {
		return codificacaoJFugue.indexOf("BPM") != -1;
	}
	
	private boolean ehSubidaDeRitmo(int indiceInicialMudanca) {
		return ehAumentoDeVolume(indiceInicialMudanca);
	}
	
	private void ajustaRitmo() {
		
		int indiceInicialMudanca;
		String ritmoFormatoJFugue;
		
		
		while (aindaHaRitmos(codificacaoJFugue)) {
			indiceInicialMudanca = codificacaoJFugue.indexOf("BPM");
			
			if (ehSubidaDeRitmo(indiceInicialMudanca)) { //BPM Up
				ritmo.aumentaRitmo();
				ritmoFormatoJFugue = "T[" + ritmo.getRitmoAtual() + "]";
				codificacaoJFugue = codificacaoJFugue.replaceFirst("BPMU", ritmoFormatoJFugue);
			}
			
			else {// BPM Down
				ritmo.diminuiRitmo();
				ritmoFormatoJFugue = "T[" + ritmo.getRitmoAtual() + "]";
				codificacaoJFugue = codificacaoJFugue.replaceFirst("BPMD", ritmoFormatoJFugue);
			}
		}
	}
	
	private boolean aindaHaVolume() {
		return codificacaoJFugue.indexOf("VOL") != -1;
	}
	
	private void ajustaVolume() {
		
		int indiceInicialMudanca;
		String volumeFormatoJFugue;
		
		while (aindaHaVolume()) {
			indiceInicialMudanca = codificacaoJFugue.indexOf("VOL");
			
			if (ehAumentoDeVolume(indiceInicialMudanca)) { //Volume Up
				volume.multiplicaVolume(2);
				volumeFormatoJFugue = "X[Volume]=" + volume.getVolume();
				codificacaoJFugue = codificacaoJFugue.replaceFirst("VOLU", volumeFormatoJFugue);
				
			}
			
			else {//Volume Down
				volume.divideVolume(2);
				volumeFormatoJFugue = "X[Volume]=" + volume.getVolume();
				codificacaoJFugue = codificacaoJFugue.replaceFirst("VOLD", volumeFormatoJFugue);
				
			}
			
		}
	}

	private boolean ehAumentoDeVolume(int indiceInicialMudanca) {
		return codificacaoJFugue.charAt(indiceInicialMudanca + 3) == 'U';
	}

	

	
	
	public void recodificacaoJFugue(TradutorDeTextoEmMusica codificador) {
		codificador.setTextoBruto(textoBruto);
		codificador.setConfiguracaoPadrao(volume,oitava,ritmo);
		codificacaoJFugue = codificador.TraduzirTextoEmMusica();
		ajustaRitmo();
		ajustaVolume();
				
	}

	
	

}

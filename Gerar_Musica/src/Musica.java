
public class Musica {
	private String textoBruto;
	private String codificacaoJFugue;
	
	private Volume volume;
	private Ritmo ritmo;
	private OitavaMusical oitava;
	
	public Musica(String textoACodificar,int volumePadrao, int ritmoPadrao, int oitavaPadrao) {
		volume =  new Volume(volumePadrao);
		ritmo  =  new Ritmo(ritmoPadrao);
		oitava =  new OitavaMusical(oitavaPadrao);
		
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
	
	private boolean ehAumentoDeVolume(int indiceInicialMudanca) {
		return codificacaoJFugue.charAt(indiceInicialMudanca + 3) == 'U';
	}
	
	private float pegarFatorDeMultiplicidade(int indiceInicialMudanca) {
		float fatorDeMultiplicidade;
		String fator = "";
		int indice;
		boolean finalizarProcura = false;
		
		indice = indiceInicialMudanca + 5;
		
		while(!finalizarProcura) {
			if(codificacaoJFugue.charAt(indice) != '_') {
				fator = fator + codificacaoJFugue.charAt(indice);				
				indice = indice + 1;
			}
			else {
				codificacaoJFugue = codificacaoJFugue.replaceFirst(fator, "");
				finalizarProcura = true;
			}
		}
		codificacaoJFugue = codificacaoJFugue.replaceFirst("_", "");
		codificacaoJFugue = codificacaoJFugue.replaceFirst("_", "");
		
		fatorDeMultiplicidade = Float.parseFloat(fator);
		return fatorDeMultiplicidade;
	}
	
	private boolean aindaHaVolume() {
		return codificacaoJFugue.indexOf("VOL") != -1;
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
	
	private void ajustaVolume() {
		
		int indiceInicialMudanca;
		String volumeFormatoJFugue;
		float fatorDeMultiplicidade;
		
		while (aindaHaVolume()) {
			indiceInicialMudanca = codificacaoJFugue.indexOf("VOL");
			
			if (ehAumentoDeVolume(indiceInicialMudanca)) { //Volume Up
				fatorDeMultiplicidade = pegarFatorDeMultiplicidade(indiceInicialMudanca);
				volume.multiplicaVolume(fatorDeMultiplicidade);
				volumeFormatoJFugue = "X[Volume]=" + volume.getVolume();
				codificacaoJFugue = codificacaoJFugue.replaceFirst("VOLU", volumeFormatoJFugue);
				
			}
			
			else {//Volume Down
				volume.divideVolume((float) 2.0);
				volumeFormatoJFugue = "X[Volume]=" + volume.getVolume();
				codificacaoJFugue = codificacaoJFugue.replaceFirst("VOLD", volumeFormatoJFugue);
			}
			
		}
	}
	
	public void recodificacaoJFugue(TradutorDeTextoEmMusica codificador) {
		codificador.setTextoBruto(textoBruto);
		codificador.setConfiguracaoPadrao(volume, oitava, ritmo);
		codificacaoJFugue = codificador.TraduzirTextoEmMusica();
		ajustaRitmo();
		ajustaVolume();
				
	}

}

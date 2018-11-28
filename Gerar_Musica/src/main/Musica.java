package main;

import java.util.regex.Pattern;

public class Musica {
	private String textoBruto;
	private String codificacaoJFugue;
	
	private Volume volume;
	private Ritmo ritmo;
	private OitavaMusical oitava;
	private InstrumentoMusical InstrumentoMusical;
	
	public Musica(String textoACodificar) {
		volume =  new Volume(1000);
		ritmo  =  new Ritmo(0);
		oitava =  new OitavaMusical(5);
		InstrumentoMusical = new InstrumentoMusical();
		codificacaoJFugue = "";
		
		textoBruto = textoACodificar;
	}
	
	private void limparCodificacaoJFugue() {
		codificacaoJFugue = "";
	}
	
	public void setTextoBruto(String textoACodificar) {
		textoBruto = textoACodificar;
		limparCodificacaoJFugue();
	}
	
	public String getCodificacaoJFugue() {
		return codificacaoJFugue;
	}
	
	private boolean aindaHaRitmos() {
		return codificacaoJFugue.indexOf("BPM") != -1;
	}
	
	private boolean ehSubidaDeRitmo(int indiceInicialMudanca) {
		return ehAumentoDeVolume(indiceInicialMudanca);
	}
	
	private boolean ehAumentoDeVolume(int indiceInicialMudanca) {
		return codificacaoJFugue.charAt(indiceInicialMudanca + 3) == 'U';
	}
	
	private boolean ehFatorDeSoma(int indiceInicialMudanca) {
		return codificacaoJFugue.charAt(indiceInicialMudanca + 11) == 'F';
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
				finalizarProcura = true;
			}
		}
		
		fatorDeMultiplicidade = Float.parseFloat(fator);
		return fatorDeMultiplicidade;
	}
	
	private int pegarInstrumentoMusical(int indiceInicialMudanca, int indiceDoNumeroInstrumento) {
		String instrumentoMusical = "";
		int indice;
		boolean finalizarProcura = false;
		
		indice = indiceInicialMudanca + indiceDoNumeroInstrumento;
		
		while(!finalizarProcura) {
			if(codificacaoJFugue.charAt(indice) != '_') {
				instrumentoMusical = instrumentoMusical + codificacaoJFugue.charAt(indice);				
				indice = indice + 1;
			}
			else {
				finalizarProcura = true;
			}			
		}
		
		return Integer.parseInt(instrumentoMusical);
	}
	
	private boolean aindaHaVolume() {
		return codificacaoJFugue.indexOf("VOL") != -1;
	}
	
	private boolean aindaHaInstrumentoMusical() {
		return codificacaoJFugue.indexOf("INSTRUMENTO") != -1;
	}
	
	private void ajustaRitmo() {
		
		int indiceInicialMudanca;
		String ritmoFormatoJFugue;
		
		
		while (aindaHaRitmos()) {
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
				codificacaoJFugue = codificacaoJFugue.replaceFirst("VOLU_" + Float.toString(fatorDeMultiplicidade) + "_", volumeFormatoJFugue);
			}
			
			else {//Volume Down
				volume.divideVolume((float) 2.0);
				volumeFormatoJFugue = "X[Volume]=" + volume.getVolume();
				codificacaoJFugue = codificacaoJFugue.replaceFirst("VOLD", volumeFormatoJFugue);
			}	
		}
	}
	
	private void ajustaInstrumentoMusical() {
		int indiceInicialMudanca;
		int numeroDoInstrumento;
		String instrumentoFormatoJFugue;
		boolean possuiFatorDeSoma = false;
		
		while (aindaHaInstrumentoMusical()) {
			indiceInicialMudanca = codificacaoJFugue.indexOf("INSTRUMENTO");
			if (ehFatorDeSoma(indiceInicialMudanca)) {
				numeroDoInstrumento = pegarInstrumentoMusical(indiceInicialMudanca, 13);
				InstrumentoMusical.somarFatorInstrumentoAtual(numeroDoInstrumento);
				possuiFatorDeSoma = true;
			}
			else {
				numeroDoInstrumento = pegarInstrumentoMusical(indiceInicialMudanca, 12);
				InstrumentoMusical.setInstrumentoMusicalAtual(numeroDoInstrumento);
			}
			
			instrumentoFormatoJFugue = "I" + InstrumentoMusical.getInstrumentoMusicalAtual();
			if (possuiFatorDeSoma) {
				String stringParaTrocar = Pattern.quote("INSTRUMENTOF_" + Integer.toString(numeroDoInstrumento) + "_");
				codificacaoJFugue = codificacaoJFugue.replaceFirst(stringParaTrocar, instrumentoFormatoJFugue);
			}
			else {
				codificacaoJFugue = codificacaoJFugue.replaceFirst("INSTRUMENTO_" + InstrumentoMusical.getInstrumentoMusicalAtual() +  "_", instrumentoFormatoJFugue);
			}
			
			possuiFatorDeSoma = false;
		}
		
	}
	
	public void recodificacaoJFugue(TradutorDeTextoEmMusica codificador) {
		codificador.setTextoBruto(textoBruto);
		codificacaoJFugue = codificador.TraduzirTextoEmMusica(oitava);
		ajustaRitmo();
		ajustaVolume();
		ajustaInstrumentoMusical();		
	}

}

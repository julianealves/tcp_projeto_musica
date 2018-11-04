
public class Musica {
	private String Musica;
	private int VolumeDaMusica;
	private int OitavaMusical;
	private int BPM;
	private final int VOLUME_MAXIMO = 16383;
	private final int OITAVA_DEFAULT = 5;
	private final int OITAVA_MAXIMA = 10;
	private final int OITAVA_MINIMA = 0;
	private final int BPM_MINIMO = 40;
	private final int BPM_MAXIMO = 220;
	private final String INSTRUMENTO_MUSICAL = "GUITAR";  //Coloquei um instrumento qualquer, depois decidimos qual sera

	public Musica() {
		this.Musica = "";
		this.VolumeDaMusica = 10200;
		this.OitavaMusical = OITAVA_DEFAULT;
		this.BPM = 120;
	}
	
	public void ComporMusica(String Musica) {
		
		this.Musica = Musica;
		this.VerificarVolume("AUMENTARVOLUME");	
		this.VerificarVolume("DIMINUIRVOLUME");
		this.VerificarOitava("AUMENTAROITAVA");
		this.VerificarOitava("DIMINUIROITAVA");
		this.VerificarOitava("OITAVADEFAULT");
		this.VerificarBPM("AUMENTARBPM");
		this.VerificarBPM("DIMINUIRBPM");
		this.VerificarInstrumento("TROCARINSTRUMENTO");
	}
	
	private void DobrarVolume() {
		if (this.VolumeDaMusica*2 <= VOLUME_MAXIMO) {
			this.VolumeDaMusica = this.VolumeDaMusica * 2;
		}
		else {
			this.VolumeDaMusica = VOLUME_MAXIMO;
		}
	}
	
	private void DiminuirVolumePelaMetade() {
		this.VolumeDaMusica = this.VolumeDaMusica/2;
	}
	
	private void VerificarVolume(String operacao) {
		int indice;
		
		indice = 0;
		
		while(indice > -1) {
			indice = this.Musica.indexOf(operacao);
			
			if (indice > -1) {
				if (operacao == "AUMENTARVOLUME") {
					this.DobrarVolume();
				}
				else {
					this.DiminuirVolumePelaMetade();
				}
				
				this.Musica = this.Musica.replaceFirst(operacao, "X[Volume]=" + Integer.toString(this.VolumeDaMusica));
			}
		}
	}
	
	private void VerificarOitava(String operacao) {
		int indice;
			
		indice = 0;
			
		while(indice > -1) {
			indice = this.Musica.indexOf(operacao);
			
			if (indice > -1) {
				if (operacao == "AUMENTAROITAVA") {
					this.OitavaMusical = this.OitavaMusical + 1;
					if (this.OitavaMusical > OITAVA_MAXIMA) {
						this.OitavaMusical = OITAVA_MAXIMA;
					}
				}
				else if (operacao == "DIMINUIROITAVA") {
					this.OitavaMusical = this.OitavaMusical - 1;
					if (this.OitavaMusical < OITAVA_MINIMA) {
						this.OitavaMusical = OITAVA_MINIMA;
					}
				}
				else {
					this.OitavaMusical = OITAVA_DEFAULT;
				}
				this.Musica = this.Musica.replaceFirst(operacao, "C" + Integer.toString(this.OitavaMusical));
			}
			
		}
			
	}
	
	private void VerificarBPM(String operacao) {
		//TODO: alterar a logica, pois o JFugue nao tem um padrao de aumento de BPM
		int indice;
			
		indice = 0;
			
		while(indice > -1) {
			indice = this.Musica.indexOf(operacao);
			
			if (indice > -1) {
				if (operacao == "AUMENTARBPM") {
					this.BPM = this.BPM + 5;
					if (this.BPM > BPM_MAXIMO) {
						this.BPM = BPM_MAXIMO;
					}
				}
				else {
					this.BPM = this.BPM - 5;
					if (this.BPM < BPM_MINIMO) {
						this.BPM = BPM_MINIMO;
					}
				}
				this.Musica = this.Musica.replaceFirst(operacao, "T" + Integer.toString(this.BPM));
			}
			
		}
			
	}
	
	private void VerificarInstrumento(String operacao) {
		int indice;
		
		indice = 0;
			
		while(indice > -1) {
			indice = this.Musica.indexOf(operacao);
			if (indice > -1) {
				this.Musica = this.Musica.replaceFirst(operacao, "T[" + INSTRUMENTO_MUSICAL + "]");
			}
		}
	}
	
	public String getMusicaString() {
		return this.Musica;
	}
}


public class Musica {
	private String Musica;
	private int VolumeDaMusica;
	private int OitavaMusical;
	private int BPM;

	public Musica() {
		this.Musica = "";
		this.VolumeDaMusica = 10200;
		this.OitavaMusical = 5;
		this.BPM = 120;
	}
	
	public void ComporMusica(String Musica) {
		this.Musica = Musica;
	}
	
	public String getMusicaString() {
		return this.Musica;
	}
}

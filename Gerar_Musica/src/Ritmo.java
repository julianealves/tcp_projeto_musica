import java.awt.List;
import java.util.ArrayList;
import java.io.*;

public class Ritmo {
	private ArrayList<String> escalaDeRitmo;
	private int ritmoAtual;
	
	private void preencheEscala() {
		escalaDeRitmo = new ArrayList<String>();
		escalaDeRitmo.add("Grave");
		escalaDeRitmo.add("Largo");
		escalaDeRitmo.add("Larghetto");
		escalaDeRitmo.add("Lento");
		escalaDeRitmo.add("Adagio");
		escalaDeRitmo.add("Adagietto");
		escalaDeRitmo.add("Andante");
		escalaDeRitmo.add("Andantino");
		escalaDeRitmo.add("Moderato");
		escalaDeRitmo.add("Allegro");
		escalaDeRitmo.add("Vivace");
		escalaDeRitmo.add("Presto");
		escalaDeRitmo.add("Pretissimo");
	}
	
	
	public Ritmo(int ritmoDefault) {
		preencheEscala();
		ritmoAtual = ritmoDefault;
		
		
	}
	
	public String getRitmoAtual() {
		return (String) escalaDeRitmo.get(ritmoAtual);
	}
	
	private boolean isRitmoMaximo() {
		return ritmoAtual == (escalaDeRitmo.size() - 1);
	}
	
	//Satura o ritmo no ritmoMaximo
	public void aumentaRitmo() {
		if (!isRitmoMaximo()) {
			ritmoAtual++;
		}	
	}
	

	private boolean isRitmoMinimo() {
		return ritmoAtual == 0;
	}
	
	//Satura o ritmo no ritimoMinimo
	public void diminuiRitmo(){
		if (!isRitmoMinimo()) {
			ritmoAtual--;
		}
	}
	
}

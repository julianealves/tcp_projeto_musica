package main;
import java.util.ArrayList;

public class Ritmo {
	private ArrayList<String> escalaDeRitmo;
	private int ritmoAtual;
	private final int RITMO_MAXIMO = 12;
	private final int RITMO_MINIMO = 0;
	
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
		
		if (ritmoDefault > RITMO_MAXIMO) {
			ritmoAtual = RITMO_MAXIMO;
		}
		else if(ritmoDefault < RITMO_MINIMO) {
			ritmoAtual = RITMO_MINIMO;
		}
		else {
			ritmoAtual = ritmoDefault;
		}		
	}
	
	public String getRitmoAtual() {
		return (String) escalaDeRitmo.get(ritmoAtual);
	}
	
	private boolean isRitmoMaximo() {
		return ritmoAtual == RITMO_MAXIMO;
	}
	
	//Satura o ritmo no ritmoMaximo
	public void aumentaRitmo() {
		if (!isRitmoMaximo()) {
			ritmoAtual++;
		}	
	}

	private boolean isRitmoMinimo() {
		return ritmoAtual == RITMO_MINIMO;
	}
	
	//Satura o ritmo no ritimoMinimo
	public void diminuiRitmo(){
		if (!isRitmoMinimo()) {
			ritmoAtual--;
		}
	}
	
}

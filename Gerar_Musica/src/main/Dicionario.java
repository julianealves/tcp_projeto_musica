package main;
import java.util.HashMap;
import java.util.Map;

public class Dicionario {
	
	private Map<String, String> DicionarioDeNotas = new HashMap<String, String>();

	public Dicionario() {
		/* Inicializacao do dicionario com as notas musicais.
		 Os caraceteres correspondem as chaves e as notas 
		 correspondem aos valores das chaves.		 
		*/
		
		DicionarioDeNotas.put( "A", new String( "A" )); //Nota La
		DicionarioDeNotas.put( "B", new String( "B" )); //Nota Si
		DicionarioDeNotas.put( "C", new String( "C" )); //Nota Do
		DicionarioDeNotas.put( "D", new String( "D" )); //Nota Re
		DicionarioDeNotas.put( "E", new String( "E" )); //Nota Mi
		DicionarioDeNotas.put( "F", new String( "F" )); //Nota Fa
		DicionarioDeNotas.put( "G", new String( "G" )); //Nota Sol
		DicionarioDeNotas.put( " ", new String( "VOLU_2.0_" )); //Aumentar o volume
		DicionarioDeNotas.put( "!", new String( "INSTRUMENTO_6_" )); //Trocar para instrumento 6 (HARPISCHORD)
		DicionarioDeNotas.put( "I", new String( "VOLU_1.1_" )); //Aumentar o volume em 10%
		DicionarioDeNotas.put( "O", new String( "VOLU_1.1_" )); //Aumentar o volume em 10%
		DicionarioDeNotas.put( "U", new String( "VOLU_1.1_" )); //Aumentar o volume em 10%
		DicionarioDeNotas.put( "i", new String( "VOLU_1.1_" )); //Aumentar o volume em 10%
		DicionarioDeNotas.put( "o", new String( "VOLU_1.1_" )); //Aumentar o volume em 10%
		DicionarioDeNotas.put( "u", new String( "VOLU_1.1_" )); //Aumentar o volume em 10%
		DicionarioDeNotas.put( "\r\n", new String( "INSTRUMENTO_14_" )); //Trocar para instrumento 14 (TUBULAR BELLS)
		DicionarioDeNotas.put( "\n", new String( "INSTRUMENTO_14_" )); //Trocar para instrumento 14 (TUBULAR BELLS)
		DicionarioDeNotas.put( ";", new String( "INSTRUMENTO_75_" )); //Trocar para instrumento 75 (PAN FLUTE)
		DicionarioDeNotas.put( ",", new String( "INSTRUMENTO_19_" )); //Trocar para instrumento 19 (CHURCH ORGAN)	
	}
	
	public String TraduzirCaractere(String caractere) {		
		if (DicionarioDeNotas.containsKey(caractere)) {
			return DicionarioDeNotas.get(caractere);
		}
		else if(Character.isDigit(caractere.charAt(0))) {	
			int indice = 0;
			String fator = "";
			while (indice < caractere.length() && Character.isDigit(caractere.charAt(indice))) {
				fator = fator + caractere.charAt(indice);
				indice = indice + 1;
			}
			return "INSTRUMENTOF_" + fator + "_";  //F de Fator de soma
		}
		return "none";
	}

}

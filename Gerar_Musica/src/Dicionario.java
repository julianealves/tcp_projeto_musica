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
		DicionarioDeNotas.put( " ", new String( "R" )); //Silencio/pausa
		DicionarioDeNotas.put( "!", new String( "AUMENTARVOLUME" )); //Aumentar o volume
		DicionarioDeNotas.put( "I", new String( "DIMINUIRVOLUME" )); //Diminuir o volume
		DicionarioDeNotas.put( "O", new String( "DIMINUIRVOLUME" )); //Diminuir o volume
		DicionarioDeNotas.put( "U", new String( "DIMINUIRVOLUME" )); //Diminuir o volume
		DicionarioDeNotas.put( "\r\n", new String( "TROCARINSTRUMENTO" )); //Trocar de instrumento musical
		DicionarioDeNotas.put( "\n", new String( "TROCARINSTRUMENTO" )); //Trocar de instrumento
		DicionarioDeNotas.put( ";", new String( "AUMENTARBPM" )); //Aumenta quantidade de batidas por minuto
		DicionarioDeNotas.put( ",", new String( "DIMINUIRBPM" )); //Diminui quantidade de batidas por minuto
		DicionarioDeNotas.put( "?", new String( "OITAVADEFAULT" )); //Coloca oitava default
		DicionarioDeNotas.put( ".", new String( "OITAVADEFAULT" )); //Coloca oitava default	
	}
	
	public String TraduzirCaractere(String caractere) {
		if (DicionarioDeNotas.containsKey(caractere)) {
			return DicionarioDeNotas.get(caractere);
		}
		return "none";
	}

}

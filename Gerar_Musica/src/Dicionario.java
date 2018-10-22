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
	}
	
	public String TraduzirCaractere(String caractere) {
		return DicionarioDeNotas.get(caractere);
	}

}

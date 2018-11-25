package main;

import controllers.ControladorInterface;

public class ControladorDoSistema {
	
	private static ControladorInterface interfaceUsuario;

	public static void main(String[] args) {
		interfaceUsuario.iniciarUI(args);
	}

}

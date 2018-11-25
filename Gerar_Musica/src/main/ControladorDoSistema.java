package main;

import controllers.ControladorInterface;

public class ControladorDoSistema {
	
	private static ControladorInterface interfaceUsuario = new ControladorInterface();

	public static void main(String[] args) {
		interfaceUsuario.iniciarUI(args);
	}

}

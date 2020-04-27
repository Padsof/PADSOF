package gui.control;

import gui.mainform.*;

public class ControladorRegistrarse {

	private Registrarse botonRegistrarse;
	
	public ControladorRegistrarse(RegistroFrame registro) {
		
		this.botonRegistrarse = new Registrarse(registro);
	}

	public Registrarse getBotonRegistrarse() {
		return botonRegistrarse;
	}
	
	
}

package gui.control;

import gui.mainform.RegistroFrame;
import gui.mainform.Ventana;

public class ControladorRegistrate {
	
	private Registrate botonRegistrar;
	
	public ControladorRegistrate(Ventana frame) {
		
		this.botonRegistrar = new Registrate(frame);
	}

	public Registrate getBotonRegistrar() {
		return botonRegistrar;
	}
}

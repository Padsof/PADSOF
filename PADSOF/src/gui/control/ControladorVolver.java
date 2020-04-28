package gui.control;

import gui.mainform.RegistroFrame;
import gui.mainform.Ventana;

public class ControladorVolver {

	private Volver botonVolver;
	//private Ventana frame = new Ventana();
	//private RegistroFrame registro = new RegistroFrame();
	
	public ControladorVolver(Ventana frame, RegistroFrame registro) {
		
		this.botonVolver = new Volver(frame, registro);
	}

	public Volver getBotonVolver() {
		return botonVolver;
	}
	
}

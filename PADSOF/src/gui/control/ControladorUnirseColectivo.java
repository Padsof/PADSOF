package gui.control;

import ads.PADSOF.Ciudadano;
import gui.mainform.AsociacionFrame;
import gui.mainform.Ventana;

public class ControladorUnirseColectivo {
	
	private UnirseColectivo botonUC;
	
	public ControladorUnirseColectivo(AsociacionFrame frame, Ciudadano c) {
		
		this.botonUC = new UnirseColectivo(frame, c);
	}

	public UnirseColectivo getBotonUC() {
		return botonUC;
	}
	
	

}

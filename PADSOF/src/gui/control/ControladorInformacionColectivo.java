package gui.control;

import ads.PADSOF.Ciudadano;
import gui.mainform.MenuAsociacionFrame;
import gui.mainform.Ventana;

public class ControladorInformacionColectivo {
	
	private InformacionColectivo botonInformacionColectivo;
	
	public ControladorInformacionColectivo(MenuAsociacionFrame frame, Ciudadano c) {
		
		this.botonInformacionColectivo = new InformacionColectivo(frame, c);
	}

	public InformacionColectivo getBotonInformacionColectivo() {
		return botonInformacionColectivo;
	}
	
	

}

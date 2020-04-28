package gui.control;

import ads.PADSOF.Ciudadano;
import gui.mainform.AdministradorAceptarFrame;
import gui.mainform.AdministradorUsuarioFrame;
import gui.mainform.UsuarioFrame;

public class ControladorLeerNotificacion {
	
	private LeerNotificacion leer;
	
	public ControladorLeerNotificacion(Ciudadano c, UsuarioFrame frame) {
		
		this.leer = new LeerNotificacion(c, frame);
	}

	public LeerNotificacion getLeer() {
		return leer;
	}
	
	

}

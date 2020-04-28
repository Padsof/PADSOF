package gui.control;

import ads.PADSOF.Ciudadano;
import gui.mainform.UsuarioFrame;

public class ControladorEliminarNotificacion {
	
	private EliminarNotificacion eliminar;
	
	public ControladorEliminarNotificacion(Ciudadano c, UsuarioFrame frame) {
		
		this.eliminar = new EliminarNotificacion(c, frame);
	}

	public EliminarNotificacion getEliminar() {
		return eliminar;
	}
	
	


}

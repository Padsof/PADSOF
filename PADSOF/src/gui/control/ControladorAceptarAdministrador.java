package gui.control;

import gui.mainform.AdministradorAceptarFrame;
import gui.mainform.PerfilAdministradorFrame;

public class ControladorAceptarAdministrador {
	
	private AceptarAdministrador boton;
	
	public ControladorAceptarAdministrador(PerfilAdministradorFrame pa) {
		
		this.boton = new AceptarAdministrador(pa);
	}

	public AceptarAdministrador getBoton() {
		return boton;
	}

	
	

}

package gui.control;

import gui.mainform.*;

public class ControladorAceptarUsuario {
	
	private AceptarUsuario botonAU;
	
	public ControladorAceptarUsuario(AdministradorUsuarioFrame au) {
		
		this.botonAU = new AceptarUsuario(au);
	}

	public AceptarUsuario getBotonAU() {
		return botonAU;
	}
	
	


}

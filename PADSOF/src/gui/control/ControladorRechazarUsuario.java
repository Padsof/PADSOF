package gui.control;

import gui.mainform.*;

public class ControladorRechazarUsuario {
	
private RechazarUsuario botonAU;
	
	public ControladorRechazarUsuario(AdministradorUsuarioFrame au) {
		
		this.botonAU = new RechazarUsuario(au);
	}

	public RechazarUsuario getBotonAU() {
		return botonAU;
	}

}

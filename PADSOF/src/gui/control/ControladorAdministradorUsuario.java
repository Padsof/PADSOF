package gui.control;

import gui.mainform.AdministradorAceptarFrame;
import gui.mainform.AdministradorUsuarioFrame;
import gui.mainform.PerfilAdministradorFrame;
import gui.mainform.UsuarioFrame;
import gui.mainform.Ventana;

public class ControladorAdministradorUsuario {
	
	private AdministradorUsuario botonAU;
	
	public ControladorAdministradorUsuario(AdministradorAceptarFrame frameaa) {
		
		this.botonAU = new AdministradorUsuario(frameaa);
	}

	public AdministradorUsuario getBotonAU() {
		return botonAU;
	}

}

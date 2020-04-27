package gui.control;

import gui.mainform.*;

public class ControladorBloquearUsuario {
	
	private BloquearUsuario botonBU;
	
	public ControladorBloquearUsuario(AdministradorUsuarioFrame au) {
		
		this.botonBU = new BloquearUsuario(au);
	}

	public BloquearUsuario getBotonBU() {
		return botonBU;
	}
	
	

}

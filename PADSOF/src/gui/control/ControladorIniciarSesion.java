package gui.control;

import gui.mainform.PerfilAdministradorFrame;
import gui.mainform.RegistroFrame;
import gui.mainform.UsuarioFrame;
import gui.mainform.Ventana;

public class ControladorIniciarSesion {

	private IniciarSesion botonIniciarSesion;
	
	public ControladorIniciarSesion(Ventana frame) {
		
		this.botonIniciarSesion = new IniciarSesion(frame);
	}

	public IniciarSesion getBotonIniciarSesion() {
		return botonIniciarSesion;
	}

	
	
	
}
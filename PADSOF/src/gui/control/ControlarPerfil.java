package gui.control;

import ads.PADSOF.Ciudadano;
import gui.mainform.*;

public class ControlarPerfil {
	
	private Perfil botonPerfil;
	
	public ControlarPerfil(Ciudadano c, BusquedaFrame frame, ProyectosCreadosFrame proyectos, ProyectoFrame proyecto, CrearProyectoFrame crearp, MenuProyectosFrame menuP, AsociacionFrame asociacion, CrearAsociacionFrame crearAsociacion, AsociacionesCreadasFrame asociacionesCreadas, MenuAsociacionFrame menuAsociacion) {
		
		this.botonPerfil = new Perfil(c, frame,proyectos, proyecto, crearp, menuP, asociacion, crearAsociacion, asociacionesCreadas, menuAsociacion);
	}

	public Perfil getBotonPerfil() {
		return botonPerfil;
	}


}

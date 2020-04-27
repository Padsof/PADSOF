package gui.control;

import ads.PADSOF.Ciudadano;
import gui.mainform.*;

public class ControladorBuscar {
	
	private Buscar botonBuscar;
	
	public ControladorBuscar(Ciudadano c, UsuarioFrame usuario, ProyectosCreadosFrame proyectos, ProyectoFrame proyecto, CrearProyectoFrame crearp, MenuProyectosFrame menuP, AsociacionFrame asociacion, CrearAsociacionFrame crearAsociacion, AsociacionesCreadasFrame asociacionesCreadas, MenuAsociacionFrame menuAsociacion) {
		
		this.botonBuscar = new Buscar(c, usuario, proyectos, proyecto, crearp, menuP, asociacion, crearAsociacion, asociacionesCreadas, menuAsociacion);
	}

	public Buscar getBotonBuscar() {
		return botonBuscar;
	}
	
	

}

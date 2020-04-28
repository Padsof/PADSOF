package gui.control;

import ads.PADSOF.Ciudadano;
import gui.mainform.*;

public class ControladorMenuColectivo {
	
private MenuColectivo botonMenuC;
	
	public ControladorMenuColectivo(Ciudadano c, BusquedaFrame frame, UsuarioFrame usuario, ProyectosCreadosFrame proyectos, ProyectoFrame proyecto, CrearProyectoFrame crearp, MenuProyectosFrame menuP, AsociacionFrame asociacion, CrearAsociacionFrame crearAsociacion, AsociacionesCreadasFrame asociacionesCreadas) {
		
		this.botonMenuC = new MenuColectivo(c, frame, usuario, proyectos, proyecto, crearp, menuP, asociacion, crearAsociacion, asociacionesCreadas);
	}

	public MenuColectivo getBotonMenuC() {
		return botonMenuC;
	}
	
	

}

package gui.control;

import ads.PADSOF.Ciudadano;
import gui.mainform.*;

public class ControladorMenuProyectos {
	
private MenuProyecto botonMenuP;
	
	public ControladorMenuProyectos(Ciudadano ciudadano, BusquedaFrame frame, UsuarioFrame usuario, ProyectosCreadosFrame proyectos, ProyectoFrame proyecto, CrearProyectoFrame crearp, AsociacionFrame asociacion, CrearAsociacionFrame crearAsociacion, AsociacionesCreadasFrame asociacionesCreadas, MenuAsociacionFrame menuAsociacion) {
		
		this.botonMenuP = new MenuProyecto(ciudadano, frame, usuario, proyectos, proyecto, crearp, asociacion, crearAsociacion, asociacionesCreadas, menuAsociacion);
	}

	public MenuProyecto getBotonMenuP() {
		return botonMenuP;
	}
	
	

}

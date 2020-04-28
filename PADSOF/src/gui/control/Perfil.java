package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ads.PADSOF.Ciudadano;
import gui.mainform.*;

public class Perfil implements ActionListener{
	
	private BusquedaFrame frameB;
	private ProyectosCreadosFrame framePC;
	private ProyectoFrame frameP;
	private CrearProyectoFrame frameCP;
	private MenuProyectosFrame frameMP;
	private AsociacionFrame frameA;
	private CrearAsociacionFrame frameCA;
	private AsociacionesCreadasFrame frameAC;
	private MenuAsociacionFrame frameMA;
	
	private FormPanelBusqueda busquedaVista;
	private FormPanelProyectosCreados creadosVista;
	private FormPanelProyecto proyectoVista;
	private FormPanelCrearProyecto crearpVista;
	private FormPanelMenuProyectos menupVista;
	private FormPanelAsociacion asociacionVista;
	private FormPanelCrearAsociacion crearAsociacionVista;
	private FormPanelAsociacionesCreadas asociacionesCreadasVista;
	private FormPanelMenuAsociacion menuAsociacionVista;
	
	private Ciudadano ciudadano;
	
	public Perfil(Ciudadano c, BusquedaFrame frame, ProyectosCreadosFrame proyectos, ProyectoFrame proyecto, CrearProyectoFrame crearp, MenuProyectosFrame menuP, AsociacionFrame asociacion, CrearAsociacionFrame crearAsociacion, AsociacionesCreadasFrame asociacionesCreadas, MenuAsociacionFrame menuAsociacion) { 

		 this.frameB = frame;
		 this.busquedaVista = frame.getBusqueda();
		 this.ciudadano = c;
		 this.framePC = proyectos;
		 this.creadosVista =  proyectos.getProyectosCreados();
		 this.frameP = proyecto;
		 this.proyectoVista = proyecto.getProyecto();
		 this.frameCP = crearp;
		 this.crearpVista = crearp.getProyecto();
		 this.frameMP = menuP;
		 this.menupVista = menuP.getMenuP();
		 this.asociacionVista = asociacion.getAsociacion();
		 this.frameA = asociacion;
		 this.frameCA = crearAsociacion;
		 this.crearAsociacionVista = crearAsociacion.getCrearAsociacion();
		 this.frameAC = asociacionesCreadas;
		 this.asociacionesCreadasVista = asociacionesCreadas.getAsociacionesCreadas();
		 this.frameMA = menuAsociacion;
		 this.menuAsociacionVista = menuAsociacion.getMenuAsociacion();
		 
	 }
	
	public void actionPerformed(ActionEvent arg0) {
		
		UsuarioFrame newframe = new UsuarioFrame(ciudadano);
		FormPanelUsuario newvista = new FormPanelUsuario(ciudadano);
		
		
		ControladorLeerNotificacion controladorLN = new ControladorLeerNotificacion(ciudadano, newframe);
		ControladorEliminarNotificacion controladorEN = new ControladorEliminarNotificacion(ciudadano, newframe);
		ControladorBuscar controladorB = new ControladorBuscar(ciudadano, newframe, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControladorMenuProyectos controladorMP = new ControladorMenuProyectos(ciudadano, frameB, newframe, framePC, frameP, frameCP, frameA, frameCA, frameAC, frameMA);
		ControladorMenuColectivo controladorMC = new ControladorMenuColectivo(ciudadano, frameB, newframe, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC);
	
		newframe.setControladorBuscar(controladorB);
		newframe.setControladorMenuProyecto(controladorMP);
		newframe.setControladorMenuColectivo(controladorMC);
		newframe.setControladorLeerNotificaciones(controladorLN);
		newframe.setControladorEliminarNotificaciones(controladorEN);
		
		
		
		frameB.setVisible(false);
		newframe.setVisible(true);
		framePC.setVisible(false);
		frameP.setVisible(false);
		frameCP.setVisible(false);
		frameMP.setVisible(false);
		frameA.setVisible(false);
		frameCA.setVisible(false);
		frameAC.setVisible(false);
		frameMA.setVisible(false);

		
		newvista.setVisible(true);
		busquedaVista.setVisible(false);
		creadosVista.setVisible(false);
		proyectoVista.setVisible(false);
		crearpVista.setVisible(false);
		menupVista.setVisible(false);
		asociacionVista.setVisible(false);
		crearAsociacionVista.setVisible(false);
		asociacionesCreadasVista.setVisible(false);
		menuAsociacionVista.setVisible(false);

		
	}

}

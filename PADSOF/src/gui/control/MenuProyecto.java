package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ads.PADSOF.Ciudadano;
import gui.mainform.*;

public class MenuProyecto implements ActionListener{

	private BusquedaFrame frameB;
	private UsuarioFrame frameU;
	private ProyectosCreadosFrame framePC;
	private ProyectoFrame frameP;
	private CrearProyectoFrame frameCP;
	private AsociacionFrame frameA;
	private CrearAsociacionFrame frameCA;
	private AsociacionesCreadasFrame frameAC;
	private MenuAsociacionFrame frameMA;
	
	private FormPanelUsuario usuarioVista;
	private FormPanelBusqueda busquedaVista;
	private FormPanelProyectosCreados creadosVista;
	private FormPanelProyecto proyectoVista;
	private FormPanelCrearProyecto crearpVista;
	private FormPanelAsociacion asociacionVista;
	private FormPanelCrearAsociacion crearAsociacionVista;
	private FormPanelAsociacionesCreadas asociacionesCreadasVista;
	private FormPanelMenuAsociacion menuAsociacionVista;
	
	private Ciudadano c;

	
	public MenuProyecto(Ciudadano ciudadano, BusquedaFrame frame, UsuarioFrame usuario, ProyectosCreadosFrame proyectos, ProyectoFrame proyecto, CrearProyectoFrame crearp, AsociacionFrame asociacion, CrearAsociacionFrame crearAsociacion, AsociacionesCreadasFrame asociacionesCreadas, MenuAsociacionFrame menuAsociacion) { 

		 this.c = ciudadano;
		 this.frameB = frame;
		 this.busquedaVista = frame.getBusqueda();
		 this.frameU = usuario;
		 this.usuarioVista = usuario.getUsuario();
		 this.framePC = proyectos;
		 this.creadosVista =  proyectos.getProyectosCreados();
		 this.frameP = proyecto;
		 this.proyectoVista = proyecto.getProyecto();
		 this.frameCP = crearp;
		 this.crearpVista = crearp.getProyecto();
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
		
		MenuProyectosFrame frameMP = new MenuProyectosFrame();
		FormPanelMenuProyectos menupVista = new FormPanelMenuProyectos();
		
		ControladorBuscar controladorB = new ControladorBuscar(c, frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControlarPerfil controladorP = new ControlarPerfil(c, frameB, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControladorMenuColectivo controladorMC = new ControladorMenuColectivo(c, frameB, frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC);

		
		frameMP.setControladorBuscar(controladorB);
		frameMP.setControladorPerfil(controladorP);
		frameMP.setControladorMenuColectivo(controladorMC);


	
		frameB.setVisible(false);
		frameU.setVisible(false);
		framePC.setVisible(false);
		frameP.setVisible(false);
		frameCP.setVisible(false);
		frameMP.setVisible(true);
		frameA.setVisible(false);
		frameCA.setVisible(false);
		frameAC.setVisible(false);
		frameMA.setVisible(false);

		
		usuarioVista.setVisible(false);
		busquedaVista.setVisible(false);
		creadosVista.setVisible(false);
		proyectoVista.setVisible(false);
		crearpVista.setVisible(false);
		menupVista.setVisible(true);
		asociacionVista.setVisible(false);
		crearAsociacionVista.setVisible(false);
		asociacionesCreadasVista.setVisible(false);
		menuAsociacionVista.setVisible(false);
	}
	
}

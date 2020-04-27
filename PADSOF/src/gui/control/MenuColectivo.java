package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ads.PADSOF.Ciudadano;
import gui.mainform.*;

public class MenuColectivo implements ActionListener{
	
	private BusquedaFrame frameB;
	private UsuarioFrame frameU;
	private ProyectosCreadosFrame framePC;
	private ProyectoFrame frameP;
	private CrearProyectoFrame frameCP;
	private MenuProyectosFrame frameMP;
	private AsociacionFrame frameA;
	private CrearAsociacionFrame frameCA;
	private AsociacionesCreadasFrame frameAC;
	
	private FormPanelUsuario usuarioVista;
	private FormPanelBusqueda busquedaVista;
	private FormPanelProyectosCreados creadosVista;
	private FormPanelProyecto proyectoVista;
	private FormPanelCrearProyecto crearpVista;
	private FormPanelMenuProyectos menupVista;
	private FormPanelAsociacion asociacionVista;
	private FormPanelCrearAsociacion crearAsociacionVista;
	private FormPanelAsociacionesCreadas asociacionesCreadasVista;
	private FormPanelMenuAsociacion menuAsociacionVista;
	
	private Ciudadano c;
	
	public MenuColectivo(Ciudadano ciudadano, BusquedaFrame frame, UsuarioFrame usuario, ProyectosCreadosFrame proyectos, ProyectoFrame proyecto, CrearProyectoFrame crearp, MenuProyectosFrame menuP, AsociacionFrame asociacion, CrearAsociacionFrame crearAsociacion, AsociacionesCreadasFrame asociacionesCreadas) { 

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
		 this.frameMP = menuP;
		 this.menupVista = menuP.getMenuP();
		 this.asociacionVista = asociacion.getAsociacion();
		 this.frameA = asociacion;
		 this.frameCA = crearAsociacion;
		 this.crearAsociacionVista = crearAsociacion.getCrearAsociacion();
		 this.frameAC = asociacionesCreadas;
		 this.asociacionesCreadasVista = asociacionesCreadas.getAsociacionesCreadas();
		 
	 }
	
	public void actionPerformed(ActionEvent arg0) {
		
		MenuAsociacionFrame frameMA = new MenuAsociacionFrame();
		FormPanelMenuAsociacion menuAsociacionVista = new FormPanelMenuAsociacion();
		
		ControladorBuscar controladorB = new ControladorBuscar(c, frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControladorMenuProyectos controladorMP = new ControladorMenuProyectos(c, frameB, frameU, framePC, frameP, frameCP, frameA, frameCA, frameAC, frameMA);
		ControlarPerfil controladorP = new ControlarPerfil(c, frameB, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControladorInformacionColectivo controladorIC = new ControladorInformacionColectivo(frameMA, c);
		
		frameMA.setControladorBuscar(controladorB);
		frameMA.setControladorMenuProyecto(controladorMP);
		frameMA.setControladorPerfil(controladorP);
		frameMA.setControladorInformacionColectivo(controladorIC);
		
		frameB.setVisible(false);
		frameU.setVisible(false);
		framePC.setVisible(false);
		frameP.setVisible(false);
		frameCP.setVisible(false);
		frameMP.setVisible(false);
		frameA.setVisible(false);
		frameCA.setVisible(false);
		frameAC.setVisible(false);
		frameMA.setVisible(true);

		
		usuarioVista.setVisible(false);
		busquedaVista.setVisible(false);
		creadosVista.setVisible(false);
		proyectoVista.setVisible(false);
		crearpVista.setVisible(false);
		menupVista.setVisible(false);
		asociacionVista.setVisible(false);
		crearAsociacionVista.setVisible(false);
		asociacionesCreadasVista.setVisible(false);
		menuAsociacionVista.setVisible(true);

		
	}

}

package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ads.PADSOF.Ciudadano;
import gui.mainform.*;

public class Buscar implements ActionListener{
	
	private UsuarioFrame frameU;
	private ProyectosCreadosFrame framePC;
	private ProyectoFrame frameP;
	private CrearProyectoFrame frameCP;
	private MenuProyectosFrame frameMP;
	private AsociacionFrame frameA;
	private CrearAsociacionFrame frameCA;
	private AsociacionesCreadasFrame frameAC;
	private MenuAsociacionFrame frameMA;
	
	private FormPanelUsuario usuarioVista;
	private FormPanelProyectosCreados creadosVista;
	private FormPanelProyecto proyectoVista;
	private FormPanelCrearProyecto crearpVista;
	private FormPanelMenuProyectos menupVista;
	private FormPanelAsociacion asociacionVista;
	private FormPanelCrearAsociacion crearAsociacionVista;
	private FormPanelAsociacionesCreadas asociacionesCreadasVista;
	private FormPanelMenuAsociacion menuAsociacionVista;
	
	private Ciudadano ciudadano;
	
	public Buscar(Ciudadano c, UsuarioFrame usuario, ProyectosCreadosFrame proyectos, ProyectoFrame proyecto, CrearProyectoFrame crearp, MenuProyectosFrame menuP, AsociacionFrame asociacion, CrearAsociacionFrame crearAsociacion, AsociacionesCreadasFrame asociacionesCreadas, MenuAsociacionFrame menuAsociacion) { 
		
		 this.ciudadano = c;
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
		 this.frameMA = menuAsociacion;
		 this.menuAsociacionVista = menuAsociacion.getMenuAsociacion();
		 
	 }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		BusquedaFrame newframe = new BusquedaFrame();
		FormPanelBusqueda newvista = new FormPanelBusqueda();
		
		ControladorBuscar controladorB = new ControladorBuscar(ciudadano, frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControlarPerfil controladorP = new ControlarPerfil(ciudadano, newframe, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControladorMenuProyectos controladorMP = new ControladorMenuProyectos(ciudadano, newframe, frameU, framePC, frameP, frameCP,frameA, frameCA, frameAC, frameMA);
		ControladorMenuColectivo controladorMC = new ControladorMenuColectivo(ciudadano, newframe, frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC);
		
		
		newframe.setControladorBuscar(controladorB);
		newframe.setControladorMenuColectivo(controladorMC);
		newframe.setControladorMenuProyecto(controladorMP);
		newframe.setControladorPerfil(controladorP);
	
		newframe.setVisible(true);
		frameU.setVisible(false);
		framePC.setVisible(false);
		frameP.setVisible(false);
		frameCP.setVisible(false);
		frameMP.setVisible(false);
		frameA.setVisible(false);
		frameCA.setVisible(false);
		frameAC.setVisible(false);
		frameMA.setVisible(false);

		
		usuarioVista.setVisible(false);
		newvista.setVisible(true);
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

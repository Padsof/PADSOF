package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import ads.PADSOF.Colectivo;
import gui.mainform.AsociacionFrame;
import gui.mainform.AsociacionesCreadasFrame;
import gui.mainform.BusquedaFrame;
import gui.mainform.CrearAsociacionFrame;
import gui.mainform.CrearProyectoFrame;
import gui.mainform.FormPanelAsociacion;
import gui.mainform.FormPanelBusqueda;
import gui.mainform.FormPanelMenuAsociacion;
import gui.mainform.MenuAsociacionFrame;
import gui.mainform.MenuProyectosFrame;
import gui.mainform.ProyectoFrame;
import gui.mainform.ProyectosCreadosFrame;
import gui.mainform.UsuarioFrame;

public class InformacionColectivo implements ActionListener{
	
	private MenuAsociacionFrame frameMA;
	private FormPanelMenuAsociacion menuAsociacionVista;
	
	private Ciudadano ciudadano;
	
	public InformacionColectivo(MenuAsociacionFrame frame, Ciudadano c) { 
		
		 this.frameMA = frame;
		 this.menuAsociacionVista = frame.getMenuAsociacion();
		 this.ciudadano = c;
		 
	 }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String nombreAsociacion = menuAsociacionVista.nombreColectivo();
		Colectivo colectivo = null;
		
		int tam = Aplicacion.getColectivos().size();
		int i, flag = 0;
		
		for (i = 0; i < tam; i++) {
			if(Aplicacion.getColectivos().get(i).getNombre().equals(nombreAsociacion)) {
				colectivo = Aplicacion.getColectivos().get(i);
				flag = 1;
			}
		}
		
		if(flag == 0) {
			
			JOptionPane.showMessageDialog(null, "Debes seleccionar un colectivo.", "Error", JOptionPane.ERROR_MESSAGE);

			
			return;
		}
		
		
		tam = Aplicacion.getColectivos().size();
		
		for (i = 0; i < tam; i++) {
			if(Aplicacion.getColectivos().get(i).getNombre().equals(nombreAsociacion)) {
				colectivo = Aplicacion.getColectivos().get(i);
			}
		}
		
		BusquedaFrame frameB = new BusquedaFrame();
		ProyectosCreadosFrame framePC = new ProyectosCreadosFrame();
		ProyectoFrame frameP = new ProyectoFrame();
		CrearProyectoFrame frameCP = new CrearProyectoFrame();
		MenuProyectosFrame frameMP = new MenuProyectosFrame();
		CrearAsociacionFrame frameCA = new CrearAsociacionFrame();
		AsociacionesCreadasFrame frameAC = new AsociacionesCreadasFrame();
		UsuarioFrame frameU = new UsuarioFrame(colectivo.getRepresentante());		
		
		AsociacionFrame frameA = new AsociacionFrame(colectivo);
		FormPanelAsociacion vistaA = new FormPanelAsociacion(colectivo);
		
		ControladorBuscar controladorB = new ControladorBuscar(colectivo.getRepresentante(), frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControlarPerfil controladorP = new ControlarPerfil(colectivo.getRepresentante(), frameB, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControladorMenuProyectos controladorMP = new ControladorMenuProyectos(colectivo.getRepresentante(), frameB, frameU, framePC, frameP, frameCP,frameA, frameCA, frameAC, frameMA);
		ControladorMenuColectivo controladorMC = new ControladorMenuColectivo(colectivo.getRepresentante(), frameB, frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC);
		ControladorUnirseColectivo controladorUC = new ControladorUnirseColectivo(frameA, ciudadano);
		
		frameA.setControladorBuscar(controladorB);
		frameA.setControladorMenuColectivo(controladorMC);
		frameA.setControladorMenuProyecto(controladorMP);
		frameA.setControladorPerfil(controladorP);
		frameA.setControladorUnirseColectivo(controladorUC);
		
		frameA.setVisible(true);
		vistaA.setVisible(true);
		frameMA.setVisible(false);
		menuAsociacionVista.setVisible(false);

		
	}



}

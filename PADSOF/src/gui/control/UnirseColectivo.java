package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import ads.PADSOF.Colectivo;
import gui.MenuAsociacion;
import gui.mainform.*;

public class UnirseColectivo implements ActionListener{
	
	private AsociacionFrame frameA;
	private FormPanelAsociacion vistaA;
	

	private Ciudadano ciudadano;
	
	public UnirseColectivo(AsociacionFrame frame, Ciudadano c) { 
		
		 this.frameA = frame;
		 this.vistaA = frame.getAsociacion();
		 
		 this.ciudadano = c;
		 
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		int tam = Aplicacion.getColectivos().size();
		int i;
		
		Colectivo colectivo = null;
		
		for (i = 0; i < tam; i++) {
			if(vistaA.nombreAsociacion().equals(Aplicacion.getColectivos().get(i).getNombre())) {
				colectivo = Aplicacion.getColectivos().get(i);
			}
		}
		
		if(colectivo.agregarMiembro(ciudadano)) {
			JOptionPane.showMessageDialog(null, "Enhorabuena, "+ciudadano.getNombre()+" te has unido con exito al colectivo "+colectivo.getNombre()+""); 
		}
		else {
			JOptionPane.showMessageDialog(null, "No puedes formar parte del colectivo ."+colectivo.getNombre()+"", "Error", JOptionPane.ERROR_MESSAGE);

			return;
		}
		
		BusquedaFrame frameB = new BusquedaFrame();
		ProyectosCreadosFrame framePC = new ProyectosCreadosFrame();
		ProyectoFrame frameP = new ProyectoFrame();
		CrearProyectoFrame frameCP = new CrearProyectoFrame();
		MenuProyectosFrame frameMP = new MenuProyectosFrame();
		CrearAsociacionFrame frameCA = new CrearAsociacionFrame();
		AsociacionesCreadasFrame frameAC = new AsociacionesCreadasFrame();
		UsuarioFrame frameU = new UsuarioFrame(colectivo.getRepresentante());		
		MenuAsociacionFrame frameMA = new MenuAsociacionFrame();

		AsociacionFrame newframeA = new AsociacionFrame(colectivo);
		FormPanelAsociacion newvistaA = new FormPanelAsociacion(colectivo);
		
		ControladorBuscar controladorB = new ControladorBuscar(colectivo.getRepresentante(), frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControlarPerfil controladorP = new ControlarPerfil(colectivo.getRepresentante(), frameB, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControladorMenuProyectos controladorMP = new ControladorMenuProyectos(colectivo.getRepresentante(), frameB, frameU, framePC, frameP, frameCP,frameA, frameCA, frameAC, frameMA);
		ControladorMenuColectivo controladorMC = new ControladorMenuColectivo(colectivo.getRepresentante(), frameB, frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC);
		ControladorUnirseColectivo controladorUC = new ControladorUnirseColectivo(frameA, ciudadano);

		
		newframeA.setControladorBuscar(controladorB);
		newframeA.setControladorMenuColectivo(controladorMC);
		newframeA.setControladorMenuProyecto(controladorMP);
		newframeA.setControladorPerfil(controladorP);
		newframeA.setControladorUnirseColectivo(controladorUC);
		
		
		frameA.setVisible(false);
		vistaA.setVisible(false);
		
		newframeA.setVisible(true);
		newvistaA.setVisible(true);
		
	}

}

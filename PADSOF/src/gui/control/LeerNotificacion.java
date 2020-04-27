package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import ads.PADSOF.Colectivo;
import ads.PADSOF.Notificacion;
import gui.mainform.*;

public class LeerNotificacion implements ActionListener{
	
	private UsuarioFrame frameU;
	
	private FormPanelUsuario Uvista;
	
	private Ciudadano ciudadano;
	
	private Notificacion notificacion;
	
	private UsuarioFrame newframeU;
	
	private FormPanelUsuario newUvista;

	
	public LeerNotificacion(Ciudadano c, UsuarioFrame frame ) { 
		
		this.frameU = frame;
		
		this.Uvista = frame.getUsuario();
		
		this.ciudadano = c;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		
		int tam = Aplicacion.getUsuariosAceptados().size();
		int i, flag = 0;
		
		for (i = 0; i < tam; i++) {
			if(Aplicacion.getUsuariosAceptados().get(i).getNombre().equals(Uvista.getNombre())){
			}
		}
		
		tam = ciudadano.getNotificaciones().size();
		
		for(i = 0; i < tam; i++) {
			if(ciudadano.getNotificaciones().get(i).getAbreviatura().equals(Uvista.nombreNotificacion())) { 
				
				flag = 1;
				
				notificacion = ciudadano.getNotificaciones().get(i);
				
				ciudadano.leerNotificacion(ciudadano.getNotificaciones().get(i));
				JOptionPane.showMessageDialog(null, notificacion.getTexto()+" \nMotivo: "+notificacion.getMotivo()+""); 
				
				newframeU = new UsuarioFrame(ciudadano);
				newUvista = new FormPanelUsuario(ciudadano);
				
				Ciudadano ciu = new Ciudadano ("Nombre", "Contraseña", "DNI");
				Colectivo aux = new Colectivo ("Auxiliar", ciu);
								
				BusquedaFrame frameB = new BusquedaFrame();
				ProyectosCreadosFrame framePC = new ProyectosCreadosFrame();
				ProyectoFrame frameP = new ProyectoFrame();
				CrearProyectoFrame frameCP = new CrearProyectoFrame();
				MenuProyectosFrame frameMP = new MenuProyectosFrame();
				AsociacionFrame frameA = new AsociacionFrame(aux);
				CrearAsociacionFrame frameCA = new CrearAsociacionFrame();
				AsociacionesCreadasFrame frameAC = new AsociacionesCreadasFrame();
				MenuAsociacionFrame frameMA = new MenuAsociacionFrame();
				
				ControladorBuscar controladorB = new ControladorBuscar(ciudadano, newframeU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
				ControladorMenuProyectos controladorMP = new ControladorMenuProyectos(ciudadano, frameB, newframeU, framePC, frameP, frameCP, frameA, frameCA, frameAC, frameMA);
				ControladorMenuColectivo controladorMC = new ControladorMenuColectivo(ciudadano, frameB, newframeU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC);
				ControladorLeerNotificacion controladorLN = new ControladorLeerNotificacion(ciudadano, newframeU);
				ControladorEliminarNotificacion controladorEN = new ControladorEliminarNotificacion(ciudadano, newframeU);

				newframeU.setControladorBuscar(controladorB);
				newframeU.setControladorMenuProyecto(controladorMP);
				newframeU.setControladorMenuColectivo(controladorMC);
				newframeU.setControladorLeerNotificaciones(controladorLN);
				newframeU.setControladorEliminarNotificaciones(controladorEN);
				
				newUvista.updateLN(Uvista.nombreNotificacion());
				newUvista.update(Uvista.getNombre(), Uvista.getContraseña());
				newframeU.setVisible(true);
				newUvista.setVisible(true);
				Uvista.setVisible(false);
				frameU.setVisible(false);
				
				return;
			}
			
		}
		
		tam = ciudadano.getNotificacionesLeidas().size();
		
		for(i = 0; i < tam; i++) {
			
			if(ciudadano.getNotificacionesLeidas().get(i).getAbreviatura().equals(Uvista.nombreNotificacionLeida())) {
				
				flag = 1;
				
				notificacion = ciudadano.getNotificacionesLeidas().get(i);
				
				JOptionPane.showMessageDialog(null, notificacion.getTexto()+" \nMotivo: "+notificacion.getMotivo()+""); 
				
				return;
				
			}
		
		}
		
		
		if(flag == 0) {
			JOptionPane.showMessageDialog(null, "Selecciona una notificacion.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
	}
		
	}

}

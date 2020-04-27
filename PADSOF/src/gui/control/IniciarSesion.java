package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import ads.PADSOF.Colectivo;
import gui.mainform.*;

public class IniciarSesion implements ActionListener{
	
	private Ventana frame;
		private FormPanelInicio inicioVista;
	
	public IniciarSesion(Ventana frame) { 

		 
		 this.frame = frame;
		 this.inicioVista = frame.getInicio();
		
	 }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(Aplicacion.getAdministradorCreado() == 1) {
			
			if(inicioVista.getCampoNombre().length() == 0 && inicioVista.getCampoContraseña().equals(Aplicacion.getAdministrador().getcontrasenia())) { //PARA QUE INICIE SESION EL ADMINISTRADOR
								
				JOptionPane.showMessageDialog(null, "Bienvenido "+inicioVista.getCampoNombre()+""); 
				 
				PerfilAdministradorFrame framePA = new PerfilAdministradorFrame(Aplicacion.getAdministrador());
				FormPanelPerfilAdministrador PAdministradorVista = new FormPanelPerfilAdministrador(Aplicacion.getAdministrador());
								
				ControladorAceptarAdministrador controladorAA = new ControladorAceptarAdministrador(framePA);

				framePA.setControladorAceptarUsuario(controladorAA);
				
				PAdministradorVista.update(Aplicacion.getAdministrador().getcontrasenia());
				
				System.out.println(inicioVista.getCampoNombre());
				
				PAdministradorVista.setVisible(true);
				framePA.setVisible(true);
				frame.setVisible(false);
				inicioVista.setVisible(false);
				
				return;

			}
		}
		
		
		
		if(inicioVista.getCampoNombre().length() < 4) {
			
			 JOptionPane.showMessageDialog(null, "Debe introducir un nombre de usuario de minimo 4 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
			 
			 return;
		 }
		
		if(inicioVista.getCampoContraseña().length() < 5) {
			
			 JOptionPane.showMessageDialog(null, "Debe introducir una contraseña de minimo 5 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);

			 /*if (aux == false) {
				 JOptionPane.showMessageDialog(null, "Debe introducir un nombre de usuario de minimo 4 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }*/
			 
			 return;
		 }
		
		
		Ciudadano c = null;
		
		int tam = Aplicacion.getUsuariosAceptados().size();
		int i, flag = 0;
		
		for(i = 0; i < tam; i++) {
			if(Aplicacion.getUsuariosAceptados().get(i).getNombre().equals(inicioVista.getCampoNombre())) {
				c = Aplicacion.getUsuariosAceptados().get(i);
				flag = 1;
			}
		}
		
		if(flag == 0) {
			
			JOptionPane.showMessageDialog(null, "Usuario no valido.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		
		UsuarioFrame frameU = new UsuarioFrame(c);
		FormPanelUsuario usuarioVista = new FormPanelUsuario(c);
		
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
		
		
		ControladorBuscar controladorB = new ControladorBuscar(c, frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC, frameMA);
		ControladorMenuProyectos controladorMP = new ControladorMenuProyectos(c, frameB, frameU, framePC, frameP, frameCP, frameA, frameCA, frameAC, frameMA);
		ControladorMenuColectivo controladorMC = new ControladorMenuColectivo(c, frameB, frameU, framePC, frameP, frameCP, frameMP, frameA, frameCA, frameAC);
		ControladorLeerNotificacion controladorLN = new ControladorLeerNotificacion(c, frameU);
		ControladorEliminarNotificacion controladorEN = new ControladorEliminarNotificacion(c, frameU);

		
		frameU.setControladorBuscar(controladorB);
		frameU.setControladorMenuProyecto(controladorMP);
		frameU.setControladorMenuColectivo(controladorMC);
		frameU.setControladorLeerNotificaciones(controladorLN);
		frameU.setControladorEliminarNotificaciones(controladorEN);
		
		
		//usuarioVista.update(inicioVista.getCampoNombre(), inicioVista.getCampoContraseña());
		frame.setVisible(false);
		frameU.setVisible(true);
		usuarioVista.setVisible(true);
		inicioVista.setVisible(false);
		
		return;
	}

}

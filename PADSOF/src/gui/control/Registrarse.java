package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ads.PADSOF.*;
import gui.mainform.*;

public class Registrarse implements ActionListener{

	private RegistroFrame ventanaRegistro;
	private FormPanelRegistro registroVista;
	
	private boolean aux;
	
	CiudadanoNoRegistrado CiuAuxiliar;
	Ciudadano ciudadano;


	
	 public Registrarse(RegistroFrame registro) { 

		 this.ventanaRegistro = registro;
		 this.registroVista = registro.getRegistro();
	 }
	 
	 public void actionPerformed(ActionEvent e) { 
		 		 
		 CiuAuxiliar = new CiudadanoNoRegistrado(registroVista.getCampoNombre(), registroVista.getCampoContraseña(), registroVista.getCampoDNI());

		 
		 if(registroVista.getCampoNombre().length() < 4) {
			 
			 aux = CiuAuxiliar.Registrarse(null, CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
			 
			 if (aux == false) {
				 JOptionPane.showMessageDialog(null, "Debe introducir un nombre de usuario de minimo 4 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
		 }
		 
		 if(registroVista.getCampoContraseña().length() < 5) {
			 
			 aux = CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), null, CiuAuxiliar.getDNI());
			 
			 if (aux == false) {
				 JOptionPane.showMessageDialog(null, "Debe introducir una contraseña de minimo 5 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
		 }

		 if(registroVista.getCampoDNI().length() == 0) {
			 aux = CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), null);
			 if (aux == false) {
					System.out.println(Aplicacion.getAdministrador());

				 JOptionPane.showMessageDialog(null, "Ya existe un Administrador de la aplicacion.", "Error", JOptionPane.ERROR_MESSAGE);
				 return;
			 }
			 JOptionPane.showMessageDialog(null, "Enhorabuena, te has registrado como el Administrador de la aplicacion"); 
			 
			 
			 Ventana frame = new Ventana();
			 FormPanelInicio inicioVista = new FormPanelInicio();
			 
			 ControladorRegistrate controladorR = new ControladorRegistrate (frame);
			 ControladorIniciarSesion controladorIS = new ControladorIniciarSesion(frame);
			 
			 frame.setControladorRegistrar(controladorR);
			 frame.setControladorIniciarSesion(controladorIS);
			 		 
			 inicioVista.setVisible(true);
			 registroVista.setVisible(false);
			 ventanaRegistro.setVisible(false);
			 frame.setVisible(true);
			 return;
		 }
		 
		 aux = CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());

		 if (aux == false) {
			 JOptionPane.showMessageDialog(null, "Ya hay un usuario registrado con ese Nombre/DNI.", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		 }
		 
		 JOptionPane.showMessageDialog(null, "Enhorabuena, te has registrado. Ahora tienes que esperar a que el Administrador te acepte"); 
		 
		 Ventana frame = new Ventana();
		 FormPanelInicio inicioVista = new FormPanelInicio();
		 
		 ControladorRegistrate controladorR = new ControladorRegistrate (frame);
		 ControladorIniciarSesion controladorIS = new ControladorIniciarSesion(frame);

		 
		 frame.setControladorRegistrar(controladorR);
		 frame.setControladorIniciarSesion(controladorIS);
		 
		 		 
		 inicioVista.setVisible(true);
		 registroVista.setVisible(false);
		 ventanaRegistro.setVisible(false);
		 frame.setVisible(true);
		 System.out.println(Aplicacion.getUsuariosPorAceptar());
		 return;
	 }

}

package gui.mainform;

import javax.swing.*;

public class FormPanelAdministradorUsuario extends JPanel{

	public FormPanelAdministradorUsuario(AdministradorUsuarioFrame administradorUsuarioFrame) {

		JTextField campo = new JTextField(100);	
		JButton boton = new JButton("Administrador");	
		JLabel etiqueta = new JLabel("Usuario: nombre del usuario ");
		JLabel etiqueta2 = new JLabel("DNI: DNI del usuario ");
		JButton boton2 = new JButton("Aceptar Usuario");	
		JButton boton3 = new JButton("Rechazar Usuario");	
		JLabel etiqueta3 = new JLabel("Escribe aquí el motivo para bloquear al usuario: ");
		JTextField campo2 = new JTextField(100);	
		JButton boton4 = new JButton("Bloquear Usuario");	
		JButton boton5 = new JButton("Desbloquear Usuario");	

		
		this.add(campo);
		this.add(boton);
		this.add(etiqueta);
		this.add(etiqueta2);
		this.add(boton2);
		this.add(boton3);
		this.add(etiqueta2);
		this.add(campo2);
		this.add(boton4);
		this.add(boton5);

	}

}

package gui.mainform;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanelAdministradorAceptar extends JPanel{

	public FormPanelAdministradorAceptar(AdministradorAceptarFrame administradorAceptarFrame) {
		
		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(100);	
		JButton boton = new JButton("Administrador");	
		JLabel etiqueta = new JLabel("Proyectos por aceptar: ");
		JButton boton2 = new JButton("Proyecto1");	
		JLabel etiqueta2 = new JLabel("Usuarios por aceptar: ");
		JButton boton3 = new JButton("Usuario1");	

		this.add(campo);
		this.add(boton);
		this.add(etiqueta);
		this.add(boton2);
		this.add(etiqueta2);
		this.add(boton3);
	
	}

}

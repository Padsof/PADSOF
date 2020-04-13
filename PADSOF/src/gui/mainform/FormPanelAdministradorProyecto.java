package gui.mainform;

import javax.swing.*;

public class FormPanelAdministradorProyecto extends JPanel{

	public FormPanelAdministradorProyecto(AdministradorProyectoFrame administradorProyectoFrame) {

		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(100);	
		JButton boton = new JButton("Administrador");
		JLabel etiqueta = new JLabel("Proyecto ");
		JLabel etiqueta2 = new JLabel("Descripcion del proyecto ");
		JLabel etiqueta3 = new JLabel("Presupuesto ");
		JLabel etiqueta4 = new JLabel("Tipo de proyecto ");
		
		//INFORMACION SEGUN EL TIPO DE PROYECTO
		
		JButton boton2 = new JButton("Aceptar");
		JButton boton3 = new JButton("Rechazar");

		this.add(campo);
		this.add(boton);
		this.add(etiqueta);
		this.add(etiqueta2);
		this.add(etiqueta3);
		this.add(etiqueta4);
		this.add(boton2);
		this.add(boton3);

	}

}

package gui.mainform;

import javax.swing.*;

public class FormPanelAsociacionesCreadas extends JPanel{

	public FormPanelAsociacionesCreadas(AsociacionesCreadasFrame asociacionesCreadasFrame) {

		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(100);
		
		JButton boton = new JButton("Proyectos");
		JButton boton2 = new JButton("Perfil");
		JButton boton3 = new JButton("Colectivos");
		JLabel etiqueta = new JLabel("Mis asociaciones: ");
		JButton boton4 = new JButton("Asociacion numero 1"); //MOSTRAMOS TODAS LAS ASOCIACIONES CREADAS POR UN USUARIO
		JButton boton5 = new JButton("Eliminar");

		
		
		
		this.add(campo);
		this.add(boton);
		this.add(boton2);
		this.add(boton3);
		this.add(etiqueta);
		this.add(boton4);
		this.add(boton5);
	
	}

}

package gui.mainform;

import javax.swing.*;

public class FormPanelCrearAsociacion extends JPanel{

	public FormPanelCrearAsociacion(CrearAsociacionFrame crearAsociacionFrame) {
		
		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(100);
		
		JButton boton = new JButton("Proyectos");
		JButton boton2 = new JButton("Perfil");
		JButton boton3 = new JButton("Colectivos");
		
		JTextField campo2 = new JTextField(20);
		JButton boton4 = new JButton("Crear Asociacion");

		
		
		this.add(campo);
		this.add(boton);
		this.add(boton2);
		this.add(boton3);
		this.add(campo2);
		this.add(boton4);

	}

}

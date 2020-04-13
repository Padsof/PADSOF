package gui.mainform;

import javax.swing.*;
public class FormPanelAsociacion extends JPanel{

	public FormPanelAsociacion(AsociacionFrame asociacionFrame) {

		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(100);
		
		JButton boton = new JButton("Proyectos");
		JButton boton2 = new JButton("Perfil");
		JButton boton3 = new JButton("Colectivos");
		
		JLabel etiqueta = new JLabel("Asociacion: Nombre de la asociacion ");
		JButton boton4 = new JButton("Unirse");
		JButton boton5 = new JButton("Abandonar");
		
		JButton boton6 = new JButton("Crear sub-asociacion");

		
		this.add(campo);
		this.add(boton);
		this.add(boton2);
		this.add(boton3);
		this.add(etiqueta);
		this.add(boton4);
		this.add(boton5);		
		this.add(boton6);



	}

}

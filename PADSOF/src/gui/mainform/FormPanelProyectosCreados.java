package gui.mainform;

import javax.swing.*;

public class FormPanelProyectosCreados extends JPanel{

	public FormPanelProyectosCreados(ProyectosCreadosFrame proyectosCreadosFrame) {
		
		JTextField campo = new JTextField(100);
		
		JButton boton = new JButton("Proyectos");
		JButton boton2 = new JButton("Perfil");
		JButton boton3 = new JButton("Colectivos");
		
		JLabel etiqueta = new JLabel("Mis Proyectos: ");
		//LO HARÍAMOS PARA CADA UNO DE LOS PROYECTOS
		JButton boton4 = new JButton("Proyecto numero 1");
		JButton boton5 = new JButton("Eliminar"); //HACE FALTA IMPLEMENTAR UNA FUNCION PARA ELIMINAR UN PROYECTO
		JButton boton6 = new JButton("Mandar a financiar");

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

package gui.mainform;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanelProyecto extends JPanel{

	public FormPanelProyecto(ProyectoFrame proyectoFrame) {

		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(100);
		JButton boton = new JButton("Proyectos");
		JButton boton2 = new JButton("Perfil");
		JButton boton3 = new JButton("Colectivos");
		JLabel etiqueta = new JLabel("Proyecto: ");
		JLabel etiqueta2 = new JLabel("Breve descripcion del proyecto: ");
		JButton boton4 = new JButton("Suscribirse");
		JButton boton5 = new JButton("Apoyar");
		JButton boton6 = new JButton("Pedir informe de popularidad");
		
		
		this.add(campo);
		this.add(boton);
		this.add(boton2);
		this.add(boton3);
		this.add(etiqueta);
		this.add(etiqueta2);
		this.add(boton4);
		this.add(boton5);
		this.add(boton6);

	}

}

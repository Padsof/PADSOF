package gui.mainform;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanelMenuProyectos extends JPanel{

	public FormPanelMenuProyectos(MenuProyectosFrame menuProyectosFrame) {

		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(100);
		
		JButton boton = new JButton("Proyectos");
		JButton boton2 = new JButton("Perfil");
		JButton boton3 = new JButton("Colectivos");
		JLabel etiqueta = new JLabel("Nuevos proyectos: "); //LISTA CON LOS NUEVOS PROYECTOS CREADOS
		JButton boton4 = new JButton("Proyecto numero 1");

		
		

		this.add(campo);
		this.add(boton);
		this.add(boton2);
		this.add(boton3);
		this.add(etiqueta);
		this.add(boton4);

	}

}

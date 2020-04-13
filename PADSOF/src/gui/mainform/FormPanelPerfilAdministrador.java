package gui.mainform;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanelPerfilAdministrador extends JPanel{

	public FormPanelPerfilAdministrador(PerfilAdministradorFrame perfilAdministradorFrame) {
		
		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(100);	
		JButton boton = new JButton("Administrador");
		JButton boton2 = new JButton("Aceptar Usuarios/Proyectos");
		
		JLabel etiqueta = new JLabel("Umbral de Votos ");
		JTextField campo2 = new JTextField(5);	
		JButton boton3 = new JButton("Cambiar");

	
		this.add(campo);
		this.add(boton);
		this.add(boton2);
		this.add(etiqueta);
		this.add(campo2);
		this.add(boton3);

	}

}

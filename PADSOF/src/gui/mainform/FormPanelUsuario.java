package gui.mainform;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanelUsuario extends JPanel {

	
public FormPanelUsuario(UsuarioFrame usuarioFrame) {
				
	//PARA REALIZAR BUSQUEDAS
	JTextField campo = new JTextField(100);
	
	JButton boton = new JButton("Proyectos");
	JButton boton2 = new JButton("Perfil");
	JButton boton3 = new JButton("Colectivos");
	
	JLabel etiqueta = new JLabel("Mis datos: ");
	JLabel etiqueta2 = new JLabel("Usuario: ");
	JLabel etiqueta3 = new JLabel("DNI: ");
	
	JLabel etiqueta4 = new JLabel("Proyectos: ");
	JButton boton4 = new JButton("Crear nuevo proyecto");
	JButton boton5 = new JButton("Ver mis proyectos creados");
	
	JLabel etiqueta5 = new JLabel("Asociaciones: ");
	JButton boton6 = new JButton("Crear nueva asociacion");
	JButton boton7 = new JButton("Ver mis asociaciones creadas");
	
	JTextField campo2 = new JTextField(20);
	JTextField campo3 = new JTextField(20);
	JButton boton8 = new JButton("Informa de afinidad");


	
	this.add(campo);
	this.add(boton);
	this.add(boton2);
	this.add(boton3);
	this.add(etiqueta);
	this.add(etiqueta2);
	this.add(etiqueta3);
	this.add(etiqueta4);
	this.add(boton4);
	this.add(boton5);
	this.add(etiqueta5);
	this.add(boton6);
	this.add(boton7);
	this.add(campo2);
	this.add(campo3);
	this.add(boton8);





	//REALIZAR BUSQUEDA
	
		
	}
}

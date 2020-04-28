package gui.mainform;

import java.awt.Dimension;

import java.awt.event.ActionListener;

import javax.swing.*;

import ads.PADSOF.Administrador;
import gui.control.*;

public class FormPanelPerfilAdministrador extends JPanel{
	
	private JLabel Nombre;
	private JLabel Contraseña;
	
	private JButton Buscar;
	
	private JButton Perfil;

	
	private JButton Aceptar;


	public FormPanelPerfilAdministrador(Administrador administrador) {
		
		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
	
		
		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(50);	
		Buscar = new JButton("Buscar");
		Perfil = new JButton("Administrador");
		Aceptar = new JButton("Aceptar Usuarios/Proyectos");
	

		
		JLabel etiqueta = new JLabel("Umbral de Votos ");
		JTextField campo2 = new JTextField(5);	
		JButton boton3 = new JButton("Cambiar");
		
		JLabel etiqueta2 = new JLabel("DATOS");
		JLabel etiqueta3 = new JLabel("Nombre: ");
		Nombre = new JLabel(administrador.getNombre() ); //NOMBRE DEL ADMINISTRADOR
		JLabel etiqueta5 = new JLabel("Contraseña: ");
		Contraseña = new JLabel(administrador.getcontrasenia() ); //CONTRASEÑA DEL ADMINISTRADOR

		
		
		layout.putConstraint(SpringLayout.WEST, campo, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Buscar, 20, SpringLayout.EAST, campo);         
		layout.putConstraint(SpringLayout.NORTH, Buscar, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Perfil, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Perfil, 200, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Aceptar, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Aceptar, 100, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta2, 600, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta2, 100, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta3, 600, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta3, 150, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, Nombre, 660, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Nombre, 150, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta5, 600, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta5, 200, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, Contraseña, 680, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Contraseña, 200, SpringLayout.SOUTH, campo);
		
		//FALTA PROYECTOS MANDADOS A FINANCIAR/RECHAZAR
		
		layout.putConstraint(SpringLayout.WEST, etiqueta, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 150, SpringLayout.SOUTH, Aceptar);
		
		layout.putConstraint(SpringLayout.WEST, campo2, 300, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo2, 170, SpringLayout.NORTH, Aceptar); 
		
		layout.putConstraint(SpringLayout.WEST, boton3, 400, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, boton3, 170, SpringLayout.NORTH, Aceptar); 
		
		this.setPreferredSize(new Dimension(850,500)); 

	
		this.add(campo);
		this.add(Perfil);
		this.add(Aceptar);
		this.add(etiqueta);
		this.add(campo2);
		this.add(boton3);
		this.add(Buscar);
		this.add(Nombre);
		this.add(Contraseña);
		this.add(etiqueta2);
		this.add(etiqueta3);
		this.add(etiqueta5);


	}
	
	public void update(String password) { 
		Contraseña.setText(password);
	}
	
	public void setControladorAceptarUsuario(ActionListener c) {  
		Aceptar.addActionListener(c);   
	}

	public String getNombre() {
		return Nombre.getText();
	}

	public String getContraseña() {
		return Contraseña.getText();
	} 
	
	
	
	
}

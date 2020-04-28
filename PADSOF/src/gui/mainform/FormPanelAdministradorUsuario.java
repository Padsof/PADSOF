package gui.mainform;

import java.awt.Dimension;

import javax.swing.*;

import ads.PADSOF.Ciudadano;
import gui.control.AceptarUsuario;
import gui.control.BloquearUsuario;
import gui.control.DesbloquearUsuario;
import gui.control.RechazarUsuario;

public class FormPanelAdministradorUsuario extends JPanel{
	
	private JLabel Nombre;
	private JLabel DNI;
	private JLabel contraseña;
	
	private JTextField Motivo;
	
	private JButton Buscar;
	private JButton Perfil;
	private JButton Aceptar;
	private JButton Rechazar;
	private JButton Bloquear;
	private JButton Desbloquear;



	public FormPanelAdministradorUsuario( Ciudadano ciudadano) {
		
		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 

		JTextField campo = new JTextField(50);	
		Buscar = new JButton("Buscar");

		Perfil = new JButton("Administrador");	
		JLabel etiqueta = new JLabel("Usuario: ");
		Nombre = new JLabel(ciudadano.getNombre());
		JLabel etiqueta2 = new JLabel("DNI: ");
		DNI = new JLabel(ciudadano.getcontrasenia() );
		Aceptar = new JButton("Aceptar Usuario");	
		Rechazar = new JButton("Rechazar Usuario");	
		JLabel etiqueta3 = new JLabel("Escribe aquí el motivo para bloquear al usuario: ");
		Motivo = new JTextField(75);	
		Bloquear = new JButton("Bloquear Usuario");	
		Desbloquear = new JButton("Desbloquear Usuario");	
		
		contraseña = new JLabel();
		
		layout.putConstraint(SpringLayout.WEST, campo, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Buscar, 20, SpringLayout.EAST, campo);         
		layout.putConstraint(SpringLayout.NORTH, Buscar, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Perfil, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Perfil, 200, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 150, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, Nombre, 230, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Nombre, 150, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta2, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta2, 200, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, DNI, 200, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, DNI, 200, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, Aceptar, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Aceptar, 250, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, Rechazar, 300, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Rechazar, 250, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta3, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta3, 300, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, Motivo, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Motivo, 350, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, Bloquear, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Bloquear, 450, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, Desbloquear, 300, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Desbloquear, 450, SpringLayout.SOUTH, campo);
		
		this.setPreferredSize(new Dimension(1200,700)); 

		
		this.add(campo);
		this.add(Perfil);
		this.add(etiqueta);
		this.add(etiqueta2);
		this.add(Aceptar);
		this.add(Rechazar);
		this.add(etiqueta3);
		this.add(Motivo);
		this.add(Bloquear);
		this.add(Desbloquear);
		this.add(Buscar);
		this.add(Nombre);
		this.add(DNI);

	}
	
	public void update(String name, String dni, String contra) { 
		Nombre.setText(name);
		DNI.setText(dni);
		contraseña.setText(contra);
	}

	public String getNombre() {
		return Nombre.getText();
	}

	public String getDNI() {
		return DNI.getText();
	}

	public String getContraseña() {
		return contraseña.getText();
	}

	public void setControladorAceptarUsuario(AceptarUsuario botonau) {
		Aceptar.addActionListener(botonau);   		
	}
	
	public void setControladorRechazarUsuario(RechazarUsuario botonru) {
		Rechazar.addActionListener(botonru);   		
	}
	
	public void setControladorBloquearUsuario(BloquearUsuario botonbu) {
		Bloquear.addActionListener(botonbu);   		
	}

	public String getMotivo() {
		return Motivo.getText();
	}

	public void setControladorDesbloquearUsuario(DesbloquearUsuario botondbu) {
		Desbloquear.addActionListener(botondbu);   		
	}
	
	
	
	
	
	

}

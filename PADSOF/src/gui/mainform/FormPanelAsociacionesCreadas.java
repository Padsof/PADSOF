package gui.mainform;

import java.awt.event.ActionListener;

import javax.swing.*;

public class FormPanelAsociacionesCreadas extends JPanel{
	
	private JButton Buscar;
	private JButton Proyectos;
	private JButton Perfil;
	private JButton Colectivos;
	
	private JComboBox opcion;


	public FormPanelAsociacionesCreadas() {
		
		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
		
		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(50);
		Buscar = new JButton("Buscar");
		
		Proyectos = new JButton("Proyectos");
		Perfil = new JButton("Perfil");
		Colectivos = new JButton("Colectivos");
		JLabel etiqueta = new JLabel("Mis asociaciones: ");
		JButton boton4 = new JButton("Asociacion numero 1"); //MOSTRAMOS TODAS LAS ASOCIACIONES CREADAS POR UN USUARIO
		JButton boton5 = new JButton("Eliminar");
		
		String[] busqueda = {"Colectivos", "Proyectos"};
		opcion = new JComboBox(busqueda);
		opcion.setSelectedIndex(1);

		layout.putConstraint(SpringLayout.WEST, campo, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Buscar, 20, SpringLayout.EAST, campo);         
		layout.putConstraint(SpringLayout.NORTH, Buscar, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, opcion, 50, SpringLayout.EAST, Buscar);         
		layout.putConstraint(SpringLayout.NORTH, opcion, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Proyectos, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Proyectos, 60, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Perfil, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Perfil, 300, SpringLayout.SOUTH, Proyectos); 
		
		layout.putConstraint(SpringLayout.WEST, Colectivos, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Colectivos, 300, SpringLayout.SOUTH, Perfil); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 100, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, boton4, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, boton4, 20, SpringLayout.SOUTH, etiqueta); 
		
		layout.putConstraint(SpringLayout.WEST, boton5, 500, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, boton5, 20, SpringLayout.SOUTH, etiqueta); 
		
		this.add(campo);
		this.add(Buscar);
		this.add(Proyectos);
		this.add(Perfil);
		this.add(Colectivos);
		this.add(etiqueta);
		this.add(boton4);
		this.add(boton5);
		
		this.add(opcion);

	
	}
	
	public void setControladorBuscar(ActionListener c) {  
		Buscar.addActionListener(c);   
	}

	public void setControladorPerfil(ActionListener c) {  
		Perfil.addActionListener(c);   
	} 
	
	public void setControladorMenuProyecto(ActionListener c) {  
		Proyectos.addActionListener(c);   
	} 
	
	public void setControladorMenuColectivo(ActionListener c) {  
		Colectivos.addActionListener(c);   
	}

}

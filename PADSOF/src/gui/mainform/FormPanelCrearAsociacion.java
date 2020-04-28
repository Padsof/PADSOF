package gui.mainform;

import java.awt.event.ActionListener;

import javax.swing.*;

import gui.control.MenuColectivo;

public class FormPanelCrearAsociacion extends JPanel{
	
	private JButton Crear;
	private JButton Buscar;
	private JButton Proyectos;
	private JButton Perfil;
	private JButton Colectivos;
	
	private JComboBox opcion;



	public FormPanelCrearAsociacion() {
		
		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
		
		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(50);
		
		Proyectos = new JButton("Proyectos");
		Perfil = new JButton("Perfil");
		Colectivos = new JButton("Colectivos");
		JLabel etiqueta = new JLabel("Nombre asociacion: ");
		
		Crear = new JButton("Crear Asociacion");
		
		JTextField campo2 = new JTextField(20);
		Buscar = new JButton("Buscar");
		
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
		
		layout.putConstraint(SpringLayout.WEST, campo2, 300, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo2, 100, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, Crear, 300, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Crear, 100, SpringLayout.SOUTH, campo2);
		
		
		
		this.add(campo);
		this.add(Proyectos);
		this.add(etiqueta);
		this.add(Perfil);
		this.add(Colectivos);
		this.add(campo2);
		this.add(Buscar);
		this.add(Crear);
		
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

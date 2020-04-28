package gui.mainform;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FormPanelBusqueda extends JPanel{
	
	private JButton Buscar;
	private JButton Proyectos;
	private JButton Perfil;
	private JButton Colectivos;
	
	private JComboBox opcion;


	public FormPanelBusqueda() {

		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
		
		JTextField campo = new JTextField(100);
		Proyectos = new JButton("Proyectos");
		Perfil = new JButton("Perfil");
		Colectivos = new JButton("Colectivos");
		Buscar = new JButton("Buscar");
		
		String[] busqueda = {"Colectivos", "Proyectos"};
		opcion = new JComboBox(busqueda);
		opcion.setSelectedIndex(1);

		
		// Crear un array con las opciones del combo 
		String[] tipo = {"Proyectos", "Colectivos"};
		// Crear el combo, pasando el array como parámetro 
		JComboBox combo = new JComboBox(tipo); 
		// Añadir el combo al panel donde se quiera mostrar 
		JPanel ejemploComboBox = new JPanel(new GridLayout(1,2,10,0)); 
		ejemploComboBox.add(new JLabel("Selecciona un tipo")); 
		ejemploComboBox.add(combo);
		
		JLabel etiqueta = new JLabel("Resultados: ");
		
		//PROYECTOS O ASOCIACIONES
		
		layout.putConstraint(SpringLayout.WEST, campo, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Buscar, 20, SpringLayout.EAST, campo);         
		layout.putConstraint(SpringLayout.NORTH, Buscar, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Proyectos, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Proyectos, 60, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, opcion, 50, SpringLayout.EAST, Buscar);         
		layout.putConstraint(SpringLayout.NORTH, opcion, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Perfil, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Perfil, 300, SpringLayout.SOUTH, Proyectos); 
		
		layout.putConstraint(SpringLayout.WEST, Colectivos, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Colectivos, 300, SpringLayout.SOUTH, Perfil); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 60, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, combo, 400, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, combo, 60, SpringLayout.SOUTH, campo);
		
		this.add(campo);
		this.add(Buscar);
		this.add(Proyectos);
		this.add(Perfil);
		this.add(Colectivos);
		this.add(combo);
		this.add(etiqueta);
		
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

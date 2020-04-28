package gui.mainform;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class FormPanelBusquedaAdministrador extends JPanel{

	public FormPanelBusquedaAdministrador(BusquedaAdministradorFrame busquedaAdministradorFrame) {

		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout);
		
		JTextField campo = new JTextField(50);
		JButton boton7 = new JButton("Buscar");
		JButton boton = new JButton("Administrador");

		// Crear un array con las opciones del combo 
		String[] tipo = {"Proyectos", "Colectivos"};
		// Crear el combo, pasando el array como parámetro 
		JComboBox combo = new JComboBox(tipo); 
		// Añadir el combo al panel donde se quiera mostrar 
		JPanel ejemploComboBox = new JPanel(new GridLayout(1,2,10,0)); 
		ejemploComboBox.add(new JLabel("Selecciona un tipo")); 
		ejemploComboBox.add(combo);
		
		JLabel etiqueta = new JLabel("Resultados: ");
		
		layout.putConstraint(SpringLayout.WEST, campo, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, boton7, 20, SpringLayout.EAST, campo);         
		layout.putConstraint(SpringLayout.NORTH, boton7, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, boton, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, boton, 60, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 60, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, combo, 400, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, combo, 60, SpringLayout.SOUTH, campo);
		
		//PROYECTOS O ASOCIACIONES
		
		this.add(campo);
		this.add(boton);
		this.add(boton7);
		this.add(combo);
		this.add(etiqueta);
	
	}

}

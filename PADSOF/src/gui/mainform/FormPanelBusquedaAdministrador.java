package gui.mainform;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormPanelBusquedaAdministrador extends JPanel{

	public FormPanelBusquedaAdministrador(BusquedaAdministradorFrame busquedaAdministradorFrame) {

		JTextField campo = new JTextField(100);
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
		
		//PROYECTOS O ASOCIACIONES
		
		this.add(campo);
		this.add(boton);
		this.add(combo);
		this.add(etiqueta);
	
	}

}

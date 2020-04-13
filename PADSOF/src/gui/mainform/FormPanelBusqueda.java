package gui.mainform;

import java.awt.GridLayout;

import javax.swing.*;

public class FormPanelBusqueda extends JPanel{

	public FormPanelBusqueda(BusquedaFrame busquedaFrame) {

		JTextField campo = new JTextField(100);
		JButton boton = new JButton("Proyectos");
		JButton boton2 = new JButton("Perfil");
		JButton boton3 = new JButton("Colectivos");
		
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
		this.add(boton2);
		this.add(boton3);
		this.add(combo);
		this.add(etiqueta);



	}

}

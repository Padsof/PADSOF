package gui.mainform;

import java.awt.GridLayout;

import javax.swing.*;
public class FormPanelCrearProyecto extends JPanel{

	public FormPanelCrearProyecto(CrearProyectoFrame crearProyectoFrame) {

		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(100);
		JButton boton = new JButton("Proyectos");
		JButton boton2 = new JButton("Perfil");
		JButton boton3 = new JButton("Colectivos");
		JLabel etiqueta = new JLabel("Titulo: ");
		JTextField campo2 = new JTextField(10);
		JLabel etiqueta2 = new JLabel("Descripcion: ");
		JTextField campo3 = new JTextField(100);
		JLabel etiqueta3 = new JLabel("Presupuesto solicitado: ");
		JTextField campo4 = new JTextField(10);
		JButton boton4 = new JButton("Crear proyecto");

		//AÑADIR TIPO DE PROYECTO
		
		// Crear un array con las opciones del combo 
		String[] tipo = {"Social", "Infraestructura"};
		// Crear el combo, pasando el array como parámetro 
		JComboBox combo = new JComboBox(tipo); 
		// Añadir el combo al panel donde se quiera mostrar 
		JPanel ejemploComboBox = new JPanel(new GridLayout(1,2,10,0)); 
		ejemploComboBox.add(new JLabel("Selecciona un tipo")); 
		ejemploComboBox.add(combo);
		
		//EN CASO DE QUE EL PROYECTO SEA SOCIAL
		// Crear un array con las opciones del combo 
		String[] tipo2 = {"Nacional", "Internacional"};
		// Crear el combo, pasando el array como parámetro 
		JComboBox combo2 = new JComboBox(tipo2); 
		// Añadir el combo al panel donde se quiera mostrar 
		JPanel ejemploComboBox2 = new JPanel(new GridLayout(1,2,10,0)); 
		ejemploComboBox.add(new JLabel("Selecciona un tipo")); 
		ejemploComboBox.add(combo2);
		
		//EN CASO DE QUE EL PROYECTO SEA UNA INFRAESTRUCTURA
		JLabel etiqueta4 = new JLabel("Infraestructura: subir link del esquema/Social: indicar grupo social ");
		JTextField campo5 = new JTextField(100);
		
		//AÑADIR DISTRITOS
		
		this.add(campo);
		this.add(boton);
		this.add(boton2);
		this.add(boton3);
		this.add(etiqueta);
		this.add(campo2);
		this.add(etiqueta2);
		this.add(campo3);
		this.add(etiqueta3);
		this.add(campo4);
		this.add(combo);
		this.add(combo2);
		this.add(etiqueta4);
		this.add(campo5);
		this.add(boton4);


	}

}

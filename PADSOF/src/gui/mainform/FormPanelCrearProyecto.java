package gui.mainform;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
public class FormPanelCrearProyecto extends JPanel{
	
	private JButton Buscar;
	private JButton Proyectos;
	private JButton Perfil;
	private JButton Colectivos;
	
	private JComboBox opcion;


	public FormPanelCrearProyecto() {

		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
		
		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(50);
		Buscar = new JButton("Buscar");
		Proyectos = new JButton("Proyectos");
		Perfil = new JButton("Perfil");
		Colectivos = new JButton("Colectivos");
		JLabel etiqueta = new JLabel("Titulo: ");
		JTextField campo2 = new JTextField(10);
		JLabel etiqueta2 = new JLabel("Descripcion: ");
		JTextField campo3 = new JTextField(100);
		JLabel etiqueta3 = new JLabel("Presupuesto solicitado: ");
		JTextField campo4 = new JTextField(10);
		JLabel etiqueta5 = new JLabel("Tipo de Proyecto: ");
		
		String[] busqueda = {"Colectivos", "Proyectos"};
		opcion = new JComboBox(busqueda);
		opcion.setSelectedIndex(1);


		//AÑADIR TIPO DE PROYECTO
		
		// Crear un array con las opciones del combo 
		String[] tipo = {"Social", "Infraestructura"};
		// Crear el combo, pasando el array como parámetro 
		JComboBox combo = new JComboBox(tipo); 
		// Añadir el combo al panel donde se quiera mostrar 
		JPanel ejemploComboBox = new JPanel(new GridLayout(1,2,10,0)); 
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
		
		layout.putConstraint(SpringLayout.WEST, campo2, 200, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo2, 100, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta2, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta2, 50, SpringLayout.SOUTH, etiqueta); 
		
		layout.putConstraint(SpringLayout.WEST, campo3, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo3, 10, SpringLayout.SOUTH, etiqueta2); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta3, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta3, 50, SpringLayout.SOUTH, campo3); 
		
		layout.putConstraint(SpringLayout.WEST, campo4, 300, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo4, 50, SpringLayout.SOUTH, campo3);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta5, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta5, 50, SpringLayout.SOUTH, campo4); 
		
		layout.putConstraint(SpringLayout.WEST, combo, 300, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, combo, 50, SpringLayout.SOUTH, campo4); 
		
		layout.putConstraint(SpringLayout.WEST, combo2, 450, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, combo2, 50, SpringLayout.SOUTH, campo4);
		
		//FALTA AÑADIR EL ENLACE EN CASO DE QUE SEA UNA INFRAESTRUCTURA
		//FALTA AÑADIR EL DISTRITO/S
		//FALTA AÑADIR EL GRUPO SOCIAL

		
		this.add(campo);
		this.add(Buscar);
		
		this.add(Proyectos);
		this.add(Perfil);
		this.add(Colectivos);
		
		this.add(etiqueta);
		this.add(campo2);
		
		this.add(etiqueta2);
		this.add(campo3);
		
		this.add(etiqueta3);
		this.add(campo4);
		
		this.add(combo);
		this.add(combo2);
		
		//this.add(etiqueta4);
		//this.add(campo5);
		
		this.add(etiqueta5);
		
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

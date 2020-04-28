package gui.mainform;

import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionListener;

import javax.swing.*;

import ads.PADSOF.*;


public class FormPanelUsuario extends JPanel {
	
	private FormPanelInicio vistaInicio;

	private JLabel Nombre;
	private JLabel Contraseña;
	
	private JComboBox opcion;
	
	private JButton Buscar;
	private JButton Proyectos;
	private JButton Perfil;
	private JButton Colectivos;
	private JButton Leer;
	private JButton Eliminar;
	
	private JList listaNotificaciones;
	
	private DefaultListModel notificaciones;
	
	private JList listaNotificacionesLeidas;
	
	private DefaultListModel notificaciones_leidas;
	
public FormPanelUsuario(Ciudadano c) {
				
	SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
	this.setLayout(layout); 
	
	//PARA REALIZAR BUSQUEDAS
	JTextField campo = new JTextField(50);
	Buscar = new JButton("Buscar");

	Proyectos = new JButton("Proyectos");
	Perfil = new JButton("Perfil");
	Colectivos = new JButton("Colectivos");
	
	JLabel etiqueta = new JLabel("Mis datos: ");
	Nombre = new JLabel(c.getNombre()); //NOMBRE
	Contraseña = new JLabel(c.getcontrasenia() ); //CONTRASEÑA
	JLabel etiqueta7 = new JLabel("Usuario/DNI: ");
	JLabel etiqueta9 = new JLabel("Contraseña: ");

	JLabel etiqueta4 = new JLabel("Proyectos: ");
	JButton boton4 = new JButton("Crear nuevo proyecto");
	JButton boton5 = new JButton("Ver mis proyectos creados");
	
	JLabel etiqueta5 = new JLabel("Asociaciones: ");
	JButton boton6 = new JButton("Crear nueva asociacion");
	JButton boton7 = new JButton("Ver mis asociaciones creadas");
	
	JLabel etiqueta6 = new JLabel("Informe de afinidad: ");
	JTextField campo2 = new JTextField(20);
	JTextField campo3 = new JTextField(20);
	JButton boton8 = new JButton("Solicitar");
	
	JLabel etiqueta2 = new JLabel("Notificaciones: ");
	JLabel etiqueta3 = new JLabel("Notificaciones Leidas: ");
	
	Leer = new JButton("Leer Notificacion");
	Eliminar = new JButton("Eliminar Notificacion");


	
	String[] busqueda = {"Colectivos", "Proyectos"};
	opcion = new JComboBox(busqueda);
	opcion.setSelectedIndex(1);
	
	
	
	notificaciones = new DefaultListModel();
	
	//System.out.println(c.getNotificaciones());
	
	int tam = c.getNotificaciones().size();
	int i;
	
	for (i = 0; i < tam; i++) {
		notificaciones.addElement(c.getNotificaciones().get(i).getAbreviatura());
	}
	
	listaNotificaciones = new JList(notificaciones); 
	
	listaNotificaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
	
	JScrollPane scroll = new JScrollPane(listaNotificaciones); 
	
	
	
	
	notificaciones_leidas = new DefaultListModel();
		
	tam = c.getNotificacionesLeidas().size();
	
	for (i = 0; i < tam; i++) {
		notificaciones_leidas.addElement(c.getNotificacionesLeidas().get(i).getAbreviatura());
	}
	
	listaNotificacionesLeidas = new JList(notificaciones_leidas); 
	
	listaNotificacionesLeidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
	
	JScrollPane scroll2 = new JScrollPane(listaNotificacionesLeidas); 
	
	
	

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
	
	layout.putConstraint(SpringLayout.WEST, etiqueta4, 160, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, etiqueta4, 60, SpringLayout.SOUTH, campo); 
	
	layout.putConstraint(SpringLayout.WEST, boton4, 160, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, boton4, 20, SpringLayout.SOUTH, etiqueta4); 
	
	layout.putConstraint(SpringLayout.WEST, boton5, 160, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, boton5, 20, SpringLayout.SOUTH, boton4); 
	
	layout.putConstraint(SpringLayout.WEST, etiqueta5, 160, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, etiqueta5, 100, SpringLayout.SOUTH, boton4); 
	
	layout.putConstraint(SpringLayout.WEST, etiqueta2, 500, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, etiqueta2, 100, SpringLayout.SOUTH, boton4);
	
	layout.putConstraint(SpringLayout.WEST, listaNotificaciones, 500, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, listaNotificaciones, 150, SpringLayout.SOUTH, boton4);
	
	layout.putConstraint(SpringLayout.WEST, Leer, 500, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, Leer, 50, SpringLayout.SOUTH, listaNotificaciones);
	
	layout.putConstraint(SpringLayout.WEST, listaNotificacionesLeidas, 700, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, listaNotificacionesLeidas, 150, SpringLayout.SOUTH, boton4);
	
	layout.putConstraint(SpringLayout.WEST, Eliminar, 700, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, Eliminar, 50, SpringLayout.SOUTH, listaNotificacionesLeidas);
	
	layout.putConstraint(SpringLayout.WEST, etiqueta3, 700, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, etiqueta3, 100, SpringLayout.SOUTH, boton4);
	
	layout.putConstraint(SpringLayout.WEST, boton6, 160, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, boton6, 20, SpringLayout.SOUTH, etiqueta5); 
	
	layout.putConstraint(SpringLayout.WEST, boton7, 160, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, boton7, 20, SpringLayout.SOUTH, boton6);
	
	layout.putConstraint(SpringLayout.WEST, etiqueta6, 160, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, etiqueta6, 100, SpringLayout.SOUTH, boton7); 
	
	layout.putConstraint(SpringLayout.WEST, campo2, 160, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, campo2, 20, SpringLayout.SOUTH, etiqueta6); 
	
	layout.putConstraint(SpringLayout.WEST, campo3, 160, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, campo3, 20, SpringLayout.SOUTH, campo2);
	
	layout.putConstraint(SpringLayout.WEST, boton8, 160, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, boton8, 20, SpringLayout.SOUTH, campo3);
	
	layout.putConstraint(SpringLayout.WEST, etiqueta, 500, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, etiqueta, 60, SpringLayout.SOUTH, campo); 
	
	layout.putConstraint(SpringLayout.WEST, etiqueta7, 500, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, etiqueta7, 20, SpringLayout.SOUTH, etiqueta); 
	
	layout.putConstraint(SpringLayout.WEST, Nombre, 600, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, Nombre, 20, SpringLayout.SOUTH, etiqueta);  
	
	layout.putConstraint(SpringLayout.WEST, etiqueta9, 500, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, etiqueta9, 20, SpringLayout.SOUTH, Nombre); 
	
	layout.putConstraint(SpringLayout.WEST, Contraseña, 600, SpringLayout.WEST, this);         
	layout.putConstraint(SpringLayout.NORTH, Contraseña, 20, SpringLayout.SOUTH, Nombre); 
	
	
	this.add(campo);
	this.add(Buscar);
	
	this.add(Proyectos);
	this.add(Perfil);
	this.add(Colectivos);
	
	this.add(etiqueta);
	this.add(Nombre);
	
	this.add(etiqueta4);
	this.add(boton4);
	this.add(boton5);
	
	this.add(etiqueta5);
	this.add(boton6);
	this.add(boton7);
	
	this.add(etiqueta6);
	this.add(campo2);
	this.add(campo3);
	this.add(boton8);
	
	this.add(etiqueta7);
	this.add(etiqueta9);
	this.add(Contraseña);
	
	this.add(etiqueta2);
	this.add(etiqueta3);
	
	this.add(opcion);
	
	this.add(listaNotificaciones);
	this.add(listaNotificacionesLeidas);
	this.add(scroll);
	this.add(scroll2);
	
	this.add(Leer);
	this.add(Eliminar);
	
	this.setPreferredSize(new Dimension(1000,750)); 
	
		
	}

	public void updateLN(String name) {
		notificaciones.removeElement(name);
	}
	
	public void updateEN(String name) {
		notificaciones_leidas.removeElement(name);
	}


	public void update(String name, String password) { 
		Nombre.setText(name);
		Contraseña.setText(password);
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
	
	public void setControladorLeerNotificaciones(ActionListener c) {  
		Leer.addActionListener(c);   
	}
	
	public void setControladorEliminarNotificaciones(ActionListener c) {  
		Eliminar.addActionListener(c);   
	}
	
	public String nombreNotificacion() {
		return (String)listaNotificaciones.getSelectedValue();
	}
	
	public String nombreNotificacionLeida() {
		return (String)listaNotificacionesLeidas.getSelectedValue();
	}

	public String getNombre() {
		return Nombre.getText();
	}

	public String getContraseña() {
		return Contraseña.getText();
	}
	
	
	
	
}

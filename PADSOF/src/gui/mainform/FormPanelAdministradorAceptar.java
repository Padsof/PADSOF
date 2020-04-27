package gui.mainform;

import java.awt.Component;

import java.awt.Dimension;
import java.util.List;

import javax.swing.*;

import ads.PADSOF.*;
import gui.control.AdministradorUsuario;

public class FormPanelAdministradorAceptar extends JPanel{
	
	private JButton AceptarUsuarios;
	
	private JButton AceptarProyectos;
	
	private JButton Perfil;
	
	private JList listaUsuarios;
	
	private DefaultListModel Usuarios;
	
	private JList listaUsuariosAceptados;
	
	private DefaultListModel UsuarioAceptados;
	
	private JList listaUsuariosBloqueados;
	
	private DefaultListModel Bloqueados;

	public FormPanelAdministradorAceptar(List<Ciudadano> usuariosPorAceptar, List<Proyecto> proyectosPorAceptar, List<Ciudadano> usuariosAceptados, List<Ciudadano> usuariosBloqueados) { 
		
		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
		
		Usuarios = new DefaultListModel();
		
		DefaultListModel Proyectos = new DefaultListModel();

		//LISTA USUARIOS POR ACEPTAR
		
		int tam = usuariosPorAceptar.size();
		int i;
		
		for (i = 0; i < tam; i++) {
			Usuarios.addElement(usuariosPorAceptar.get(i).getNombre());
		}
		
		listaUsuarios = new JList(Usuarios); 
		
		listaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		
		JScrollPane scroll = new JScrollPane(listaUsuarios); 
		
		//LISTA PROYECTOS
		
		tam = proyectosPorAceptar.size();
		
		for (i = 0; i < tam; i++) {
			Proyectos.addElement(proyectosPorAceptar.get(i).getTitulo());
		}
		
		JList lista2 = new JList(Proyectos); 
		
		lista2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		
		JScrollPane scroll2 = new JScrollPane(lista2); 
		
		//LISTA USUARIOS ACEPTADOS
		
		UsuarioAceptados = new DefaultListModel();
		
		tam = usuariosAceptados.size();
		
		
		for (i = 0; i < tam; i++) {
			UsuarioAceptados.addElement(usuariosAceptados.get(i).getNombre());
		}
		
		listaUsuariosAceptados = new JList(UsuarioAceptados); 
		
		listaUsuariosAceptados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		
		JScrollPane scroll3 = new JScrollPane(listaUsuariosAceptados); 
		
		//LISTA USUARIOS BLOQUEADOS
		
		Bloqueados = new DefaultListModel();
		
		tam = usuariosBloqueados.size();
		
		for (i = 0; i < tam; i++) {
			Bloqueados.addElement(usuariosBloqueados.get(i).getNombre());
		}
		
		listaUsuariosBloqueados = new JList(Bloqueados);
		
		listaUsuariosBloqueados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		
		JScrollPane scroll4 = new JScrollPane(listaUsuariosBloqueados); 
		
		
		JTextField campo = new JTextField(50);
		JButton boton7 = new JButton("Buscar");
		Perfil = new JButton("Administrador");	
		
		JLabel etiqueta2 = new JLabel("Usuarios por aceptar: ");
		JLabel etiqueta3 = new JLabel("Proyectos por aceptar: ");
		JLabel etiqueta4 = new JLabel ("Usuarios aceptados");
		JLabel etiqueta5 = new JLabel ("Usuarios bloqueados");

		AceptarUsuarios = new JButton("Consultar Usuario");
		AceptarProyectos = new JButton("Aceptar/Rechazar");
		
		layout.putConstraint(SpringLayout.WEST, campo, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, boton7, 20, SpringLayout.EAST, campo);         
		layout.putConstraint(SpringLayout.NORTH, boton7, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Perfil, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Perfil, 200, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta2, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta2, 100, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, listaUsuarios, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, listaUsuarios, 20, SpringLayout.SOUTH, etiqueta2); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta4, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta4, 50, SpringLayout.SOUTH, listaUsuarios); 
		
		layout.putConstraint(SpringLayout.WEST, listaUsuariosAceptados, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, listaUsuariosAceptados, 20, SpringLayout.SOUTH, etiqueta4); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta5, 300, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta5, 50, SpringLayout.SOUTH, listaUsuarios); 
		
		layout.putConstraint(SpringLayout.WEST, listaUsuariosBloqueados, 300, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, listaUsuariosBloqueados, 20, SpringLayout.SOUTH, etiqueta5); 
		
		layout.putConstraint(SpringLayout.WEST, AceptarUsuarios, 160, SpringLayout.WEST, etiqueta2);         
		layout.putConstraint(SpringLayout.NORTH, AceptarUsuarios, 100, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta3, 500, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta3, 100, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, lista2, 500, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, lista2, 20, SpringLayout.SOUTH, etiqueta2); 
		
		layout.putConstraint(SpringLayout.WEST, AceptarProyectos, 160, SpringLayout.WEST, etiqueta3);         
		layout.putConstraint(SpringLayout.NORTH, AceptarProyectos, 100, SpringLayout.SOUTH, campo); 
		
		
		this.setPreferredSize(new Dimension(1000,500)); 

		this.add(campo);
		this.add(Perfil);
		this.add(etiqueta2);
		this.add(listaUsuarios);
		this.add(listaUsuariosAceptados);
		this.add(listaUsuariosBloqueados);
		this.add(boton7);
		this.add(AceptarUsuarios);
		this.add(AceptarProyectos);
		this.add(scroll);
		this.add(lista2);
		this.add(scroll2);
		this.add(etiqueta3);
		this.add(scroll3);
		this.add(scroll4);
		this.add(etiqueta4);
		this.add(etiqueta5);
	
	}

	public String getNombre() {
		return (String)listaUsuarios.getSelectedValue();
	}
	
	public String getNombreAceptado() {
		return (String)listaUsuariosAceptados.getSelectedValue();
	}
	
	public String getNombreBloqueado() {
		return (String)listaUsuariosBloqueados.getSelectedValue();
	}

	public void setControladorMenuColectivo(AdministradorUsuario botonAU) {
		AceptarUsuarios.addActionListener(botonAU);   
		
	}
	
	public void update(String nombre) {
		
		Usuarios.removeElement(nombre);
		UsuarioAceptados.addElement(nombre);
		
	}
	
	public void updateR(String nombre) {
		Usuarios.removeElement(nombre);
	}
	
	public void updateB(String nombre) {
		UsuarioAceptados.removeElement(nombre);
		Bloqueados.addElement(nombre);
	}
	
	public void updateD(String nombre) {
		Bloqueados.removeElement(nombre);
		UsuarioAceptados.addElement(nombre);
	}
	
	

}

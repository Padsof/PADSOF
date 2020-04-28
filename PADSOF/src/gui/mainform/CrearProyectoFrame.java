package gui.mainform;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import gui.control.Buscar;
import gui.control.ControladorBuscar;
import gui.control.ControladorMenuColectivo;
import gui.control.ControladorMenuProyectos;
import gui.control.ControlarPerfil;
import gui.control.MenuColectivo;
import gui.control.MenuProyecto;
import gui.control.Perfil;

public class CrearProyectoFrame extends JFrame{

	
	private JPanel contentPane;
	
	private FormPanelCrearProyecto Proyecto;
	
	private Buscar botonBuscar;
	
	private Perfil botonPerfil;
	
	private MenuProyecto botonMenuP;
	
	private MenuColectivo botonMenuC;
	
	public CrearProyectoFrame() {
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.Proyecto = new FormPanelCrearProyecto();		
		contentPane.add(Proyecto, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public FormPanelCrearProyecto getProyecto() {
		return Proyecto;
	}
	
	public void setControladorBuscar(ControladorBuscar controlador) {
		this.botonBuscar = controlador.getBotonBuscar();
		Proyecto.setControladorBuscar(botonBuscar);
	}
	
	public void setControladorPerfil(ControlarPerfil controlador) {
		this.botonPerfil = controlador.getBotonPerfil();
		Proyecto.setControladorPerfil(botonPerfil);
	}
	
	public void setControladorMenuProyecto(ControladorMenuProyectos controlador) {
		this.botonMenuP = controlador.getBotonMenuP();
		Proyecto.setControladorMenuProyecto(botonMenuP);
	}
	
	public void setControladorMenuColectivo(ControladorMenuColectivo controlador) {
		this.botonMenuC = controlador.getBotonMenuC();
		Proyecto.setControladorMenuColectivo(botonMenuC);
	}
}

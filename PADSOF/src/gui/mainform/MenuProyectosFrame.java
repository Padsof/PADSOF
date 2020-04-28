package gui.mainform;

import java.awt.BorderLayout;
import java.awt.Container;

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

public class MenuProyectosFrame extends JFrame{
	
	private JPanel contentPane;
	
	private FormPanelMenuProyectos MenuP;
	
	private Buscar botonBuscar;
	
	private Perfil botonPerfil;
	
	private MenuProyecto botonMenuP;
	
	private MenuColectivo botonMenuC;
	
	public MenuProyectosFrame() {
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.MenuP = new FormPanelMenuProyectos();
		contentPane.add(MenuP, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public FormPanelMenuProyectos getMenuP() {
		return MenuP;
	}
	
	public void setControladorBuscar(ControladorBuscar controlador) {
		this.botonBuscar = controlador.getBotonBuscar();
		MenuP.setControladorBuscar(botonBuscar);
	}
	
	public void setControladorPerfil(ControlarPerfil controlador) {
		this.botonPerfil = controlador.getBotonPerfil();
		MenuP.setControladorPerfil(botonPerfil);
	}
	
	public void setControladorMenuProyecto(ControladorMenuProyectos controlador) {
		this.botonMenuP = controlador.getBotonMenuP();
		MenuP.setControladorMenuProyecto(botonMenuP);
	}
	
	public void setControladorMenuColectivo(ControladorMenuColectivo controlador) {
		this.botonMenuC = controlador.getBotonMenuC();
		MenuP.setControladorMenuColectivo(botonMenuC);
	}
	
	
	
}

package gui.mainform;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

import gui.control.Buscar;
import gui.control.ControladorBuscar;
import gui.control.ControladorInformacionColectivo;
import gui.control.ControladorMenuColectivo;
import gui.control.ControladorMenuProyectos;
import gui.control.ControlarPerfil;
import gui.control.InformacionColectivo;
import gui.control.MenuColectivo;
import gui.control.MenuProyecto;
import gui.control.Perfil;

public class MenuAsociacionFrame extends JFrame{
	
	private JPanel contentPane;
	
	private FormPanelMenuAsociacion MenuAsociacion;
	
	private Buscar botonBuscar;
	
	private Perfil botonPerfil;
	
	private MenuProyecto botonMenuP;
	
	private MenuColectivo botonMenuC;
	
	private InformacionColectivo botonIC;
			
	
	
	public MenuAsociacionFrame() {
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.MenuAsociacion = new FormPanelMenuAsociacion();
		contentPane.add(MenuAsociacion, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		
	}


	public FormPanelMenuAsociacion getMenuAsociacion() {
		return MenuAsociacion;
	}
	
	public void setControladorBuscar(ControladorBuscar controlador) {
		this.botonBuscar = controlador.getBotonBuscar();
		MenuAsociacion.setControladorBuscar(botonBuscar);
	}
	
	public void setControladorPerfil(ControlarPerfil controlador) {
		this.botonPerfil = controlador.getBotonPerfil();
		MenuAsociacion.setControladorPerfil(botonPerfil);
	}
	
	public void setControladorMenuProyecto(ControladorMenuProyectos controlador) {
		this.botonMenuP = controlador.getBotonMenuP();
		MenuAsociacion.setControladorMenuProyecto(botonMenuP);
	}
	
	public void setControladorMenuColectivo(ControladorMenuColectivo controlador) {
		this.botonMenuC = controlador.getBotonMenuC();
		MenuAsociacion.setControladorMenuColectivo(botonMenuC);
	}
	
	public void setControladorInformacionColectivo(ControladorInformacionColectivo controlador) {
		this.botonIC = controlador.getBotonInformacionColectivo();
		MenuAsociacion.setControladorInformacion(botonIC);
	}
	
	
	
	
	
}


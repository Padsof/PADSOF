package gui.mainform;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

import gui.control.Buscar;
import gui.control.ControladorBuscar;
import gui.control.ControladorMenuColectivo;
import gui.control.ControladorMenuProyectos;
import gui.control.ControlarPerfil;
import gui.control.MenuColectivo;
import gui.control.MenuProyecto;
import gui.control.Perfil;


public class AsociacionesCreadasFrame extends JFrame{

	private JPanel contentPane;
	
	private FormPanelAsociacionesCreadas asociacionesCreadas;
	
	private Buscar botonBuscar;
	
	private Perfil botonPerfil;
	
	private MenuProyecto botonMenuP;
	
	private MenuColectivo botonMenuC;
	
	public AsociacionesCreadasFrame() {
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.asociacionesCreadas = new FormPanelAsociacionesCreadas();
		contentPane.add(asociacionesCreadas, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}

	public FormPanelAsociacionesCreadas getAsociacionesCreadas() {
		return asociacionesCreadas;
	}
	
	public void setControladorBuscar(ControladorBuscar controlador) {
		this.botonBuscar = controlador.getBotonBuscar();
		asociacionesCreadas.setControladorBuscar(botonBuscar);
	}

	public void setControladorPerfil(ControlarPerfil controlador) {
		this.botonPerfil = controlador.getBotonPerfil();
		asociacionesCreadas.setControladorPerfil(botonPerfil);
	}
	
	public void setControladorMenuProyecto(ControladorMenuProyectos controlador) {
		this.botonMenuP = controlador.getBotonMenuP();
		asociacionesCreadas.setControladorMenuProyecto(botonMenuP);
	}
	
	public void setControladorMenuColectivo(ControladorMenuColectivo controlador) {
		this.botonMenuC = controlador.getBotonMenuC();
		asociacionesCreadas.setControladorMenuColectivo(botonMenuC);
	}
	
	
}

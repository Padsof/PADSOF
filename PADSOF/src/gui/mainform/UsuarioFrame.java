package gui.mainform;

import java.awt.*;

import javax.swing.*;

import ads.PADSOF.*;
import gui.control.*;

public class UsuarioFrame extends JFrame{

	private JPanel contentPane;
	
	private FormPanelUsuario usuario;
	
	private Buscar botonBuscar;
	
	private Perfil botonPerfil;
	
	private MenuProyecto botonMenuP;
	
	private MenuColectivo botonMenuC;
	
	private LeerNotificacion botonleer;
	
	private EliminarNotificacion botoneliminar;
	
	//private Ciudadano c;
			
	public UsuarioFrame(Ciudadano c) {
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.usuario = new FormPanelUsuario(c);
		contentPane.add(usuario, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}

	public FormPanelUsuario getUsuario() {
		return usuario;
	}
	
	public void setControladorBuscar(ControladorBuscar controlador) {
		this.botonBuscar = controlador.getBotonBuscar();
		usuario.setControladorBuscar(botonBuscar);
	}
	
	public void setControladorPerfil(ControlarPerfil controlador) {
		this.botonPerfil = controlador.getBotonPerfil();
		usuario.setControladorPerfil(botonPerfil);
	}
	
	public void setControladorMenuProyecto(ControladorMenuProyectos controlador) {
		this.botonMenuP = controlador.getBotonMenuP();
		usuario.setControladorMenuProyecto(botonMenuP);
	}
	
	public void setControladorMenuColectivo(ControladorMenuColectivo controlador) {
		this.botonMenuC = controlador.getBotonMenuC();
		usuario.setControladorMenuColectivo(botonMenuC);
	}
	
	public void setControladorLeerNotificaciones(ControladorLeerNotificacion controlador) {
		this.botonleer = controlador.getLeer();
		usuario.setControladorLeerNotificaciones(botonleer);
	}
	
	public void setControladorEliminarNotificaciones(ControladorEliminarNotificacion controlador) {
		this.botoneliminar = controlador.getEliminar();
		usuario.setControladorEliminarNotificaciones(botoneliminar);
	}
	
	
	
	
}


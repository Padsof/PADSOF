package gui.mainform;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

import ads.PADSOF.Aplicacion;
import gui.AdministradorUsuario;
import gui.control.Buscar;
import gui.control.ControladorAdministradorUsuario;
import gui.control.ControladorMenuColectivo;
import gui.control.Perfil;

public class AdministradorAceptarFrame extends JFrame{ //PARA ACEPTAR USUARIOS
	
	private JPanel contentPane;
	
	private Buscar botonBuscar;
	
	private Perfil botonPerfil;
	
	private gui.control.AdministradorUsuario botonAU;
	
	
	
	private FormPanelAdministradorAceptar AceptarUsuarios;	
		
	public AdministradorAceptarFrame() {
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.AceptarUsuarios = new FormPanelAdministradorAceptar(Aplicacion.getUsuariosPorAceptar(), Aplicacion.getProyectosPorAceptar(), Aplicacion.getUsuariosAceptados(), Aplicacion.getBloqueados());
		contentPane.add(AceptarUsuarios, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}

	public FormPanelAdministradorAceptar getAceptarUsuarios() {
		return AceptarUsuarios;
	}
	
	public void setControladorAdministradorUsuario(ControladorAdministradorUsuario controlador) {
		this.botonAU = controlador.getBotonAU();
		AceptarUsuarios.setControladorMenuColectivo(botonAU);
	}
	
	
}


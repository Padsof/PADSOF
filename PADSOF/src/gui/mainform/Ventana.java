package gui.mainform;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

import gui.control.*;

public class Ventana extends JFrame{

	private JPanel contentPane;
	
	private Registrate botonRegistrar;
	
	private IniciarSesion botonIniciarSesion;
	
	private FormPanelInicio inicio;
	
	public Ventana() {
				
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.inicio = new FormPanelInicio();		
		contentPane.add(inicio, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setVisible(true);
		
	}

	public FormPanelInicio getInicio() {
		return this.inicio;
	}

	
	public void setControladorRegistrar(ControladorRegistrate controlador) {
		this.botonRegistrar = controlador.getBotonRegistrar();
		inicio.setControladorRegistrar(botonRegistrar);
	}
	
	public void setControladorIniciarSesion(ControladorIniciarSesion controlador) {
		this.botonIniciarSesion = controlador.getBotonIniciarSesion();
		inicio.setControladorIniciar(botonIniciarSesion);
	}
	
	
	
}

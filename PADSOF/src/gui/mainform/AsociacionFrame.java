package gui.mainform;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ads.PADSOF.Colectivo;
import gui.control.Buscar;
import gui.control.ControladorBuscar;
import gui.control.ControladorMenuColectivo;
import gui.control.ControladorMenuProyectos;
import gui.control.ControladorUnirseColectivo;
import gui.control.ControlarPerfil;
import gui.control.InformacionColectivo;
import gui.control.MenuColectivo;
import gui.control.MenuProyecto;
import gui.control.Perfil;
import gui.control.UnirseColectivo;

public class AsociacionFrame extends JFrame{
	
	private JPanel contentPane;
	
	private FormPanelAsociacion asociacion;
	
	private Buscar botonBuscar;
	
	private Perfil botonPerfil;

	private MenuProyecto botonMenuP;
	
	private MenuColectivo botonMenuC;
	
	private UnirseColectivo botonUC;
		
	
	public AsociacionFrame(Colectivo colectivo) {
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.asociacion = new FormPanelAsociacion(colectivo);
		contentPane.add(asociacion, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}




	public FormPanelAsociacion getAsociacion() {
		return asociacion;
	}
	
	public void setControladorBuscar(ControladorBuscar controlador) {
		this.botonBuscar = controlador.getBotonBuscar();
		asociacion.setControladorBuscar(botonBuscar);
	}

	public void setControladorPerfil(ControlarPerfil controlador) {
		this.botonPerfil = controlador.getBotonPerfil();
		asociacion.setControladorPerfil(botonPerfil);
	}
	
	public void setControladorMenuProyecto(ControladorMenuProyectos controlador) {
		this.botonMenuP = controlador.getBotonMenuP();
		asociacion.setControladorMenuProyecto(botonMenuP);
	}
	
	public void setControladorMenuColectivo(ControladorMenuColectivo controlador) {
		this.botonMenuC = controlador.getBotonMenuC();
		asociacion.setControladorMenuColectivo(botonMenuC);
	}
	
	public void setControladorUnirseColectivo(ControladorUnirseColectivo controlador) {
		this.botonUC = controlador.getBotonUC();
		asociacion.setControladorUnirseColectivo(botonUC);
	}
}

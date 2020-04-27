package gui.mainform;

import java.awt.BorderLayout;


import javax.swing.*;

import ads.PADSOF.Ciudadano;
import gui.AdministradorAceptar;
import gui.control.*;

public class AdministradorUsuarioFrame extends JFrame{
	
	private JPanel contentPane;
		
	private FormPanelAdministradorUsuario AdministradorUsuario;
	
	private AceptarUsuario botonau;
	
	private RechazarUsuario botonru;
	
	private BloquearUsuario botonbu;
	
	private DesbloquearUsuario botondbu;
			
	public AdministradorUsuarioFrame(Ciudadano ciudadano) {
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.AdministradorUsuario = new FormPanelAdministradorUsuario(ciudadano);
		contentPane.add(AdministradorUsuario, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}

	public FormPanelAdministradorUsuario getAdministradorUsuario() {
		return AdministradorUsuario;
	}
	
	public void setControladorAceptarUsuario(ControladorAceptarUsuario controlador) {
		this.botonau = controlador.getBotonAU();
		AdministradorUsuario.setControladorAceptarUsuario(botonau);
	}
	
	public void setControladorRechazarUsuario(ControladorRechazarUsuario controlador) {
		this.botonru = controlador.getBotonAU();
		AdministradorUsuario.setControladorRechazarUsuario(botonru);
	}
	
	public void setControladorBloquearUsuario(ControladorBloquearUsuario controlador) {
		this.botonbu = controlador.getBotonBU();
		AdministradorUsuario.setControladorBloquearUsuario(botonbu);
	}
	
	public void setControladorDesbloquearUsuario(ControladorDesbloquearUsuario controlador) {
		this.botondbu = controlador.getBotonDBU();
		AdministradorUsuario.setControladorDesbloquearUsuario(botondbu);
	}

	
	
	
}


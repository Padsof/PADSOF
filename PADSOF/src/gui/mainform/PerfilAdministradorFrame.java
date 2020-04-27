package gui.mainform;

import java.awt.BorderLayout;

import java.awt.Container;

import javax.swing.*;

import ads.PADSOF.Administrador;
import gui.control.*;

public class PerfilAdministradorFrame extends JFrame{
	
	private JPanel contentPane;
		
	private AceptarAdministrador aceptarAdministrador;
	
	private FormPanelPerfilAdministrador PerfilAdministrador;
		
	public PerfilAdministradorFrame(Administrador administrador) {
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.PerfilAdministrador = new FormPanelPerfilAdministrador(administrador);
		contentPane.add(PerfilAdministrador, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}

	public FormPanelPerfilAdministrador getPerfilAdministrador() {
		return PerfilAdministrador;
	}
	
	public void setControladorAceptarUsuario(ControladorAceptarAdministrador controlador) {
		this.aceptarAdministrador = controlador.getBoton();
		PerfilAdministrador.setControladorAceptarUsuario(aceptarAdministrador);
	}

	
	
	
}


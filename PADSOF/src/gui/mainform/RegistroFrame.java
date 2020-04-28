package gui.mainform;
import java.awt.*;
import javax.swing.*;
import gui.control.*;

public class RegistroFrame extends JFrame{
	
	private JPanel contentPane;
	
	private FormPanelRegistro registro;
		
	private Volver botonVolver;
	
	private Registrarse botonRegistrarse;

	
	public RegistroFrame() {
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		this.registro = new FormPanelRegistro();
		contentPane.add(registro, BorderLayout.CENTER); 

		setBounds(100, 100, 450, 300);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
	}
	
	public FormPanelRegistro getRegistro() {
		return this.registro;
	}



	public void setControladorVolver(ControladorVolver controlador) {
		this.botonVolver = controlador.getBotonVolver();
		registro.setControladorVolver(botonVolver);
	}
	
	public void setControladorRegistrarse(ControladorRegistrarse controlador) {
		this.botonRegistrarse = controlador.getBotonRegistrarse();
		registro.setControladorRegistrarse(botonRegistrarse);
	}
	
	
	
}

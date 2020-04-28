package gui.mainform;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FormPanelInicio extends JPanel {
	
	 private JButton botonRegistrar;
	 private JButton botonInicioSesion;
	 
	 private JTextField campoNombre;
	 private JTextField campoDNI;
	 private JPasswordField campoContraseña;

	public FormPanelInicio() {
		
		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
				
		JLabel etiqueta = new JLabel("Usuario o DNI");
		campoNombre = new JTextField(10);
		JLabel etiqueta2 = new JLabel("Contraseña");
		campoContraseña = new JPasswordField(10); 
		JPanel ejemploPasswordField = new JPanel(new GridLayout(2,1,2,2)); 
		ejemploPasswordField.add(campoContraseña); 
		botonInicioSesion = new JButton("Iniciar Sesion");
		JLabel etiqueta3 = new JLabel("¿Usuario nuevo?");
		botonRegistrar = new JButton("Registrate");
		
		layout.putConstraint(SpringLayout.WEST, etiqueta, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 10, SpringLayout.NORTH, this); 
		 
		layout.putConstraint(SpringLayout.WEST, campoNombre, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campoNombre, 20, SpringLayout.NORTH, etiqueta); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta2, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta2, 20, SpringLayout.NORTH, campoNombre); 
		
		layout.putConstraint(SpringLayout.WEST, campoContraseña, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campoContraseña, 20, SpringLayout.NORTH, etiqueta2); 
		
		layout.putConstraint(SpringLayout.WEST, botonInicioSesion, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, botonInicioSesion, 40, SpringLayout.NORTH, campoContraseña); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta3, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta3, 40, SpringLayout.NORTH, botonInicioSesion); 
		
		layout.putConstraint(SpringLayout.WEST, botonRegistrar, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, botonRegistrar, 40, SpringLayout.NORTH, etiqueta3); 
		

		this.add(etiqueta);
		this.add(campoNombre);
		this.add(etiqueta2);
		this.add(campoContraseña);
		this.add(botonInicioSesion);
		this.add(etiqueta3);
		this.add(botonRegistrar);	
		
		this.setPreferredSize(new Dimension(250,250)); 
		
	}
		
	public void setControladorRegistrar(ActionListener c) {  
		botonRegistrar.addActionListener(c);  
	} 
	
	public void setControladorIniciar(ActionListener c) {  
		botonInicioSesion.addActionListener(c);  
	}

	public String getCampoNombre() {
		return campoNombre.getText();
	}

	public String getCampoContraseña() {
		return campoContraseña.getText();
	}



}

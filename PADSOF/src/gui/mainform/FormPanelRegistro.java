package gui.mainform;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import gui.control.Volver;

public class FormPanelRegistro extends JPanel {
	
	 private JButton botonVolver;
	 private JButton botonRegistrarse;
	 
	 private JTextField campoNombre;
	 private JTextField campoDNI;
	 private JPasswordField campoContraseña;


	public FormPanelRegistro() {
		
		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
		
		JLabel etiqueta = new JLabel("Usuario");
		campoNombre = new JTextField(10);
		JLabel etiqueta2 = new JLabel("DNI");
		campoDNI = new JTextField(9);
		JLabel etiqueta3 = new JLabel("Contraseña");
		campoContraseña = new JPasswordField(10); 
		JPanel ejemploPasswordField = new JPanel(new GridLayout(2,1,2,2)); 
		ejemploPasswordField.add(campoContraseña); 				
		botonRegistrarse = new JButton("Registrarse");
		botonVolver = new JButton("Volver");

		
		layout.putConstraint(SpringLayout.WEST, etiqueta, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 10, SpringLayout.NORTH, this); 
		 
		layout.putConstraint(SpringLayout.WEST, campoNombre, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campoNombre, 20, SpringLayout.NORTH, etiqueta); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta2, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta2, 20, SpringLayout.NORTH, campoNombre); 
		
		layout.putConstraint(SpringLayout.WEST, campoDNI, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campoDNI, 20, SpringLayout.NORTH, etiqueta2); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta3, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta3, 20, SpringLayout.NORTH, campoDNI); 
		
		layout.putConstraint(SpringLayout.WEST, campoContraseña, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campoContraseña, 20, SpringLayout.NORTH, etiqueta3); 
		
		layout.putConstraint(SpringLayout.WEST, botonRegistrarse, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, botonRegistrarse, 40, SpringLayout.NORTH, campoContraseña); 
		
		layout.putConstraint(SpringLayout.WEST, botonVolver, 40, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, botonVolver, 40, SpringLayout.NORTH, botonRegistrarse); 
		
	

		this.add(etiqueta);
		this.add(campoNombre);
		this.add(etiqueta2);
		this.add(campoDNI);
		this.add(etiqueta3);
		this.add(campoContraseña);
		this.add(botonRegistrarse);
		this.add(botonVolver);
		
		this.setPreferredSize(new Dimension(250,250)); 

		
	}
	
	public void setControladorVolver(ActionListener c) {  
		botonVolver.addActionListener(c);   
	} 
	
	public void setControladorRegistrarse(ActionListener c) {  
		botonRegistrarse.addActionListener(c);   
	}

	public String getCampoNombre() {
		return campoNombre.getText();
	}

	public String getCampoDNI() {
		return campoDNI.getText();
	}

	public String getCampoContraseña() {
		return campoContraseña.getText();
	} 
	
	


}
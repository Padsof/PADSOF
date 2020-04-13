package gui.mainform;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FormPanelRegistro extends JPanel {

	public FormPanelRegistro(RegistroFrame registroFrame) {
		
		JLabel etiqueta = new JLabel("Usuario");
		JTextField campo = new JTextField(10);
		
		JLabel etiqueta2 = new JLabel("DNI");
		JTextField campo2 = new JTextField(9);
		
		JLabel etiqueta3 = new JLabel("Contraseña");
		JPasswordField campo3 = new JPasswordField(10); 
		JPanel ejemploPasswordField = new JPanel(new GridLayout(2,1,2,2)); 
		//ejemploPasswordField.add(new JLabel("Introduce la contraseña")); 
		ejemploPasswordField.add(campo3); 
		//JTextField campo3 = new JTextField(10);
				
		JButton boton = new JButton("Registrarse");
		
		JButton boton2 = new JButton("Volver");


		this.add(etiqueta);
		this.add(campo);
		this.add(etiqueta2);
		this.add(campo2);
		this.add(etiqueta3);
		this.add(campo3);
		this.add(boton);
		this.add(boton2);
		
	}

}
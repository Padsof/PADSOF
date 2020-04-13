package gui.mainform;

import java.awt.event.ActionEvent;

import javax.swing.*;


public class FormPanel extends JPanel{

	public FormPanel(MainFrame mainFrame) {
		
		JLabel etiqueta = new JLabel("Usuario o DNI");
		JTextField campo = new JTextField(10);
		
		JLabel etiqueta2 = new JLabel("Contraseña");
		JTextField campo2 = new JTextField(10);
		
		JButton boton = new JButton("Iniciar Sesion");
		
		JLabel etiqueta3 = new JLabel("¿Usuario nuevo?");
		JButton boton2 = new JButton("Registrate");
		
		boton.addActionListener(e -> JOptionPane.showMessageDialog(mainFrame, "Esto va de mal en peor"));

		this.add(etiqueta);
		this.add(campo);
		this.add(etiqueta2);
		this.add(campo2);
		this.add(boton);
		this.add(etiqueta3);
		this.add(boton2);
	}

}

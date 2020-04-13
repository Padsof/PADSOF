package gui.mainform;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FormPanelInicio extends JPanel {

	public FormPanelInicio(InicioFrame inicioFrame) {
				
		JLabel etiqueta = new JLabel("Usuario o DNI");
		JTextField campo = new JTextField(10);
		
		JLabel etiqueta2 = new JLabel("Contraseña");
		JPasswordField campo2 = new JPasswordField(10); 
		JPanel ejemploPasswordField = new JPanel(new GridLayout(2,1,2,2)); 
		//ejemploPasswordField.add(new JLabel("Introduce la contraseña")); 
		ejemploPasswordField.add(campo); 
		//JTextField campo2 = new JTextField(10);
		
		JButton boton = new JButton("Iniciar Sesion");
		
		JLabel etiqueta3 = new JLabel("¿Usuario nuevo?");
		JButton boton2 = new JButton("Registrate");
		
		boton.addActionListener(e -> JOptionPane.showMessageDialog(inicioFrame, "Esto va de mal en peor"));

		this.add(etiqueta);
		this.add(campo);
		this.add(etiqueta2);
		this.add(campo2);
		this.add(boton);
		this.add(etiqueta3);
		this.add(boton2);	
		
	}

}

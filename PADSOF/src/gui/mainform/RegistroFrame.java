package gui.mainform;

import javax.swing.*;

public class RegistroFrame extends JFrame{
	
	private FormPanelRegistro fp = new FormPanelRegistro(this);
	
	public RegistroFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}

package gui.mainform;

import javax.swing.*;

public class UsuarioFrame extends JFrame{
	
	private FormPanelUsuario fp = new FormPanelUsuario(this);
	
	public UsuarioFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}


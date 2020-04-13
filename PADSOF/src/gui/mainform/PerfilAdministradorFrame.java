package gui.mainform;

import javax.swing.*;

public class PerfilAdministradorFrame extends JFrame{
	
	private FormPanelPerfilAdministrador fp = new FormPanelPerfilAdministrador(this);
	
	public PerfilAdministradorFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}


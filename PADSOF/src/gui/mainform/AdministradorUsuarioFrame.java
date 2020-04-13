package gui.mainform;

import javax.swing.*;

public class AdministradorUsuarioFrame extends JFrame{
	
	private FormPanelAdministradorUsuario fp = new FormPanelAdministradorUsuario(this);
	
	public AdministradorUsuarioFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}


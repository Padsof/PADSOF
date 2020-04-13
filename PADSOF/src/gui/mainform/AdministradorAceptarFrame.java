package gui.mainform;

import javax.swing.*;

public class AdministradorAceptarFrame extends JFrame{
	
	private FormPanelAdministradorAceptar fp = new FormPanelAdministradorAceptar(this);
	
	public AdministradorAceptarFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}


package gui.mainform;

import javax.swing.*;

public class AdministradorProyectoFrame extends JFrame{
	
	private FormPanelAdministradorProyecto fp = new FormPanelAdministradorProyecto(this);
	
	public AdministradorProyectoFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}


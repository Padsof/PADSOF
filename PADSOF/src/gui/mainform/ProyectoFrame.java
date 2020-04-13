package gui.mainform;

import javax.swing.*;

public class ProyectoFrame extends JFrame{
	
	private FormPanelProyecto fp = new FormPanelProyecto(this);
	
	public ProyectoFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}

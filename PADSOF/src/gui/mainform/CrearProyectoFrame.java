package gui.mainform;

import javax.swing.JFrame;

public class CrearProyectoFrame extends JFrame{

private FormPanelCrearProyecto fp = new FormPanelCrearProyecto(this);
	
	public CrearProyectoFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}

package gui.mainform;

import javax.swing.*;

public class ProyectosCreadosFrame extends JFrame{
	
	private FormPanelProyectosCreados fp = new FormPanelProyectosCreados(this);
	
	public ProyectosCreadosFrame() {
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}

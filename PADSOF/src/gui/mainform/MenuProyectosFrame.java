package gui.mainform;

import javax.swing.JFrame;

public class MenuProyectosFrame extends JFrame{
	
	private FormPanelMenuProyectos fp = new FormPanelMenuProyectos(this);
	
	public MenuProyectosFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}

package gui.mainform;

import javax.swing.*;

public class MenuAsociacionFrame extends JFrame{
	
	private FormPanelMenuAsociacion fp = new FormPanelMenuAsociacion(this);
	
	public MenuAsociacionFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}


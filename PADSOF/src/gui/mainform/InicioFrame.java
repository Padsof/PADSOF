package gui.mainform;

import javax.swing.*;

public class InicioFrame extends JFrame{
	
	private FormPanelInicio fp = new FormPanelInicio(this);
	
	public InicioFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}

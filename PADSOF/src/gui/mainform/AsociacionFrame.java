package gui.mainform;

import javax.swing.JFrame;

public class AsociacionFrame extends JFrame{
	
	private FormPanelAsociacion fp = new FormPanelAsociacion(this);
	
	public AsociacionFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}

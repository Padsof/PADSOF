package gui.mainform;

import javax.swing.*;

public class CrearAsociacionFrame extends JFrame{
	
	private FormPanelCrearAsociacion fp = new FormPanelCrearAsociacion(this);
	
	public CrearAsociacionFrame() {
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}


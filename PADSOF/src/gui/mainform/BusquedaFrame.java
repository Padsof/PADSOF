package gui.mainform;

import javax.swing.*;

public class BusquedaFrame extends JFrame{
	
	private FormPanelBusqueda fp = new FormPanelBusqueda(this);
	
	public BusquedaFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}


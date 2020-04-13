package gui.mainform;

import javax.swing.*;

public class BusquedaAdministradorFrame extends JFrame{
	
	private FormPanelBusquedaAdministrador fp = new FormPanelBusquedaAdministrador(this);
	
	public BusquedaAdministradorFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}


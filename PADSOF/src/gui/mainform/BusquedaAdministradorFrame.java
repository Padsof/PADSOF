package gui.mainform;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.*;

public class BusquedaAdministradorFrame extends JFrame{
	
	private FormPanelBusquedaAdministrador fp = new FormPanelBusquedaAdministrador(this);
	
	public BusquedaAdministradorFrame() {
		
		super("Administrador Busqueda");
		Container cp = this.getContentPane();
		cp.setLayout(new BorderLayout()); 
		
		cp.add(fp, BorderLayout.CENTER); 
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}


package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.mainform.*;

public class AceptarUsuarios implements ActionListener{
	
	private PerfilAdministradorFrame framePA;
	private AdministradorAceptarFrame frameAA;
	
	private FormPanelPerfilAdministrador PAvista;
	private FormPanelAdministradorAceptar AAvista;
	
	public AceptarUsuarios(PerfilAdministradorFrame pa, AdministradorAceptarFrame aa ) { 
		
		this.frameAA = aa;
		this.framePA = pa;
		
		this.AAvista = aa.getAceptarUsuarios();
		this.PAvista = pa.getPerfilAdministrador();
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
	
		frameAA.setVisible(true);
		framePA.setVisible(false);
		
		AAvista.setVisible(true);;
		PAvista.setVisible(false);

		
	}


}

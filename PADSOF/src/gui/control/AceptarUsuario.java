package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ads.PADSOF.*;
import gui.mainform.*;

public class AceptarUsuario implements ActionListener{
	
	
	private AdministradorUsuarioFrame frameAU;
	
	private FormPanelAdministradorUsuario AUvista;
	
	Ciudadano ciudadano;
	Ciudadano aux;

	
	public AceptarUsuario (AdministradorUsuarioFrame au ) { 
		
		this.frameAU = au;
		
		this.AUvista = au.getAdministradorUsuario();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		
		int tam = Aplicacion.getUsuariosPorAceptar().size();
		int i;
		int flag = 0;

						
		for(i = 0; i < tam; i++) {
			if(AUvista.getNombre().equals(Aplicacion.getUsuariosPorAceptar().get(i).getNombre())) {
				ciudadano = Aplicacion.getUsuariosPorAceptar().get(i);
				aux = ciudadano;
				flag = 1;
			}
		}
		
		if (flag == 0) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar un usuario no aceptado en la aplicacion.", "Error", JOptionPane.ERROR_MESSAGE);
			
			AdministradorAceptarFrame newFrame = new AdministradorAceptarFrame();
			FormPanelAdministradorAceptar newVista = newFrame.getAceptarUsuarios();
			
			ControladorAdministradorUsuario controladorAU = new ControladorAdministradorUsuario(newFrame);
			
			newFrame.setControladorAdministradorUsuario(controladorAU);
			
			newFrame.setVisible(true);
			frameAU.setVisible(false);
			
			newVista.setVisible(true);
			AUvista.setVisible(false);
			return;
		}
		
		ciudadano.aceptarUsuario(ciudadano);		
		
		JOptionPane.showMessageDialog(null, "Usuario aceptado"); 
		
		AdministradorAceptarFrame newFrame = new AdministradorAceptarFrame();
		FormPanelAdministradorAceptar newVista = newFrame.getAceptarUsuarios();
		
		ControladorAdministradorUsuario controladorAU = new ControladorAdministradorUsuario(newFrame);
		
		newFrame.setControladorAdministradorUsuario(controladorAU);
				
		newFrame.setVisible(true);
		frameAU.setVisible(false);
		
		newVista.setVisible(true);
		AUvista.setVisible(false);
		

		
	}

}

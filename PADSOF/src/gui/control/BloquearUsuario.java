package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ads.PADSOF.*;
import gui.mainform.*;

public class BloquearUsuario implements ActionListener{
	
	private AdministradorUsuarioFrame frameAU;
	
	private FormPanelAdministradorUsuario AUvista;
	
	Ciudadano ciudadano;
	Ciudadano aux;
	
	public BloquearUsuario(AdministradorUsuarioFrame au) { 
		
		this.frameAU = au;
		
		this.AUvista = au.getAdministradorUsuario();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		
		int tam = Aplicacion.getBloqueados().size();
		int i;
		int flag = 0;
						
		for(i = 0; i < tam; i++) {
				
				ciudadano = Aplicacion.getBloqueados().get(i);
				
				if(Aplicacion.getBloqueados().contains(ciudadano)) {
					JOptionPane.showMessageDialog(null, "Este usuario ya ha sido bloquedado.", "Error", JOptionPane.ERROR_MESSAGE);
					
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
							
		}
		
		
		tam = Aplicacion.getUsuariosAceptados().size();
		
		for(i = 0; i < tam; i++) {
			
			ciudadano = Aplicacion.getUsuariosAceptados().get(i);
			
			if(Aplicacion.getBloqueados().contains(ciudadano)) {
								
			
			}
			
			flag = 1;
		}

			
		
		if (flag == 0) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar un usuario ya aceptado en la aplicacion.", "Error", JOptionPane.ERROR_MESSAGE);
			
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
		
		Administrador administrador = new Administrador("a", "Auxiliar", null);
		
		
		administrador.bloquearUsuario(ciudadano, AUvista.getMotivo());
		
		JOptionPane.showMessageDialog(null, "Usuario Bloqueado"); 
				
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

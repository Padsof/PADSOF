package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ads.PADSOF.*;
import gui.mainform.*;

public class DesbloquearUsuario implements ActionListener{
	
	private AdministradorUsuarioFrame frameAU;
	
	private FormPanelAdministradorUsuario AUvista;
	
	Ciudadano ciudadano;
	Ciudadano aux;
	
	public DesbloquearUsuario(AdministradorUsuarioFrame au) { 
		
		this.frameAU = au;
		
		this.AUvista = au.getAdministradorUsuario();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {	
		
		int tam = Aplicacion.getBloqueados().size();
		int i;
		int flag = 0;
						
		for(i = 0; i < tam; i++) {
			//System.out.println(AUvista.getNombre());
			if(AUvista.getNombre().equals(Aplicacion.getBloqueados().get(i).getNombre())) {
				ciudadano = Aplicacion.getBloqueados().get(i);
				
				flag = 1;
			}
		}
		
		if (flag == 0) {
			JOptionPane.showMessageDialog(null, "Debes seleccionar un usuario ya aceptado en la aplicacion que haya sido bloqueado.", "Error", JOptionPane.ERROR_MESSAGE);
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
		
		Administrador administrador = new Administrador("Auxiliar", "Auxiliar", null);

		
		
		administrador.desbloquearUsuario(ciudadano);
		
		JOptionPane.showMessageDialog(null, "Usuario Desbloqueado"); 
				
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

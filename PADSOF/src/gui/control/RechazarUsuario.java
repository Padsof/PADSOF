package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ads.PADSOF.Administrador;
import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import gui.mainform.*;

public class RechazarUsuario implements ActionListener{
	
	private AdministradorAceptarFrame frameAA;
	private AdministradorUsuarioFrame frameAU;
	private PerfilAdministradorFrame framePA;
	
	private FormPanelAdministradorAceptar AAvista;
	private FormPanelAdministradorUsuario AUvista;
	private FormPanelPerfilAdministrador PAvista;
	
	Administrador administrador;
	Ciudadano ciudadano;
	Ciudadano aux;
	
	public RechazarUsuario(AdministradorUsuarioFrame au ) { 
		
		this.frameAU = au;
		
		this.AUvista = au.getAdministradorUsuario();
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		int tam = Aplicacion.getUsuariosPorAceptar().size();
		int i;
		int flag = 0;
				
		for(i = 0; i < tam; i++) {
			
			/*if(AUvista.getNombre().equals(Aplicacion.getBloqueados().get(i).getNombre())) {
				JOptionPane.showMessageDialog(null, "No puedes rechazar a un usuario aceptado en la aplicacion.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}*/
			
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
		
		ciudadano.rechazarUsuario(ciudadano);
		
		JOptionPane.showMessageDialog(null, "Usuario Rechazado "); 
		
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

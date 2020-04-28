package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import gui.mainform.*;

public class AdministradorUsuario implements ActionListener{
	
	private AdministradorAceptarFrame frameAA;
	
	private FormPanelAdministradorAceptar aaVista;
		
	public AdministradorUsuario(AdministradorAceptarFrame frameaa) { 

		 
		 this.frameAA = frameaa;
		 this.aaVista = frameaa.getAceptarUsuarios();
		 
	 }
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String nombre = null;
		String DNI = null;
		String contraseña = null;
		
		Ciudadano ciudadano = null;
		
		int tam;
		int i;
		
		
		if(aaVista.getNombre() == null && aaVista.getNombreAceptado() == null && aaVista.getNombreBloqueado() == null) {
			 JOptionPane.showMessageDialog(null, "Debes elegir un usuario.", "Error", JOptionPane.ERROR_MESSAGE);
			 return;
		}
		else if(aaVista.getNombre() == null && aaVista.getNombreBloqueado() == null) {
			nombre = aaVista.getNombreAceptado();
			tam = Aplicacion.getUsuariosAceptados().size();
			for (i = 0; i < tam; i++) {
				
				if(Aplicacion.getUsuariosAceptados().get(i).getNombre().equals(nombre)) {
					DNI = Aplicacion.getUsuariosAceptados().get(i).getDNI();
					ciudadano = Aplicacion.getUsuariosAceptados().get(i);
				}
			}
		
		}
		else if(aaVista.getNombre() == null && aaVista.getNombreAceptado() == null) {
			nombre = aaVista.getNombreBloqueado();
			tam = Aplicacion.getBloqueados().size();
			for (i = 0; i < tam; i++) {
				
				if(Aplicacion.getBloqueados().get(i).getNombre().equals(nombre)) {
					DNI = Aplicacion.getBloqueados().get(i).getDNI();
					ciudadano = Aplicacion.getBloqueados().get(i);
				}
			}
		}
		
		else if(aaVista.getNombreAceptado() == null && aaVista.getNombreBloqueado() == null){
			nombre = aaVista.getNombre();
			tam = Aplicacion.getUsuariosPorAceptar().size();
			for (i = 0; i < tam; i++) {
				
				if(Aplicacion.getUsuariosPorAceptar().get(i).getNombre().equals(nombre)) {
					DNI = Aplicacion.getUsuariosPorAceptar().get(i).getDNI();
					ciudadano = Aplicacion.getUsuariosPorAceptar().get(i);
				}
			}
		}
		
		AdministradorUsuarioFrame frameAU = new AdministradorUsuarioFrame(ciudadano);
		FormPanelAdministradorUsuario auVista = new FormPanelAdministradorUsuario(ciudadano);
		
		ControladorAceptarUsuario controladorAus = new ControladorAceptarUsuario(frameAU);
		ControladorRechazarUsuario controladorRU = new ControladorRechazarUsuario(frameAU);
		ControladorBloquearUsuario controladorBU = new ControladorBloquearUsuario(frameAU);
		ControladorDesbloquearUsuario controladorDBU = new ControladorDesbloquearUsuario(frameAU);
		
		
		frameAU.setControladorAceptarUsuario(controladorAus);
		frameAU.setControladorRechazarUsuario(controladorRU);
		frameAU.setControladorBloquearUsuario(controladorBU);
		frameAU.setControladorDesbloquearUsuario(controladorDBU);
				
		 frameAA.setVisible(false);
		 aaVista.setVisible(false);
		 frameAU.setVisible(true);
		 auVista.setVisible(true);

		
	}
	
	

}

package gui.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ads.PADSOF.Aplicacion;
import gui.mainform.*;

public class AceptarAdministrador implements ActionListener{
	
	private PerfilAdministradorFrame framePA;
	
	private FormPanelPerfilAdministrador PAvista;
	
	public AceptarAdministrador(PerfilAdministradorFrame pa) { 
		
		this.framePA = pa;
		
		this.PAvista = pa.getPerfilAdministrador();
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		AdministradorAceptarFrame frameAA = new AdministradorAceptarFrame();
		FormPanelAdministradorAceptar AAvista = new FormPanelAdministradorAceptar(Aplicacion.getUsuariosPorAceptar(), Aplicacion.getProyectosPorAceptar(), Aplicacion.getUsuariosAceptados(), Aplicacion.getBloqueados());
	
		ControladorAdministradorUsuario controladorAU = new ControladorAdministradorUsuario(frameAA);
		
		frameAA.setControladorAdministradorUsuario(controladorAU);

		
		frameAA.setVisible(true);
		framePA.setVisible(false);
		
		AAvista.setVisible(true);;
		PAvista.setVisible(false);

		
	}
}

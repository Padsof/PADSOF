package gui.control;

import gui.mainform.AdministradorAceptarFrame;
import gui.mainform.AdministradorUsuarioFrame;

public class ControladorDesbloquearUsuario {
			
		private DesbloquearUsuario botonDBU;
		
		public ControladorDesbloquearUsuario(AdministradorUsuarioFrame au) {
			
			this.botonDBU = new DesbloquearUsuario(au);
		}

		public DesbloquearUsuario getBotonDBU() {
			return botonDBU;
		}
		
		

}

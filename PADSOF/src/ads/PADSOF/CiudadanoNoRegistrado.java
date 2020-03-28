package ads.PADSOF;

import java.util.ArrayList;
import java.util.List;

/**

 * Esta clase modela los usuarios de tipo Ciudadano.

 *

 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es

 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es

 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es

 *

*/

public class CiudadanoNoRegistrado extends Usuario {
	
	/**

     * Constructor de la clase Ciudadano no Registrado.

     * 

     * @param name El nombre con el que el usuario se ha registrado
     * 
     * @param password La contrase�a con la que el usuario se ha registrado

     * @param dni El DNI del usuario 

     */
	
	public CiudadanoNoRegistrado(String name, String password, String dni) {
		super(name, password, dni);
		
		Aplicacion.getCNR().add(this);

	}
	
	/**

     * Funcion que permite a un usuario registrarse

     * @param name El nombre con el que el usuario se ha registrado
     * 
     * @param password La contrase�a con la que el usuario se ha registrado

     * @param dni El DNI del usuario 

     */
	
	public void Registrarse(String name, String password, String dni) {
		
		
		if (Aplicacion.getAdministradorCreado() == 1 && dni ==  null) {
			System.out.println("Ya existe un Administrador en la aplicacion"); //Ha intentado registrarse como Administrador pero ya existe uno
			return;
		}
		else if(Aplicacion.getAdministradorCreado() == 1) {
			
			if (dni.length() != 9) {
				System.out.println("DNI de 9 caracteres"); //Ha intentado registrarse como Administrador pero ya existe uno
				return;
			}
			
			int j = Aplicacion.getUsuariosAceptados().size();
			int m = Aplicacion.getUsuariosPorAceptar().size();
			int i;
			
			if (Aplicacion.getUsuariosAceptados().size() > 0 || Aplicacion.getUsuariosPorAceptar().size() > 0) {

				for (i = 0; i < j; i++) {
					
					if (name == Aplicacion.getUsuariosAceptados().get(i).getNombre()) {
						System.out.println("Ya existe un usuario registrado con ese nombre");
						return;
					} 
					else if(dni == Aplicacion.getUsuariosAceptados().get(i).getDNI()){
						System.out.println("Ya existe un usuario registrado con ese DNI");
						return;
					}
				}
				
				for (i = 0; i < m; i++) {
					
					if(name == Aplicacion.getUsuariosPorAceptar().get(i).getNombre()){
						System.out.println("Ya existe un usuario registrado con ese nombre");
					return;
					}
					else if(dni == Aplicacion.getUsuariosPorAceptar().get(i).getDNI()) {
						System.out.println("Ya existe un usuario registrado con ese nombre");
						return;
					}
				}
				
				
			}
			
			new Ciudadano(name, password, dni);

		}
		else if (dni == null){
			new Administrador (name, password, null);
			System.out.println("Te has registrado como Administrador");
		}
		else {
			System.out.println("No has conseguido registrarte");
			return;
		}
		
		Aplicacion.getCNR().remove(this);

	}

}

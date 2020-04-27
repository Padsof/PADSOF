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
     * @param password La contraseña con la que el usuario se ha registrado

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
     * @param password La contraseña con la que el usuario se ha registrado

     * @param dni El DNI del usuario 

     */
	
	public boolean Registrarse(String name, String password, String dni) {
				
		if (Aplicacion.getAdministradorCreado() == 1 && dni ==  null) {
			System.out.println("Ya existe un Administrador en la aplicacion"); //Ha intentado registrarse como Administrador pero ya existe uno
			System.out.println("No has conseguido registrarte"); 
			return false;
		}
		
		else if (password == null) {
			System.out.println("La contraseña debe tener como minimo 5 caracteres"); 
			System.out.println("No has conseguido registrarte"); 
			return false;
		}
		
		else if(name == null) {
			System.out.println("El nombre de usuario debe tener como minimo 4 caracteres"); 
			System.out.println("No has conseguido registrarte"); 
			return false;
		}
		
		else if (dni == null){
			new Administrador (name, password, null);
			System.out.println("Te has registrado como Administrador");
			return true;
		}
		else {
			if (dni.length() != 9) {
				System.out.println("DNI de 9 caracteres"); 
				System.out.println("No has conseguido registrarte"); 
				return false;
			}
			
			int j = Aplicacion.getUsuariosAceptados().size();
			int m = Aplicacion.getUsuariosPorAceptar().size();
			int i;
			
			if (Aplicacion.getUsuariosAceptados().size() > 0 || Aplicacion.getUsuariosPorAceptar().size() > 0) {

				for (i = 0; i < j; i++) {
					
					if (name.equals(Aplicacion.getUsuariosAceptados().get(i).getNombre())) {
						System.out.println("Ya existe un usuario registrado con ese nombre");
						System.out.println("No has conseguido registrarte"); 
						return false;
					} 
					else if(dni.equals(Aplicacion.getUsuariosAceptados().get(i).getDNI())){
						System.out.println("Ya existe un usuario registrado con ese DNI");
						System.out.println("No has conseguido registrarte"); 
						return false;
					}
				}
				
				for (i = 0; i < m; i++) {
					
					if(name.equals(Aplicacion.getUsuariosPorAceptar().get(i).getNombre())){
						System.out.println("Ya existe un usuario registrado con ese nombre");
						System.out.println("No has conseguido registrarte"); 
						return false;
					}
					else if(dni.equals(Aplicacion.getUsuariosPorAceptar().get(i).getDNI())) {
						System.out.println("Ya existe un usuario registrado con ese nombre");
						System.out.println("No has conseguido registrarte"); 
						return false;
					}
				}
				
				
			}
			
			new Ciudadano(name, password, dni);

		}
		
		Aplicacion.getCNR().remove(this);
		return true;

	}

}

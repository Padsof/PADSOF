package ads.PADSOF;

import java.util.ArrayList;
import java.util.List;

/**

 * Esta clase modela los usuarios.

 *

 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es

 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es

 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es

 *

*/

public abstract class Usuario {

	/**

	 * El nombre del usuario

	 */
	private String nombre;
	
	/**

	 * Un entero que sirve como variable auxiliar para controlar 
	 * que exista un usuario de tipo administrador en la aplicacion

	 */
	private int creado;
	
	/**

	 * La contraseña con la que el usuario se ha registrado

	 */
	private String contrasenia;
	
	/**

	 * Un atributo auxiliar de tipo Ciudadano
	 * Un usuario puede ser un ciudadano

	 */
	private Ciudadano persona;
	
	/**

	 * Un atributo auxiliar de tipo Ciudadano
	 * Un usuario puede ser un administrador

	 */
	private Administrador administrador;
	
	/**

	 * Lista en la que almacenamos las notificaciones de un usuario

	 */
	private static List<Notificacion> Buzon = new ArrayList<>();
	
	/**

	 * Una lista auxiliar en la que almacenamos los usuarios por aceptar en la aplicación

	 */
	private static List<Ciudadano> poraceptar = new ArrayList<>();

	/**

     * Constructor de la clase Usuario.

     * 

     * @param nombre El nombre con el que el usuario se ha registrado
     * 
     * @param password La contraseña con la que el usuario se ha registrado

     * @param DNI El DNI del usuario 

     */

	  public Usuario (String name, String password, String DNI) {
		  nombre = name;
		  contrasenia = password;
		  creado = Administrador.getCreado(); //Comprobamos si el administrador está ya creado o no
		  if (DNI == null && creado != 1) { //El administrador no necesita DNI para registrarse/iniciar sesion
			  administrador = new Administrador(name, password, DNI);//Si el argumento DNI es null suponemos que el usuario es de tipo administrador
			                                                         // Y lo creamos en el caso de que no exista.
		  }
		  else {//El usuario creado es de tipo ciudadano
			persona = new Ciudadano(name, password, DNI); //Creamos el ciudadano
			poraceptar = Aplicacion.getUsuariosPorAceptar();
			poraceptar.add(persona); //Cuando se crea un usuario debe aniadirse a un array de usuarios por aceptar en la aplicacion
			Aplicacion.setUsuariosPorAceptar(poraceptar);

		  }

	  }

	  
	  /**

	     * Este metodo devuelve el nombre del Usuario

	     * @return el nombre del usuario

	     */
	public String getNombre() {
		return nombre;
	}
	
	/**

	 * Este metodo modifica el valor del atributo nombre en la clase usuario

	 * @param nombre Nombre del usuario

	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	 /**

     * Este metodo devuelve la contraseña del Usuario

     * @return la contraseña del usuario

     */
	public String getcontrasenia() {
		return contrasenia;
	}
	
	/**

	 * Este metodo modifica el valor del atributo contrasenia en la clase usuario

	 * @param contrasenia Contrasenia del usuario

	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}

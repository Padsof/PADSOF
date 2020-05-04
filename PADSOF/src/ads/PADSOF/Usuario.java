package ads.PADSOF;

import java.io.Serializable;
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

public abstract class Usuario implements Serializable{

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

	 * La contrase�a con la que el usuario se ha registrado

	 */
	private String contrasenia;
	
	/**

	 * El DNI con el que el usuario se ha registrado

	 */
	private String DNI;
	
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

	 * Una lista auxiliar en la que almacenamos los usuarios por aceptar en la aplicaci�n

	 */
	private static List<Ciudadano> poraceptar = new ArrayList<>();

	/**

     * Constructor de la clase Usuario.

     * 

     * @param nombre El nombre con el que el usuario se ha registrado
     * 
     * @param password La contrase�a con la que el usuario se ha registrado

     * @param DNI El DNI del usuario 

     */

	  public Usuario (String name, String password, String dni) {
		  nombre = name;
		  contrasenia = password;
		  DNI = dni;
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

     * Este metodo devuelve la contrase�a del Usuario

     * @return la contrase�a del usuario

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

	/**

	 * Este metodo devuelve el DNI del usuario

	 * @return DNI DNI del usuario

	 */

	public String getDNI() {
		return DNI;
	}

	/**

	 * Este metodo modifica el DNI del usuario

	 * @param dNI Contrasenia del usuario

	 */

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	
	
}

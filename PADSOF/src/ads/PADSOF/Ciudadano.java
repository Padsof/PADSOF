package ads.PADSOF;

import java.util.*;


/**

 * Esta clase modela los usuarios de tipo Ciudadano.

 *

 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es

 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es

 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es

 *

*/

public class Ciudadano extends Usuario {
	
	/**

	 * El DNI del usuario de tipo ciudadano

	 */
	private String DNI;
	
	/**

	 * Un atributo de tipo boolean que indica si el usuario ha sido bloqueado o no por el administrador
	 
	 */
    private boolean bloqueado = false;
    
    /**

	 * Un atributo de tipo boolean que indica si el usuario es representante de algun proyecto

	 */
    private boolean representanteProyecto;
    
    /**

	 * Un atributo auxiliar de tipo Colectivo

	 */
    private Colectivo asociacion;

    /**

	 * Lista en la que almacenamos los colectivos de los que el ciudadano es administrador

	 */
    private List<Colectivo> colectivos = new ArrayList<>(); //Array con los colectivos de los que es representante

    /**

	 * Una lista auxiliar en la que almacenamos los usuarios aceptados en la aplicación

	 */
	 private static List<Ciudadano> aceptados = new ArrayList<>();
	 
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

      * @param dni El DNI del usuario 

      */
	 public Ciudadano (String nombre, String password, String dni) {

		  super(nombre, password, dni);
		  bloqueado = false;
		  representanteProyecto = false;
		  
		  poraceptar = Aplicacion.getUsuariosPorAceptar();

		  poraceptar.add(this); //Cuando se crea un usuario debe aniadirse a un array de usuarios por aceptar en la aplicacion

		  Aplicacion.setUsuariosPorAceptar(poraceptar);
	 }

	 /**

      * Este método crea un colectivo.

      * 

      * @param nombre El nombre del colectivo
      * 

      */
	public void crearColectivo(String name) {

		if (this.bloqueado == true) { //Si el ciudadano está bloqueado no puede crear un colectivo.
			return;
		}

		asociacion = new Colectivo (name, this); //Creamos un colectivo

		this.getColectivos().add(asociacion); //Añadimos el colectivo al array de colectivos de los cuales el usuario es representante

		this.setRepresentanteProyecto(true);
		
		Aplicacion.getColectivos().add(asociacion); //Añadimos el colectivo al array de colectivos creados en la aplicacion
		
		return;
	}


	 /**

     * Este metodo devuelve el DNI del Usuario de tipo ciudadano

     * @return DNI el dni del usuario

     */
	public String getDNI() {

		return DNI;

	}

	/**

	 * Este metodo modifica el valor del atributo DNI en la clase ciudadano

	 * @param dni DNI del usuario

	 */
	public void setDNI(String dni) {

		DNI = dni;

	}

	 /**

     * Este metodo devuelve el valor (true/false) que indica si el usuario está bloqueado o no en la aplicacion

     * @return true/false

     */
	public boolean isBloqueado() {

		return bloqueado;

	}

	/**

	 * Este metodo modifica el valor del atributo bloqueado en la clase ciudadano

	 * @param bloqueado 

	 */
	public void setBloqueado(boolean bool) {

		this.bloqueado = bool;

	}

	/**

     * Este metodo devuelve el valor (true/false) que indica si el usuario es representante de algun proyecto

     * @return true/false

     */
	public boolean isRepresentanteProyecto() {

		return representanteProyecto;

	}

	/**

	 * Este metodo modifica el valor del atributo representanteProyecto en la clase ciudadano

	 * @param representanteProyecto

	 */
	public void setRepresentanteProyecto(boolean representanteProyecto) {

		this.representanteProyecto = representanteProyecto;

	}

	/**

     * Funcion mediante la cual se aceptan los usuarios en la aplicacion.

     * 

     * @param C objeto de clase Ciudadano 
     * 
     * @return true en el caso de que no ocurra ningun error


     */
	public void aceptarUsuario(Usuario C) {
		
		System.out.println( Aplicacion.getUsuariosAceptados().size());
		System.out.println( Aplicacion.getUsuariosPorAceptar().size());

		Aplicacion.getUsuariosAceptados().add((Ciudadano) C); //Añadimos el ciudadano a la lista de usuarios aceptados
		
		Aplicacion.getUsuariosPorAceptar().remove(C); //Borramos al ciudadano de la lista de usuarios por aceptar
		
		
	}

	/**

     * Funcion mediante la cual se rechazan los usuarios en la aplicacion.

     * 

     * @param C objeto de clase Ciudadano 
     * 
     * @return true en el caso de que no ocurra ningun error


     */
	public void rechazarUsuario(Usuario C) {
		
		System.out.println( Aplicacion.getUsuariosPorAceptar().size());

		Aplicacion.getUsuariosPorAceptar().remove((Ciudadano)C); //Eliminamos al ciudadano de la lista de usuarios por aceptar
		//C = null; //Eliminamos la clase creada.
		
	}
	
	/**

     * Funcion mediante la cual se bloquea a un usuario de la aplicacion.

     * 

     * 
     * @return true en el caso de que no ocurra ningun error


     */
	public void bloquearUsuario() {

		this.bloqueado = true;
		
	}

	/**

     * Funcion mediante la cual se desbloquea a un usuario de la aplicacion.

     * 

     * 
     * @return true en el caso de que no ocurra ningun error


     */
	public void desbloquearUsuario() {

		this.bloqueado = false;
		
	}


	public void eliminarNotificacion() {


	}


	public void leerNotificacion() {


	}

	public List<Colectivo> getColectivos() {
		return colectivos;
	}

	public void setColectivos(List<Colectivo> colectivos) {
		this.colectivos = colectivos;
	}


	
	



}

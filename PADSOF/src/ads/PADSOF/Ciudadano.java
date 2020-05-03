package ads.PADSOF;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

import fechasimulada.FechaSimulada;


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

	 * Lista en la que almacenamos los proyectos creados por el usuario

	 */
    private List<Proyecto> proyectos = new ArrayList<>();
     
     /**

	  * Una lista en la que almacenamos los colectivos de los cuales el usuario es miembro

	  */
     
     private List<Colectivo> miembro = new ArrayList<>();
     
     /**

	  * Una lista en la que almacenamos los proyectos a los que se ha suscrito el usuario

	  */
     
     private  List<Proyecto> suscrito = new ArrayList<>();
     
     /**

 	 * Lista en la que almacenamos los proyectos a los que el usuario ha votado

 	 */
     
     private List<Proyecto> votado = new ArrayList<>();
     
     /**

 	 * Lista en la que almacenamos los proyectos a los que el usuario ha votado de forma individual

 	 */
     
     private List<Proyecto> votoIndividual = new ArrayList<>();
     
     /**

 	 * Lista en la que almacenamos las notificaciones recibidas de la aplicacion

 	 */

     private List<Notificacion> notificaciones = new ArrayList<>();
     
     /**

 	 * Lista en la que almacenamos las notificaciones leidas

 	 */
     
     private List<Notificacion> notificacionesLeidas = new ArrayList<>();

     
     /**

      * Constructor de la clase Ciudadano.

      * 

      * @param nombre El nombre con el que el usuario se ha registrado
      * 
      * @param password La contraseña con la que el usuario se ha registrado

      * @param dni El DNI del usuario 

      */
	 public Ciudadano (String nombre, String password, String dni) {

		  super(nombre, password, dni);
		  DNI = dni;
		  bloqueado = false;
		  representanteProyecto = false;

		  Aplicacion.getUsuariosPorAceptar().add(this);
	 }

	 /**

      * Este método crea un colectivo.

      * 

      * @param nombre El nombre del colectivo
      * 

      */
	public Colectivo crearColectivo(String name) {
		int i;
		int j = Aplicacion.getColectivos().size();
		
		if (this.bloqueado == true) { //Si el ciudadano está bloqueado no puede crear un colectivo.
			System.out.println("ESTAS BLOQUEADO. ACCION NO PERMITIDA");
			return null;
		}
		
		
		if (j > 0) {

			for (i = 0; i < j; i++) {
				
				if (name == Aplicacion.getColectivos().get(i).getNombre()) {
					System.out.println("Ya existe un colectivo con ese nombre");
					return null;
				}

			}
		}

		asociacion = new Colectivo (name, this); //Creamos un colectivo. El constructor se encarga de introducirlo en el array de colectivos de la aplicacion
												 //y en array de colectivos creados por el usuario

		this.setRepresentanteProyecto(true);
				
		return asociacion;
	
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

     */
	public void aceptarUsuario(Ciudadano C) {
		
		Aplicacion.getUsuariosAceptados().add((Ciudadano) C); //Añadimos el ciudadano a la lista de usuarios aceptados
		
		Aplicacion.getUsuariosPorAceptar().remove(C); //Borramos al ciudadano de la lista de usuarios por aceptar
		
		Aplicacion.generarNotificacionAceptado(C, "Te consideramos apto para formar parte de nuestra comunidad ", "Aceptado");
		
		
	}

	/**

     * Funcion mediante la cual se rechazan los usuarios en la aplicacion.

     * @param C objeto de clase Ciudadano 
     * 

     */
	public void rechazarUsuario(Usuario C) {
		
		Aplicacion.getUsuariosPorAceptar().remove((Ciudadano)C); //Eliminamos al ciudadano de la lista de usuarios por aceptar

	}
	
	/**

     * Funcion mediante la cual eliminamos notificaciones del array de notificaciones del usuario.

     * @param n objeto de clase Notificacion 
     * 

     */


	public boolean eliminarNotificacion(Notificacion n) {

		int tamanio = this.getNotificacionesLeidas().size();
		int i;
		
		for (i = 0; i < tamanio; i++) {
			
			if(this.getNotificacionesLeidas().get(i).equals(n)) {
				
				this.getNotificacionesLeidas().remove(n);
				
				return true;

			}
		}
		
		System.out.println("adios");
		
		return false;

	}
	
	/**

     * Funcion mediante la cual leemos notificaciones del array de notificaciones del usuario y las añadimos a un array donde se almacenan las notificaciones leidas.

     * @param n objeto de clase Notificacion 
     * 

     */


	public boolean leerNotificacion(Notificacion n) {

		int tamanio = this.getNotificaciones().size();
		int i;
		
		for (i = 0; i < tamanio; i++) {
			
			if(this.getNotificaciones().get(i).equals(n)) {
				
				this.getNotificacionesLeidas().add(n);
				this.getNotificaciones().remove(n);
				
				return true;

			}
		}
		
		return false;

	}
		
	/**

     * Este metodo devuelve la Lista de colectivos de los que el usuario es administrador

     * @return colectivos Lista de colectivos de los que el usuario es administrador

     */


	public List<Colectivo> getColectivos() {
		return colectivos;
	}
	
	/**

     * Este metodo modifica la Lista de colectivos de los que el usuario es administrador

     * @param colectivos Lista de colectivos de los que el usuario es administrador

     */

	public void setColectivos(ArrayList<Colectivo> colectivos) {
		this.colectivos = colectivos;
	}
	
	public String toString() {
		return "Nombre: " +this.getNombre()+ "  Contraseña: " +this.getcontrasenia()+" DNI: "+this.getDNI()+"";
	}
	
	/**

     * Este metodo crea un proyecto

     * @param titulo titulo del proyecto
     * @param descripcion descripcion del proyecto
     * @param presupuesto presupuesto del proyecto
     * @param estado estado del proyecto
     * @param tipo tipo del proyecto (social o innfraestructuras)
     * @param claseSocial clase social del proyecto
     * @param nacional indica si el proyecto es de ambito nacional o interncional
     * @param distrito lista de distritos en los que se va aplicar el proyecto

     */
	
	public void proponerProyecto(String titulo, String descripcion, double presupuesto, EstadoProyecto estado, String tipo, String claseSocial, boolean nacional, List<String> distrito) {
		
		if (this.bloqueado == true) { //Si el ciudadano está bloqueado no puede crear un colectivo.
			System.out.println("ESTAS BLOQUEADO. ACCION NO PERMITIDA");
			return;
		}
		
		if(titulo.length() > 25) {
			System.out.println("El titutlo es demasiado grande");
			return;
		}
		
		if (descripcion.length() > 500) {
			System.out.println("La descripcion es demasiado grande");
			return;
		}
		
		if (claseSocial.length() > 50) {
			System.out.println("La clase social es demasiado grande");
			return;
		}
		Proyecto proyecto;
		
		FechaSimulada.restablecerHoyReal(); //MODIFICAMOS LA FECHA ANTES DE INTRODUCIRLA
		
		if (tipo == "Social") {
			
			proyecto = new PoySocial(titulo, descripcion, this, presupuesto, FechaSimulada.getHoy(), estado, claseSocial, nacional );			
			
		}
		else if (tipo == "Infraestructura") {
			
			proyecto = new ProyInfraestructura(titulo, descripcion, this, presupuesto, FechaSimulada.getHoy(), estado, null, distrito);
			
		}
		else {
			System.out.println("No se ha creado ningun proyecto");
		}
	}

	/**

     * Este metodo devuelve la Lista de proyectos creados por el usuario

     * @return proyectos Lista de proyectos creados por el usuario

     */
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	/**

     * Este metodo modifica la Lista de proyectos creados por el usuario

     * @param proyectos Lista de proyectos creados por el usuario

     */

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	/**
     * Este metodo devuelve la Lista de proyectos apoyados por el Usuario

     * @return votado Lista de proyectos apoyados por el Usuario

     */

	public List<Proyecto> getVotado() {
		return votado;
	}
	
	/**

     * Este metodo modifica la Lista de proyectos apoyados por el Usuario

     * @param votado Lista de proyectos apoyados por el Usuario

     */

	public void setVotado(List<Proyecto> votado) {
		this.votado = votado;
	}
	
	/**
     * Este metodo devuelve la Lista de proyectos apoyados por el Usuario de forma individual

     * @return votado Lista de proyectos apoyados por el Usuario de forma individual

     */

	public List<Proyecto> getVotoIndividual() {
		return votoIndividual;
	}
	
	/**

     * Este metodo modifica la Lista de proyectos apoyados por el Usuario

     * @param votoIndividual Lista de proyectos apoyados por el Usuario

     */

	public void setVotoIndividual(List<Proyecto> votoIndividual) {
		this.votoIndividual = votoIndividual;
	}
	
	/**
     * Este metodo devuelve la Lista de proyectos a los que el Usuario se ha suscrito

     * @return suscrito Lista de proyectos a los que el Usuario se ha suscrito

     */

	public List<Proyecto> getSuscrito() {
		return suscrito;
	}
	
	/**

     * Este metodo modifica la Lista de proyectos a los que el Usuario se ha suscrito

     * @param suscrito Lista de proyectos a los que el Usuario se ha suscrito

     */

	public void setSuscrito(List<Proyecto> suscrito) {
		this.suscrito = suscrito;
	}
	
	/**

     * Este metodo genera un informe de popularidad en el que se informa del número de votos del proyecto

     * @param suscrito Lista de proyectos a los que el Usuario se ha suscrito

     */
	
	public boolean informePopularidad(Proyecto informe) {
		List<Proyecto> votadosI = this.votoIndividual;
		
		for (Proyecto aux: votadosI) {
			if (aux == informe) { 
				System.out.println("INFORME DE POPULARIDAD: El proyecto: "+informe.getTitulo()+" ha recibido "+informe.getnVotos()+" votos");
				return true;
			}		
		}
		return false;
	}
	
	/**

     * Este metodo devuelve una lista de todos los colectivos de los cuales el usuario es miembro

     * @return miembro lista de todos los colectivos de los cuales el usuario es miembro

     */
	
	public List<Colectivo> getMiembro() {
		return miembro;
	}

	/**

     * Este metodo modifica la lista de todos los colectivos de los cuales el usuario es miembro

     * @param miembro lista de todos los colectivos de los cuales el usuario es miembro

     */
	
	public void setMiembro(List<Colectivo> miembro) {
		this.miembro = miembro;
	}

	public boolean informeAfinidad(Colectivo uno, Colectivo dos) {
		
		List<Colectivo> colectivos = this.getMiembro();
		List<Proyecto> proyectosA = uno.getProyectos();
		List<Proyecto> proyectosB = dos.getProyectos();
		List<Proyecto> votadosA = uno.getVotoColectivo();
		List<Proyecto> votadosB = dos.getVotoColectivo();
		int i = 0;
		int m = 0;
		int A = 0, B = 0;
		int pA = uno.getProyectos().size();
		int pB = dos.getProyectos().size();
		double total = pA + pB;
		double afinidad;
		double porcentaje;


		if (this.getMiembro().size() < 2) {
			System.out.println("El usuario debe de pertener al menos a DOS colectivos");
			return false;
		}
		
		for (Colectivo aux: colectivos) {
			if (aux == uno) {
				i = 1;
			}
			
			if (aux == dos) {
				m = 1;
			}
		}
		
		if (i == 0 || m == 0) {
			System.out.println("El usuario debe de pertenecer a los DOS colectivos");
			return false;
		}
		
		for(Proyecto aux: proyectosA) {
			
			for(Proyecto aux2: votadosB) {
				
				if (aux == aux2) {
					A++;
				}
			}
		}
		
		for(Proyecto aux: proyectosB) {
			
			for(Proyecto aux2: votadosA) {
				
				if (aux == aux2) {
					B++;
				}
			}
		}
		
		afinidad = (((A+B)/total));
		porcentaje = ((double)afinidad*100.0);
				
		System.out.println("Los colectivos "+uno.getNombre()+ " y "+dos.getNombre()+" tienen una afinidad del: "+porcentaje+ " %");
		
		return true;
	}
	
	/**

     * Este metodo permite al usuario consultar a que colectivos pertenece

     */
	
	public void soyMiembro() {
		
		System.out.println(this.getMiembro());

	}
	
	/**

     * Este metodo devuelve la lista de todas las notificaciones pendientes de leer por el usuario

     * @return notificaciones lista de todas las notificaciones pendientes de leer por el usuario

     */

	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}
	
	/**

     * Este metodo modifica la lista de todas las notificaciones pendientes de leer por el usuario

     * @param notificaciones lista de todas las notificaciones pendientes de leer por el usuario

     */

	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}
	
	/**

     * Este metodo devuelve la lista de todas las notificaciones leidas por el usuario

     * @return notificacionesLeidas lista de todas las notificaciones leidas por el usuario

     */

	public List<Notificacion> getNotificacionesLeidas() {
		return notificacionesLeidas;
	}
	
	/**

     * Este metodo modifica la lista de todas las notificaciones leidas por el usuario

     * @param notificacionesLeidas lista de todas las notificaciones leidas por el usuario

     */

	public void setNotificacionesLeidas(List<Notificacion> notificacionesLeidas) {
		this.notificacionesLeidas = notificacionesLeidas;
	}
	
	/**

     * Este metodo modifica la lista de colectivos creados por el usuario (elimina el colectivo indicado)

     * @param colectivo Colectivo que queremos eliminar
     
     */
	
	public void EliminarColectivo(Colectivo colectivo) {
		
		this.getColectivos().remove(colectivo);
		Aplicacion.getColectivos().remove(colectivo);
		
		int tam = colectivo.getNumMiembros();
		int i;
		
		for(i = 0; i < tam; i++) {
			colectivo.getMiembros().get(i).getMiembro().remove(colectivo);
		}
		
		return;	
	}
	
	
	
	
	
}

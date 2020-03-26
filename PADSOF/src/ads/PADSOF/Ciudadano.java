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

	 * Una lista auxiliar en la que almacenamos los usuarios aceptados en la aplicación

	 */
	 private static List<Ciudadano> aceptados = new ArrayList<>();
	 
	 /**

	  * Una lista auxiliar en la que almacenamos los usuarios por aceptar en la aplicación

	  */
     private  List<Ciudadano> poraceptar = new ArrayList<>();
     
     private List<Colectivo> miembro = new ArrayList<>();
     
     private  List<Proyecto> suscrito = new ArrayList<>();
     
     private List<Proyecto> votado = new ArrayList<>();
     
     private List<Proyecto> votoIndividual = new ArrayList<>();

     private List<Notificacion> notificaciones = new ArrayList<>();
     
     private List<Notificacion> notificacionesLeidas = new ArrayList<>();

     
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
		  DNI = dni;
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

		asociacion = new Colectivo (name, this); //Creamos un colectivo

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
     * @return true en el caso de que no ocurra ningun error


     */
	public void aceptarUsuario(Ciudadano C) {
		
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
		
		Aplicacion.getUsuariosPorAceptar().remove((Ciudadano)C); //Eliminamos al ciudadano de la lista de usuarios por aceptar
		//C = null; //Eliminamos la clase creada.
		
	}


	public void eliminarNotificacion() {


	}


	public void leerNotificacion() {


	}

	public List<Colectivo> getColectivos() {
		return colectivos;
	}

	public void setColectivos(ArrayList<Colectivo> colectivos) {
		this.colectivos = colectivos;
	}
	
	public String toString() {
		return "Nombre: " +this.getNombre()+ "  Contraseña: " +this.getcontrasenia()+" DNI: "+this.getDNI()+"";
	}
	
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

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public List<Proyecto> getVotado() {
		return votado;
	}

	public void setVotado(List<Proyecto> votado) {
		this.votado = votado;
	}

	public List<Proyecto> getVotoIndividual() {
		return votoIndividual;
	}

	public void setVotoIndividual(List<Proyecto> votoIndividual) {
		this.votoIndividual = votoIndividual;
	}

	public List<Proyecto> getSuscrito() {
		return suscrito;
	}

	public void setSuscrito(List<Proyecto> suscrito) {
		this.suscrito = suscrito;
	}
	
	public void informePopularidad(Proyecto informe) {
		List<Proyecto> votadosI = this.votoIndividual;
		
		for (Proyecto aux: votadosI) {
			if (aux == informe) { 
				System.out.println("INFORME DE POPULARIDAD: El proyecto: "+informe.getTitulo()+" ha recibido "+informe.getnVotos()+" votos");
				return;
			}		
		}
	}
	
	
	
	public List<Colectivo> getMiembro() {
		return miembro;
	}

	public void setMiembro(List<Colectivo> miembro) {
		this.miembro = miembro;
	}

	public void informeAfinidad(Colectivo uno, Colectivo dos) {
		
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
			return;
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
			return;
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
		
	}
	
	public void soyMiembro() {
		
		System.out.println(this.getMiembro());

	}

	public List<Notificacion> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(List<Notificacion> notificaciones) {
		this.notificaciones = notificaciones;
	}

	public List<Notificacion> getNotificacionesLeidas() {
		return notificacionesLeidas;
	}

	public void setNotificacionesLeidas(List<Notificacion> notificacionesLeidas) {
		this.notificacionesLeidas = notificacionesLeidas;
	}
	
	
	
	



}

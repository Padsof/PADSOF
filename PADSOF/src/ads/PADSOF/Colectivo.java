package ads.PADSOF;



import java.util.*;

import fechasimulada.FechaSimulada;



/**

 * Esta clase modela los colectivos.

 *

 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es

 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es

 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es

 *

*/



public class Colectivo {

	

	/**

	 * El nombre del colectivo

	 */

	private String nombre;

	/**

	 * El numero de miembros del colectivo

	 */

    private int numMiembros;

    /**

     * Un objeto Ciudadano que indicará quién es el creador y representante del colectivo

     */

    private Ciudadano representante;

    /**

     * Un ArrayList que almacenara los ciudadanos que forman parte del Colectivo

     */

    private ArrayList<Ciudadano> miembros;

    /**

     * Un objeto Colectivo que almacenara el padre del colectivo, en caso de tenerlo

     */

    private Colectivo padre;

    /**

     * Un ArrayList que almacenara los colectivos hijos de este colectivo, en caso de tener

     */
    
    private List<Colectivo> hijos = new ArrayList<>();

    /**

     * Un auxiliar boolean para saber si es un colectivo "hijo"

     */
    
    private boolean hijo;
    
    /**

     * Un ArrayList que almacenara los proyectos a los que ha apoyado el colectivo

     */
    
    private List<Proyecto> votoColectivo = new ArrayList<>();
    
    /**

	 * Lista en la que almacenamos los proyectos creados por el colectivo

	 */
    private List<Proyecto> proyectos = new ArrayList<>();
    

	/**

     * Constructor de la clase Colectivo.
     * 

     * @param nombre El nombre del colectivo

     * @param representante Un objeto Ciudadano que correspondera con el representante y creador del colectivo

     */

    

    public Colectivo(String nombre, Ciudadano representante) {

		this.nombre = nombre;

		this.numMiembros = 0;

		this.representante = representante;

		this.miembros = new ArrayList<Ciudadano>();

		this.padre = null;

		this.hijos = new ArrayList<Colectivo>();
		
		this.hijo = false;

		Aplicacion.getColectivos().add(this);
		
		representante.getColectivos().add(this);
		
		
    }

	/**



	 * Este metodo agrega un miembro al ArrayList de ciudadanos correspondiente con los miembros del colectivo



	 * @param ciudadano



	 * @return true si se realiza correctamente o false hay algun error



	 */

	public boolean agregarMiembro(Ciudadano c) {
		String name = c.getNombre();
		int miembros;
		int i, m;
		
		if (this.representante.getNombre() == name) {
			System.out.println("El usuario: "+name+ " es Representante del colectivo "+this.nombre+"");
			return false;
		}
		
		if (this.hijo == true) {
			miembros = this.getPadre().getMiembros().size();
			
			for (i = 0; i < miembros; i++) {
				if (name == this.getPadre().getMiembros().get(i).getNombre()) {
					System.out.println("El usuario: "+name+ " ya es miembro del colectivo padre "+this.padre.nombre+"");
					return false;
				}
			}
			
			this.miembros.add(c);
			c.getMiembro().add(this);
			this.numMiembros++;
			return true;
		}
		
		miembros = this.getMiembros().size();
		
		for (i = 0; i < miembros; i++) {
			if (name == this.getMiembros().get(i).getNombre()) {
				System.out.println("El usuario: "+name+ " ya es miembro del colectivo "+this.nombre+"");
				return false;
			}
		}
		
		int hijos = this.getHijos().size();
		for (i = 0; i < hijos; i++) {
			miembros = this.getHijos().get(i).getMiembros().size();
			for (m = 0; m < miembros; m ++) {
				if (name == this.getHijos().get(i).getMiembros().get(m).getNombre()) {
					System.out.println("El usuario: "+name+ " ya es miembro del colectivo hijo "+this.getHijos().get(i).nombre+"");
					return false;
				}
			}
		}
		this.miembros.add(c);
		c.getMiembro().add(this);
		this.numMiembros++;

		return true;
	}

	/**



	 * Este metodo elimina el mimbro solicitado del ArrayList de ciudadanos correspondiente con los miembros del colectivo



	 * @param ciudadano



	 * @return true si se realiza correctamente o false hay algun error



	 */

	public void quitarMiembro(Ciudadano c) {

		this.getMiembros().remove(c);
		c.getMiembro().remove(this);
		this.numMiembros--;
	}
	
	public String toString() {
		return "Nombre: " +this.nombre+ "";
	}
	

	public void añadirColectivoHijo (Colectivo asociacion) {
		
		if (this.representante == asociacion.getRepresentante() && asociacion.getMiembros().isEmpty() == true && asociacion.getPadre() == null) {
			this.getHijos().add(asociacion);
			asociacion.setPadre(this);
			asociacion.hijo = true;
		}
	}

	

    /**

     * Este metodo devuelve el nombre del Colectivo

     * @return nombre

     */



	public String getNombre() {



		return nombre;



	}



	/**

	 * Este metodo modifica el nombre del Colectivo

	 * @param nombre

	 */



	public void setNombre(String nombre) {



		this.nombre = nombre;



	}







	/**

	 * Este metodo devuelve el numero  de miembros del colectivo

	 * @return numMiembros

	 */



	public int getNumMiembros() {



		return numMiembros;



	}



	/**



	 * Este metodo modifica el numero de miembros del colectivo



	 * @param numMiembros



	 */



	public void setNumMiembros(int numMiembros) {



		this.numMiembros = numMiembros;



	}







	/**



	 * Este metodo devuelve el objeto Ciudadano que es representante de este colectivo



	 * @return representante



	 */



	public Ciudadano getRepresentante() {



		return representante;



	}



	/**



	 * Este metodo modifica el objeto Ciudadano que es representante de este colectivo



	 * @param representante



	 */



	public void setRepresentante(Ciudadano representante) {



		this.representante = representante;



	}







	/**



	 * Este metodo devuelve el ArrayList que almacena todos los objetos de tipo Ciudadano que corresponden con los miembros del colectivo



	 * @return miembros



	 */



	public ArrayList<Ciudadano> getMiembros() {



		return miembros;



	}



	/**



	 * Este metodo modifica el ArrayList que almacena todos los objetos de tipo Ciudadano que corresponden con los miembros del colectivo



	 * @param miembros



	 */



	public void setMiembros(ArrayList<Ciudadano> miembros) {



		this.miembros = miembros;



	}







	/**



	 * Este metodo devuelve el objeto Colectivo que corresponde con el padre del colectivo



	 * @return padre 



	 */



	public Colectivo getPadre() {



		return padre;



	}



	/**



	 * Este metodo modifica el objeto Colectivo que corresponde con el padre del colectivo



	 * @param padre



	 */



	public void setPadre(Colectivo padre) {



		this.padre = padre;



	}







	/**



	 * Este metodo devuelve el ArrayList de objetos de tipo Colectivo que corresponde con la lista de hijo



	 * @return hijos 



	 */



	public ArrayList<Colectivo> getHijos() {



		return (ArrayList<Colectivo>) hijos;



	}







	/**


	 * Este metodo modifica el ArrayList de objetos de tipo Colectivo que corresponde con la lista de hijos del colectivo


	 * @param hijos


	 */



	public void setHijos(ArrayList<Colectivo> hijos) {



		this.hijos = hijos;



	}

	/**



	 * Este metodo crea un proyecto propuesto por un colectivo


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
		
		if(this.representante.isBloqueado() == true) {
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
		
		int votos = this.getNumMiembros();
		int i;
		
		FechaSimulada.restablecerHoyReal(); //MODIFICAMOS LA FECHA ANTES DE INTRODUCIRLA
		
		if (tipo == "Social") {
			
			proyecto = new PoySocial(titulo, descripcion, this, votos, presupuesto, FechaSimulada.getHoy(), estado, claseSocial, nacional );			
			
		}
		else if (tipo == "Infraestructura") {
			
			proyecto = new ProyInfraestructura(titulo, descripcion, votos, this, presupuesto, FechaSimulada.getHoy(), estado, null, distrito);
			
		}
		else {
			System.out.println("No se ha creado ningun proyecto");
		}
		
		
	}
	
	/**

	 * Este metodo devuelve la lista de proyectos a los que ha votado el colectivo

	 * @return votoColectivo

	 */

	public List<Proyecto> getVotoColectivo() {
		return votoColectivo;
	}
	
	/**

	 * Este metodo modifica la lista de proyectos a los que ha votado el colectivo

	 * @param votoColectivo

	 */

	public void setVotoColectivo(List<Proyecto> votoColectivo) {
		this.votoColectivo = votoColectivo;
	}
	
	/**

	 * Este metodo devuelve la lista de proyectos creados por el colectivo

	 * @return proyectos

	 */
	
	
	public List<Proyecto> getProyectos() {
		return proyectos;
	}
	
	/**

	 * Este metodo modifica la lista de proyectos creados por el colectivo

	 * @param proyectos

	 */

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}
	
	/**

	 * Este metodo modifica la lista de proyectos creados por el colectivo

	 * @param proyectos

	 */

	public boolean informePopularidad(Proyecto informe) {
		List<Proyecto> votadosI = this.getVotoColectivo();
		for (Proyecto aux: votadosI) {
			if (aux == informe) { 
				System.out.println("INFORME DE POPULARIDAD: El proyecto: "+informe.getTitulo()+" ha recibido "+informe.getnVotos()+" votos");
				return true;
			}		
		}
		
		return false;
	}
	
	/**

	 * Este metodo devuelve un atributo boolean que indica si el colectivo es hijo de otro

	 * @return hijo

	 */

	public boolean isHijo() {
		return hijo;
	}

	public void setHijo(boolean hijo) {
		this.hijo = hijo;
	}
	
	
	
	
	
    
}

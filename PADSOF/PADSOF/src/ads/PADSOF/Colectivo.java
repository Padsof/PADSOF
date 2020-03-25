package ads.PADSOF;

import java.util.*;

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
    private ArrayList<Colectivo> hijos;
    
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
    }

    /**
     * Este metodo devuelve el nombre del Colectivo
     * @return el nombre del colectivo
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
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
	 * @return
	 */
	public ArrayList<Colectivo> getHijos() {
		return hijos;
	}
	
	/**
	 * Este metodo modifica el ArrayList de objetos de tipo Colectivo que corresponde con la lista de hijos del colectivo
	 * @param hijos
	 */
	public void setHijos(ArrayList<Colectivo> hijos) {
		this.hijos = hijos;
	}
	
	/**
	 * Este metodo agrega un miembro al ArrayList de ciudadanos correspondiente con los miembros del colectivo
	 * @param ciudadano
	 * @return true si se realiza correctamente o false hay algun error
	 */
	public boolean agregarMiembro(Ciudadano ciudadano) {
		return this.miembros.add(ciudadano);
	}
	
	/**
	 * Este metodo elimina el mimbro solicitado del ArrayList de ciudadanos correspondiente con los miembros del colectivo
	 * @param ciudadano
	 * @return true si se realiza correctamente o false hay algun error
	 */
	public boolean quitarMiembro(Ciudadano ciudadano) {
		return this.miembros.remove(ciudadano);
	}
	
	/**
	 * Este metodo crea un informe de afinidad entre dos colectivos
	 * @param colectivo
	 * @return el informe de afinidad creado
	 */
	public InfAfinidad informeAfinidad(Colectivo colectivo) {
		
	}
  
}

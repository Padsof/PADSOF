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
	 * Este metodo
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getNumMiembros() {
		return numMiembros;
	}
	public void setNumMiembros(int numMiembros) {
		this.numMiembros = numMiembros;
	}
	
	public Ciudadano getRepresentante() {
		return representante;
	}
	public void setRepresentante(Ciudadano representante) {
		this.representante = representante;
	}
	
	
	public ArrayList<Ciudadano> getMiembros() {
		return miembros;
	}
	public void setMiembros(ArrayList<Ciudadano> miembros) {
		this.miembros = miembros;
	}
	
	public Colectivo getPadre() {
		return padre;
	}
	public void setPadre(Colectivo padre) {
		this.padre = padre;
	}


	public ArrayList<Colectivo> getHijos() {
		return hijos;
	}
	public void setHijos(ArrayList<Colectivo> hijos) {
		this.hijos = hijos;
	}
	
	public void agregarMiembro(ciudadano c) {
		
	}
	
	public void quitarMiembro(ciudadano c) {
		
	}
	
	public InfAfinidad informeAfinidad(Colectivo c) {
		
	}
  
}

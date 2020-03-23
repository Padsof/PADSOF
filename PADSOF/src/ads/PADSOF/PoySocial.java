package ads.PADSOF;

import java.io.*;
import java.time.LocalDate;


/**
 * Esta clase modela la clase PryInfraestructura
 *
 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es
 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es
 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es
 *
*/

public class PoySocial extends Proyecto{

	/**
	 * Clase social a la que va dirigida
	 */
	private String claseSocial;

	/**
	 * Si es de caracter nacional o internacional
	 */
	private boolean nacional;
	
	/**
	 * Constructor de la clase ProyInfraestuctura
	 * 
	 * @param titulo Titulo del proyecto
	 * @param descripcion Descripcion del proyecto
	 * @param presupuesto Presupuesto inicial
	 * @param presupuestoFinal Presupuesto final
	 * @param nVotos Numeros de votos del proyecto
	 * @param fechaCreacion Fecha de creacion
	 * @param fechaUltimoVoto Fecha del ultimo voto
	 * @param estado Estado en el que se encuentra el proyecto
	 * @param claseSocial clase social a la que va dirigida
	 * @param nacional Si es de caracter nacional
	 */
	public PoySocial(String titulo, String descripcion, double presupuesto, double presupuestoFinal, int nVotos,
			LocalDate fechaCreacion, LocalDate fechaUltimoVoto, EstadoProyecto estado, String claseSocial,
			boolean nacional) {
		super(titulo, descripcion, presupuesto, presupuestoFinal, nVotos, fechaCreacion, fechaUltimoVoto, estado);
		this.claseSocial = claseSocial;
		this.nacional = nacional;
	}

	/**
	 * Este metodo devuelve la clase social a la que va dirigida el proyecto
	 * @return claseSocial 
	 */
	public String getClaseSocial() {
		return claseSocial;
	}

	/**
	 * Este metodo cambia la clase social del proyecto
	 * @param claseSocial Clase social del proyecto
	 */
	public void setClaseSocial(String claseSocial) {
		this.claseSocial = claseSocial;
	}

	/**
	 * Este metodo devuelve si es nacional el proyecto
	 * @return nacional 
	 */
	public boolean isNacional() {
		return nacional;
	}

	/**
	 * Este metodo cambia el caracter nacional del proyecto
	 * @param nacional Esquema del proyecto
	 */
	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}
	
	
}


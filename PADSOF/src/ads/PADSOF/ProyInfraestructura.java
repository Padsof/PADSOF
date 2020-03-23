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

public class ProyInfraestructura extends Proyecto {

	/**
	 * Esquema de la infraestructura
	 */
	private File esquema;

	/**
	 * Distrito donde se va a realizar
	 */
	private String distrito;
	
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
	 * @param esquema Esquema de la realizacion del proyecto
	 * @param distrito Distrito donde se va a llevar a cabo el proyecto
	 */
	public ProyInfraestructura(String titulo, String descripcion, double presupuesto, double presupuestoFinal,
			int nVotos, LocalDate fechaCreacion, LocalDate fechaUltimoVoto, EstadoProyecto estado, File esquema,
			String distrito) {
		super(titulo, descripcion, presupuesto, presupuestoFinal, nVotos, fechaCreacion, fechaUltimoVoto, estado);
		this.esquema = esquema;
		this.distrito = distrito;
	}

	/**
	 * Este metodo devuelve el esquema del proyecto
	 * @return esquema 
	 */
	public File getEsquema() {
		return esquema;
	}

	/**
	 * Este metodo cambia el esquema del proyecto
	 * @param esquema Esquema del proyecto
	 */
	public void setEsquema(File esquema) {
		this.esquema = esquema;
	}

	/**
	 * Este metodo devuelve el distrito donde se va a realizar el proyecto
	 * @return distrito
	 */
	public String getDistrito() {
		return distrito;
	}

	/**
	 * Este metodo cambia el distrito del proyecto
	 * @param distrito Distrito del proyecto
	 */
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	
	
}

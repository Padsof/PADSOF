package ads.PADSOF;

/**
 * Esta clase enumera los distintos estados de Proyecto.
 *
 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es
 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es
 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es
 *
*/
public enum EstadoProyecto {
	/** 
	 * El proyecto ha sido aceptado
	 */
	aceptado,
	/**
	 * El proyecto ha sido rechazado
	 */
	rechazado,
	/**
	 * El proyecto ha caducado
	 */
	caducado,
	/**
	 * El proyecto ha superado el umbral de votos establecidos
	 */
	umbralSuperado,
	/**
	 * El proyecto has sido aprobado y financiado por la app externa
	 */
	financiado,
	/**
	 * El proyecto todavía no ha sido aprobado
	 */
	poraceptar,
	/**
	 * El proyecto puede pedir financiacion
	 */
	financiable,
	/**
	 * El proyecto espera a ser financiado
	 */
	esperando;
	
	/**
	 * Este metodo devuelve si el estado del parametro ese igual al estado del proyecto actual
	 * @param ep Estado del proyecto a comparar
	 * @return true or false
	 */
	public final boolean equals(EstadoProyecto ep) {
		return this==ep;
	}
}

package ads.PADSOF;

/**
 * Esta clase enumera TipoNotificacion
 *
 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es
 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es
 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es
 *
*/
public enum TipoNotificacion {
	/**
	 * El proyecto ha sido aceptado
	 */
	aceptado(1),

	/**
	 * El proyecto ha sido rechazado
	 */
	rechazado(2),

	/**
	 * El proyecto ha sido cancelado
	 */
	cancelado(3),

	/**
	 * El proyecto ha sido financiado
	 */
	financiado(4)
	;
	
	/**
	 * Tipo de la notificacion
	 */
	private final int tipo;
	
	/**
	 * Este metodo cambia el tipo de la notificacion
	 * @param tipo Nuevo tipo de la notificacion
	 */
	private TipoNotificacion(int tipo){
		this.tipo = tipo;
	}
	
	/**
	 * Este metodo devuelve que numero es el estado de la notificacion
	 * @return integer de la enumeracion
	 */
	public int getTipoNotif() {
		return this.tipo;
	}
	
}

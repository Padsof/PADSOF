package ads.PADSOF;

import java.io.Serializable;

/**
 * Esta clase enumera TipoNotificacion
 *
 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es
 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es
 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es
 *
*/
public enum TipoNotificacion implements Serializable{
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
	financiado(4),
	/**
	 * El proyecto es financiable
	 */
	financiable(5),
	/**
	 * El proyecto ha caducado
	 */
	caducado(6),
	/**
	 * Un Usuario ha sido bloqueado
	 */
	bloqueado(7),
	/**
	 * Un Usuario ha sido desbloqueado
	 */
	desbloqueado(8),
	/**
	 * Un Usuario ha sido aceptado
	 */
	aceptadoU(9),
	/**
	 * Un Usuario se ha unido a un colectivo
	 */
	colectivoU(10),
	/**
	 * Un Usuario ha abandonado un colectivo
	 */
	colectivoA(10);
	
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

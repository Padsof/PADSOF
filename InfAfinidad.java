package ads.PADSOF;

/**
 * Esta clase cambia el estado de la clase InfAfinidad.
 *
 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es
 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es
 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es
 *
*/
public class InfAfinidad extends Informe{
	/**
	 * Afinidad entre dos colectivos
	 */
	private double afinidad;
	
	/**
	 * Constructor de la clase InfAfinidad
	 * @param afin Afinidad de los colectivos
	 */
	public InfAfinidad(double afin) {
		afinidad = afin;
	}

	/**
	 * Este metodo devuelve la afinidad del informe
	 * @return afinidad
	 */
	public double getAfinidad() {
		return afinidad;
	}

	/**
	 * Este metodo cambia la afinidad del informe
	 * @param afinidad La nueva afinidad del informe
	 */
	public void setAfinidad(double afinidad) {
		this.afinidad = afinidad;
	}

}

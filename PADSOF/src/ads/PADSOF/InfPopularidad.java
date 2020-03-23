package ads.PADSOF;

/**
 * Esta clase modela la clase InfPopularidad
 *
 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es
 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es
 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es
 *
*/
public class InfPopularidad extends Informe {

	/**
	 * Numero de votos del proyecto
	 */
	private double popularidad;

	/**
	 * Este metodo cambia el esquema del proyecto
	 * @param popu Popularidad del proyecto
	 */
	public InfPopularidad(double popu) {
		popularidad = popu;
	}

	/**
	 * Este metodo devuelve la popularidad del proyecto
	 * @return popularidad Popularidad del proyecto
	 */
	public double getPopularidad() {
		return popularidad;
	}

	/**
	 * Este metodo cambia la popularidad del proyecto
	 * @param popularidad Popularidad del proyecto
	 */
	public void setPopularidad(double popularidad) {
		this.popularidad = popularidad;
	}
}

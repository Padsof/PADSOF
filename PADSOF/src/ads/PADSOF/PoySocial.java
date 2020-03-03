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
	private String claseSocial;
	private boolean nacional;
	
	public PoySocial(String titulo, String descripcion, double presupuesto, double presupuestoFinal, int nVotos,
			LocalDate fechaCreacion, LocalDate fechaUltimoVoto, EstadoProyecto estado, String claseSocial,
			boolean nacional) {
		super(titulo, descripcion, presupuesto, presupuestoFinal, nVotos, fechaCreacion, fechaUltimoVoto, estado);
		this.claseSocial = claseSocial;
		this.nacional = nacional;
	}

	public String getClaseSocial() {
		return claseSocial;
	}
	public void setClaseSocial(String claseSocial) {
		this.claseSocial = claseSocial;
	}

	public boolean isNacional() {
		return nacional;
	}
	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}
	
	
}


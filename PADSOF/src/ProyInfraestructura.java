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
	private File esquema;
	private String distrito;
	
	public ProyInfraestructura(String titulo, String descripcion, double presupuesto, double presupuestoFinal,
			int nVotos, LocalDate fechaCreacion, LocalDate fechaUltimoVoto, EstadoProyecto estado, File esquema,
			String distrito) {
		super(titulo, descripcion, presupuesto, presupuestoFinal, nVotos, fechaCreacion, fechaUltimoVoto, estado);
		this.esquema = esquema;
		this.distrito = distrito;
	}

	public File getEsquema() {
		return esquema;
	}
	public void setEsquema(File esquema) {
		this.esquema = esquema;
	}

	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	
	
}

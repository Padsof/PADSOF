package ads.PADSOF;
import java.util.*;
import java.time.*;

/**
 * Esta clase modela los proyectos.
 *
 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es
 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es
 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es
 *
*/
public abstract class Proyecto {

	/**
	 * El titulo del proyecto
	 */
	private String titulo;

	/**
	 * Breve descripcion sobre el proyecto
	 */
	private String descripcion;

	/**
	 * El presupuesto del proyecto
	 */
	private double presupuesto;

	/**
	 * El presupuesto final del proyecto
	 */
	private double presupuestoFinal;

	/**
	 * Numero de votos con los que cuenta el proyecto
	 */
	private int nVotos;

	/**
	 * La fecha en la que se creo el proyecto
	 */
	private LocalDate fechaCreacion;

	/**
	 * La fecha del ultimo voto
	 */
	private LocalDate fechaUltimoVoto;

	/**
	 * Estado en el que se encuentra el proyecto
	 */
	private EstadoProyecto estado;
	
	/**
	 * Un arrayList con los ciudadanos que se han suscrito al proyecto
	 */
	private ArrayList<ciudadano>suscritos;

	/**
	 * Un arrayList con los ciudadanos que han votado el proyecto
	 */
	private ArrayList<ciudadano>votos;
	
	/**
	 * Constructor de la clase Proyecto
	 * 
	 * @param titulo Titulo del proyecto
	 * @param descripcion Descripcion del proyecto
	 * @param presupuesto Presupuesto inicial
	 * @param presupuestoFinal Presupuesto final
	 * @param nVotos Numeros de votos del proyecto
	 * @param fechaCreacion Fecha de creacion
	 * @param fechaUltimoVoto Fecha del ultimo voto
	 * @param estado Estado en el que se encuentra el proyecto
	 */
	public Proyecto(String titulo, String descripcion, double presupuesto, double presupuestoFinal, int nVotos,
			LocalDate fechaCreacion, LocalDate fechaUltimoVoto, EstadoProyecto estado) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.presupuesto = presupuesto;
		this.presupuestoFinal = presupuestoFinal;
		this.nVotos = nVotos;
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimoVoto = fechaUltimoVoto;
		this.estado = estado;
	}
	
	/**
	 * Este metodo devuelve el titulo del proyecto
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Este metodo cambia el nombre del proyecto
	 * @param titulo Titulo del proyecto
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Este metodo devuelve la descripcion del proyecto
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Este metodo cambia la descripcion del proyecto
	 * @param descripcion Descripcion del proyecto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Este metodo devuelve el presupuesto del proyecto
	 * @return presupuesto
	 */
	public double getPresupuesto() {
		return presupuesto;
	}

	/**
	 * Este metodo cambia el presupuesto del proyecto
	 * @param presupuesto Pesupuesto del proyecto
	 */
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	/**
	 * Este metodo devuelve el el presupuesto final del proyecto
	 * @return presupuesto final
	 */
	public double getPresupuestoFinal() {
		return presupuestoFinal;
	}

	/**
	 * Este metodo cambia el presupuesto final del proyecto
	 * @param presupuestoFinal Presupuesto final del proyecto
	 */
	public void setPresupuestoFinal(double presupuestoFinal) {
		this.presupuestoFinal = presupuestoFinal;
	}
	
	/**
	 * Este metodo devuelve el numero de votos del proyecto
	 * @return numero de votos
	 */
	public int getnVotos() {
		return nVotos;
	}

	/**
	 * Este metodo cambia el numero de votos del proyecto
	 * @param nVotos Numero de votos del proyecto
	 */
	public void setnVotos(int nVotos) {
		this.nVotos = nVotos;
	}
	
	/**
	 * Este metodo devuelve la fecha de creacion del proyecto del proyecto
	 * @return fecha de creacion
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Este metodo cambia la fecha de creacion del proyecto
	 * @param fechaCreacion Fecha de creacion del proyecto
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	/**
	 * Este metodo devuelve la fecha del ultimo voto del proyecto
	 * @return fecha ultimo voto
	 */
	public LocalDate getFechaUltimoVoto() {
		return fechaUltimoVoto;
	}
	
	/**
	 * Este metodo cambia la fecha del ultimo voto del proyecto
	 * @param fechaUltimoVoto Fecha del ultimo voto del proyecto
	 */
	public void setFechaUltimoVoto(LocalDate fechaUltimoVoto) {
		this.fechaUltimoVoto = fechaUltimoVoto;
	}
	
	/**
	 * Este metodo devuelve el estado del proyecto
	 * @return estado
	 */
	public EstadoProyecto getEstado() {
		return estado;
	}

	/**
	 * Este metodo cambia el estado del proyecto
	 * @param estado Estado del proyecto
	 */
	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
	}
	
	/**
	 * Este metodo aniade un ciudadano a la lista de suscritos si no estaba anteriormente
	 * @param c Ciudadano a aniadir a suscritos
	 */
	public int suscribir(ciudadano c) {
		for (ciudadano aux: suscritos) {
			if (aux == c) {
				return -1;
			}
		}
		
		suscritos.add(c);
		return 0;
	}
	
	/**
	 * Este metodo elimina a un ciudadano suscrito de la lista
	 * @param c Ciudadano a eliminar de la lista
	 */
	public int desuscribir(ciudadano c) {
		for (ciudadano aux: suscritos) {
			if (aux == c) {
				suscritos.remove(c);
				return 0;
			}
		}
		return 0;
	}
	
	/**
	 * Este metodo genera un informe de popularidad con los votos del proyecto
	 */
	public InfPopularidad informePopularidad() {
		InfPopularidad informe = new InfPopularidad(nVotos);
		return informe;
	}
	
	/**
	 * Este metodo manda a financiar un proyecto que cumple los requisitos
	 * @param a Aplicacion donde se aniade si cumple los requisitos y no estaba ya en la lista
	 */
	public void solicitudFinanciar(Aplicacion a) {
		if (estado.equals(EstadoProyecto.umbralSuperado)) {
			//mandar a financiar (al arrayList de paraFinanciar)
		}
	}
	
	/**
	 * Este metodo anula un voto del proyecto
	 * @param c Ciudadano que quita su voto
	 */
	public void anularVoto(ciudadano c) {
		for (ciudadano aux: votos) {
			if (aux == c) {
				votos.remove(c);
				nVotos--;
			}
		}
	}
	
	/**
	 * Este metodo aniade un ciudadano a la lista de votos y suma un voto a nVotos
	 * @param c Ciudadano que vota el proyecto
	 */
	public int votarProyecto(ciudadano c) {
		for (ciudadano aux: votos) {
			if (aux == c) {
				return -1;
			}
		}
		votos.add(c);
		nVotos++;
		return 0;
	}

	/**
	 * Este metodo acepta el proyecto, cambia su estado
	 */
	public void aceptarProyecto() {
		this.estado = EstadoProyecto.aceptado;
	}
	
	/**
	 * Este metodo rechaza el proyecto, cambia su estado
	 */
	public void rechazarProyecto() {
		this.estado = EstadoProyecto.rechazado;
		// eliminar proyecto??
	}
	
	/**
	 * Este metodo caduca el proyecto, cambia su estado
	 */
	public void caducarProyecto() {
		this.estado = EstadoProyecto.caducado;
		// eliminar proyecto??
	}
}

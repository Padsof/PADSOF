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
	 * Codigo identificativo
	 */
	private int codigo;
	
	/**
	 * El proponente del proyecto
	 */
	private Ciudadano proponente;

	/**
	 * Breve descripcion sobre el proyecto
	 */
	private String descripcion;

	/**
	 * El presupuesto del proyecto
	 */
	private double presupuestoSolicitado;

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
	private List <Ciudadano> suscritos = new ArrayList<>();

	/**
	 * Un arrayList con los ciudadanos que han votado el proyecto
	 */
	private List<Ciudadano>votos = new ArrayList<>();
	
		
	/**
	 * Constructor de la clase Proyecto cuando lo crea un usuario de forma individual
	 * 
	 * @param titulo Titulo del proyecto
	 * @param descripcion Descripcion del proyecto
	 * @param proponente del proyecto
	 * @param presupuesto Presupuesto inicial
	 * @param fechaCreacion Fecha de creacion
	 * @param estado Estado en el que se encuentra el proyecto
	 */
	public Proyecto(String titulo, String descripcion, Ciudadano ciudadano, double presupuesto, 
			LocalDate fechaCreacion, EstadoProyecto estado) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.presupuestoSolicitado = presupuesto;
		this.presupuestoFinal = 0; //TODAVIA NO SE LE HA ASIGNADO NINGUN PRESUPUESTO
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimoVoto = fechaCreacion; //CUANDO SE CREA EL PROYECTO EL PRIMER VOTO SE LE ASIGNA NADA MAS CREARLO
		this.estado = estado;
		this.nVotos = 0;
		this.proponente = ciudadano;
		proponente.getProyectos().add(this);


	}
	
	/**
	 * Constructor de la clase Proyecto cuando lo crea un usuario de forma individual
	 * 
	 * @param titulo Titulo del proyecto
	 * @param descripcion Descripcion del proyecto
	 * @param proponente del proyecto
	 * @param numero de votos asignados
	 * @param colectivo que ha creado el proyecto
	 * @param presupuesto Presupuesto inicial
	 * @param fechaCreacion Fecha de creacion
	 * @param estado Estado en el que se encuentra el proyecto
	 */
	public Proyecto(String titulo, String descripcion, Colectivo colectivo, double presupuesto, 
			LocalDate fechaCreacion, EstadoProyecto estado) {
		super();
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.presupuestoSolicitado = presupuesto;
		this.presupuestoFinal = 0; //TODAVIA NO SE LE HA ASIGNADO NINGUN PRESUPUESTO
		this.fechaCreacion = fechaCreacion;
		this.fechaUltimoVoto = fechaCreacion; //CUANDO SE CREA EL PROYECTO EL PRIMER VOTO SE LE ASIGNA NADA MAS CREARLO
		this.estado = estado;
		this.nVotos = colectivo.getNumMiembros(); //SE LE ASIGNA UN VOTO POR CADA UNO DE LOS MIEMBROS DEL COLECTIVO
		this.proponente = colectivo.getRepresentante();
		
		colectivo.getProyectos().add(this);

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
		return presupuestoSolicitado;
	}

	/**
	 * Este metodo cambia el presupuesto del proyecto
	 * @param presupuesto Pesupuesto del proyecto
	 */
	public void setPresupuesto(double presupuesto) {
		this.presupuestoSolicitado = presupuesto;
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
	public abstract void suscribir(Ciudadano c);
	
	/**
	 * Este metodo elimina a un ciudadano suscrito de la lista
	 * @param c Ciudadano a eliminar de la lista
	 */
	public abstract void desuscribir(Ciudadano c);
	
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
	public void anularVoto(Ciudadano c) {
		for (Ciudadano aux: votos) {
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
	public abstract void votarProyecto(Ciudadano c);
	
	public abstract void votarProyectoColectivo (Colectivo colectivo);

	/**
	 * Este metodo acepta el proyecto, cambia su estado
	 */
	public void aceptarProyecto() {
		this.estado = EstadoProyecto.aceptado;
		
		Aplicacion.getProyectosPorAceptar().remove(this);
		
		Aplicacion.getProyectosAceptados().add(this);
		
	}
	
	/**
	 * Este metodo rechaza el proyecto, cambia su estado
	 */
	public void rechazarProyectoUsuario(Ciudadano c) {
		
		this.estado = EstadoProyecto.rechazado;
		
		Aplicacion.getProyectosPorAceptar().remove(this);
		
		c.getProyectos().remove(this);		

	}
	
	/**
	 * Este metodo rechaza el proyecto, cambia su estado
	 */
	public void rechazarProyectoColectivo(Colectivo c) {
		
		this.estado = EstadoProyecto.rechazado;
		
		Aplicacion.getProyectosPorAceptar().remove(this);
		
		c.getProyectos().remove(this);
		

	}
	
	/**
	 * Este metodo caduca el proyecto, cambia su estado
	 */
	public void caducarProyecto() {
		this.estado = EstadoProyecto.caducado;
		// eliminar proyecto??
	}

	public Ciudadano getProponente() {
		return proponente;
	}

	public void setProponente(Ciudadano proponente) {
		this.proponente = proponente;
	}

	public double getPresupuestoSolicitado() {
		return presupuestoSolicitado;
	}

	public void setPresupuestoSolicitado(double presupuestoSolicitado) {
		this.presupuestoSolicitado = presupuestoSolicitado;
	}

	public List<Ciudadano> getSuscritos() {
		return suscritos;
	}

	public void setSuscritos(List<Ciudadano> suscritos) {
		this.suscritos = suscritos;
	}

	public List<Ciudadano> getVotos() {
		return votos;
	}

	public void setVotos(List<Ciudadano> votos) {
		this.votos = votos;
	}
	
	public String toString() {
		return "Codigo: "+this.codigo+" Titulo: " +this.titulo+ "  Descripcion: " +this.descripcion+ "  Estado: "+this.estado+"  Fecha Creacion: "+this.fechaCreacion+"  Proponente: "+this.proponente+"";
	}

	protected abstract String getCaracter();

	protected abstract List<String> getDistrito();

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
	
	
}

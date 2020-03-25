package ads.PADSOF;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
	 * El titulo del proyecto
	 */
	private String titulo;
	
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
	private List <Ciudadano> suscritos;

	/**
	 * Un arrayList con los ciudadanos que han votado el proyecto
	 */
	private List<Ciudadano>votos;
	
	/**
	 * Esquema de la infraestructura
	 */
	private File esquema;

	/**
	 * Distrito donde se va a realizar
	 */
	private String distrito;
	
	/**
	 * El proyecto puede ser de caracter nacional o internacional
	 */
	private String caracter;
	
	/**
	 * Constructor de la clase ProyInfraestuctura
	 * 
	 * @param titulo Titulo del proyecto
	 * @param descripcion Descripcion del proyecto
	 * @param presupuesto Presupuesto inicial
	 * @param fechaCreacion Fecha de creacion
	 * @param estado Estado en el que se encuentra el proyecto
	 * @param esquema Esquema de la realizacion del proyecto
	 * @param distrito Distrito donde se va a llevar a cabo el proyecto
	 */ 
	public ProyInfraestructura(String titulo, String descripcion, Ciudadano proponente, double presupuesto,
			 LocalDate fechaCreacion, EstadoProyecto estado, File esquema,
			String distrito) {
		super(titulo, descripcion, proponente, presupuesto, fechaCreacion, estado);
		this.esquema = esquema;
		this.distrito = distrito;
		this.presupuestoFinal = 0; //TODAVIA NO SE LE HA ASIGNADO NINGUN PRESUPUESTO
		this.fechaUltimoVoto = fechaCreacion; //CUANDO SE CREA EL PROYECTO EL PRIMER VOTO SE LE ASIGNA NADA MAS CREARLO
		this.nVotos = 1; //SE LE ASIGNA EL VOTO DEL CREADOR DEL PROYECTO
		this.suscritos = new ArrayList<>();
		this.votos = new ArrayList<>();
		
		Aplicacion.getProyectosPorAceptar().add(this);

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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Ciudadano getProponente() {
		return proponente;
	}

	public void setProponente(Ciudadano proponente) {
		this.proponente = proponente;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPresupuestoSolicitado() {
		return presupuestoSolicitado;
	}

	public void setPresupuestoSolicitado(double presupuestoSolicitado) {
		this.presupuestoSolicitado = presupuestoSolicitado;
	}

	public double getPresupuestoFinal() {
		return presupuestoFinal;
	}

	public void setPresupuestoFinal(double presupuestoFinal) {
		this.presupuestoFinal = presupuestoFinal;
	}

	public int getnVotos() {
		return nVotos;
	}

	public void setnVotos(int nVotos) {
		this.nVotos = nVotos;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDate getFechaUltimoVoto() {
		return fechaUltimoVoto;
	}

	public void setFechaUltimoVoto(LocalDate fechaUltimoVoto) {
		this.fechaUltimoVoto = fechaUltimoVoto;
	}

	public EstadoProyecto getEstado() {
		return estado;
	}

	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
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

	@Override
	protected String getCaracter() {
		// TODO Auto-generated method stub
		return null;
	}
		
	
}

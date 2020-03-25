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

public class PoySocial extends Proyecto{
	
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
	 * El proyecto puede ser de caracter nacional o internacional
	 */
	private String caracter;

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
	 * Clase social a la que va dirigida
	 */
	private String claseSocial;

	/**
	 * Si es de caracter nacional o internacional
	 */
	private boolean nacional;
	
	/**
	 * Constructor de la clase ProyInfraestuctura
	 * 
	 * @param titulo Titulo del proyecto
	 * @param descripcion Descripcion del proyecto
	 * @param presupuesto Presupuesto inicial
	 * @param fechaCreacion Fecha de creacion
	 * @param estado Estado en el que se encuentra el proyecto
	 * @param claseSocial clase social a la que va dirigida
	 * @param nacional Si es de caracter nacional
	 */
	public PoySocial(String titulo, String descripcion, Ciudadano proponente, double presupuesto,
			LocalDate fechaCreacion,  EstadoProyecto estado, String claseSocial, 
			boolean nacional) {
		super(titulo, descripcion, proponente, presupuesto, fechaCreacion, estado);
		this.claseSocial = claseSocial;
		this.nacional = nacional;
		this.presupuestoFinal = 0; //TODAVIA NO SE LE HA ASIGNADO NINGUN PRESUPUESTO
		this.fechaUltimoVoto = fechaCreacion; //CUANDO SE CREA EL PROYECTO EL PRIMER VOTO SE LE ASIGNA NADA MAS CREARLO
		this.nVotos = 1; //SE LE ASIGNA EL VOTO DEL CREADOR DEL PROYECTO
		this.suscritos = new ArrayList<>();
		this.votos = new ArrayList<>();
		
		if (nacional == true) {
			this.caracter = "nacional";
		}
		else {
			this.caracter = "Internacional";
		}
		
		Aplicacion.getProyectosPorAceptar().add(this);
	}

	/**
	 * Este metodo devuelve la clase social a la que va dirigida el proyecto
	 * @return claseSocial 
	 */
	public String getClaseSocial() {
		return claseSocial;
	}

	/**
	 * Este metodo cambia la clase social del proyecto
	 * @param claseSocial Clase social del proyecto
	 */
	public void setClaseSocial(String claseSocial) {
		this.claseSocial = claseSocial;
	}

	/**
	 * Este metodo devuelve si es nacional el proyecto
	 * @return nacional 
	 */
	public boolean isNacional() {
		return nacional;
	}

	/**
	 * Este metodo cambia el caracter nacional del proyecto
	 * @param nacional Esquema del proyecto
	 */
	public void setNacional(boolean nacional) {
		this.nacional = nacional;
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

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}
	
	
	
	
	
	
}


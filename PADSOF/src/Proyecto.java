package ads.PADSOF;

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
	private String titulo;
	private String descripcion;
	private double presupuesto;
	private double presupuestoFinal;
	private int nVotos;
	private LocalDate fechaCreacion;
	private LocalDate fechaUltimoVoto;
	private EstadoProyecto estado;
	
	
	
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
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
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
}

package ads.PADSOF;

import java.io.Serializable;
import java.time.LocalDate; 

/**
 * Esta clase cambia el estado de la clase Notificacion
 *
 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es
 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es
 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es
 *
*/
public class Notificacion implements Serializable{

	/**
	 * Texto que se muestra en la notificacion
	 */
	private String texto;

	/**
	 * Fecha en la que se creo la notificacion
	 */
	private LocalDate fecha;

	/**
	 * Tipo de la notificacion
	 */
	private TipoNotificacion tipo;
	
	/**
	 * Motivo de rechazo de proyecyo
	 */
	private String motivo;
	/**
	 * Abreviatura de la notificacion
	 */
	private String abreviatura;
	
	/**
	 * Constructor de la clase ProyInfraestuctura
	 * 
	 * @param texto Texto de la notificacion
	 * @param fecha Fecha en la que se creo el proyecto
	 * @param tipo Tipo de notificacion
	 */
	public Notificacion(String texto, LocalDate fecha, String Abreviatura, TipoNotificacion tipo) {
		super();
		this.texto = texto;
		this.fecha = fecha;
		this.tipo = tipo;
		this.abreviatura = Abreviatura;
	}
	
	public Notificacion(String texto, String motivo, LocalDate fecha, String Abreviatura, TipoNotificacion tipo) {
		super();
		this.texto = texto;
		this.fecha = fecha;
		this.tipo = tipo;
		this.motivo = motivo;
		this.abreviatura = Abreviatura;

	}

	/**
	 * Este metodo devuelve el texto de la notificacion
	 * @return texto 
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * Este metodo cambia el texto de la notificacion
	 * @param texto Texto de la notificacion
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/**
	 * Este metodo devuelve la fecha de la notificacion
	 * @return fecha 
	 */
	public LocalDate getFecha() {
		return fecha;
	}

	/**
	 * Este metodo cambia la fecha de la notificacion
	 * @param fecha Fecha de la notificacion
	 */
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	/**
	 * Este metodo devuelve el tipo de la notificacion
	 * @return tipo 
	 */
	public TipoNotificacion getTipo() {
		return tipo;
	}

	/**
	 * Este metodo cambia el tipo de la notificacion
	 * @param tipo Tipo de la notificacion
	 */
	public void setTipo(TipoNotificacion tipo) {
		this.tipo = tipo;
	}
	
	public String toString() {
		return ""+this.texto+" "+this.motivo+" "+this.fecha+" "+this.tipo+"";
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public String getMotivo() {
		return motivo;
	}
	
	
	
	
	
	
}

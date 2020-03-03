package ads.PADSOF;

import java.time.LocalDate; 

public class Notificacion {
	private String texto;
	private LocalDate fecha;
	private TipoNotificacion tipo;
	
	public Notificacion(String texto, LocalDate fecha, TipoNotificacion tipo) {
		super();
		this.texto = texto;
		this.fecha = fecha;
		this.tipo = tipo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public TipoNotificacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoNotificacion tipo) {
		this.tipo = tipo;
	}
	
	
}


public enum TipoNotificacion {
	aceptado(1),
	rechazado(2),
	cancelado(3),
	financiado(4)
	;
	
	private final int tipo;
	
	private TipoNotificacion(int tipo){
		this.tipo = tipo;
	}
	
	public int getTipoNotif() {
		return this.tipo;
	}
	
}

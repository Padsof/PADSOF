package ads.PADSOF;

public class ciudadano extends Usuario {
	
	private String DNI;
    private boolean bloqueado;
    
    
    
	  public ciudadano (String dni, boolean baneado, String name, String password) {
		  super(name, password);
		  DNI = dni;
		  bloqueado = baneado;
	  }



	public String getDNI() {
		return DNI;
	}



	public void setDNI(String dNI) {
		DNI = dNI;
	}



	public boolean isBloqueado() {
		return bloqueado;
	}



	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	  
	
	
	public void aceptarUsuario() {
		
	}
	
	public void rechazarUsuario() {
		
	}
	
	public void bloquearUsuario() {
		
	}
	
	public void desbloquearUsuario() {
		
	}
	
	public void eliminarNotificacion() {
		
	}
	
	public void leerNotificacion() {
		
	}

}

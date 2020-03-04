package ads.PADSOF;

import java.util.*;

public class Ciudadano extends Usuario {
	
	private String DNI;
    private boolean bloqueado;
    private boolean representanteProyecto;
    private Colectivo asociacion;
    
    private List<Ciudadano> Aceptados = new ArrayList<>(); //Se deberia crear en aplicacion
    private List<Colectivo> Colectivos = new ArrayList<>();

    
	public Ciudadano (String dni, String name, String password) {
		  super(name, password, dni);
		  DNI = dni;
		  bloqueado = false;
		  representanteProyecto = false;
	 }
	
	public void crearColectivo(String colectivo, String name) {
		asociacion = new Colectivo (colectivo, name);
		Colectivos.add(asociacion);
		representanteProyecto = true;
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
	  
	
	
	public boolean isRepresentanteProyecto() {
		return representanteProyecto;
	}



	public void setRepresentanteProyecto(boolean representanteProyecto) {
		this.representanteProyecto = representanteProyecto;
	}



	public void aceptarUsuario(Ciudadano C) {
		Aceptados.add(C);
	}
	
	public void rechazarUsuario() {
		
	}
	
	public void bloquearUsuario() {
		
		bloqueado = true;
		
	}
	
	public void desbloquearUsuario() {
		bloqueado = false;
	}
	
	public void eliminarNotificacion() {
		
	}
	
	public void leerNotificacion() {
		
	}

}

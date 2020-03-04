package ads.PADSOF;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {

	private String nombre;
    private String contrasenia;
    private List<Ciudadano> PorAceptar = new ArrayList<>(); //Se debe crear en aplicacion
    private Ciudadano persona;
    
    
	  public Usuario (String name, String password, String DNI) {
		  nombre = name;
		  contrasenia = password;
		  persona = new Ciudadano(DNI, name, password);
		  PorAceptar.add(persona); //debe añadir un nuevo ciudadano pero no se crea la lista en esta clase
	  }
	  
	

	public List<Ciudadano> getPorAceptar() { //No deberia estar aqui
		return PorAceptar;
	}



	public void setPorAceptar(List<Ciudadano> porAceptar) { //No deberia estar aqui
		PorAceptar = porAceptar;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getcontrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}

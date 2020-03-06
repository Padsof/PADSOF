package ads.PADSOF;

public abstract class Usuario {

	private String nombre;
    private String contrasenia;
    
	  public Usuario (String name, String password) {
		  nombre = name;
		  contrasenia = password;
	  }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
}

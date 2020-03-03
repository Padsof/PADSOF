
public abstract class Usuario {

	private String nombre;
    private String contraseña;
    
	  public Usuario (String name, String password) {
		  nombre = name;
		  contraseña = password;
	  }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
}

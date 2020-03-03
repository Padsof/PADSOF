package ads.PADSOF;

public abstract class Usuario {

	private String nombre;
    private String contrase�a;
    
	  public Usuario (String name, String password) {
		  nombre = name;
		  contrase�a = password;
	  }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
}

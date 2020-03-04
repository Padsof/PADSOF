package ads.PADSOF;

public class Colectivo {
	
	private String nombre;
	private String representante;
    private int numMiembros;
    
    
	  public Colectivo(String name, String rep) {
		nombre = name;
		representante = rep;

	  }


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getNumMiembros() {
		return numMiembros;
	}


	public void setNumMiembros(int numMiembros) {
		this.numMiembros = numMiembros;
	}
	
	public void agregarMiembro(Ciudadano c) {
		
	}
	
	public void quitarMiembro(Ciudadano c) {
		
	}
	
	public InfAfinidad informeAfinidad(Colectivo c) {
		
	}
    
    
    
    
    
    
    
    
    
    
    
    
}

package ads.PADSOF;

/**

 * Esta clase modela los usuarios de tipo Administrador.

 *

 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es

 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es

 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es

 *

*/

public class Administrador extends Usuario {
	
	/**

	 * Una variable auxiliar para saber si el usuario administrador ha sido creado

	 */
	private static int creado;

	/**

     * Constructor de la clase Administrador.

     * 

     * @param nombre El nombre con el que el usuario se ha registrado
     * 
     * @param password La contraseña con la que el usuario se ha registrado

     * @param DNI El DNI del usuario 

     */
	  public Administrador (String nombre, String password, String DNI) {
		  super(nombre, password, null);
		  creado = 1;
		  Aplicacion.setAdministradorCreado(1);
		  Aplicacion.setAdministrador(this);
	  }

	public static int getCreado() {
		return creado;
	}

	public static void setCreado(int creado) {
		Administrador.creado = creado;
	}
	
	
	
	
	
	

	@Override
	protected void setRepresentanteProyecto(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isRepresentanteProyecto() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void crearColectivo(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setBloqueado(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isBloqueado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void bloquearUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void desbloquearUsuario() {
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return "Nombre: " +this.getNombre()+ "  Contraseña: " +this.getcontrasenia()+"  DNI: "+this.getDNI()+"";
	}

	
}

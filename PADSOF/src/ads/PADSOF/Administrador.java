package ads.PADSOF;
import java.util.ArrayList;
import java.util.List;

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

	protected void crearColectivo(String string) {
		// TODO Auto-generated method stub
		
	}

	protected void setBloqueado(boolean b) {
		// TODO Auto-generated method stub 
		
	}

	protected boolean isBloqueado() {
		// TODO Auto-generated method stub
		return false;
	}

	
	protected void bloquearUsuario(Ciudadano c) {

		List<Proyecto> numero = c.getVotado();
		int numero1 = c.getVotado().size();
		int votos;
		int i;
		
		c.setBloqueado(true);
		System.out.println("Se ha bloqueado correctamente al usuario: "+c+"");
		
		for (i = 0; i < numero1; i++) {
			c.getVotado().get(0).getVotos().remove(c);
			votos = c.getVotado().get(0).getnVotos();
			votos--;
			c.getVotado().get(0).setnVotos(votos);
			c.getVotado().remove(c.getVotado().get(0));
			
		}
		
		/*for(Proyecto aux: numero) {
			aux.getVotos().remove(c);
			votos = aux.getnVotos();
			votos--;
			aux.setnVotos(votos);
		}*/
		
		
	}

	
	protected void desbloquearUsuario(Ciudadano c) {
		
		c.setBloqueado(false);
	}
	
	public String toString() {
		return "Nombre: " +this.getNombre()+ "  Contraseña: " +this.getcontrasenia()+"  DNI: "+this.getDNI()+"";
	}
	
	public void limiteVotos (int limite) {
		
		Aplicacion.setUmbral(limite);
	}

	
}

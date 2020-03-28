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
	  
   /**
	* Este metodo devuelve la variable auxiliar para saber si el usuario administrador ha sido creado
	* @return creado variable auxiliar para saber si el usuario administrador ha sido creado
	*/

	public static int getCreado() {
		return creado;
	}
	
	/**
	 * Este metodo cambia la variable auxiliar para saber si el usuario administrador ha sido creado
	 * @param creado variable auxiliar para saber si el usuario administrador ha sido creado
	 */

	public static void setCreado(int creado) {
		Administrador.creado = creado;
	}
	
	/**
	 * Este metodo bloquea al usuario
	 * @param c Usuario de clase ciudadano al que queremos bloquear
	 */
	
	public void bloquearUsuario(Ciudadano c) {

		List<Proyecto> numero = c.getVotado();
		int numero1 = c.getVotado().size();
		int numero2 = c.getVotoIndividual().size();
		int votos;
		int i;
		
		c.setBloqueado(true);
		System.out.println("Se ha bloqueado correctamente al usuario: "+c+"");
		Aplicacion.getBloqueados().add(c); //AÑADIMOS EL OBJETO CIUDADANO A UN ARRAY QUE GUARDA TODOS LOS USUARIOS BLOQUEADOS
		
		for (i = 0; i < numero1; i++) {
			c.getVotado().get(0).getVotos().remove(c); //UN USUARIO BLOQUEADO NO PUEDE APOYAR NINGUN PROYECTO
			votos = c.getVotado().get(0).getnVotos();
			votos--; //SE QUITA EL APOYO DEL USUARIO BLOQUEADO
			c.getVotado().get(0).setnVotos(votos); 
			c.getVotado().remove(c.getVotado().get(0)); //SE ELIMINA AL USUARIO DE LA LISTA DE USUARIOS QUE HAN APOYADO UN DETERMINADO PROYECTO
		}
		
		for (i = 0; i < numero2; i++) {
			c.getVotoIndividual().remove(c.getVotoIndividual().get(i));
		}
		
	}

	/**
	 * Este metodo desbloquea al usuario
	 * @param c Usuario de clase ciudadano al que queremos desbloquear
	 */
	
	public void desbloquearUsuario(Ciudadano c) {
		
		c.setBloqueado(false);
	}
	
	public String toString() {
		return "Nombre: " +this.getNombre()+ "  Contraseña: " +this.getcontrasenia()+"  DNI: "+this.getDNI()+"";
	}
	
	/**
	 * Este metodo establece el umbral límite de votos
	 * @param limite umbral límite de votos
	 */
	
	public void limiteVotos (int limite) {
		
		Aplicacion.setUmbral(limite);
	}

	
}

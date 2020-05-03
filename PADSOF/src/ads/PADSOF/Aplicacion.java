package ads.PADSOF;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import fechasimulada.FechaSimulada;


/**

 * Esta clase modela la clase Aplicacion.

 *

 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es

 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es

 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es

 *

*/


public class Aplicacion implements Serializable{

	/**

	 * Determina el numero de votos que necesita alcanzar un proyecto para 
	 * considerar su financiacion 

	 */
	
	static int umbral;
	
	/**

	 * Administrador de la aplicacion

	 */

	static Administrador administrador;
	
	/**

	 * Variable que nos indica si el Administrador ha sido creado (el administrador debe ser unico)

	 */
	 
	private static int administradorCreado;
	
	/**

	 * Lista en la que almacenamos los usuarios de tipo ciudadano que no se han registrado en la aplicacion

	 */
	
	private static List<CiudadanoNoRegistrado> CNR = new ArrayList<>();
	
	/**

	 * Lista en la que almacenamos los usuarios registrados aceptados en la aplicacion.

	 */
	
	private static List<Ciudadano> usuariosAceptados = new ArrayList<>();
	/**

	 * Lista en la que almacenamos los usuarios registrados en espera de ser aceptados en la aplicacion.

	 */

    private static List<Ciudadano> usuariosPorAceptar = new ArrayList<>();
    
	/**

	 * Lista en la que almacenamos los colectivos creados.

	 */
    
    private static List<Colectivo> colectivos = new ArrayList<>();
    
	/**

	 * Lista en la que almacenamos los proyectos aceptados en la aplicacion.

	 */
    
    private static List<Proyecto> proyectosAceptados = new ArrayList<>();
    
	/**

	 * Lista en la que almacenamos los proyectos en espera de ser aceptados en la aplicacion.

	 */
    
    private static List<Proyecto> proyectosPorAceptar = new ArrayList<>();
    
	/**

	 * Lista en la que almacenamos los proyectos caducados.

	 */
    
        
    private static List<Proyecto> caducados = new ArrayList<>();
    
    /**

	 * Lista en la que almacenamos los Usuarios de tipo Ciudadano bloqueados.

	 */
    
        
    private static List<Ciudadano> bloqueados = new ArrayList<>();
        
	/**
	 * Este metodo genera un identificador unico a cada proyecto
	 * @param p al que se le asigna el identificador
	 */
    public static void generarIdentificador(Proyecto p) {
    	    	
    	int i = Aplicacion.getProyectosAceptados().size();
    	p.setCodigo(i);
    	
    }
    
	/**

     * Constructor de la clase Aplicacion.

     * 

     * @param limite El limite de votos que debe alcanzar un proyecto para ser considerado apto para la financiacion

     */
    
	public Aplicacion(int limite) {
		umbral = limite;
		try {

			ObjectOutputStream guardando_datos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data"));

			guardando_datos.writeObject(this);

			guardando_datos.close();

		}catch(Exception e) {

			System.out.println("Error al gurdar los datos");

		};

	  }
	
	/**
	 * Este metodo devuelve la lista de usuarios de tipo ciudadano aceptados en la aplicacion
	 * @return usuariosAceptados lista con los usuarios de tipo ciudadano aceptados en la aplicacion
	 */
	public static List<Ciudadano> getUsuariosAceptados() {
		return usuariosAceptados;
	}

	/**
	 * Este metodo cambia la lista de usuarios de tipo ciudadano aceptados en la aplicacion
	 * @param usuariosAceptados lista con los usuarios de tipo ciudadano aceptados en la aplicacion
	 */

	public static void setUsuariosAceptados(List<Ciudadano> usuariosAceptados) {
		Aplicacion.usuariosAceptados = usuariosAceptados;
	}

	/**
	 * Este metodo devuelve la lista de usuarios de tipo ciudadano en espera de ser aceptados en la aplicacion
	 * @return usuariosPorAceptar  lista de usuarios de tipo ciudadano en espera de ser aceptados en la aplicacion
	 */

	public static List<Ciudadano> getUsuariosPorAceptar() {
		return usuariosPorAceptar;
	}

	/**
	 * Este metodo cambia la  lista de usuarios de tipo ciudadano en espera de ser aceptados en la aplicacion
	 * @param usuariosPorAceptar  lista de usuarios de tipo ciudadano en espera de ser aceptados en la aplicacion
	 */

	public static void setUsuariosPorAceptar(List poraceptar) {
		Aplicacion.usuariosPorAceptar = poraceptar;
	}

	/**
	 * Este metodo devuelve la lista de colectivos creados
	 * @return colectivos lista de colectivos creados
	 */

	public static List<Colectivo> getColectivos() {
		return colectivos;
	}

	/**
	 * Este metodo cambia la lista de colectivos creados
	 * @param colectivos lista de colectivos creados
	 */

	public static void setColectivos(List<Colectivo> colectivos) {
		Aplicacion.colectivos = colectivos;
	}


	public static boolean login (String user, String contrasenia, String DNI) {
		
		
		int tam = Aplicacion.getUsuariosAceptados().size();
		int i, flag = 0;
		
		for(i = 0; i < tam; i++) {
			if(Aplicacion.getUsuariosAceptados().get(i).getNombre().equals(user) || Aplicacion.getUsuariosAceptados().get(i).getDNI().equals(DNI) && Aplicacion.getUsuariosAceptados().get(i).getcontrasenia().equals(contrasenia)) {
				flag = 1;
			}
		}
		
		if(flag == 1) {
			return true;
		}
		
		tam = Aplicacion.getBloqueados().size();
		
		for(i = 0; i < tam; i++) {
			if(Aplicacion.getBloqueados().get(i).getNombre().equals(user) || Aplicacion.getBloqueados().get(i).getDNI().equals(DNI) && Aplicacion.getBloqueados().get(i).getcontrasenia().equals(contrasenia)) {
				flag = 1;
			}
		}
		
		if(flag == 1) {
			return true;
		}
		
		
		return false;

	}

	public void logout () {

	}
	
	/**
	 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la envía al ciudadano correspondiente (la almacena en una lista de Notificaciones 
	 * particular del usuario)
	 * @param p proyecto del cual debemos conocer informacion como el estado para saber que tipo de notificacion generar o los miembros y el proponente para saber a que usuarios enviar la notificacion
	 * @param motivo por el cual el administrador ha decidido rechazar el proyecto
	 * @param abrev Abreviatura para visibilizar la notificacion

	 */

	public static void generarNotificacion(Proyecto p, String motivo, String abrev) {
		Notificacion notificacion;
		int suscritos = p.getSuscritos().size();
		int i;
		FechaSimulada.restablecerHoyReal();
		
		if (p.getEstado() == EstadoProyecto.financiable) {
			notificacion = new Notificacion("El proyecto "+p.getTitulo()+" ya es financiable", FechaSimulada.getHoy(), abrev, TipoNotificacion.financiable);
			for(i = 0; i < suscritos; i++) {
				p.getSuscritos().get(i).getNotificaciones().add(notificacion);
			}
			
		}
		else if (p.getEstado() == EstadoProyecto.rechazado) {
			notificacion = new Notificacion("El proyecto "+p.getTitulo()+" ha sido rechazado.", "El motivo se indica a continuacion: "+motivo+"" ,FechaSimulada.getHoy(), abrev, TipoNotificacion.rechazado);
			p.getProponente().getNotificaciones().add(notificacion);
			
		}
		else if (p.getEstado() == EstadoProyecto.caducado) {
			notificacion = new Notificacion("El proyecto "+p.getTitulo()+" ha caducado.", motivo ,FechaSimulada.getHoy(), abrev, TipoNotificacion.caducado);
			for(i = 0; i < suscritos; i++) {
				p.getSuscritos().get(i).getNotificaciones().add(notificacion);
			}
		}
		
		return;
	}
	
	/**
	 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la envía al ciudadano correspondiente (la almacena en una lista de Notificaciones 
	 * particular del usuario)
	 * @param c Ciudadano al cual queremos mandar la notificacion
	 * @param motivo Motivo por el cual mandamos la notificacion
	 * @param abrev Abreviatura para visibilizar la notificacion
	 * @param motivo por el cual el administrador ha decidido rechazar el proyecto
	 */
	
	public static void generarNotificacionUsuario(Ciudadano c, String motivo, String abrev) {
		Notificacion notificacion;
		FechaSimulada.restablecerHoyReal();

		
		if(c.isBloqueado() == true) {
			System.out.println("Hola");
			notificacion = new Notificacion("Ha sido bloqueado por el administrador de la aplicacion. Todas las funciones han dejado de estar disponibles", motivo,FechaSimulada.getHoy(), abrev, TipoNotificacion.bloqueado);
			c.getNotificaciones().add(notificacion);
		}
		
		if(c.isBloqueado() == false) {
			notificacion = new Notificacion("Ha sido desbloqueado por el administrador de la aplicacion. Todas las funciones vuelven a estar disponibles", motivo, FechaSimulada.getHoy(), abrev, TipoNotificacion.desbloqueado);
			c.getNotificaciones().add(notificacion);
		}
		
		return;
		
	}
	
	/**
	 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la envía al ciudadano correspondiente (la almacena en una lista de Notificaciones 
	 * particular del usuario)
	 * @param c Ciudadano al cual queremos mandar la notificacion
	 * @param motivo Motivo por el cual mandamos la notificacion
	 * @param abrev Abreviatura para visibilizar la notificacion
	 * @param motivo por el cual el administrador ha decidido rechazar el proyecto
	 */
		
		public static void generarNotificacionAceptado(Ciudadano c, String motivo, String abrev) {
			Notificacion notificacion;
			FechaSimulada.restablecerHoyReal();
			notificacion = new Notificacion("Enhorabuena, has sido aceptado en la aplicacion", motivo, FechaSimulada.getHoy(), abrev, TipoNotificacion.aceptadoU);
			c.getNotificaciones().add(notificacion);
		
		return;
	}
		
		/**
		 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la envía al ciudadano correspondiente (la almacena en una lista de Notificaciones 
		 * particular del usuario)
		 * @param c Ciudadano al cual queremos mandar la notificacion
		 * @param motivo Motivo por el cual mandamos la notificacion
		 * @param abrev Abreviatura para visibilizar la notificacion
		 * @param motivo por el cual el administrador ha decidido rechazar el proyecto
		 */
			
			public static void generarNotificacionColectivoU(Ciudadano c, String motivo, String abrev) {
				Notificacion notificacion;
				FechaSimulada.restablecerHoyReal();
				notificacion = new Notificacion("Gracias por unirte a nuestro colectivo", motivo, FechaSimulada.getHoy(), abrev, TipoNotificacion.aceptadoU);
				c.getNotificaciones().add(notificacion);
			
			return;
		}
			
			/**
			 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la envía al ciudadano correspondiente (la almacena en una lista de Notificaciones 
			 * particular del usuario)
			 * @param c Ciudadano al cual queremos mandar la notificacion
			 * @param motivo Motivo por el cual mandamos la notificacion
			 * @param abrev Abreviatura para visibilizar la notificacion
			 * @param motivo por el cual el administrador ha decidido rechazar el proyecto
			 */
				
		public static void generarNotificacionColectivoA(Ciudadano c, String motivo, String abrev) {
				Notificacion notificacion;
				FechaSimulada.restablecerHoyReal();
				notificacion = new Notificacion("Sentimos que nos abandones", motivo, FechaSimulada.getHoy(), abrev, TipoNotificacion.aceptadoU);
				c.getNotificaciones().add(notificacion);
				
				return;
			}
	
	/**
	 * Este metodo devuelve el usuario de tipo Administrador de la aplicacion
	 * @return administrador administrador de la aplicacion
	 */

	public static Administrador getAdministrador() {
		return administrador;
	}

	/**
	 * Este metodo cambia el usuario de tipo Administrador de la aplicacion
	 * @param administrador usuario de tipo Administrador de la aplicacion
	 */


	public static void setAdministrador(Administrador administrador) {
		Aplicacion.administrador = administrador;
	}

	/**
	 * Este metodo devuelve la variable que nos indica si el Administrador ha sido creado
	 * @return administradorCreado Variable que nos indica si el Administrador ha sido creado
	 */

	public static int getAdministradorCreado() {
		return administradorCreado;
	}

	/**
	 * Este metodo cambia la variable que nos indica si el Administrador ha sido creado
	 * @param administradorCreado variable que nos indica si el Administrador ha sido creado
	 */

	public static void setAdministradorCreado(int administradorCreado) {
		Aplicacion.administradorCreado = administradorCreado;
	}

	/**
	 * Este metodo cambia la lista en la que almacenamos los usuarios de tipo ciudadano que no se han registrado en la aplicacion
	 * @param cNR lista en la que almacenamos los usuarios de tipo ciudadano que no se han registrado en la aplicacion
	 */
	public static void setCNR(List<CiudadanoNoRegistrado> cNR) {
		CNR = cNR;
	}

	/**
	 * Este metodo devuelve la lista en la que almacenamos los usuarios de tipo ciudadano que no se han registrado en la aplicacion
	 * @return CNR Lista en la que almacenamos los usuarios de tipo ciudadano que no se han registrado en la aplicacion
	 */

	public static List<CiudadanoNoRegistrado> getCNR() {
		return CNR;
	}
	
	/**
	 * Este metodo devuelve la Lista en la que almacenamos los proyectos aceptados en la aplicacion.
	 * @return proyectosAceptados Lista en la que almacenamos los proyectos aceptados en la aplicacion.
	 */

	public static List<Proyecto> getProyectosAceptados() {
		return proyectosAceptados;
	}

	/**
	 * Este metodo cambia la Lista en la que almacenamos los proyectos aceptados en la aplicacion.
	 * @param proyectosAceptados Lista en la que almacenamos los proyectos aceptados en la aplicacion.
	 */
	
	public static void setProyectosAceptados(List<Proyecto> proyectosAceptados) {
		Aplicacion.proyectosAceptados = proyectosAceptados;
	}
	
	/**
	 * Este metodo devuelve la Lista en la que almacenamos los proyectos pendientes de ser aceptados en la aplicacion.
	 * @return proyectosPorAceptar Lista en la que almacenamos los proyectos pendientes de ser aceptados en la aplicacion.
	 */

	public static List<Proyecto> getProyectosPorAceptar() {
		return proyectosPorAceptar;
	}

	/**
	 * Este metodo cambia la Lista en la que almacenamos los proyectos pendientes de ser aceptados en la aplicacion.
	 * @param proyectosPorAceptar Lista en la que almacenamos los proyectos pendientes de ser aceptados en la aplicacion.
	 */
	

	public static void setProyectosPorAceptar(List<Proyecto> proyectosPorAceptar) {
		Aplicacion.proyectosPorAceptar = proyectosPorAceptar;
	}

	/**
	 * Este metodo devuelve el umbral que marca el limite de votos que debe alcanzar un proyecto para considerar su financiacion
	 * @return umbral umbral que marca el limite de votos que debe alcanzar un proyecto para considerar su financiacion
	 */

	public static int getUmbral() {
		return umbral;
	}

	/**
	 * Este metodo cambia el umbral que marca el limite de votos que debe alcanzar un proyecto para considerar su financiacion
	 * @param umbral umbral que marca el limite de votos que debe alcanzar un proyecto para considerar su financiacion
	 */

	public static void setUmbral(int umbral) {
		Aplicacion.umbral = umbral;
	}
	
	/**
	 * Este metodo devuelve la lista de proyectos caducados
	 * @return caducados lista de proyectos caducados
	 */

	public static List<Proyecto> getCaducados() {
		return caducados;
	}
	
	/**
	 * Este metodo cambia la lista de proyectos caducados
	 * @param caducados lista de proyectos caducados
	 */

	public static void setCaducados(List<Proyecto> caducados) {
		Aplicacion.caducados = caducados;
	}

	/**
	 * Este metodo devuelve la lista de usuarios de tipo ciudadano bloqueados
	 * @return bloqueados Lista de Usuarios de tipo Ciudadano bloqueados
	 */
	public static List<Ciudadano> getBloqueados() {
		return bloqueados;
	}

	/**
	 * Este metodo modifica la lista de usuarios de tipo ciudadano bloqueados
	 * @param bloqueados Lista de Usuarios de tipo Ciudadano bloqueados
	 */
	public static void setBloqueados(List<Ciudadano> bloqueados) {
		Aplicacion.bloqueados = bloqueados;
	}
	
	
	
	
	
	
	
	



}

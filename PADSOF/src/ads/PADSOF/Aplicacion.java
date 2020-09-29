package ads.PADSOF;

import java.io.*;
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
     * Usuario cuya sesion esta iniciada actualmente
     */
        
    private static Usuario sesion = null;
    
    
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

	public static void setUsuariosPorAceptar(List<Ciudadano> poraceptar) {
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


	
	/**
	 * Este metodo devuelve el usuario que ha iniciado sesion en la aplicacion
	 * @return bloqueados Lista de Usuarios de tipo Ciudadano bloqueados
	 */
	public static Usuario getSesion() {
		return sesion;
	}

	/**
	 * Este metodo modifica la lista de usuarios de tipo ciudadano bloqueados
	 * @param bloqueados Lista de Usuarios de tipo Ciudadano bloqueados
	 */
	public static void setSesion(Usuario sesion) {
		Aplicacion.sesion = sesion;
	}
	
	/**
	 * Este metodo realiza el guardado de todos los datos de la aplicacion
	 */
	private static void cargaDatos() {
		try {
			ObjectInputStream cargando_administrador = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/administrador.dat"));
			Aplicacion.setAdministrador((Administrador) cargando_administrador.readObject());
			cargando_administrador.close();
			
			ObjectInputStream cargando_administradorcreado = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/administradorcreado.dat"));
			Aplicacion.setAdministradorCreado((int) cargando_administradorcreado.readObject());
			cargando_administradorcreado.close();
			
			ObjectInputStream cargando_bloqueados = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/bloqueados.dat"));
			Aplicacion.setBloqueados((List<Ciudadano>) cargando_bloqueados.readObject());
			cargando_bloqueados.close();
			
			ObjectInputStream cargando_caducados = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/caducados.dat"));
			Aplicacion.setCaducados((List<Proyecto>)cargando_caducados.readObject());
			cargando_caducados.close();
			
			ObjectInputStream cargando_cnr = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/cnr.dat"));
			Aplicacion.setCNR((List<CiudadanoNoRegistrado>)cargando_cnr.readObject());
			cargando_cnr.close();
			
			ObjectInputStream cargando_colectivos = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/colectivos.dat"));
			Aplicacion.setColectivos((List<Colectivo>)cargando_colectivos.readObject());
			cargando_colectivos.close();
			
			ObjectInputStream cargando_proyectosaceptados = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/proyectosaceptados.dat"));
			Aplicacion.setProyectosAceptados((List<Proyecto>)cargando_proyectosaceptados.readObject());
			cargando_proyectosaceptados.close();
			
			ObjectInputStream cargando_proyectosporaceptar= new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/proyectosporaceptar.dat"));
			Aplicacion.setProyectosPorAceptar((List<Proyecto>)cargando_proyectosporaceptar.readObject());
			cargando_proyectosporaceptar.close();
			
			ObjectInputStream cargando_umbral= new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/umbral.dat"));
			Aplicacion.setUmbral((int)cargando_umbral.readObject());
			cargando_umbral.close();
			
			ObjectInputStream cargando_usuariosaceptados = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/usuariosaceptados.dat"));
			Aplicacion.setUsuariosAceptados((List<Ciudadano>)cargando_usuariosaceptados.readObject());
			cargando_usuariosaceptados.close();
			
			ObjectInputStream cargando_usuariosporaceptar = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/usuariosporaceptar.dat"));
			Aplicacion.setUsuariosPorAceptar((List<Ciudadano>)cargando_usuariosporaceptar.readObject());
			cargando_usuariosporaceptar.close();
			
			ObjectInputStream cargando_sesion = new ObjectInputStream(new FileInputStream(System.getProperty("user.dir") + "/data/sesion.dat"));
			Aplicacion.setSesion((Usuario)cargando_sesion.readObject());
			cargando_sesion.close();
			
		} catch(Exception e){
			System.out.println("Error al cargar los datos");
		}
	}
	
	/**
	 * Este metodo realiza el inicio de sesion de un usuario en la aplicacion
	 * @param user
	 * @param contrasenia
	 * @return
	 */
	public static boolean login (String user, String contrasenia) {
		
		Aplicacion.cargaDatos();
		
		if(Aplicacion.getAdministrador().getNombre().equals(user) && Aplicacion.getAdministrador().getcontrasenia().equals(contrasenia)) {
			
			return true;
			
		}else {
			for(Ciudadano u : Aplicacion.getUsuariosAceptados()) {
				if((u.getNombre().equals(user) || u.getDNI().equals(user)) && u.getcontrasenia().equals(contrasenia) ) {
					
					for(Ciudadano c : Aplicacion.getBloqueados()) {
						if(u.equals(c)) {
							return false;
						}
					}
					return true;
				}
			}
		}
		
		return false;
			
	}

	/**
	 * Este metodo realiza el cerrado de sesion de un usuario y el guardado de los datos de la aplicacion
	 */
	public static void logout () {
		try {
			Aplicacion.sesion = null;
			
			
			ObjectOutputStream guardando_administrador = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/administrador.dat"));
			guardando_administrador.writeObject(Aplicacion.getAdministrador());
			guardando_administrador.close();
			
			ObjectOutputStream guardando_administradorcreado = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/administradorcreado.dat"));
			guardando_administradorcreado.writeObject(Aplicacion.getAdministradorCreado());
			guardando_administradorcreado.close();
			
			ObjectOutputStream guardando_bloqueados = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/bloqueados.dat"));
			guardando_bloqueados.writeObject(Aplicacion.getBloqueados());
			guardando_bloqueados.close();
			
			ObjectOutputStream guardando_caducados = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/caducados.dat"));
			guardando_caducados.writeObject(Aplicacion.getCaducados());
			guardando_caducados.close();
			
			ObjectOutputStream guardando_cnr = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/cnr.dat"));
			guardando_cnr.writeObject(Aplicacion.getCNR());
			guardando_cnr.close();
			
			ObjectOutputStream guardando_colectivos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/colectivos.dat"));
			guardando_colectivos.writeObject(Aplicacion.getColectivos());
			guardando_colectivos.close();
			
			ObjectOutputStream guardando_proyectosaceptados = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/proyectosaceptados.dat"));
			guardando_proyectosaceptados.writeObject(Aplicacion.getProyectosAceptados());
			guardando_proyectosaceptados.close();
			
			ObjectOutputStream guardando_proyectosporaceptar= new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/proyectosporaceptar.dat"));
			guardando_proyectosporaceptar.writeObject(Aplicacion.getProyectosPorAceptar());
			guardando_proyectosporaceptar.close();
			
			ObjectOutputStream guardando_umbral= new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/umbral.dat"));
			guardando_umbral.writeObject(Aplicacion.getUmbral());
			guardando_umbral.close();
			
			ObjectOutputStream guardando_usuariosaceptados = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/usuariosaceptados.dat"));
			guardando_usuariosaceptados.writeObject(Aplicacion.getUsuariosAceptados());
			guardando_usuariosaceptados.close();
			
			ObjectOutputStream guardando_usuariosporaceptar = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/usuariosporaceptar.dat"));
			guardando_usuariosporaceptar.writeObject(Aplicacion.getUsuariosPorAceptar());
			guardando_usuariosporaceptar.close();
			
			ObjectOutputStream guardando_sesion = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data/sesion.dat"));
			guardando_sesion.writeObject(Aplicacion.getSesion());
			guardando_sesion.close();

		}catch(Exception e) {
			System.out.println("Error al gurdar los datos");
		}
		
	}

	
	
	/**
	 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la env�a al ciudadano correspondiente (la almacena en una lista de Notificaciones 
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
	 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la env�a al ciudadano correspondiente (la almacena en una lista de Notificaciones 
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
	 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la env�a al ciudadano correspondiente (la almacena en una lista de Notificaciones 
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
		 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la env�a al ciudadano correspondiente (la almacena en una lista de Notificaciones 
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
			 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la env�a al ciudadano correspondiente (la almacena en una lista de Notificaciones 
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

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
	
	int umbral;
	
	/**

	 * Administrador de la aplicacion

	 */

	Administrador administrador;
	
	/**

	 * Variable que nos indica si el Administrador ha sido creado (el administrador debe ser unico)

	 */
	 
	private int administradorCreado;
	
	/**

	 * Lista en la que almacenamos los usuarios de tipo ciudadano que no se han registrado en la aplicacion

	 */
	
	private List<CiudadanoNoRegistrado> CNR = new ArrayList<>();
	
	/**

	 * Lista en la que almacenamos los usuarios registrados aceptados en la aplicacion.

	 */
	
	private List<Ciudadano> usuariosAceptados = new ArrayList<>();
	/**

	 * Lista en la que almacenamos los usuarios registrados en espera de ser aceptados en la aplicacion.

	 */

    private List<Ciudadano> usuariosPorAceptar = new ArrayList<>();
    
	/**

	 * Lista en la que almacenamos los colectivos creados.

	 */
    
    private List<Colectivo> colectivos = new ArrayList<>();
    
	/**

	 * Lista en la que almacenamos los proyectos aceptados en la aplicacion.

	 */
    
    private List<Proyecto> proyectosAceptados = new ArrayList<>();
    
	/**

	 * Lista en la que almacenamos los proyectos en espera de ser aceptados en la aplicacion.

	 */
    
    private List<Proyecto> proyectosPorAceptar = new ArrayList<>();
    
	/**

	 * Lista en la que almacenamos los proyectos caducados.

	 */
    
        
    private List<Proyecto> caducados = new ArrayList<>();
    
    /**

	 * Lista en la que almacenamos los Usuarios de tipo Ciudadano bloqueados.

	 */
    
        
    private List<Ciudadano> bloqueados = new ArrayList<>();
        
	/**
	 * Este metodo genera un identificador unico a cada proyecto
	 * @param p al que se le asigna el identificador
	 */
    public void generarIdentificador(Proyecto p) {
    	    	
    	int i = this.getProyectosAceptados().size();
    	p.setCodigo(i);
    	
    }
    
	/**

     * Constructor de la clase Aplicacion.

     * 

     * @param limite El limite de votos que debe alcanzar un proyecto para ser considerado apto para la financiacion

     */
    
	public Aplicacion(int limite) {
		umbral = limite;

	  }
	
	/**
	 * Este metodo devuelve la lista de usuarios de tipo ciudadano aceptados en la aplicacion
	 * @return usuariosAceptados lista con los usuarios de tipo ciudadano aceptados en la aplicacion
	 */
	public List<Ciudadano> getUsuariosAceptados() {
		return usuariosAceptados;
	}

	/**
	 * Este metodo cambia la lista de usuarios de tipo ciudadano aceptados en la aplicacion
	 * @param usuariosAceptados lista con los usuarios de tipo ciudadano aceptados en la aplicacion
	 */

	public void setUsuariosAceptados(List<Ciudadano> usuariosAceptados) {
		this.usuariosAceptados = usuariosAceptados;
	}

	/**
	 * Este metodo devuelve la lista de usuarios de tipo ciudadano en espera de ser aceptados en la aplicacion
	 * @return usuariosPorAceptar  lista de usuarios de tipo ciudadano en espera de ser aceptados en la aplicacion
	 */

	public List<Ciudadano> getUsuariosPorAceptar() {
		return usuariosPorAceptar;
	}

	/**
	 * Este metodo cambia la  lista de usuarios de tipo ciudadano en espera de ser aceptados en la aplicacion
	 * @param usuariosPorAceptar  lista de usuarios de tipo ciudadano en espera de ser aceptados en la aplicacion
	 */

	public void setUsuariosPorAceptar(List poraceptar) {
		this.usuariosPorAceptar = poraceptar;
	}

	/**
	 * Este metodo devuelve la lista de colectivos creados
	 * @return colectivos lista de colectivos creados
	 */

	public List<Colectivo> getColectivos() {
		return colectivos;
	}

	/**
	 * Este metodo cambia la lista de colectivos creados
	 * @param colectivos lista de colectivos creados
	 */

	public void setColectivos(List<Colectivo> colectivos) {
		this.colectivos = colectivos;
	}


	public void login (String user, String contrasenia, String DNI) {
		
	}

	public void logout () {
		try {
			ObjectOutputStream guardando_datos = new ObjectOutputStream(new FileOutputStream(System.getProperty("user.dir") + "/data"));
			guardando_datos.writeObject(this);
			guardando_datos.close();
		}catch(Exception e) {
			System.out.println("Error al gurdar los datos");;
		}
	}
	
	/**
	 * Este metodo genera una notificacion (objeto de tipo Notificacion) y la env�a al ciudadano correspondiente (la almacena en una lista de Notificaciones 
	 * particular del usuario)
	 * @param p proyecto del cual debemos conocer informacion como el estado para saber que tipo de notificacion generar o los miembros y el proponente para saber a que usuarios enviar la notificacion
	 * @param motivo por el cual el administrador ha decidido rechazar el proyecto
	 */

	public void generarNotificacion(Proyecto p, String motivo) {
		Notificacion notificacion;
		int suscritos = p.getSuscritos().size();
		int i;
		FechaSimulada.restablecerHoyReal();
		
		if (p.getEstado() == EstadoProyecto.financiable) {
			notificacion = new Notificacion("El proyecto "+p.getTitulo()+" ya es financiable", FechaSimulada.getHoy(), TipoNotificacion.financiable);
			for(i = 0; i < suscritos; i++) {
				p.getSuscritos().get(i).getNotificaciones().add(notificacion);
			}
			
		}
		else if (p.getEstado() == EstadoProyecto.rechazado) {
			notificacion = new Notificacion("El proyecto "+p.getTitulo()+" ha sido rechazado.", "El motivo se indica a continuacion: "+motivo+"" ,FechaSimulada.getHoy(), TipoNotificacion.rechazado);
			p.getProponente().getNotificaciones().add(notificacion);
			
		}
		else if (p.getEstado() == EstadoProyecto.caducado) {
			notificacion = new Notificacion("El proyecto "+p.getTitulo()+" ha caducado.", motivo ,FechaSimulada.getHoy(), TipoNotificacion.caducado);
			for(i = 0; i < suscritos; i++) {
				p.getSuscritos().get(i).getNotificaciones().add(notificacion);
			}
		}
		
		return;
	}
	
	/**
	 * Este metodo devuelve el usuario de tipo Administrador de la aplicacion
	 * @return administrador administrador de la aplicacion
	 */

	public Administrador getAdministrador() {
		return administrador;
	}

	/**
	 * Este metodo cambia el usuario de tipo Administrador de la aplicacion
	 * @param administrador usuario de tipo Administrador de la aplicacion
	 */


	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	/**
	 * Este metodo devuelve la variable que nos indica si el Administrador ha sido creado
	 * @return administradorCreado Variable que nos indica si el Administrador ha sido creado
	 */

	public int getAdministradorCreado() {
		return administradorCreado;
	}

	/**
	 * Este metodo cambia la variable que nos indica si el Administrador ha sido creado
	 * @param administradorCreado variable que nos indica si el Administrador ha sido creado
	 */

	public void setAdministradorCreado(int administradorCreado) {
		this.administradorCreado = administradorCreado;
	}

	/**
	 * Este metodo cambia la lista en la que almacenamos los usuarios de tipo ciudadano que no se han registrado en la aplicacion
	 * @param cNR lista en la que almacenamos los usuarios de tipo ciudadano que no se han registrado en la aplicacion
	 */
	public void setCNR(List<CiudadanoNoRegistrado> cNR) {
		CNR = cNR;
	}

	/**
	 * Este metodo devuelve la lista en la que almacenamos los usuarios de tipo ciudadano que no se han registrado en la aplicacion
	 * @return CNR Lista en la que almacenamos los usuarios de tipo ciudadano que no se han registrado en la aplicacion
	 */

	public List<CiudadanoNoRegistrado> getCNR() {
		return CNR;
	}
	
	/**
	 * Este metodo devuelve la Lista en la que almacenamos los proyectos aceptados en la aplicacion.
	 * @return proyectosAceptados Lista en la que almacenamos los proyectos aceptados en la aplicacion.
	 */

	public List<Proyecto> getProyectosAceptados() {
		return proyectosAceptados;
	}

	/**
	 * Este metodo cambia la Lista en la que almacenamos los proyectos aceptados en la aplicacion.
	 * @param proyectosAceptados Lista en la que almacenamos los proyectos aceptados en la aplicacion.
	 */
	
	public void setProyectosAceptados(List<Proyecto> proyectosAceptados) {
		this.proyectosAceptados = proyectosAceptados;
	}
	
	/**
	 * Este metodo devuelve la Lista en la que almacenamos los proyectos pendientes de ser aceptados en la aplicacion.
	 * @return proyectosPorAceptar Lista en la que almacenamos los proyectos pendientes de ser aceptados en la aplicacion.
	 */

	public List<Proyecto> getProyectosPorAceptar() {
		return proyectosPorAceptar;
	}

	/**
	 * Este metodo cambia la Lista en la que almacenamos los proyectos pendientes de ser aceptados en la aplicacion.
	 * @param proyectosPorAceptar Lista en la que almacenamos los proyectos pendientes de ser aceptados en la aplicacion.
	 */
	

	public void setProyectosPorAceptar(List<Proyecto> proyectosPorAceptar) {
		this.proyectosPorAceptar = proyectosPorAceptar;
	}

	/**
	 * Este metodo devuelve el umbral que marca el limite de votos que debe alcanzar un proyecto para considerar su financiacion
	 * @return umbral umbral que marca el limite de votos que debe alcanzar un proyecto para considerar su financiacion
	 */

	public int getUmbral() {
		return umbral;
	}

	/**
	 * Este metodo cambia el umbral que marca el limite de votos que debe alcanzar un proyecto para considerar su financiacion
	 * @param umbral umbral que marca el limite de votos que debe alcanzar un proyecto para considerar su financiacion
	 */

	public void setUmbral(int umbral) {
		this.umbral = umbral;
	}
	
	/**
	 * Este metodo devuelve la lista de proyectos caducados
	 * @return caducados lista de proyectos caducados
	 */

	public List<Proyecto> getCaducados() {
		return caducados;
	}
	
	/**
	 * Este metodo cambia la lista de proyectos caducados
	 * @param caducados lista de proyectos caducados
	 */

	public void setCaducados(List<Proyecto> caducados) {
		this.caducados = caducados;
	}

	/**
	 * Este metodo devuelve la lista de usuarios de tipo ciudadano bloqueados
	 * @return bloqueados Lista de Usuarios de tipo Ciudadano bloqueados
	 */
	public List<Ciudadano> getBloqueados() {
		return bloqueados;
	}

	/**
	 * Este metodo modifica la lista de usuarios de tipo ciudadano bloqueados
	 * @param bloqueados Lista de Usuarios de tipo Ciudadano bloqueados
	 */
	public void setBloqueados(List<Ciudadano> bloqueados) {
		this.bloqueados = bloqueados;
	}
	
	
	
	
	
	



}

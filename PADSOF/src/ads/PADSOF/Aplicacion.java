package ads.PADSOF;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {

	public int umbral;

	static Administrador administrador;
	 
	private static int administradorCreado;
	
	private static List<CiudadanoNoRegistrado> CNR = new ArrayList<>();
	
	private static List<Ciudadano> usuariosAceptados = new ArrayList<>();

    private static List<Ciudadano> usuariosPorAceptar = new ArrayList<>();
    
    private static List<Colectivo> colectivos = new ArrayList<>();
    
    private static List<Proyecto> proyectosAceptados = new ArrayList<>();
    
    private static List<Proyecto> proyectosPorAceptar = new ArrayList<>();
    
    private static List<Proyecto> proyectos = new ArrayList<>();

	public Aplicacion(int limite) {
		umbral = limite;

	  }
	

	public static List<Ciudadano> getUsuariosAceptados() {
		return usuariosAceptados;
	}



	public static void setUsuariosAceptados(List<Ciudadano> usuariosAceptados) {
		Aplicacion.usuariosAceptados = usuariosAceptados;
	}



	public static List<Ciudadano> getUsuariosPorAceptar() {
		return usuariosPorAceptar;
	}



	public static void setUsuariosPorAceptar(List poraceptar) {
		Aplicacion.usuariosPorAceptar = poraceptar;
	}



	public static List<Colectivo> getColectivos() {
		return colectivos;
	}



	public static void setColectivos(List<Colectivo> colectivos) {
		Aplicacion.colectivos = colectivos;
	}



	public int getUmbral() {
		return umbral;
	}

	public void setUmbral(int umbral) {
		this.umbral = umbral;
	}

	public void login (String user, String contrasenia, String DNI) {

	}

	public void logout () {

	}

	public Notificacion generarNotificacion(String titulo) {
		Notificacion notificaciones = null;
		return notificaciones;
	}


	public Administrador getAdministrador() {
		return administrador;
	}


	public static void setAdministrador(Administrador administrador) {
		Aplicacion.administrador = administrador;
	}


	public static int getAdministradorCreado() {
		return administradorCreado;
	}


	public static void setAdministradorCreado(int administradorCreado) {
		Aplicacion.administradorCreado = administradorCreado;
	}

	public static void setCNR(List<CiudadanoNoRegistrado> cNR) {
		CNR = cNR;
	}


	public static List<CiudadanoNoRegistrado> getCNR() {
		return CNR;
	}


	public static List<Proyecto> getProyectosAceptados() {
		return proyectosAceptados;
	}


	public static void setProyectosAceptados(List<Proyecto> proyectosAceptados) {
		Aplicacion.proyectosAceptados = proyectosAceptados;
	}


	public static List<Proyecto> getProyectosPorAceptar() {
		return proyectosPorAceptar;
	}


	public static void setProyectosPorAceptar(List<Proyecto> proyectosPorAceptar) {
		Aplicacion.proyectosPorAceptar = proyectosPorAceptar;
	}
	
	
	
	



}

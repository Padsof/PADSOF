package ads.PADSOF;

import java.util.ArrayList;
import java.util.List;

import fechasimulada.FechaSimulada;

public class Aplicacion {

	public static int umbral;

	static Administrador administrador;
	 
	private static int administradorCreado;
	
	private static List<CiudadanoNoRegistrado> CNR = new ArrayList<>();
	
	private static List<Ciudadano> usuariosAceptados = new ArrayList<>();

    private static List<Ciudadano> usuariosPorAceptar = new ArrayList<>();
    
    private static List<Colectivo> colectivos = new ArrayList<>();
    
    private static List<Proyecto> proyectosAceptados = new ArrayList<>();
    
    private static List<Proyecto> proyectosPorAceptar = new ArrayList<>();
    
    private static List<Proyecto> proyectos = new ArrayList<>();
        
    
    public static void generarIdentificador(Proyecto p) {
    	    	
    	
    	int i = Aplicacion.getProyectosAceptados().size();
    	p.setCodigo(i);
    	

    }
    
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


	public void login (String user, String contrasenia, String DNI) {

	}

	public void logout () {

	}

	public static void generarNotificacion(String titulo, Ciudadano c, Proyecto p) {
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
		
		return;
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


	public static int getUmbral() {
		return umbral;
	}


	public static void setUmbral(int umbral) {
		Aplicacion.umbral = umbral;
	}
	
	
	
	



}

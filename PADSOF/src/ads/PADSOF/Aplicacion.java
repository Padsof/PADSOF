package ads.PADSOF;

import java.util.ArrayList;
import java.util.List;

public class Aplicacion {

	public int umbral;

	private static List<Ciudadano> usuariosAceptados = new ArrayList<>();

    private static List<Ciudadano> usuariosPorAceptar = new ArrayList<>();
    
    private static List<Colectivo> colectivos = new ArrayList<>();
    
    private static List<Proyecto> proyectosAceptados = new ArrayList<>();
    
    private static List<Proyecto> proyectosPorAceptar = new ArrayList<>();

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



	public static void setUsuariosPorAceptar(List<Ciudadano> usuariosPorAceptar) {
		Aplicacion.usuariosPorAceptar = usuariosPorAceptar;
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

	public void login (String user, String contrasenia) {

	}

	public void logout () {

	}

	public Notificacion generarNotificacion(String titulo) {
		Notificacion notificaciones = null;
		return notificaciones;
	}



}

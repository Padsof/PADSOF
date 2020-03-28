package test;

import static org.junit.Assert.*; 
import org.junit.Test;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import ads.PADSOF.Colectivo;
import ads.PADSOF.EstadoProyecto;
import ads.PADSOF.Notificacion;
import ads.PADSOF.PoySocial;
import ads.PADSOF.Proyecto;
import ads.PADSOF.TipoNotificacion;
import ads.PADSOF.Usuario;
import fechasimulada.FechaSimulada;

import org.junit.Before;

public class CiudadanoTest {

	private Ciudadano ciudadano;

	
	@Before
	public void setUp() throws Exception {
		ciudadano = new Ciudadano("Javier", "Contraseña", "02298366E");
	}
	
	@Test
	public void testAceptarUsuario(){
						
		ciudadano.aceptarUsuario(ciudadano);
				
		assertEquals(1, Aplicacion.getUsuariosAceptados().size());
				
		assertEquals(1, Aplicacion.getUsuariosPorAceptar().size()); 

	}

	
	@Test
	public void testRechazarUsuario(){
		
		Aplicacion.getUsuariosPorAceptar().remove(Aplicacion.getUsuariosPorAceptar().get(0)); 
		
		Aplicacion.getUsuariosPorAceptar().remove(ciudadano);
								
		ciudadano.rechazarUsuario(ciudadano);	
				
		assertEquals(1, Aplicacion.getUsuariosPorAceptar().size()); 
		
	}
	
	@Test
	public void testCrearColectivo(){
				
		ciudadano.crearColectivo("Coronavirus");
		
		
		assertEquals(1, ciudadano.getColectivos().size()); //Comprueba que se ha incluido la asociacion
		assertTrue(((Ciudadano) ciudadano).isRepresentanteProyecto()); //Comprueba que el ciudadano es representante
		assertEquals(1, Aplicacion.getColectivos().size()); 

	}
	
	@Test
	public void testeliminarNotificacion(){
		
		FechaSimulada.restablecerHoyReal();
		
		Notificacion n = new Notificacion("test", FechaSimulada.getHoy(), TipoNotificacion.aceptado);
		
		ciudadano.getNotificaciones().add(n);
		
		ciudadano.eliminarNotificacion(n);
		
		assertEquals(0, ciudadano.getNotificaciones().size()); 

		
	}
	
	@Test
	public void testleerNotificacion(){
		
		FechaSimulada.restablecerHoyReal();
		
		Notificacion n = new Notificacion("test", FechaSimulada.getHoy(), TipoNotificacion.aceptado);
		
		ciudadano.getNotificaciones().add(n);
		
		ciudadano.leerNotificacion(n);
		
		assertEquals(0, ciudadano.getNotificaciones().size()); 
		assertEquals(1, ciudadano.getNotificacionesLeidas().size()); 

		
	}
	
	@Test
	public void testproponerProyecto(){
		
		FechaSimulada.restablecerHoyReal();
		
		ciudadano.proponerProyecto("test", "test", 1000, EstadoProyecto.aceptado, "Social", "gente", true, null);
		
		Aplicacion.getProyectosPorAceptar().remove(Aplicacion.getProyectosPorAceptar().get(0));
		
		assertEquals(1, Aplicacion.getProyectosPorAceptar().size()); 
		assertEquals(1, ciudadano.getSuscrito().size()); 

	}
	
	@Test
	public void testinformePopularidad(){
		
		FechaSimulada.restablecerHoyReal();
		
		Proyecto proyecto = new PoySocial("Test", "test", ciudadano, 1000, FechaSimulada.getHoy(), EstadoProyecto.financiable, null, false);
		
		ciudadano.getVotoIndividual().add(proyecto);
		
		boolean bool = ciudadano.informePopularidad(proyecto);
		
		assertTrue(bool);

	}
	
	@Test
	public void testinformeAfinidad(){
		
		boolean bool;
		Colectivo uno = new Colectivo("test1", ciudadano);
		Colectivo dos = new Colectivo("test2", ciudadano);
		Proyecto proyecto = new PoySocial("Test", "test", ciudadano, 1000, FechaSimulada.getHoy(), EstadoProyecto.financiable, null, false);
		Proyecto proyecto2 = new PoySocial("Test", "test", ciudadano, 1000, FechaSimulada.getHoy(), EstadoProyecto.financiable, null, false);

		ciudadano.getMiembro().add(uno);
		ciudadano.getMiembro().add(dos);
		uno.agregarMiembro(ciudadano);
		dos.agregarMiembro(ciudadano);
		uno.getProyectos().add(proyecto);
		dos.getProyectos().add(proyecto2);
		uno.getVotoColectivo().add(proyecto2);
		dos.getVotoColectivo().add(proyecto);
		
		bool = ciudadano.informeAfinidad(uno, dos);

		assertTrue(bool);


	}


	
}

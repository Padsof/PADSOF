package test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import ads.PADSOF.EstadoProyecto;
import ads.PADSOF.PoySocial;
import ads.PADSOF.Proyecto;
import fechasimulada.FechaSimulada;

public class AplicacionTest {

	
	Aplicacion aplicacion;
	
	@Before
	public void setUp() throws Exception {
		aplicacion = new Aplicacion(5);
	}
	
	@Test
	public void testgenerarIdentificador(){
		
		FechaSimulada.restablecerHoyReal();
		
		Ciudadano ciudadano = new Ciudadano("Javier", "Contraseña", "02297366E");
		
		Proyecto proyecto = new PoySocial("Test", "test", ciudadano, 1000, FechaSimulada.getHoy(), EstadoProyecto.financiable, null, false);
				
		Aplicacion.generarIdentificador(proyecto);
		
		assertEquals(0, proyecto.getCodigo());
	}
	
	@Test
	public void testgenerarNotificacion(){
		
		FechaSimulada.restablecerHoyReal();
		
		Ciudadano ciudadano = new Ciudadano("Javier", "Contraseña", "02298366E");
		
		Proyecto proyecto = new PoySocial("Test", "test", ciudadano, 1000, FechaSimulada.getHoy(), EstadoProyecto.financiable, null, false);
		
		proyecto.suscribir(ciudadano);
		
		proyecto.setEstado(EstadoProyecto.financiable);
				
		Aplicacion.generarNotificacion(proyecto, "");
				
		assertEquals(1, ciudadano.getNotificaciones().size());
	}
}

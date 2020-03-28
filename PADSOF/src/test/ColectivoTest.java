package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import ads.PADSOF.Colectivo;
import ads.PADSOF.EstadoProyecto;
import ads.PADSOF.PoySocial;
import ads.PADSOF.Proyecto;
import fechasimulada.FechaSimulada;

public class ColectivoTest {

	private Colectivo colectivo;
	private Ciudadano ciudadano = new Ciudadano("Javier", "Contraseña", "02298366E");
	private Ciudadano ciudadano2 = new Ciudadano("Pero", "Contraseña", "02294466E");
	

	
	@Before
	public void setUp() throws Exception {
		colectivo = new Colectivo("test", ciudadano);

	}
	
	@Test
	public void testagregarMiembro(){
						
		colectivo.agregarMiembro(ciudadano2);
		
		assertEquals(1, colectivo.getNumMiembros());
		
		assertEquals(1, colectivo.getMiembros().size());
		
		assertEquals(1, ciudadano2.getMiembro().size());


	}
	
	@Test
	public void testquitarMiembro(){
						
		colectivo.agregarMiembro(ciudadano2);
		
		colectivo.quitarMiembro(ciudadano2);
		
		assertEquals(0, colectivo.getNumMiembros());
		
		assertEquals(0, colectivo.getMiembros().size());
		
		assertEquals(0, ciudadano2.getMiembro().size());


	}
	
	@Test
	public void testproponerProyecto(){
		
		FechaSimulada.restablecerHoyReal();
		
		colectivo.proponerProyecto("test", "test", 1000, EstadoProyecto.aceptado, "Social", "gente", true, null);
		
		Aplicacion.getProyectosPorAceptar().remove(Aplicacion.getProyectosPorAceptar().get(0));
		
		assertEquals(1, Aplicacion.getProyectosPorAceptar().size()); 
		assertEquals(1, colectivo.getRepresentante().getSuscrito().size()); 
		assertEquals(1, colectivo.getProyectos().size()); 

	}
	
	@Test
	public void testinformePopularidad(){
		
		FechaSimulada.restablecerHoyReal();
		
		Proyecto proyecto = new PoySocial("Test", "test", ciudadano, 1000, FechaSimulada.getHoy(), EstadoProyecto.financiable, null, false);
		
		colectivo.getVotoColectivo().add(proyecto);
		
		boolean bool = colectivo.informePopularidad(proyecto);
		
		assertTrue(bool);

	}
	
	@Test
	public void testañadirColectivoHijo(){
		
		Colectivo colectivo2 = new Colectivo("test", ciudadano);
		
		colectivo.añadirColectivoHijo(colectivo2);
		
		assertTrue(colectivo2.isHijo());

		assertEquals(1, colectivo.getHijos().size()); 


	}
	
	
}

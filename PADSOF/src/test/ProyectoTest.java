package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import ads.PADSOF.Colectivo;
import ads.PADSOF.EstadoProyecto;
import ads.PADSOF.Notificacion;
import ads.PADSOF.PoySocial;
import ads.PADSOF.Proyecto;
import ads.PADSOF.TipoNotificacion;
import fechasimulada.FechaSimulada;

public class ProyectoTest { //AMBAS CLASES DE PROYECTOS TIENEN LAS MISMAS FUNCIONES Y EL FUNCIONAMIENTO ES EL MISMO
							//TOMAMOS SOLO UNA CLASE DE PROYECTO

	private Proyecto proyecto;
	private Proyecto proyecto2;
	private Ciudadano ciudadano = new Ciudadano("Javier", "Contraseña", "02298366E");


	@Before
	public void setUp() throws Exception {
		
		FechaSimulada.restablecerHoyReal();

		proyecto = new PoySocial("test", "test", ciudadano, 100, FechaSimulada.getHoy(), EstadoProyecto.poraceptar, "alumnos", true);

	}
	
	@Test
	public void testvotarProyecto(){
		
		Ciudadano ciudadano2 = new Ciudadano("Pedro", "Contraseña", "01298366E");
		
		proyecto.votarProyecto(ciudadano2);

		assertEquals(1, proyecto.getVotos().size()); 
		assertEquals(1, ciudadano2.getVotado().size()); 
		assertEquals(1, ciudadano2.getVotoIndividual().size()); 
		assertEquals(1, proyecto.getnVotos()); 


	}
	
	@Test
	public void testvotarProyectoColectivo(){
		
		Ciudadano ciudadano2 = new Ciudadano("Pedro", "Contraseña", "01298366E");
		
		Ciudadano ciudadano3 = new Ciudadano("Alonso", "Contraseña", "01298346E");
		
		Colectivo colectivo = new Colectivo("test", ciudadano2);
		
		colectivo.getMiembros().add(ciudadano3);

		colectivo.setNumMiembros(1);	
		
		proyecto.votarProyectoColectivo(colectivo);

		assertEquals(1, proyecto.getVotos().size()); 
		assertEquals(1, colectivo.getMiembros().get(0).getVotado().size()); 
		assertEquals(1, proyecto.getnVotos()); 


	}
	
	@Test
	public void testsuscribir(){
		
		Ciudadano ciudadano2 = new Ciudadano("Pedro", "Contraseña", "01298366E");
		
		proyecto.suscribir(ciudadano2);

		assertEquals(2, proyecto.getSuscritos().size()); //TAMBIEN ESTA SUSCRITO EL PROPONENTE


	}
	
	@Test
	public void testdesuscribir(){
		
		Ciudadano ciudadano2 = new Ciudadano("Pedro", "Contraseña", "01298366E");
		
		proyecto.suscribir(ciudadano2);
		
		proyecto.desuscribir(ciudadano2);

		assertEquals(1, proyecto.getSuscritos().size()); //TAMBIEN ESTA SUSCRITO EL PROPONENTE


	}
	
	@Test
	public void testestadoFinanciable(){
		
		boolean bool = proyecto.estadoFinanciable();

		assertTrue(bool);

	}
	
	@Test
	public void testaceptarProyecto(){
		
		Aplicacion.getProyectosPorAceptar().remove(Aplicacion.getProyectosPorAceptar().get(0));

		boolean bool = proyecto.aceptarProyecto();

		assertTrue(bool);
		
		assertEquals(0, Aplicacion.getProyectosPorAceptar().size());

		assertEquals(1, Aplicacion.getProyectosAceptados().size());


	}
	
	@Test
	public void testrechazarProyectoUsuario(){
		
       //TENEMOS QUE BORRAR TODOS LOS PROYECTOS CREADOS ANTERIORMENTE PARA QUE NO INFLUYAN EN EL RESULTADO
	   //HAY 5 PROYECTOS CREADOS. BORRAMOS CUATRO PARA DEJAR SOLO UNO EN LA LISTA
		
		Aplicacion.getProyectosPorAceptar().remove(Aplicacion.getProyectosPorAceptar().get(0));

		Aplicacion.getProyectosPorAceptar().remove(Aplicacion.getProyectosPorAceptar().get(0));

		Aplicacion.getProyectosPorAceptar().remove(Aplicacion.getProyectosPorAceptar().get(0));

				
		boolean bool = proyecto.rechazarProyectoUsuario(ciudadano, "test");
		
		assertTrue(bool);
		
		assertEquals(0, ciudadano.getProyectos().size());

		assertEquals(0, Aplicacion.getProyectosPorAceptar().size());


	}
	
	@Test
	public void testrechazarProyectoColectivo(){
		
		Aplicacion.getProyectosPorAceptar().remove(Aplicacion.getProyectosPorAceptar().get(0));

		Aplicacion.getProyectosPorAceptar().remove(Aplicacion.getProyectosPorAceptar().get(0));
		
		Colectivo colectivo = new Colectivo("test", ciudadano);
				
		boolean bool = proyecto.rechazarProyectoColectivo(colectivo, "test");
		
		assertTrue(bool);
		
		assertEquals(0, colectivo.getProyectos().size());
		
		assertEquals(0, Aplicacion.getProyectosPorAceptar().size());


	}
	

}

package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ads.PADSOF.Administrador;
import ads.PADSOF.Aplicacion;
import ads.PADSOF.Ciudadano;
import ads.PADSOF.EstadoProyecto;
import ads.PADSOF.PoySocial;
import ads.PADSOF.Proyecto;
import fechasimulada.FechaSimulada;

public class AdministradorTest {

	Administrador administrador;
	
	@Before
	public void setUp() throws Exception {
		administrador = new Administrador("Javier", "Contraseña", null);
	}
	
	@Test
	public void testbloquearUsuario(){
				
		Ciudadano ciudadano = new Ciudadano("Javier", "Contraseña", "02298366E");
		
		Proyecto proyecto = new PoySocial("Test", "test", ciudadano, 1000, FechaSimulada.getHoy(), EstadoProyecto.financiable, null, false);
		
		ciudadano.getVotado().add(proyecto);
		ciudadano.getVotoIndividual().add(proyecto);
		proyecto.setnVotos(1);
		ciudadano.getVotado().get(0).getVotos().add(ciudadano);
				
		administrador.bloquearUsuario(ciudadano);

		assertTrue(ciudadano.isBloqueado());
		assertEquals(0, ciudadano.getVotado().size());
		assertEquals(0, ciudadano.getVotoIndividual().size());
		assertEquals(0, proyecto.getnVotos());

	}
	
	@Test
	public void testdesbloquearUsuario(){
				
		Ciudadano ciudadano = new Ciudadano("Javier", "Contraseña", "02298366E");

		administrador.desbloquearUsuario(ciudadano);

		assertFalse(ciudadano.isBloqueado());

	}
	
	@Test
	public void testlimiteVotos(){
				
		administrador.limiteVotos(5);

		assertEquals(5, Aplicacion.getUmbral() );

	}
	
	
	

}

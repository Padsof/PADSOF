package ads.PADSOF;

import static org.junit.Assert.*; 
import org.junit.Test; 
import org.junit.Before;

public class CiudadanoTest {

	Usuario ciudadano;
	
	@Before
	public void setUp() throws Exception {
		ciudadano = new Ciudadano("Javier", "Contraseña", "02298366E");
	}
	
	@Test
	public void testCrearColectivo(){
				
		((Ciudadano) ciudadano).crearColectivo("Coronavirus");
		
		
		assertEquals(1, ciudadano.getColectivos().size()); //Comprueba que se ha incluido la asociacion
		assertTrue(ciudadano.isRepresentanteProyecto()); //Comprueba que el ciudadano es representante
		assertEquals(1, Aplicacion.getColectivos().size()); 

	}
	
	@Test
	public void testAceptarUsuario(){
				
		((Ciudadano) ciudadano).aceptarUsuario((Ciudadano) ciudadano);
				
		assertEquals(1, Aplicacion.getUsuariosAceptados().size());
		
		assertEquals(0, Aplicacion.getUsuariosPorAceptar().size()); 

	}
	

	@Test
	public void testRechazarUsuario(){
		
		Aplicacion.getUsuariosPorAceptar().remove(ciudadano);
								
		((Ciudadano) ciudadano).rechazarUsuario(ciudadano);	
				
		assertEquals(0, Aplicacion.getUsuariosPorAceptar().size()); 
		
		//assertNull(ciudadano);

	}
	
	@Test
	public void testBloquearUsuario() {
				
		ciudadano.bloquearUsuario();
		
		Aplicacion.getUsuariosPorAceptar().remove(ciudadano);
		
		assertTrue(ciudadano.isBloqueado());
	}
	
	@Test
	public void testDesbloquearUsuario() {
				
		ciudadano.desbloquearUsuario();
		
		Aplicacion.getUsuariosPorAceptar().remove(ciudadano);
		
		assertFalse(ciudadano.isBloqueado());

	}

}

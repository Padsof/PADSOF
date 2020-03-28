package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.CiudadanoNoRegistrado;


public class CiudadanoNoRegistradoTest {

private CiudadanoNoRegistrado CNR;
private CiudadanoNoRegistrado CNR2;


	
	@Before
	public void setUp() throws Exception {
		CNR = new CiudadanoNoRegistrado("Javier", "Contraseña", "02298366E");
		CNR2 = new CiudadanoNoRegistrado("Pedro","Contraseña", null );


	}
	
	@Test
	public void testRegistrarse(){
		
		
		CNR2.Registrarse(CNR2.getNombre(),CNR2.getcontrasenia(), CNR2.getDNI() );
		
		assertEquals(1, Aplicacion.getAdministradorCreado());
		assertEquals(1, Aplicacion.getCNR().size());
		
		CNR.Registrarse(CNR.getNombre(),CNR.getcontrasenia(), CNR.getDNI() );

		assertEquals(0, Aplicacion.getCNR().size());
		assertEquals(1, Aplicacion.getUsuariosPorAceptar().size());


	}

}

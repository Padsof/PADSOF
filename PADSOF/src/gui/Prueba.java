package gui;

import java.awt.*;

import ads.PADSOF.*;
import gui.control.*;
import gui.mainform.*;
public class Prueba {

public static void main(String[] args) {
	
	EventQueue.invokeLater(new Runnable() {
		
		public void run() {
			
			CiudadanoNoRegistrado CiuAuxiliar;
			Administrador administrador = new Administrador("Javier", "contraseña", null); //ADMINISTRADOR AUXILIAR
			Ciudadano ciudadano, ciudadano2 = null;
			String[] nombres = {"Quique", "Alicia", "Daniel", "Irene", "Rosa"};
			String[] DNIS = {"12345678Q", "12345678A", "12345678D", "12345678I", "12345678R"};
			String[]contrasenias = {"ContraseñaQ", "ContraseñaA", "ContraseñaD", "ContraseñaI", "ContraseñaR"};
			int numero = 5;
			int i;
			
			for (i = 0;i < numero; i++) {
				CiuAuxiliar = new CiudadanoNoRegistrado (nombres[i], contrasenias[i], DNIS[i]);
				CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());

			}
			
			ciudadano = Aplicacion.getUsuariosPorAceptar().get(0);
			ciudadano.aceptarUsuario(ciudadano);
			
			administrador.bloquearUsuario(Aplicacion.getUsuariosAceptados().get(0), "Te bloqueo porque me da la gana");
			administrador.desbloquearUsuario(Aplicacion.getBloqueados().get(0));
			
			CiuAuxiliar = new CiudadanoNoRegistrado ("2020", "Apocalipsis", "02298366E");
			CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
			
			int tam = Aplicacion.getUsuariosPorAceptar().size();
			
			for(i = 0; i < tam; i++) {
				if(Aplicacion.getUsuariosPorAceptar().get(i).getNombre().equals("2020")) {
					ciudadano2 = Aplicacion.getUsuariosPorAceptar().get(i);
					System.out.println("hola");
				}
			}
			
			ciudadano2.aceptarUsuario(ciudadano2);
						
			ciudadano = Aplicacion.getUsuariosAceptados().get(0);
			
			ciudadano.crearColectivo("Sufridores de los vecinos que ponen musica a las 20:00");
		
			Ventana frame = new Ventana();
			//RegistroFrame frameR = new RegistroFrame();
			//UsuarioFrame frameU = new UsuarioFrame(ciudadano);
			BusquedaFrame frameB = new BusquedaFrame();
			ProyectosCreadosFrame framePC = new ProyectosCreadosFrame();
			ProyectoFrame frameP = new ProyectoFrame();
			CrearProyectoFrame frameCP = new CrearProyectoFrame();
			MenuProyectosFrame frameMP = new MenuProyectosFrame();
			//AsociacionFrame frameA = new AsociacionFrame();
			CrearAsociacionFrame frameCA = new CrearAsociacionFrame();
			AsociacionesCreadasFrame frameAC = new AsociacionesCreadasFrame();
			MenuAsociacionFrame frameMA = new MenuAsociacionFrame();
			//PerfilAdministradorFrame framePAd = new PerfilAdministradorFrame();
			AdministradorAceptarFrame frameAA = new AdministradorAceptarFrame();
			//AdministradorUsuarioFrame frameAU = new AdministradorUsuarioFrame();
			
			
			ControladorRegistrate controladorR = new ControladorRegistrate(frame);
			
			//ControladorVolver controladorV = new ControladorVolver(frame, frameR);
			ControladorIniciarSesion controladorIS = new ControladorIniciarSesion(frame);
			
			
			//ControladorAceptarAdministrador controladorAA = new ControladorAceptarAdministrador(framePAd, frameAA);
			//ControladorAdministradorUsuario controladorAU = new ControladorAdministradorUsuario(frameAA);
			//ControladorAceptarUsuario controladorAus = new ControladorAceptarUsuario(frameAA, frameAU);
			//ControladorRechazarUsuario controladorRU = new ControladorRechazarUsuario(frameAA, frameAU);
			//ControladorBloquearUsuario controladorBU = new ControladorBloquearUsuario(frameAA, frameAU);
			//ControladorDesbloquearUsuario controladorDBU = new ControladorDesbloquearUsuario(frameAA, frameAU);

			
			frame.setControladorIniciarSesion(controladorIS);
			frame.setControladorRegistrar(controladorR);
			
			
			//frameR.setControladorVolver(controladorV);
			
			//framePAd.setControladorAceptarUsuario(controladorAA);

			//frameAA.setControladorAdministradorUsuario(controladorAU);
			
			/*frameAU.setControladorAceptarUsuario(controladorAus);
			frameAU.setControladorRechazarUsuario(controladorRU);
			frameAU.setControladorBloquearUsuario(controladorBU);
			frameAU.setControladorDesbloquearUsuario(controladorDBU);*/
			
			
			
			
			frame.setVisible(true);
		
		}
		
	});
			
	}
}

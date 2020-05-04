package ads.PADSOF;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fechasimulada.FechaSimulada;

public class Prueba {
	
	public static void main(String[] args) {
		
		CiudadanoNoRegistrado CiuAuxiliar;
		Ciudadano ciudadano;
		Administrador administrador;
		Colectivo ColAuxiliar;
		Proyecto proyecto;
		List<String> distrito = new ArrayList<>();
		distrito.add("Usera");
		distrito.add("Estrecho");
		Aplicacion aplicacion = new Aplicacion (5);
		
		
		int numero = 5; //COMENZAMOS TRABAJANDO CON 5 USUARIOS
		int i;
		String[] nombres = {"Quique", "Alicia", "Dani", "Irene", "Rosa"};
		String[] contrasenias = {"CQ", "CA", "CD", "CI", "CR"};
		String[] DNIS = {"12345678Q", "12345678A", "12345678D", "12345678I", "12345678R"};
		String[]nombreColectivo = {"CQ", "CA", "CD", "CI", "CR"};
		String[]nombreColectivoHijo = {"CQH", "CAH", "CDH", "CIH", "CRH"};
		String[]identificadorAdministrador = {"Javier", "contrase�a"}; //IDENTIFICADOR DE ADMINISTRADOR usuario y contrase�a predefinidos y no modificables.
		
		
		//CREAMOS UN ADMINISTRADOR PARA LA APLICACION
		CiuAuxiliar = new CiudadanoNoRegistrado (identificadorAdministrador[0], identificadorAdministrador[1], null);
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		System.out.println(Aplicacion.getAdministrador());
		//INTENTAMOS INTRODUCIR UN NUEVO ADMINISTRADOR
		CiuAuxiliar = new CiudadanoNoRegistrado ("Ciro", "contrase�a", null);
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		System.out.println(Aplicacion.getAdministrador());
		
		System.out.println(" ");
		//INTRODUCIMOS EN EL SISTEMA LOS NUEVOS USUARIOS (USUARIOS NO ACEPTADOS)
		for (i = 0;i < numero; i++) {
			CiuAuxiliar = new CiudadanoNoRegistrado (nombres[i], contrasenias[i], DNIS[i]);
			CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
			System.out.println(Aplicacion.getUsuariosPorAceptar().get(i));

		}
		
		System.out.println(" ");
		//INTRODUCIMOS EN EL SISTEMA NUEVOS USUARIOS CON NOMBRES, DNI REPETIDOS Y NO VALIDOS (NO ES POSIBLE)
		CiuAuxiliar = new CiudadanoNoRegistrado ("Quique", "contra", "12345678q");
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		CiuAuxiliar = new CiudadanoNoRegistrado ("Jorge", "contra", "12345678Q");
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		CiuAuxiliar = new CiudadanoNoRegistrado ("Jorge", "contra", "1");
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		
		System.out.println(" ");
		//ACEPTAMOS LOS USUARIOS
		numero = Aplicacion.getUsuariosPorAceptar().size();
		System.out.println("Numero de Usuarios por aceptar: "+numero+"");
		System.out.println("Numero de Usuarios aceptados: "+Aplicacion.getUsuariosAceptados().size()+"");
		
		for (i = 0; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosPorAceptar().get(0);
			ciudadano.aceptarUsuario(ciudadano);
		}
		
		System.out.println("Numero de Usuarios por aceptar: "+Aplicacion.getUsuariosPorAceptar().size()+"");
		System.out.println("Numero de Usuarios aceptados: "+Aplicacion.getUsuariosAceptados().size()+"");
		numero = Aplicacion.getUsuariosAceptados().size();
		System.out.println(" ");

		//USUARIOS ACEPTADOS
		for (i = 0;i < numero; i++) {
			System.out.println(Aplicacion.getUsuariosAceptados().get(i));
		}
		
		System.out.println(" ");
		
		
		//RECHAZAMOS USUARIOS
		CiuAuxiliar = new CiudadanoNoRegistrado ("Pedro", "Pablo", "12305678q");
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		System.out.println(Aplicacion.getUsuariosPorAceptar());
		ciudadano = Aplicacion.getUsuariosPorAceptar().get(0);
		ciudadano.rechazarUsuario(ciudadano);
		System.out.println(Aplicacion.getUsuariosPorAceptar());

		System.out.println(" ");

		//CADA USUARIO CREAR� UN COLECTIVO
		for (i = 0;i < numero; i++) {
			Aplicacion.getUsuariosAceptados().get(i).crearColectivo(nombreColectivo[i]);
		}
		
		//COLECTIVOS CREADOS
		for (i = 0;i < numero; i++) {
			System.out.println(Aplicacion.getColectivos().get(i));
		}
		System.out.println(" ");
		
		//CREAMOS UN NUEVO COLECTIVO PARA UNO DE LOS USUARIOS
		Aplicacion.getUsuariosAceptados().get(0).crearColectivo("CQ2");
		
		//COLECTIVOS CREADOS
		numero = Aplicacion.getColectivos().size();
		for (i = 0;i < numero; i++) {
			System.out.println(Aplicacion.getColectivos().get(i));
		}
		System.out.println(" ");
		
		
		
		
		
		Aplicacion.logout();
		
	
		
		Aplicacion.login("Quique", "CQ");
		
		
		
		
		
		
		
		
		
		
		
		
		//UN USUARIO PUEDE TENER SER REPRESENTANTE DE MAS DE UN COLECTIVO
		System.out.println(Aplicacion.getUsuariosAceptados().get(0).getColectivos());
		System.out.println(" ");

		//NO PUEDE HABER DOS COLECTIVOS CON EL MISMO NOMBRE 
		//INTRODUCIMOS EN EL SISTEMA NUEVOS COLECTIVOS CON UN MISMO NOMBRE (NO ES POSIBLE)
		Aplicacion.getUsuariosAceptados().get(0).crearColectivo("CQ2");
		System.out.println(" ");

		
		//CREAMOS COLECTIVOS HIJOS (IGUAL NO SE PUEDEN CREAR SI EL NOMBRE ESTA REPETIDO)

		ColAuxiliar = Aplicacion.getUsuariosAceptados().get(0).crearColectivo(nombreColectivoHijo[0]);
		Aplicacion.getUsuariosAceptados().get(0).getColectivos().get(0).aniadirColectivoHijo(ColAuxiliar);
		ColAuxiliar = Aplicacion.getUsuariosAceptados().get(0).crearColectivo("CQH2");
		Aplicacion.getUsuariosAceptados().get(0).getColectivos().get(0).aniadirColectivoHijo(ColAuxiliar);

		System.out.println(Aplicacion.getUsuariosAceptados().get(0).getColectivos().get(0).getHijos()); 
		System.out.println(Aplicacion.getUsuariosAceptados().get(0).getColectivos());
		System.out.println(Aplicacion.getUsuariosAceptados().get(0).getColectivos().get(1).getHijos());
		
		ColAuxiliar = Aplicacion.getUsuariosAceptados().get(1).crearColectivo(nombreColectivoHijo[1]);
		Aplicacion.getUsuariosAceptados().get(1).getColectivos().get(0).aniadirColectivoHijo(ColAuxiliar);

		System.out.println(Aplicacion.getUsuariosAceptados().get(1).getColectivos().get(0).getHijos()); 
		System.out.println(Aplicacion.getUsuariosAceptados().get(1).getColectivos());
		
		ColAuxiliar = Aplicacion.getUsuariosAceptados().get(0).crearColectivo(nombreColectivoHijo[0]); //NO SE VA A PODER CREAR
		
		System.out.println(" ");
		
		//METEMOS MIEMBROS EN LOS DIFERENTES COLECTIVOS
		numero = Aplicacion.getUsuariosAceptados().size();
		
		
		for (i = 1; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosAceptados().get(i); //EL PRIMER CIUDADANO ES REPRESENTANTE DEL COLECTIVO (NO SE A�ADE)
			Aplicacion.getColectivos().get(0).agregarMiembro(ciudadano);
		}
		
		System.out.println("Miembros del colectivo: "+Aplicacion.getColectivos().get(0)+"");
		System.out.println(Aplicacion.getColectivos().get(0).getMiembros());
		System.out.println(" ");

				
		for (i = 0; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosAceptados().get(i); //EL PRIMER CIUDADANO ES REPRESENTANTE DEL COLECTIVO (NO SE A�ADE)
																  //EL RESTO DE CIUDADANOS YA ESTAN INCLUIDOS EN EL COLECTIVO (NO SE A�ADEN)
			Aplicacion.getColectivos().get(0).agregarMiembro(ciudadano);
		}
		
		System.out.println(" ");

		
		for (i = 0; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosAceptados().get(i);  //LOS CIUDADANOS YA ESTAN INCLUIDOS EN EL COLECTIVO PADRE (NO SE A�ADEN)
			Aplicacion.getColectivos().get(0).getHijos().get(0).agregarMiembro(ciudadano);
		}
		
		System.out.println(" ");
		
		//LOS CIUDADANOS SE UNEN AL COLECTIVO DEL HIJO DE UNO DE LOS MIEMBROS SIN PERTENECER AL COLECTIVO PADRE
		//NO ESTAN INCLUIDOS EN EL COLECTIVO PADRE (SE A�ADEN)
		for (i = 0; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosAceptados().get(i); //EL PRIMER CIUDADANO ES REPRESENTANTE DEL COLECTIVO (NO SE A�ADE)
			Aplicacion.getColectivos().get(1).getHijos().get(0).agregarMiembro(ciudadano);
		}
		System.out.println(" ");

		
		for (i = 0; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosAceptados().get(i);  //LOS CIUDADANOS YA ESTAN INCLUIDOS EN EL COLECTIVO HIJO (NO SE A�ADEN)
			Aplicacion.getColectivos().get(1).agregarMiembro(ciudadano);
		}

		System.out.println("Miembros del colectivo: "+Aplicacion.getColectivos().get(1).getHijos().get(0)+"");
		System.out.println(Aplicacion.getColectivos().get(1).getHijos().get(0).getMiembros());
		System.out.println("Miembros del colectivo: "+Aplicacion.getColectivos().get(1)+"");
		System.out.println(Aplicacion.getColectivos().get(1).getMiembros());
		System.out.println(" ");	

		//BORRAMOS LOS MIEMBROS DEL COLECTIVO HIJO
		for (i = 0; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosAceptados().get(i); //EL PRIMER CIUDADANO ES REPRESENTANTE DEL COLECTIVO (NO SE A�ADE)
			Aplicacion.getColectivos().get(1).getHijos().get(0).quitarMiembro(ciudadano);
		}
		System.out.println("Miembros del colectivo: "+Aplicacion.getColectivos().get(1).getHijos().get(0)+"");
		System.out.println(Aplicacion.getColectivos().get(1).getHijos().get(0).getMiembros());
		System.out.println(" ");	

		//LOS A�ADIMOS DE NUEVO. VAMOS A NECESITARLOS MAS ADELANTE
		
		for (i = 0; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosAceptados().get(i); //EL PRIMER CIUDADANO ES REPRESENTANTE DEL COLECTIVO (NO SE A�ADE)
			Aplicacion.getColectivos().get(1).getHijos().get(0).agregarMiembro(ciudadano);
		}
		
		//CREAMOS PROYECTOS
		
		System.out.println("Creamos un proyecto social");

		ciudadano = Aplicacion.getUsuariosAceptados().get(0);
		ciudadano.proponerProyecto("Coronavirus", "Recaudar dinero", 1000, EstadoProyecto.poraceptar, "Social", "Infectados", true, null);
		
		System.out.println(Aplicacion.getProyectosPorAceptar());
		
		proyecto = Aplicacion.getProyectosPorAceptar().get(0);
		
		proyecto.aceptarProyecto();
		
		System.out.println(Aplicacion.getProyectosAceptados().get(0));
		System.out.println(Aplicacion.getProyectosAceptados().get(0).getCaracter());
		System.out.println(" ");	

		System.out.println("Creamos un proyecto de Infraestructura");
		ciudadano = Aplicacion.getUsuariosAceptados().get(0);
		ciudadano.proponerProyecto("Hospitales", "Espa�a se va a la mierda", 1000, EstadoProyecto.poraceptar, "Infraestructura", "que mas da", true, distrito);

		System.out.println(Aplicacion.getProyectosPorAceptar());
		proyecto = Aplicacion.getProyectosPorAceptar().get(0);
		
		proyecto.aceptarProyecto();
		
		System.out.println(Aplicacion.getProyectosAceptados().get(1));
		System.out.println(Aplicacion.getProyectosAceptados().get(1).getDistrito());
		System.out.println(" ");	

		
		//NOMBRE DE PROYECTO (MAX 50 CARACTERERES) DESCRIPCION (MAX 500 CARACTERES)
		
		ciudadano = Aplicacion.getUsuariosAceptados().get(0);
		ciudadano.proponerProyecto("qwertyuiopasdfghjkl�zxcvbn", "Recaudar dinero", 1000, EstadoProyecto.poraceptar, "Social", "Infectados", true, null);
		System.out.println(" ");	

		//RECHAZAMOS PROYECTO
		
		ciudadano = Aplicacion.getUsuariosAceptados().get(0);
		ciudadano.proponerProyecto("Coronavirus", "Recaudar dinero", 1000, EstadoProyecto.poraceptar, "Social", "Infectados", true, null);
		
		System.out.println(Aplicacion.getProyectosPorAceptar());
		
		proyecto = Aplicacion.getProyectosPorAceptar().get(0);
		
		proyecto.rechazarProyectoUsuario(ciudadano, "No se considera apropiado");
		
		System.out.println(Aplicacion.getProyectosPorAceptar());
		System.out.println(" ");	

		//UN COLECTIVO CREA UN PROYECTO
		
		ColAuxiliar = Aplicacion.getUsuariosAceptados().get(0).getColectivos().get(0);
		ColAuxiliar.proponerProyecto("Anarquia", "Vamos a prenderle fuego a las universidades", 1000, EstadoProyecto.poraceptar, "Social", "Estudiantes", false, null);
		System.out.println(Aplicacion.getProyectosAceptados().size());
		System.out.println(Aplicacion.getProyectosPorAceptar());
		proyecto = Aplicacion.getProyectosPorAceptar().get(0);
		proyecto.aceptarProyecto();
		System.out.println(" ");	
		System.out.println(ColAuxiliar.getMiembros());
		System.out.println(proyecto.getVotos());
		System.out.println(" ");	

		//VOTAMOS UN PROYECTO
		
		proyecto = Aplicacion.getProyectosAceptados().get(0);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		
		numero = Aplicacion.getUsuariosAceptados().size();

		for (i = 0; i < numero; i++) {
			proyecto.votarProyecto(Aplicacion.getUsuariosAceptados().get(i));
		}
		
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		System.out.println(" ");	

		//NO SE PUEDEN A�ADIR VOTOS PORQUE EL USUARIO HA VOTADO CON ANTERIORIDAD
		//COGEMOS COMO EJEMPLO EL PROYECTO CREADO POR UN COLECTIVO (LOS VOTOS YA HAN SIDO CONTABILIZADOS)

		proyecto = Aplicacion.getProyectosAceptados().get(2);
		
		numero = Aplicacion.getUsuariosAceptados().size();

		for (i = 0; i < numero; i++) {
			proyecto.votarProyecto(Aplicacion.getUsuariosAceptados().get(i));
		}
		
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		System.out.println(" ");	

		//UN COLECTIVO VOTA UN PROYECTO
		
		proyecto = Aplicacion.getProyectosAceptados().get(1);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		ColAuxiliar = Aplicacion.getColectivos().get(0);
		proyecto.votarProyectoColectivo(ColAuxiliar);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		System.out.println(" ");
		
		//PROYECTOS VOTADOS POR UN USUARIO
		ciudadano = Aplicacion.getUsuariosAceptados().get(0);
		System.out.println(ciudadano.getVotado()); //NO HA VOTADO NINGUN PROYECTO
		ciudadano = Aplicacion.getUsuariosAceptados().get(1);
		System.out.println(ciudadano.getVotado()); //HA VOTADO LOS TRES PROYECTOS CREADOS
		System.out.println(" ");

		
		//USUARIOS SE SUSCRIBEN A UN PROYECTO
		numero = Aplicacion.getUsuariosAceptados().size();
		proyecto = Aplicacion.getProyectosAceptados().get(0);

		for (i = 0; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosAceptados().get(i);
			proyecto.suscribir(ciudadano);
		}
		System.out.println(proyecto.getSuscritos()); //SE HAN SUSCRITO 5 USUARIOS
		System.out.println(" ");
		
		//USUARIOS SE DESUSCRIBEN DE UN PROYECTO
		for (i = 0; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosAceptados().get(i);
			proyecto.desuscribir(ciudadano);
		}
		System.out.println(proyecto.getSuscritos()); //ARRAY VACIO MENOS EL PROPONENTE
		System.out.println(" ");
		
		//CONSULTAR PROYECTOS QUE SE HA VOTADO INDIVIDUALMENTE
		ciudadano = Aplicacion.getUsuariosAceptados().get(1);
		System.out.println(ciudadano.getVotado());  //TOTAL DE PROYECTOS VOTADOS
		System.out.println(ciudadano.getVotado().size());
		System.out.println(ciudadano.getVotoIndividual()); //PROYECTOS VOTADOS INDIVIDUALMENTE
		System.out.println(ciudadano.getVotoIndividual().size());


		//SOLICITAR INFORMES DE POPULARIDAD INDIVIDUAL
		System.out.println(" ");

		ciudadano = Aplicacion.getUsuariosAceptados().get(1);
		proyecto = ciudadano.getVotoIndividual().get(0);
		ciudadano.informePopularidad(proyecto);
		System.out.println(" ");
		
		//SOLICITAR INFORMES DE POPULARIDAD COLECTIVOS
		ColAuxiliar = Aplicacion.getColectivos().get(0);
		proyecto = ColAuxiliar.getVotoColectivo().get(0);		
		ColAuxiliar.informePopularidad(proyecto);
		System.out.println(" ");
		
		//CREAMOS UN NUEVO COLECTIVO CON NUEVOS USUARIOS (METEMOS EL YA ELEGIDO)
		
		CiuAuxiliar = new CiudadanoNoRegistrado ("Juan", "contra", "12345678q");
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		CiuAuxiliar = new CiudadanoNoRegistrado ("Jorge", "contra", "12345678J");
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		CiuAuxiliar = new CiudadanoNoRegistrado ("Pedro", "contra", "87654321P");
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		
		numero = Aplicacion.getUsuariosPorAceptar().size();
		System.out.println("Numero de Usuarios por aceptar: "+numero+"");
		System.out.println("Numero de Usuarios aceptados: "+Aplicacion.getUsuariosAceptados().size()+"");
		
		for (i = 0; i < numero; i++) {
			ciudadano = Aplicacion.getUsuariosPorAceptar().get(0);
			ciudadano.aceptarUsuario(ciudadano);
		}
		
		System.out.println("Numero de Usuarios por aceptar: "+Aplicacion.getUsuariosPorAceptar().size()+"");
		System.out.println("Numero de Usuarios aceptados: "+Aplicacion.getUsuariosAceptados().size()+"");
		numero = Aplicacion.getUsuariosAceptados().size();
		System.out.println(" ");

		for (i = 0;i < numero; i++) {
			System.out.println(Aplicacion.getUsuariosAceptados().get(i));
		}
		
		System.out.println(" ");
		
		Aplicacion.getUsuariosAceptados().get(6).crearColectivo("Infectados");
		System.out.println(Aplicacion.getUsuariosAceptados().get(6).getColectivos());
		ciudadano = Aplicacion.getUsuariosAceptados().get(6);
		Aplicacion.getColectivos().get(9).agregarMiembro(ciudadano);
		ciudadano = Aplicacion.getUsuariosAceptados().get(5);
		Aplicacion.getColectivos().get(9).agregarMiembro(ciudadano);
		ciudadano = Aplicacion.getUsuariosAceptados().get(7);
		Aplicacion.getColectivos().get(9).agregarMiembro(ciudadano);
		ciudadano = Aplicacion.getUsuariosAceptados().get(3);
		Aplicacion.getColectivos().get(9).agregarMiembro(ciudadano);
		System.out.println(Aplicacion.getColectivos().get(9).getMiembros());
		System.out.println(" ");
		
		//INFORME POPULARIDAD ENTRE DOS COLECTIVOS
		
		ciudadano = Aplicacion.getUsuariosAceptados().get(3); //TOMAMOS UN USUARIO QUE PERTENEZCA A DOS COLECTIVOS
		System.out.println(ciudadano.getMiembro());
		System.out.println(" ");
		
		//CREAMOS PROYECTOS PARA PODER REALIZAR EL INFORME DE POPULARIDAD	
		
		ColAuxiliar = Aplicacion.getColectivos().get(9);
		ColAuxiliar.proponerProyecto("Porros", "Fiesta post pandemia", 100, EstadoProyecto.poraceptar, "Social", "Estudiantes", false, null);
		proyecto = Aplicacion.getProyectosPorAceptar().get(0);
		proyecto.aceptarProyecto();
		System.out.println(" ");	
		System.out.println(ColAuxiliar.getMiembros());
		System.out.println(proyecto.getVotos());
		System.out.println(" ");
		
		ColAuxiliar = Aplicacion.getUsuariosAceptados().get(0).getColectivos().get(0);
		ColAuxiliar.proponerProyecto("Anarquia Y Cerveza Fr�a", "Fiesta post pandemia", 1000, EstadoProyecto.poraceptar, "Social", "Estudiantes", false, null);
		proyecto = Aplicacion.getProyectosPorAceptar().get(0);
		proyecto.aceptarProyecto();
		System.out.println(" ");	
		System.out.println(ColAuxiliar.getMiembros());
		System.out.println(proyecto.getVotos());
		System.out.println(" ");

		ColAuxiliar = Aplicacion.getColectivos().get(9);
		ColAuxiliar.proponerProyecto("Chalet", "Alcalde corrupto se hace una casa", 1000000, EstadoProyecto.poraceptar, "Infraestructura", "que mas da", true, distrito);
		proyecto = Aplicacion.getProyectosPorAceptar().get(0);
		proyecto.aceptarProyecto();
		System.out.println(" ");	
		System.out.println(ColAuxiliar.getMiembros());
		System.out.println(proyecto.getVotos());
		System.out.println(" ");
						
		//REALIZAMOS LAS VOTACIONES NECESARIAS
		
		proyecto = Aplicacion.getProyectosAceptados().get(3);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		ColAuxiliar = Aplicacion.getColectivos().get(0);
		proyecto.votarProyectoColectivo(ColAuxiliar);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		System.out.println(" ");
		
		proyecto = Aplicacion.getProyectosAceptados().get(4);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		ColAuxiliar = Aplicacion.getColectivos().get(9);
		proyecto.votarProyectoColectivo(ColAuxiliar);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		System.out.println(" ");
		
		System.out.println (Aplicacion.getColectivos());

		System.out.println(" ");
		
		ciudadano = Aplicacion.getUsuariosAceptados().get(3);
		ciudadano.informeAfinidad(Aplicacion.getColectivos().get(0), Aplicacion.getColectivos().get(9));
		
		System.out.println(" ");

		
		//UN USUARIO PUEDE SOLICITAR VER LOS COLECTIVOS DE LOS QUE ES MIEMBRO
		
		Aplicacion.getUsuariosAceptados().get(3).soyMiembro();
		System.out.println(" ");
		
		//BLOQUEAMOS UNO DE LOS USUARIOS
		
		//DATOS PREVIOS AL BLOQUEO
		
		ciudadano = Aplicacion.getUsuariosAceptados().get(2);
		
		System.out.println(ciudadano);
		System.out.println(" ");

		System.out.println("Colectivos creados: ");
		System.out.println(ciudadano.getColectivos());
		System.out.println(" ");

		System.out.println("Proyectos creados: ");
		System.out.println(ciudadano.getProyectos());
		System.out.println(" ");
		
		System.out.println("Proyectos apoyados: ");
		System.out.println(ciudadano.getVotado());
		System.out.println(" ");
		
		System.out.println("Votos proyecto: ");
		System.out.println(Aplicacion.getProyectosAceptados().get(0).getnVotos());
		System.out.println(" ");
		
		System.out.println("Votos proyecto: ");
		System.out.println(Aplicacion.getProyectosAceptados().get(1).getnVotos());
		System.out.println(" ");
		
		System.out.println("Votos proyecto: ");
		System.out.println(ciudadano.getVotado().get(2).getnVotos());
		System.out.println(" ");
		
		System.out.println("Votos proyecto: ");
		System.out.println(Aplicacion.getProyectosAceptados().get(3).getnVotos());
		System.out.println(" ");
		
		System.out.println("Votos proyecto: ");
		System.out.println(Aplicacion.getProyectosAceptados().get(4).getnVotos());
		System.out.println(" ");
		
		//DATOS POSTERIORES AL BLOQUEO Y ACCIONES CANCELADAS
		
		administrador = Aplicacion.getAdministrador();
		
		administrador.bloquearUsuario(ciudadano, "Porque me da la gana");
		
		System.out.println(ciudadano.getNotificaciones());
		//UN USUARIO BLOQUEADO NO PUEDE CREAR UN COLECTIVO
		ciudadano.crearColectivo("nombre");
		//UN USUARIO BLOQUEADO NO PUEDE VOTAR
		Aplicacion.getProyectosAceptados().get(0).votarProyecto(ciudadano);
		//UN USUARIO BLOQUEADO NO PUEDE PROPONER UN PROYECTO
		ciudadano.proponerProyecto("Porros", "Fiesta post pandemia", 100, EstadoProyecto.poraceptar, "Social", "Estudiantes", false, null);
		//UN USUARIO BLOQUEADO NO PUEDE PROPONER UN PROYECTO COMO REPRESENTANTE DE UN COLECTIVO
		ciudadano.getColectivos().get(0).proponerProyecto("Porros", "Fiesta post pandemia", 100, EstadoProyecto.poraceptar, "Social", "Estudiantes", false, null);
		System.out.println(" ");
		//LOS VOTOS DE UN USUARIO BLOQUEADO NO SE CONTABILIZAN
		//EL USUARIO YA NO APOYA A NINGUN PROYECTO
		System.out.println("Proyectos apoyados: ");
		System.out.println(ciudadano.getVotado());
		System.out.println(" ");
		//EL NUMMERO DE VOTOS SE HA REDUCIDO EN UNO
		System.out.println("Votos proyecto: ");
		System.out.println(Aplicacion.getProyectosAceptados().get(0).getnVotos());
		System.out.println(" ");
		
		System.out.println("Votos proyecto: ");
		System.out.println(Aplicacion.getProyectosAceptados().get(1).getnVotos());
		System.out.println(" ");
		
		System.out.println("Votos proyecto: ");
		System.out.println(Aplicacion.getProyectosAceptados().get(2).getnVotos());
		System.out.println(" ");
		
		System.out.println("Votos proyecto: ");
		System.out.println(Aplicacion.getProyectosAceptados().get(3).getnVotos());
		System.out.println(" ");
		
		System.out.println("Votos proyecto: ");
		System.out.println(Aplicacion.getProyectosAceptados().get(4).getnVotos());
		System.out.println(" ");
		//EL USUARIO BLOQUEADO (DANI) YA NO APARECE COMO APOYO EN LOS PROYECTOS
		System.out.println(Aplicacion.getProyectosAceptados().get(0).getVotos());
		System.out.println(" ");
		
		//UN PROYECTO ALCANZA EL LIMITE Y SE CONVIERTE EN FINANCIABLE
		
		//CREAMOS UN NUEVO USUARIO

		CiuAuxiliar = new CiudadanoNoRegistrado ("Dolores", "contra", "65372845E");
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		ciudadano = Aplicacion.getUsuariosPorAceptar().get(0);
		ciudadano.aceptarUsuario(ciudadano);

		proyecto = Aplicacion.getProyectosAceptados().get(0);
		proyecto.setnVotos(Aplicacion.umbral); //EL UMBRAL ESTA EN 5 VOTOS
		
		proyecto.votarProyecto(ciudadano);
		
		System.out.println(Aplicacion.getUsuariosAceptados().get(0).getNotificaciones()); //EN LAS NOTIFICACIONES DEL USUARIO PODEMOS VER QUE UN PROYECTO SE HA RECHAZADO

		System.out.println(" ");
		
		//UN PROYECTO CADUCA

		proyecto = Aplicacion.getProyectosAceptados().get(3);
		
		LocalDate fecha;
		
		//!IMPORTANTE! ES NECESARIO AJUSTAR LA FECHA PARA QUE FUNCIONE LA FUNCION
		fecha = FechaSimulada.fijarFecha(27, 2, 2020); //MODIFICAMOS LA FECHA PARA COMPROBAR QUE LOS PROYECTOS PUEDEN CADUCAR

		proyecto.setFechaUltimoVoto(fecha);
		
		proyecto.caducarProyecto();
		
		System.out.println(Aplicacion.getCaducados()); //EL PROYECTO SE ENCUENTRA EN LA LISTA DE CADUCADOS

		proyecto.votarProyecto(ciudadano); //NO SE PUEDE APOYAR UN PROYECTO CADUCADO
		
		System.out.println(Aplicacion.getUsuariosAceptados().get(6).getNotificaciones()); 


	}
}

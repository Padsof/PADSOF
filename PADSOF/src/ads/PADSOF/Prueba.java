package ads.PADSOF;

import java.util.ArrayList;
import java.util.List;

import fechasimulada.FechaSimulada;

public class Prueba {
	
	public static void main(String[] args) {
		
		CiudadanoNoRegistrado CiuAuxiliar;
		Ciudadano ciudadano;
		Colectivo ColAuxiliar;
		Proyecto proyecto;
		Aplicacion aplicacion = new Aplicacion(5);
		List<String> distrito = new ArrayList<>();
		distrito.add("Usera");
		distrito.add("Estrecho");
		
		
		int numero = 5; //Vamos a trabajar con 5 Usuarios
		int i;
		String[] nombres = {"Quique", "Alicia", "Dani", "Irene", "Rosa"};
		String[] contrasenias = {"CQ", "CA", "CD", "CI", "CR"};
		String[] DNIS = {"12345678Q", "12345678A", "12345678D", "12345678I", "12345678R"};
		String[]nombreColectivo = {"CQ", "CA", "CD", "CI", "CR"};
		String[]nombreColectivoHijo = {"CQH", "CAH", "CDH", "CIH", "CRH"};
		String[]identificadorAdministrador = {"Javier", "contraseña"};

		
		List<Ciudadano> Aceptados = new ArrayList<>();
		List<Ciudadano> PorAceptar = new ArrayList<>();	    
		
		//CREAMOS UN ADMINISTRADOR PARA LA APLICACION
		CiuAuxiliar = new CiudadanoNoRegistrado (identificadorAdministrador[0], identificadorAdministrador[1], null);
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		System.out.println(aplicacion.administrador);
		//INTENTAMOS INTRODUCIR UN NUEVO ADMINISTRADOR
		CiuAuxiliar = new CiudadanoNoRegistrado ("Ciro", "contraseña", null);
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		System.out.println(aplicacion.administrador);
		
		System.out.println(" ");
		//INTRODUCIMOS EN EL SISTEMA LOS NUEVOS USUARIOS (USUARIOS NO ACEPTADOS)
		for (i = 0;i < numero; i++) {
			CiuAuxiliar = new CiudadanoNoRegistrado (nombres[i], contrasenias[i], DNIS[i]);
			CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
			System.out.println(aplicacion.getUsuariosPorAceptar().get(i));

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
		numero = aplicacion.getUsuariosPorAceptar().size();
		System.out.println("Numero de Usuarios por aceptar: "+numero+"");
		System.out.println("Numero de Usuarios aceptados: "+aplicacion.getUsuariosAceptados().size()+"");
		
		for (i = 0; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosPorAceptar().get(0);
			ciudadano.aceptarUsuario(ciudadano);
		}
		
		System.out.println("Numero de Usuarios por aceptar: "+aplicacion.getUsuariosPorAceptar().size()+"");
		System.out.println("Numero de Usuarios aceptados: "+aplicacion.getUsuariosAceptados().size()+"");
		numero = aplicacion.getUsuariosAceptados().size();
		System.out.println(" ");

		//USUARIOS ACEPTADOS
		for (i = 0;i < numero; i++) {
			System.out.println(aplicacion.getUsuariosAceptados().get(i));
		}
		
		System.out.println(" ");
		
		
		//RECHAZAMOS USUARIOS
		CiuAuxiliar = new CiudadanoNoRegistrado ("Pedro", "Pablo", "12305678q");
		CiuAuxiliar.Registrarse(CiuAuxiliar.getNombre(), CiuAuxiliar.getcontrasenia(), CiuAuxiliar.getDNI());
		System.out.println(aplicacion.getUsuariosPorAceptar());
		ciudadano = aplicacion.getUsuariosPorAceptar().get(0);
		ciudadano.rechazarUsuario(ciudadano);
		System.out.println(aplicacion.getUsuariosPorAceptar());

		System.out.println(" ");

		//CADA USUARIO CREARÁ UN COLECTIVO
		for (i = 0;i < numero; i++) {
			aplicacion.getUsuariosAceptados().get(i).crearColectivo(nombreColectivo[i]);
		}
		
		//COLECTIVOS CREADOS
		for (i = 0;i < numero; i++) {
			System.out.println(aplicacion.getColectivos().get(i));
		}
		System.out.println(" ");
		
		//CREAMOS UN NUEVO COLECTIVO PARA UNO DE LOS USUARIOS
		aplicacion.getUsuariosAceptados().get(0).crearColectivo("CQ2");
		
		//COLECTIVOS CREADOS
		numero = aplicacion.getColectivos().size();
		for (i = 0;i < numero; i++) {
			System.out.println(aplicacion.getColectivos().get(i));
		}
		System.out.println(" ");
		
		//UN USUARIO PUEDE TENER SER REPRESENTANTE DE MAS DE UN COLECTIVO
		System.out.println(aplicacion.getUsuariosAceptados().get(0).getColectivos());
		System.out.println(" ");

		//NO PUEDE HABER DOS COLECTIVOS CON EL MISMO NOMBRE 
		//INTRODUCIMOS EN EL SISTEMA NUEVOS COLECTIVOS CON UN MISMO NOMBRE (NO ES POSIBLE)
		aplicacion.getUsuariosAceptados().get(0).crearColectivo("CQ2");
		System.out.println(" ");

		
		//CREAMOS COLECTIVOS HIJOS (IGUAL NO SE PUEDEN CREAR SI EL NOMBRE ESTA REPETIDO)

		ColAuxiliar = aplicacion.getUsuariosAceptados().get(0).crearColectivo(nombreColectivoHijo[0]);
		aplicacion.getUsuariosAceptados().get(0).getColectivos().get(0).añadirColectivoHijo(ColAuxiliar);
		ColAuxiliar = aplicacion.getUsuariosAceptados().get(0).crearColectivo("CQH2");
		aplicacion.getUsuariosAceptados().get(0).getColectivos().get(0).añadirColectivoHijo(ColAuxiliar);

		System.out.println(aplicacion.getUsuariosAceptados().get(0).getColectivos().get(0).getHijos()); 
		System.out.println(aplicacion.getUsuariosAceptados().get(0).getColectivos());
		System.out.println(aplicacion.getUsuariosAceptados().get(0).getColectivos().get(1).getHijos());
		
		ColAuxiliar = aplicacion.getUsuariosAceptados().get(1).crearColectivo(nombreColectivoHijo[1]);
		aplicacion.getUsuariosAceptados().get(1).getColectivos().get(0).añadirColectivoHijo(ColAuxiliar);

		System.out.println(aplicacion.getUsuariosAceptados().get(1).getColectivos().get(0).getHijos()); 
		System.out.println(aplicacion.getUsuariosAceptados().get(1).getColectivos());
		
		ColAuxiliar = aplicacion.getUsuariosAceptados().get(0).crearColectivo(nombreColectivoHijo[0]); //NO SE VA A PODER CREAR
		
		System.out.println(" ");
		
		//METEMOS MIEMBROS EN LOS DIFERENTES COLECTIVOS
		numero = aplicacion.getUsuariosAceptados().size();
		
		
		for (i = 1; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosAceptados().get(i); //EL PRIMER CIUDADANO ES REPRESENTANTE DEL COLECTIVO (NO SE AÑADE)
			aplicacion.getColectivos().get(0).agregarMiembro(ciudadano);
		}
		
		System.out.println("Miembros del colectivo: "+aplicacion.getColectivos().get(0)+"");
		System.out.println(aplicacion.getColectivos().get(0).getMiembros());
		System.out.println(" ");

				
		for (i = 0; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosAceptados().get(i); //EL PRIMER CIUDADANO ES REPRESENTANTE DEL COLECTIVO (NO SE AÑADE)
																  //EL RESTO DE CIUDADANOS YA ESTAN INCLUIDOS EN EL COLECTIVO (NO SE AÑADEN)
			aplicacion.getColectivos().get(0).agregarMiembro(ciudadano);
		}
		
		System.out.println(" ");

		
		for (i = 0; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosAceptados().get(i);  //LOS CIUDADANOS YA ESTAN INCLUIDOS EN EL COLECTIVO PADRE (NO SE AÑADEN)
			aplicacion.getColectivos().get(0).getHijos().get(0).agregarMiembro(ciudadano);
		}
		
		System.out.println(" ");
		
		//LOS CIUDADANOS SE UNEN AL COLECTIVO DEL HIJO DE UNO DE LOS MIEMBROS SIN PERTENECER AL COLECTIVO PADRE
		//NO ESTAN INCLUIDOS EN EL COLECTIVO PADRE (SE AÑADEN)
		for (i = 0; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosAceptados().get(i); //EL PRIMER CIUDADANO ES REPRESENTANTE DEL COLECTIVO (NO SE AÑADE)
			aplicacion.getColectivos().get(1).getHijos().get(0).agregarMiembro(ciudadano);
		}
		System.out.println(" ");

		
		for (i = 0; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosAceptados().get(i);  //LOS CIUDADANOS YA ESTAN INCLUIDOS EN EL COLECTIVO HIJO (NO SE AÑADEN)
			aplicacion.getColectivos().get(1).agregarMiembro(ciudadano);
		}

		System.out.println("Miembros del colectivo: "+aplicacion.getColectivos().get(1).getHijos().get(0)+"");
		System.out.println(aplicacion.getColectivos().get(1).getHijos().get(0).getMiembros());
		System.out.println("Miembros del colectivo: "+aplicacion.getColectivos().get(1)+"");
		System.out.println(aplicacion.getColectivos().get(1).getMiembros());
		System.out.println(" ");	

		//BORRAMOS LOS MIEMBROS DEL COLECTIVO HIJO
		for (i = 0; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosAceptados().get(i); //EL PRIMER CIUDADANO ES REPRESENTANTE DEL COLECTIVO (NO SE AÑADE)
			aplicacion.getColectivos().get(1).getHijos().get(0).quitarMiembro(ciudadano);
		}
		System.out.println("Miembros del colectivo: "+aplicacion.getColectivos().get(1).getHijos().get(0)+"");
		System.out.println(aplicacion.getColectivos().get(1).getHijos().get(0).getMiembros());
		System.out.println(" ");	

		//LOS AÑADIMOS DE NUEVO. VAMOS A NECESITARLOS MAS ADELANTE
		
		for (i = 0; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosAceptados().get(i); //EL PRIMER CIUDADANO ES REPRESENTANTE DEL COLECTIVO (NO SE AÑADE)
			aplicacion.getColectivos().get(1).getHijos().get(0).agregarMiembro(ciudadano);
		}
		
		//CREAMOS PROYECTOS
		
		System.out.println("Creamos un proyecto social");

		ciudadano = aplicacion.getUsuariosAceptados().get(0);
		ciudadano.proponerProyecto("Coronavirus", "Recaudar dinero", 1000, EstadoProyecto.poraceptar, "Social", "Infectados", true, null);
		
		System.out.println(aplicacion.getProyectosPorAceptar());
		
		proyecto = aplicacion.getProyectosPorAceptar().get(0);
		
		proyecto.aceptarProyecto();
		
		System.out.println(aplicacion.getProyectosAceptados().get(0));
		System.out.println(aplicacion.getProyectosAceptados().get(0).getCaracter());
		System.out.println(" ");	

		System.out.println("Creamos un proyecto de Infraestructura");
		ciudadano = aplicacion.getUsuariosAceptados().get(0);
		ciudadano.proponerProyecto("Hospitales", "España se va a la mierda", 1000, EstadoProyecto.poraceptar, "Infraestructura", "que mas da", true, distrito);

		System.out.println(aplicacion.getProyectosPorAceptar());
		proyecto = aplicacion.getProyectosPorAceptar().get(0);
		
		proyecto.aceptarProyecto();
		
		System.out.println(aplicacion.getProyectosAceptados().get(1));
		System.out.println(aplicacion.getProyectosAceptados().get(1).getDistrito());
		System.out.println(" ");	

		
		//NOMBRE DE PROYECTO (MAX 50 CARACTERERES) DESCRIPCION (MAX 500 CARACTERES)
		
		ciudadano = aplicacion.getUsuariosAceptados().get(0);
		ciudadano.proponerProyecto("qwertyuiopasdfghjklñzxcvbn", "Recaudar dinero", 1000, EstadoProyecto.poraceptar, "Social", "Infectados", true, null);
		System.out.println(" ");	

		//RECHAZAMOS PROYECTO
		
		ciudadano = aplicacion.getUsuariosAceptados().get(0);
		ciudadano.proponerProyecto("Coronavirus", "Recaudar dinero", 1000, EstadoProyecto.poraceptar, "Social", "Infectados", true, null);
		
		System.out.println(aplicacion.getProyectosPorAceptar());
		
		proyecto = aplicacion.getProyectosPorAceptar().get(0);
		
		proyecto.rechazarProyectoUsuario(ciudadano);
		
		System.out.println(aplicacion.getProyectosPorAceptar());
		System.out.println(" ");	

		//UN COLECTIVO CREA UN PROYECTO
		
		ColAuxiliar = aplicacion.getUsuariosAceptados().get(0).getColectivos().get(0);
		ColAuxiliar.proponerProyecto("Anarquia", "Vamos a prenderle fuego a las universidades", 1000, EstadoProyecto.poraceptar, "Social", "Estudiantes", false, null);
		System.out.println(aplicacion.getProyectosPorAceptar());
		proyecto = aplicacion.getProyectosPorAceptar().get(0);
		proyecto.aceptarProyecto();
		System.out.println(" ");	
		System.out.println(ColAuxiliar.getMiembros());
		System.out.println(proyecto.getVotos());
		System.out.println(" ");	

		//VOTAMOS UN PROYECTO
		
		proyecto = aplicacion.getProyectosAceptados().get(0);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		
		numero = aplicacion.getUsuariosAceptados().size();

		for (i = 0; i < numero; i++) {
			proyecto.votarProyecto(aplicacion.getUsuariosAceptados().get(i));
		}
		
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		System.out.println(" ");	

		//NO SE PUEDEN AÑADIR VOTOS PORQUE EL USUARIO HA VOTADO CON ANTERIORIDAD
		//COGEMOS COMO EJEMPLO EL PROYECTO CREADO POR UN COLECTIVO (LOS VOTOS YA HAN SIDO CONTABILIZADOS)

		proyecto = aplicacion.getProyectosAceptados().get(2);
		
		numero = aplicacion.getUsuariosAceptados().size();

		for (i = 0; i < numero; i++) {
			proyecto.votarProyecto(aplicacion.getUsuariosAceptados().get(i));
		}
		
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		System.out.println(" ");	

		//UN COLECTIVO VOTA UN PROYECTO
		
		proyecto = aplicacion.getProyectosAceptados().get(1);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		ColAuxiliar = aplicacion.getColectivos().get(0);
		proyecto.votarProyectoColectivo(ColAuxiliar);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		System.out.println(" ");
		
		//PROYECTOS VOTADOS POR UN USUARIO
		ciudadano = aplicacion.getUsuariosAceptados().get(0);
		System.out.println(ciudadano.getVotado()); //NO HA VOTADO NINGUN PROYECTO
		ciudadano = aplicacion.getUsuariosAceptados().get(1);
		System.out.println(ciudadano.getVotado()); //HA VOTADO LOS TRES PROYECTOS CREADOS
		System.out.println(" ");

		
		//USUARIOS SE SUSCRIBEN A UN PROYECTO
		numero = aplicacion.getUsuariosAceptados().size();
		proyecto = aplicacion.getProyectosAceptados().get(0);

		for (i = 0; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosAceptados().get(i);
			proyecto.suscribir(ciudadano);
		}
		System.out.println(proyecto.getSuscritos()); //SE HAN SUSCRITO 5 USUARIOS
		System.out.println(" ");
		
		//USUARIOS SE DESUSCRIBEN DE UN PROYECTO
		for (i = 0; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosAceptados().get(i);
			proyecto.desuscribir(ciudadano);
		}
		System.out.println(proyecto.getSuscritos()); //ARRAY VACIO MENOS EL PROPONENTE
		System.out.println(" ");
		
		//CONSULTAR PROYECTOS QUE SE HA VOTADO INDIVIDUALMENTE
		ciudadano = aplicacion.getUsuariosAceptados().get(1);
		System.out.println(ciudadano.getVotado());  //TOTAL DE PROYECTOS VOTADOS
		System.out.println(ciudadano.getVotado().size());
		System.out.println(ciudadano.getVotoIndividual()); //PROYECTOS VOTADOS INDIVIDUALMENTE
		System.out.println(ciudadano.getVotoIndividual().size());


		//SOLICITAR INFORMES DE POPULARIDAD INDIVIDUAL
		System.out.println(" ");

		ciudadano = aplicacion.getUsuariosAceptados().get(1);
		proyecto = ciudadano.getVotoIndividual().get(0);
		ciudadano.informePopularidad(proyecto);
		System.out.println(" ");
		
		//SOLICITAR INFORMES DE POPULARIDAD COLECTIVOS
		ColAuxiliar = aplicacion.getColectivos().get(0);
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
		
		numero = aplicacion.getUsuariosPorAceptar().size();
		System.out.println("Numero de Usuarios por aceptar: "+numero+"");
		System.out.println("Numero de Usuarios aceptados: "+aplicacion.getUsuariosAceptados().size()+"");
		
		for (i = 0; i < numero; i++) {
			ciudadano = aplicacion.getUsuariosPorAceptar().get(0);
			ciudadano.aceptarUsuario(ciudadano);
		}
		
		System.out.println("Numero de Usuarios por aceptar: "+aplicacion.getUsuariosPorAceptar().size()+"");
		System.out.println("Numero de Usuarios aceptados: "+aplicacion.getUsuariosAceptados().size()+"");
		numero = aplicacion.getUsuariosAceptados().size();
		System.out.println(" ");

		for (i = 0;i < numero; i++) {
			System.out.println(aplicacion.getUsuariosAceptados().get(i));
		}
		
		System.out.println(" ");
		
		aplicacion.getUsuariosAceptados().get(6).crearColectivo("Infectados");
		System.out.println(aplicacion.getUsuariosAceptados().get(6).getColectivos());
		ciudadano = aplicacion.getUsuariosAceptados().get(6);
		aplicacion.getColectivos().get(9).agregarMiembro(ciudadano);
		ciudadano = aplicacion.getUsuariosAceptados().get(5);
		aplicacion.getColectivos().get(9).agregarMiembro(ciudadano);
		ciudadano = aplicacion.getUsuariosAceptados().get(7);
		aplicacion.getColectivos().get(9).agregarMiembro(ciudadano);
		ciudadano = aplicacion.getUsuariosAceptados().get(3);
		aplicacion.getColectivos().get(9).agregarMiembro(ciudadano);
		System.out.println(aplicacion.getColectivos().get(9).getMiembros());
		System.out.println(" ");
		
		//INFORME POPULARIDAD ENTRE DOS COLECTIVOS
		
		ciudadano = aplicacion.getUsuariosAceptados().get(3); //TOMAMOS UN USUARIO QUE PERTENEZCA A DOS COLECTIVOS
		System.out.println(ciudadano.getMiembro());
		System.out.println(" ");
		
		//CREAMOS PROYECTOS PARA PODER REALIZAR EL INFORME DE POPULARIDAD	
		
		ColAuxiliar = aplicacion.getColectivos().get(9);
		ColAuxiliar.proponerProyecto("Porros", "Fiesta post pandemia", 100, EstadoProyecto.poraceptar, "Social", "Estudiantes", false, null);
		proyecto = aplicacion.getProyectosPorAceptar().get(0);
		proyecto.aceptarProyecto();
		System.out.println(" ");	
		System.out.println(ColAuxiliar.getMiembros());
		System.out.println(proyecto.getVotos());
		System.out.println(" ");
		
		ColAuxiliar = aplicacion.getUsuariosAceptados().get(0).getColectivos().get(0);
		ColAuxiliar.proponerProyecto("Anarquia Y Cerveza Fría", "Fiesta post pandemia", 1000, EstadoProyecto.poraceptar, "Social", "Estudiantes", false, null);
		proyecto = aplicacion.getProyectosPorAceptar().get(0);
		proyecto.aceptarProyecto();
		System.out.println(" ");	
		System.out.println(ColAuxiliar.getMiembros());
		System.out.println(proyecto.getVotos());
		System.out.println(" ");

		ColAuxiliar = aplicacion.getColectivos().get(9);
		ColAuxiliar.proponerProyecto("Chalet", "Alcalde corrupto se hace una casa", 1000000, EstadoProyecto.poraceptar, "Infraestructura", "que mas da", true, distrito);
		proyecto = aplicacion.getProyectosPorAceptar().get(0);
		proyecto.aceptarProyecto();
		System.out.println(" ");	
		System.out.println(ColAuxiliar.getMiembros());
		System.out.println(proyecto.getVotos());
		System.out.println(" ");
						
		//REALIZAMOS LAS VOTACIONES NECESARIAS
		
		proyecto = aplicacion.getProyectosAceptados().get(3);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		ColAuxiliar = aplicacion.getColectivos().get(0);
		proyecto.votarProyectoColectivo(ColAuxiliar);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		System.out.println(" ");
		
		proyecto = aplicacion.getProyectosAceptados().get(4);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		ColAuxiliar = aplicacion.getColectivos().get(9);
		proyecto.votarProyectoColectivo(ColAuxiliar);
		System.out.println (proyecto.getnVotos());
		System.out.println (proyecto.getVotos());
		System.out.println(" ");
		
		System.out.println (aplicacion.getColectivos());

		System.out.println(" ");
		
		ciudadano = aplicacion.getUsuariosAceptados().get(3);
		ciudadano.informeAfinidad(aplicacion.getColectivos().get(0), aplicacion.getColectivos().get(9));
		
		System.out.println(" ");

		
		//UN USUARIO PUEDE SOLICITAR VER LOS COLECTIVOS DE LOS QUE ES MIEMBRO
		
		aplicacion.getUsuariosAceptados().get(3).soyMiembro();
		System.out.println(" ");





		
	}
}

package ads.PADSOF;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fechasimulada.FechaSimulada;


/**
 * Esta clase modela la clase PryInfraestructura
 *
 * @author Ciro Alonso Aquino ciro.alonso@estudiante.uam.es
 * @author Enrique Gutierrez Perez enrique.gutierrezp@estudiante.uam.es
 * @author Javier Benitez Miguel javier.benitezm@estudiante.uam.es
 *
*/

public class PoySocial extends Proyecto{
	
	/**
	 * El titulo del proyecto
	 */
	private String titulo;
	
	/**
	 * El proponente del proyecto
	 */
	private Ciudadano proponente;

	/**
	 * Breve descripcion sobre el proyecto
	 */
	private String descripcion;

	/**
	 * El presupuesto del proyecto
	 */
	private double presupuestoSolicitado;

	/**
	 * El presupuesto final del proyecto
	 */
	private double presupuestoFinal;

	/**
	 * Numero de votos con los que cuenta el proyecto
	 */
	private int nVotos;
	
	/**
	 * El proyecto puede ser de caracter nacional o internacional
	 */
	private String caracter;

	/**
	 * La fecha en la que se creo el proyecto
	 */
	private LocalDate fechaCreacion;

	/**
	 * La fecha del ultimo voto
	 */
	private LocalDate fechaUltimoVoto;

	/**
	 * Estado en el que se encuentra el proyecto
	 */
	private EstadoProyecto estado;
	
	/**
	 * Un arrayList con los ciudadanos que se han suscrito al proyecto
	 */
	private List <Ciudadano> suscritos;

	/**
	 * Un arrayList con los ciudadanos que han votado el proyecto
	 */
	private List<Ciudadano>votos;
	/**
	 * Clase social a la que va dirigida
	 */
	private String claseSocial;

	/**
	 * Si es de caracter nacional o internacional
	 */
	private boolean nacional;
	
	/**
	 * Codigo identificativo
	 */
	private int codigo;
	
	/**
	 * Constructor de la clase ProyInfraestuctura
	 * 
	 * @param titulo Titulo del proyecto
	 * @param descripcion Descripcion del proyecto
	 * @param proponente Ciudadano que propone el proyecto
	 * @param presupuesto Presupuesto inicial
	 * @param fechaCreacion Fecha de creacion
	 * @param estado Estado en el que se encuentra el proyecto
	 * @param claseSocial clase social a la que va dirigida
	 * @param nacional Si es de caracter nacional
	 */
	public PoySocial(String titulo, String descripcion, Ciudadano proponente, double presupuesto,
			LocalDate fechaCreacion,  EstadoProyecto estado, String claseSocial, 
			boolean nacional) {
		super(titulo, descripcion, proponente, presupuesto, fechaCreacion, estado);
		this.titulo = titulo;
		this.claseSocial = claseSocial;
		this.nacional = nacional;
		this.presupuestoFinal = 0; //TODAVIA NO SE LE HA ASIGNADO NINGUN PRESUPUESTO
		this.fechaUltimoVoto = fechaCreacion; //CUANDO SE CREA EL PROYECTO EL PRIMER VOTO SE LE ASIGNA NADA MAS CREARLO
		this.nVotos = 0;
		this.suscritos = new ArrayList<>();
		this.votos = new ArrayList<>();
		this.proponente = proponente;
		this.estado = EstadoProyecto.creado;
		
		if (nacional == true) {
			this.caracter = "nacional";
		}
		else {
			this.caracter = "Internacional";
		}
		
		Aplicacion.getProyectosPorAceptar().add(this);
		Aplicacion.generarIdentificador(this);
		this.getSuscritos().add(proponente);
		proponente.getSuscrito().add(this);
	}
	
	/**
	 * Constructor de la clase ProyInfraestuctura
	 * 
	 * @param titulo Titulo del proyecto
	 * @param descripcion Descripcion del proyecto
	 * @param votos numero de votos asignados
	 * @param colectivo que ha creado el proyecto
	 * @param presupuesto Presupuesto inicial
	 * @param fechaCreacion Fecha de creacion
	 * @param estado Estado en el que se encuentra el proyecto
	 * @param esquema Esquema de la realizacion del proyecto
	 * @param distrito Distrito donde se va a llevar a cabo el proyecto
	 */
	public PoySocial(String titulo, String descripcion, Colectivo colectivo, int votos, double presupuesto,
			LocalDate fechaCreacion,  EstadoProyecto estado, String claseSocial, 
			boolean nacional) {
		super(titulo, descripcion, colectivo, presupuesto, fechaCreacion, estado);
		this.titulo = titulo;
		this.claseSocial = claseSocial;
		this.nacional = nacional;
		this.presupuestoFinal = 0; //TODAVIA NO SE LE HA ASIGNADO NINGUN PRESUPUESTO
		this.fechaUltimoVoto = fechaCreacion; //CUANDO SE CREA EL PROYECTO EL PRIMER VOTO SE LE ASIGNA NADA MAS CREARLO 
		this.nVotos = votos;
		this.proponente = colectivo.getRepresentante();
		this.suscritos = new ArrayList<>();
		this.votos = new ArrayList<>();
		
		if (nacional == true) {
			this.caracter = "nacional";
		}
		else {
			this.caracter = "Internacional";
		}
		
		int i;
		
		for (i = 0; i < colectivo.getNumMiembros(); i++) {
			this.votos.add(colectivo.getMiembros().get(i));
			colectivo.getMiembros().get(i).getVotado().add(this);
		}
		
		Aplicacion.getProyectosPorAceptar().add(this);
		Aplicacion.generarIdentificador(this);
		this.getSuscritos().add(colectivo.getRepresentante());
		colectivo.getRepresentante().getSuscrito().add(this);
		
	}

	/**
	 * Este metodo devuelve la clase social a la que va dirigida el proyecto
	 * @return claseSocial 
	 */
	public String getClaseSocial() {
		return claseSocial;
	}

	/**
	 * Este metodo cambia la clase social del proyecto
	 * @param claseSocial Clase social del proyecto
	 */
	public void setClaseSocial(String claseSocial) {
		this.claseSocial = claseSocial;
	}

	/**
	 * Este metodo devuelve si es nacional el proyecto
	 * @return nacional 
	 */
	public boolean isNacional() {
		return nacional;
	}

	/**
	 * Este metodo cambia el caracter nacional del proyecto
	 * @param nacional Esquema del proyecto
	 */
	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}

	/**
	 * Este metodo devuelve el titulo del proyecto
	 * @return titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Este metodo cambia el nombre del proyecto
	 * @param titulo Titulo del proyecto
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Este metodo devuelve el proponente de un proyecto
	 * @return proponente proponente de un proyecto
	 */
	
	public Ciudadano getProponente() {
		return proponente;
	}
	
	/**
	 * Este metodo modifica el proponente de un proyecto
	 * @param proponente proponente de un proyecto
	 */
	 

	public void setProponente(Ciudadano proponente) {
		this.proponente = proponente;
	}

	/**
	 * Este metodo devuelve la descripcion del proyecto
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Este metodo cambia la descripcion del proyecto
	 * @param descripcion Descripcion del proyecto
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * Este metodo devuelve el presupuesto del proyecto
	 * @return presupuestoSolicitado
	 */

	public double getPresupuestoSolicitado() {
		return presupuestoSolicitado;
	}
	/**
	 * Este metodo cambia el presupuesto del proyecto
	 * @param presupuestoSolicitado Pesupuesto del proyecto
	 */

	public void setPresupuestoSolicitado(double presupuestoSolicitado) {
		this.presupuestoSolicitado = presupuestoSolicitado;
	}

	/**
	 * Este metodo devuelve el el presupuesto final del proyecto
	 * @return presupuesto final
	 */
	public double getPresupuestoFinal() {
		return presupuestoFinal;
	}

	/**
	 * Este metodo cambia el presupuesto final del proyecto
	 * @param presupuestoFinal Presupuesto final del proyecto
	 */
	public void setPresupuestoFinal(double presupuestoFinal) {
		this.presupuestoFinal = presupuestoFinal;
	}
	/**
	 * Este metodo devuelve el numero de votos del proyecto
	 * @return numero de votos
	 */
	public int getnVotos() {
		return nVotos;
	}

	/**
	 * Este metodo cambia el numero de votos del proyecto
	 * @param nVotos Numero de votos del proyecto
	 */
	public void setnVotos(int nVotos) {
		this.nVotos = nVotos;
	}

	/**
	 * Este metodo devuelve la fecha de creacion del proyecto del proyecto
	 * @return fecha de creacion
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Este metodo cambia la fecha de creacion del proyecto
	 * @param fechaCreacion Fecha de creacion del proyecto
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Este metodo devuelve la fecha del ultimo voto del proyecto
	 * @return fecha ultimo voto
	 */
	public LocalDate getFechaUltimoVoto() {
		return fechaUltimoVoto;
	}
	
	/**
	 * Este metodo cambia la fecha del ultimo voto del proyecto
	 * @param fechaUltimoVoto Fecha del ultimo voto del proyecto
	 */
	public void setFechaUltimoVoto(LocalDate fechaUltimoVoto) {
		this.fechaUltimoVoto = fechaUltimoVoto;
	}

	/**
	 * Este metodo devuelve el estado del proyecto
	 * @return estado
	 */
	public EstadoProyecto getEstado() {
		return estado;
	}

	/**
	 * Este metodo cambia el estado del proyecto
	 * @param estado Estado del proyecto
	 */
	public void setEstado(EstadoProyecto estado) {
		this.estado = estado;
	}

	/**
	 * Este metodo devuelve una lista con los usuarios de tipo ciudadano suscritos al proyecto
	 * @return suscritos una lista con los usuarios de tipo ciudadano suscritos al proyecto
	 */

	public List<Ciudadano> getSuscritos() {
		return suscritos;
	}
	
	/**
	 * Este metodo modifica una lista con los usuarios de tipo ciudadano suscritos al proyecto
	 * @param suscritos una lista con los usuarios de tipo ciudadano suscritos al proyecto
	 */

	public void setSuscritos(List<Ciudadano> suscritos) {
		this.suscritos = suscritos;
	}
	
	/**
	 * Este metodo devuelve una lista con los ciudadanos que han apoyado el proyecto
	 * @param votos
	 */

	public List<Ciudadano> getVotos() {
		return votos;
	}
	
	/**
	 * Este metodo modifica una lista con los ciudadanos que han apoyado el proyecto
	 * @param votos
	 */

	public void setVotos(List<Ciudadano> votos) {
		this.votos = votos;
	}
	
	/**
	 * Este metodo devuelve el caracter del proyecto
	 * @return caracter
	 */

	public String getCaracter() {
		return caracter;
	}
	
	/**
	 * Este metodo modifica el caracter del proyecto
	 * @param caracter
	 */

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	@Override
	protected List<String> getDistrito() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Este metodo se encarga de que un usuario de tipo ciudadano vote un proyecto
	 * @param c Usuario de tipo ciudadano
	 */

	@Override
	public void votarProyecto(Ciudadano c) {
		
		int ciudadanos = Aplicacion.getUsuariosAceptados().size();
		int i;
		
		if(this.estado == EstadoProyecto.caducado) {
			System.out.println("PROYECTO CADUCADO");
			return;
		}
		
		if(c.isBloqueado() == true) {
			System.out.println("ACCION NO PERMITIDA. USUARIO BLOQUEADO");
			return;
		}
		
		String name = this.proponente.getNombre();
		
		if (c.getNombre() == name){
			System.out.println("El proponente no puede votar el proyecto");
			return;
		}
			
		if (this.getVotos().size() > 0) {
				
			for (i = 0; i < this.getVotos().size(); i++ ) {
					
				if (c.getNombre() == this.getVotos().get(i).getNombre()) {
					System.out.println("Voto anulado");
					return;
				}

			}
		}
			
		this.votos.add(c);
		c.getVotado().add(this);
		c.getVotoIndividual().add(this);
		this.nVotos++;
		FechaSimulada.restablecerHoyReal();
		this.fechaUltimoVoto = FechaSimulada.getHoy();
		
		if (this.nVotos >= Aplicacion.getUmbral() && this.estado != EstadoProyecto.financiable) {
			this.estadoFinanciable();
		}
		
		}
	
	/**
	 * Este metodo se encarga de que un proyecto vote un proyecto
	 * @param colectivo que vota el proyecto
	 */

	@Override
	public void votarProyectoColectivo(Colectivo colectivo) {
		int ciudadanos = colectivo.getNumMiembros();
		int i, j, flag;
		LocalDate ultimafecha = FechaSimulada.getHoy();
		
		if(this.estado == EstadoProyecto.caducado) {
			System.out.println("PROYECTO CADUCADO");
			return;
		}
		
		if(colectivo.getRepresentante().isBloqueado() == true) {
			System.out.println("ACCION NO PERMITIDA. USUARIO BLOQUEADO");
			return;
		}
		
		if (colectivo.getRepresentante().getNombre() == this.proponente.getNombre()){
			System.out.println("El proponente no puede votar el proyecto");
		}
		
		for (j = 0; j < ciudadanos; j++) {

			flag = 0;
		
			if (this.getVotos().size() > 0) {
				
				for (i = 0; i < this.getVotos().size(); i++ ) {
										
					if (colectivo.getMiembros().get(j).getNombre() == this.getVotos().get(i).getNombre()) {
						System.out.println("Voto anulado");
						System.out.println(colectivo.getMiembros().get(j).getNombre());
						flag = 1;
					}

				}
			}
							
			this.votos.add(colectivo.getMiembros().get(j));
			colectivo.getMiembros().get(j).getVotado().add(this);
			this.nVotos++;
			FechaSimulada.restablecerHoyReal();
			this.fechaUltimoVoto = FechaSimulada.getHoy();

			
			if (flag == 1) {
				this.nVotos--;
				this.fechaUltimoVoto = ultimafecha;
				this.votos.remove(colectivo.getMiembros().get(j));
			}
			
			if (this.nVotos >= Aplicacion.getUmbral() && this.estado != EstadoProyecto.financiable) {
				this.estadoFinanciable();
			}
			
		}
		
		colectivo.getVotoColectivo().add(this);
						
	}
	
	/**
	 * Este metodo aniade un ciudadano a la lista de suscritos si no estaba anteriormente
	 * @param c Ciudadano a aniadir a suscritos
	 */

	@Override
	public void suscribir(Ciudadano c) {
		
		if (c.getNombre() == this.getProponente().getNombre()) {
			return;
		}
		
		for (Ciudadano aux: suscritos) {
			
			if (aux == c) { 
				return;
			}		
		}
		
		suscritos.add(c);
		return;
	}
	
	/**
	 * Este metodo elimina a un ciudadano suscrito de la lista
	 * @param c Ciudadano a eliminar de la lista
	 */

	@Override
	public void desuscribir(Ciudadano c) {
		if (c.getNombre() == this.getProponente().getNombre()) {
			return;
		}
		for (Ciudadano aux: suscritos) {
			if (aux == c) {
				suscritos.remove(c);
				return;
			}
		}
		return;
	}
	
	/**
	 * Este metodo cambia el estado del proyecto a financiable
	 */
	
	public boolean estadoFinanciable() {
		this.estado = EstadoProyecto.financiable;
		
		if (this.estado == EstadoProyecto.financiable) {
			Aplicacion.generarNotificacion(this," ", "Financiacion "+this.getTitulo()+"");
			return true;

		}
		return false;
	}
	
	/**
	 * Este metodo acepta el proyecto, cambia su estado
	 */
	public boolean aceptarProyecto() {
		this.estado = EstadoProyecto.aceptado;
		
		if(this.estado == EstadoProyecto.aceptado) {
			Aplicacion.getProyectosPorAceptar().remove(this);
			
			Aplicacion.getProyectosAceptados().add(this);
			
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * Este metodo rechaza el proyecto, cambia su estado
	 */
	public boolean rechazarProyectoUsuario(Ciudadano c, String motivo) {
		
		this.estado = EstadoProyecto.rechazado;
		
		if(this.estado == EstadoProyecto.rechazado) {
		
			Aplicacion.getProyectosPorAceptar().remove(this);
			
			if (motivo.length() <= 50) {
				Aplicacion.generarNotificacion(this, motivo, ""+this.getTitulo()+" Rechazado");
			}
					
			c.getProyectos().remove(this);
			
			return true;
		}
		
		return false;

	}
	
	/**
	 * Este metodo rechaza el proyecto, cambia su estado
	 * @return 
	 */
	public boolean rechazarProyectoColectivo(Colectivo c, String motivo) {
		
		this.estado = EstadoProyecto.rechazado;
		
		if(this.estado == EstadoProyecto.rechazado) {
			if (motivo.length() <= 50) {
				Aplicacion.generarNotificacion(this, motivo, ""+this.getTitulo()+" Rechazado");
			}
			
			Aplicacion.getProyectosPorAceptar().remove(this);
					
			c.getProyectos().remove(this);
			
			return true;
		}
		
		return false;

	}
	
	/**
	 * Funcion encargada de modificar el estado del proyecto a caducado
	 */
	
	public void caducarProyecto() {
		
		int diferenciadias;

		LocalDate voto = this.getFechaUltimoVoto();
		FechaSimulada.restablecerHoyReal();
		LocalDate hoy = FechaSimulada.getHoy();
		diferenciadias = (hoy.getDayOfYear() - voto.getDayOfYear());
		if (diferenciadias == 30) {
			System.out.println("hola");
			this.estado = EstadoProyecto.caducado;
			Aplicacion.getCaducados().add(this);
			Aplicacion.getProyectosAceptados().remove(this);
			Aplicacion.generarNotificacion(this, "Han pasado 30 d�as y el proyecto no ha recibido nuevos apoyos. Sentimos comunicarle que su proyecto ha caducado", ""+this.getTitulo()+" Caducado");

		}
		
		
	}
	
	/**
	 * Este metodo devuelve el codigo del proyecto
	 * @return codigo
	 */
	
	public int getCodigo() {
		return codigo;
	}
	
	/**
	 * Este metodo modifica el codigo del proyecto
	 * @param codigo
	 */

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	
	}
	


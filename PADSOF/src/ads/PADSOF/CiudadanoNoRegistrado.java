package ads.PADSOF;

import java.util.ArrayList;
import java.util.List;

public class CiudadanoNoRegistrado extends Usuario {
	
	private static List<CiudadanoNoRegistrado> CNR = new ArrayList<>();
	

	public CiudadanoNoRegistrado(String name, String password, String dni) {
		super(name, password, dni);
		
		CNR = Aplicacion.getCNR();

		CNR.add(this); 
		
	   Aplicacion.setCNR(CNR);
	}
	
	public void Registrarse(String name, String password, String dni) {
		
		
		if (Aplicacion.getAdministradorCreado() == 1 && dni ==  null) {
			System.out.println("Ya existe un Administrador en la aplicacion"); //Ha intentado registrarse como Administrador pero ya existe uno
			return;
		}
		else if(Aplicacion.getAdministradorCreado() == 1) {
			
			if (dni.length() != 9) {
				System.out.println("DNI de 9 caracteres"); //Ha intentado registrarse como Administrador pero ya existe uno
				return;
			}
			
			int j = Aplicacion.getUsuariosAceptados().size();
			int m = Aplicacion.getUsuariosPorAceptar().size();
			int i;
			
			if (Aplicacion.getUsuariosAceptados().size() > 0 || Aplicacion.getUsuariosPorAceptar().size() > 0) {

				for (i = 0; i < j; i++) {
					
					if (name == Aplicacion.getUsuariosAceptados().get(i).getNombre()) {
						System.out.println("Ya existe un usuario registrado con ese nombre");
						return;
					} 
					else if(dni == Aplicacion.getUsuariosAceptados().get(i).getDNI()){
						System.out.println("Ya existe un usuario registrado con ese DNI");
						return;
					}
				}
				
				for (i = 0; i < m; i++) {
					
					if(name == Aplicacion.getUsuariosPorAceptar().get(i).getNombre()){
						System.out.println("Ya existe un usuario registrado con ese nombre");
					return;
					}
					else if(dni == Aplicacion.getUsuariosPorAceptar().get(i).getDNI()) {
						System.out.println("Ya existe un usuario registrado con ese nombre");
						return;
					}
				}
				
				
			}
			
			new Ciudadano(name, password, dni);

		}
		else if (dni == null){
			new Administrador (name, password, null);
			System.out.println("Te has registrado como Administrador");
		}
		else {
			System.out.println("No has conseguido registrarte");
			return;
		}
		
		CNR = Aplicacion.getCNR();

		CNR.remove(this); 
		
	   Aplicacion.setCNR(CNR);
	}

	@Override
	protected void setRepresentanteProyecto(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isRepresentanteProyecto() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void bloquearUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isBloqueado() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void desbloquearUsuario() {
		// TODO Auto-generated method stub
		
	}

}

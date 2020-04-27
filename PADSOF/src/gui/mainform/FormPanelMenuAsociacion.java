package gui.mainform;

import java.awt.event.ActionListener;

import javax.swing.*;

import ads.PADSOF.Aplicacion;
import ads.PADSOF.Colectivo;

public class FormPanelMenuAsociacion extends JPanel{
	
	private JButton Asociacion;
	
	private JButton Buscar;
	private JButton Proyectos;
	private JButton Perfil;
	private JButton Colectivos;
	
	private JComboBox opcion;
	
	private JList listaAsociaciones;
	
	private DefaultListModel asociaciones;


	public FormPanelMenuAsociacion() {
		
		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
		
		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(50);
				
		Proyectos = new JButton("Proyectos");
		Perfil = new JButton("Perfil");
		Colectivos = new JButton("Colectivos");
		JLabel etiqueta = new JLabel("Nuevos Colectivos: "); //LISTA CON LOS NUEVOS PROYECTOS CREADOS
		Buscar = new JButton("Buscar");
		
		String[] busqueda = {"Colectivos", "Proyectos"};
		opcion = new JComboBox(busqueda);
		opcion.setSelectedIndex(1);
		
		int tam = Aplicacion.getColectivos().size();
		
		if(tam > 1) {
			
			Colectivo aux = Aplicacion.getColectivos().get((tam-1));
			
			Aplicacion.getColectivos().remove(aux);
			
		}
		
		
		asociaciones = new DefaultListModel();
		
		tam = Aplicacion.getColectivos().size();
		int i;
		
		for (i = 0; i < tam; i++) {
			asociaciones.addElement(Aplicacion.getColectivos().get(i).getNombre());
		}
		
		listaAsociaciones = new JList(asociaciones); 
		
		listaAsociaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  
		
		JScrollPane scroll = new JScrollPane(listaAsociaciones); 
		
		Asociacion = new JButton("Más Informacion");
		

		
		layout.putConstraint(SpringLayout.WEST, campo, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, campo, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Buscar, 20, SpringLayout.EAST, campo);         
		layout.putConstraint(SpringLayout.NORTH, Buscar, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, opcion, 50, SpringLayout.EAST, Buscar);         
		layout.putConstraint(SpringLayout.NORTH, opcion, 10, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Proyectos, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Proyectos, 60, SpringLayout.NORTH, this); 
		
		layout.putConstraint(SpringLayout.WEST, Perfil, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Perfil, 300, SpringLayout.SOUTH, Proyectos); 
		
		layout.putConstraint(SpringLayout.WEST, Colectivos, 10, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Colectivos, 300, SpringLayout.SOUTH, Perfil); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 100, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, listaAsociaciones, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, listaAsociaciones, 20, SpringLayout.SOUTH, etiqueta); 
		
		layout.putConstraint(SpringLayout.WEST, Asociacion, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Asociacion, 100, SpringLayout.SOUTH, listaAsociaciones); 
		
		

		this.add(campo);
		this.add(Proyectos);
		this.add(Perfil);
		this.add(Colectivos);
		this.add(etiqueta);
		this.add(Buscar);
		
		this.add(Asociacion);
		
		this.add(opcion);
		
		this.add(listaAsociaciones);
		this.add(scroll);

	
	}
	
	public void setControladorBuscar(ActionListener c) {  
		Buscar.addActionListener(c);   
	}

	public void setControladorPerfil(ActionListener c) {  
		Perfil.addActionListener(c);   
	} 
	
	public void setControladorMenuProyecto(ActionListener c) {  
		Proyectos.addActionListener(c);   
	} 
	
	public void setControladorMenuColectivo(ActionListener c) {  
		Colectivos.addActionListener(c);   
	}
	
	public void setControladorInformacion(ActionListener c) {  
		Asociacion.addActionListener(c);   
	}
	
	public String nombreColectivo() {
		return (String)listaAsociaciones.getSelectedValue();
	}


}

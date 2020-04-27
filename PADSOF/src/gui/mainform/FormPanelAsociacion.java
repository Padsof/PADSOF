package gui.mainform;

import java.awt.event.ActionListener;

import javax.swing.*;

import ads.PADSOF.Colectivo;
public class FormPanelAsociacion extends JPanel{
	
	private JButton Buscar;
	private JButton Proyectos;
	private JButton Perfil;
	private JButton Colectivos;
	private JButton Unirse;
	private JButton Abandonar;
	private JButton Sub_Asociacion;
	
	private JLabel nombre;
	
	private JComboBox opcion;

	
	public FormPanelAsociacion(Colectivo colectivo) {

		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
		
		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(50);
		
		Proyectos = new JButton("Proyectos");
		Perfil = new JButton("Perfil");
		Colectivos = new JButton("Colectivos");
		Unirse = new JButton("Unirse");
		Sub_Asociacion = new JButton("Crear Sub Asociacion");
		Abandonar = new JButton("Abandonar");
		
		String[] busqueda = {"Colectivos", "Proyectos"};
		opcion = new JComboBox(busqueda);
		opcion.setSelectedIndex(1);


		
		JLabel etiqueta = new JLabel("Asociacion: "+colectivo.getNombre()+"");
		nombre = new JLabel(colectivo.getNombre());
		
		
		JLabel etiqueta2 = new JLabel("Numero de miembros: "+colectivo.getNumMiembros()+"");
		
		JLabel etiqueta3 = new JLabel("Nombre del representante: "+colectivo.getRepresentante().getNombre()+"");


		
		Buscar = new JButton("Buscar");

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
		
		layout.putConstraint(SpringLayout.WEST, etiqueta2, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta2, 150, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, etiqueta3, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta3, 200, SpringLayout.SOUTH, campo);
		
		layout.putConstraint(SpringLayout.WEST, Unirse, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Unirse, 100, SpringLayout.SOUTH, etiqueta3);
		
		layout.putConstraint(SpringLayout.WEST, Abandonar, 260, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Abandonar, 100, SpringLayout.SOUTH, etiqueta3);
		
		layout.putConstraint(SpringLayout.WEST, Sub_Asociacion, 400, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Sub_Asociacion, 100, SpringLayout.SOUTH, etiqueta3);
		
		this.add(campo);
		this.add(Proyectos);
		this.add(Perfil);
		this.add(Colectivos);
		this.add(etiqueta);
		this.add(etiqueta2);
		this.add(etiqueta3);
		this.add(Unirse);
		this.add(Abandonar);
		this.add(Sub_Asociacion);
		this.add(Buscar);
		
		this.add(opcion);


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
	
	public void setControladorUnirseColectivo(ActionListener c) {
		Unirse.addActionListener(c);
	}
	
	public String nombreAsociacion() {
		return nombre.getText();
	}

	

}

package gui.mainform;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import gui.control.Buscar;

public class FormPanelProyecto extends JPanel{
	
	private JButton Suscribirse;
	private JButton Informe;
	private JButton Apoyar;
	
	private JButton Buscar;
	private JButton Proyectos;
	private JButton Perfil;
	private JButton Colectivos;
	
	private JComboBox opcion;



	public FormPanelProyecto() {

		SpringLayout layout = new SpringLayout(); // Layout basado en restricciones...     
		this.setLayout(layout); 
		
		//PARA REALIZAR BUSQUEDAS
		JTextField campo = new JTextField(50);
		
		Buscar = new JButton("Buscar");
		Suscribirse = new JButton ("Suscribirse");
		Informe = new JButton ("Informe de Popularidad");
		Apoyar = new JButton ("Apoyar");


		Proyectos = new JButton("Proyectos");
		Perfil = new JButton("Perfil");
		Colectivos = new JButton("Colectivos");
		JLabel etiqueta = new JLabel("Proyecto: ");
		JLabel etiqueta2 = new JLabel("Descripcion: ");
		
		String[] busqueda = {"Colectivos", "Proyectos"};
		opcion = new JComboBox(busqueda);
		opcion.setSelectedIndex(1);
		
		
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
		layout.putConstraint(SpringLayout.NORTH, etiqueta, 50, SpringLayout.SOUTH, campo); 
		
		layout.putConstraint(SpringLayout.WEST, etiqueta2, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, etiqueta2, 50, SpringLayout.SOUTH, etiqueta);
		
		layout.putConstraint(SpringLayout.WEST, Suscribirse, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Suscribirse, 100, SpringLayout.SOUTH, etiqueta2); 
		
		layout.putConstraint(SpringLayout.WEST, Apoyar, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Apoyar, 150, SpringLayout.SOUTH, etiqueta2); 
		
		layout.putConstraint(SpringLayout.WEST, Informe, 160, SpringLayout.WEST, this);         
		layout.putConstraint(SpringLayout.NORTH, Informe, 200, SpringLayout.SOUTH, etiqueta2); 
		
		
		this.add(campo);
		this.add(Buscar);
		
		this.add(Proyectos);
		this.add(Perfil);
		this.add(Colectivos);
		
		this.add(etiqueta);
		this.add(etiqueta2);
		
		this.add(Suscribirse);
		this.add(Apoyar);
		this.add(Informe);
		
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

}

package gui.control;

import java.awt.event.*;

import gui.mainform.*;
public class Volver implements ActionListener{

	private Ventana frame;
	private RegistroFrame ventanaRegistro;
	private FormPanelRegistro registroVista;
	private FormPanelInicio inicioVista;
	
	 public Volver(Ventana frame, RegistroFrame registro) { 

		 this.frame = frame;
		 this.ventanaRegistro = registro;
		 this.inicioVista = frame.getInicio();
		 this.registroVista = registro.getRegistro();
	 }
	 
	 public void actionPerformed(ActionEvent e) { 
		 		 
		 inicioVista.setVisible(true);
		 registroVista.setVisible(false);
		 ventanaRegistro.setVisible(false);
		 frame.setVisible(true);

		 
	 }

}

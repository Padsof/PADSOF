package gui.control;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import gui.mainform.*;

public class Registrate  implements ActionListener {
	
	private Ventana frame;
	private RegistroFrame ventanaRegistro;
	private FormPanelRegistro registroVista;
	private FormPanelInicio inicioVista;
	
	 public Registrate(Ventana frame) { 

		 this.frame = frame;
		 this.inicioVista = frame.getInicio();
	 }
	 
	 public void actionPerformed(ActionEvent e) { 
		 
		 RegistroFrame ventanaRegistro = new RegistroFrame();
		 FormPanelRegistro registroVista = new FormPanelRegistro();
		 
		 
		 ControladorRegistrarse controladorR2 = new ControladorRegistrarse (ventanaRegistro);
		 ControladorVolver controladorV = new ControladorVolver(frame, ventanaRegistro);


		 
		 ventanaRegistro.setControladorVolver(controladorV);
		 ventanaRegistro.setControladorRegistrarse(controladorR2);
		 
		 inicioVista.setVisible(false);
		 ventanaRegistro.setVisible(true);
		 frame.setVisible(false);
		 registroVista.setVisible(true);
		 
		 
	 }
}

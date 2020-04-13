package gui.mainform;

import javax.swing.*;

public class FormPanelMenuAsociacion extends JPanel{

	public FormPanelMenuAsociacion(MenuAsociacionFrame menuAsociacionFrame) {
		//PARA REALIZAR BUSQUEDAS
				JTextField campo = new JTextField(100);
				
				JButton boton = new JButton("Proyectos");
				JButton boton2 = new JButton("Perfil");
				JButton boton3 = new JButton("Colectivos");
				JLabel etiqueta = new JLabel("Nuevos Colectivos: "); //LISTA CON LOS NUEVOS PROYECTOS CREADOS
				JButton boton4 = new JButton("Colectivo numero 1");

				this.add(campo);
				this.add(boton);
				this.add(boton2);
				this.add(boton3);
				this.add(etiqueta);
				this.add(boton4);
	}

}

package gui.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyButtonListener implements ActionListener {

	private JFrame ventana;

	public MyButtonListener(JFrame ventana) {

		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		JOptionPane.showMessageDialog(this.ventana, "Esto va de mal en peor");
	}

}

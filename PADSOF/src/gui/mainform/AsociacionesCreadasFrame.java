package gui.mainform;
import javax.swing.*;


public class AsociacionesCreadasFrame extends JFrame{

	private FormPanelAsociacionesCreadas fp = new FormPanelAsociacionesCreadas(this);
	
	public AsociacionesCreadasFrame() {
		//this. = new JFrame("Registrarse");
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}

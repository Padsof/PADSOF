package gui.mainform;

import javax.swing.*;

public class MainFrame extends JFrame{
	
	private FormPanel fp = new FormPanel(this);
	
	public MainFrame() {
		
		this.setContentPane(fp);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250,140);
		this.setVisible(true);
		
	}
}

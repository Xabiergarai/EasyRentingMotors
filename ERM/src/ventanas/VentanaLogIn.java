package ventanas;

import java.awt.Dimension;

import javax.swing.JFrame;

public class VentanaLogIn extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	
	public VentanaLogIn() {
		this.setTitle("Easy Renting Motors");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 500, 250);
		this.setMinimumSize(new Dimension(250, 250));
		
		
	}

}

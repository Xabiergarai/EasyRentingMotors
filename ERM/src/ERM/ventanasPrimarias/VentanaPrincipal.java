package ERM.ventanasPrimarias;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {

	public VentanaPrincipal() {
		setSize(400, 360);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Menu Principal");
	}
				
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VentanaPrincipal();
	}

}

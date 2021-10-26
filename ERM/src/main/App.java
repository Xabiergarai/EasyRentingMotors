package main;

import java.awt.EventQueue;

import ventanas.VentanaLogIn;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					VentanaLogIn vl = new VentanaLogIn();
					vl.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		
		
	}

}

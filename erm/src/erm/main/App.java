package erm.main;

import java.awt.EventQueue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import erm.ventanasPrimarias.VentanaInicial;

public class App {

	public static Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		
		logger.info("Programa comenzado");
		
	

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaInicial vi = new VentanaInicial();
					vi.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		
	}

}

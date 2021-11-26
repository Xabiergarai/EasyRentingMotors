package erm.main;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import erm.ventanasPrimarias.VentanaInicial;
import erm.ventanasPrimarias.VentanaLogIn;

public class App {

	public static Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (FileInputStream fis = new FileInputStream("logger.properties")) {
			LogManager.getLogManager().readConfiguration(fis);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "No se pudo leer el fichero de configuracion del logger");
		}

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

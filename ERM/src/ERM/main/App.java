package ERM.main;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import ERM.ventanasPrimarias.VentanaLogIn;

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
					VentanaLogIn vl = new VentanaLogIn();
					vl.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		
		
        logger.info("Programa finalizado");

		
	}

}

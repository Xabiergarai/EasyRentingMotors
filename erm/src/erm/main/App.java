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
		
		Properties properties= new Properties();
	    try {
	      properties.load(new FileInputStream(new File("config.properties")));
	      
	      System.out.println(properties.get("password"));
	      System.out.println(properties.get("username"));
	      System.out.println(properties.get("driver"));
	    } catch (FileNotFoundException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    } catch (IOException e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
		

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

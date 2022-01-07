package erm.excepciones;

/**
 * Utilizamos esta excepcion para la clase alquiler. El nombre del usuario que alquila el coche de ninguna manera
 * podrá estar vacio. De ser así, saltará la excepcion implicita que hemos creado.
 * 
 * @author gutia
 *
 */

public class ExcepcionExplicita extends Exception{
	private String mensaje;
	
	public ExcepcionExplicita(String m) {
		mensaje = m;
	}
	
	public String toString() {
		return mensaje;
	}

}

package erm.excepciones;

/**
 * Utilizamos esta excepcion para la clase alquiler. El nombre del usuario que alquila el coche de ninguna manera
 * podr� estar vacio. De ser as�, saltar� la excepcion implicita que hemos creado.
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

package erm.excepciones;
/**
 * Utilizamos esta excepcion para la clase alquiler. El nombre del usuario que alquila el coche de ninguna manera
 * podrá estar vacio. De ser así, saltará la excepcion implicita que hemos creado.
 * 
 * @author gutia
 *
 */
public class ExcepcionImplicita extends RuntimeException{
	private String mensaje;
	
	public ExcepcionImplicita(String m) {
		mensaje = m;
	}
	
	public String toString() {
		return mensaje;
	}
}


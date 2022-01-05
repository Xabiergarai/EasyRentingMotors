package erm.excepciones;

/**
 * Utilizamos esta excepcion para la clase carrito. El precio no podrá ser 0 o menor que 0. 
 * Si fuera así, saltaría la excepcion explicita que estamos creando. Hay un metodo en CarritoTest que comprueba que estamos declarando la 
 * excepcion en carrito de forma correcta.
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

package erm.excepciones;
/**
 * Utilizamos esta clase para hacer que la fecha de matriculaci�n no pueda ser menor al a�o 2000. Esta
 * fecha seria demasiado antigua para poder matricularse en nuestra aplicaci�n.
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

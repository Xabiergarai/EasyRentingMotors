package erm.excepciones;

public class ExcepcionImplicita extends RuntimeException{
	private String mensaje;
	
	public ExcepcionImplicita(String m) {
		mensaje = m;
	}
	
	public String toString() {
		return mensaje;
	}
}


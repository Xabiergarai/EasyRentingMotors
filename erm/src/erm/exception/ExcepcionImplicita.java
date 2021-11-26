package erm.exception;

public class ExcepcionImplicita extends RuntimeException {
	private String mensaje;
	
	public ExcepcionImplicita(String m) {
		mensaje = m;
	}
	
	public String toString() {
		return mensaje;
	}

}

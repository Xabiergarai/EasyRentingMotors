package erm.exception;

public class ExcepcionExplicita extends Exception{
	
	private String mensaje;
	
	public ExcepcionExplicita(String m) {
		mensaje = m;
	}
	
	public String toString() {
		return mensaje;
	}

}
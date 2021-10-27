package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ERM.clasesBasicas.Usuario;

public class TestUsuario {

	private Usuario u;
	
	
	@BeforeEach
	public void setup() {
		 u=new Usuario("Javier", "Contreras", "j.contre", "123", "javicoa@opendeusto.es");
	}				
	
	@Test
	public void testNombre() {
		assertEquals("Javier", u.getNombre());						
	}
		
	@Test
	public void testContrasenya() {
		assertEquals("123", u.getContrasenya());						
	}
	
	@Test
	public void testApellido() {
		assertEquals("Contreras", u.getApellidos());						
	}
	
	/*
	public void testSetNullNombre() {
		assertThrows(NullPointerException.class,()-> u.setNombre(null));
	}
	*/
	
	
}

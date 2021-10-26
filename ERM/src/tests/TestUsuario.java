package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import clasesBasicas.Usuario;

class TestUsuario {

	
	@Test
	public void testNombre() {
		Usuario u = new Usuario("Javier", "Contreras", "contre", "123asd", "javicoa@opendeusto.es");
		assertEquals("Javier", u.getNombre());						
	}
	
	
	@Test
	public void testContrasenya() {
		Usuario u = new Usuario("Javier", "Contreras", "contre", "123asd", "javicoa@opendeusto.es");
		assertEquals("123asd", u.getContrasenya());						
	}
	
	
	
}

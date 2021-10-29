package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ERM.clasesBasicas.Usuario;


/*
 * 
 * Esta clase se encarba para hacer test de la clase basica, Usuario.
 * 
 */


public class TestUsuario extends GroupException {

	private Usuario u;
		
	@BeforeEach
	public void setup() {
		 u=new Usuario("Javier", "Contreras", "j.contre", "123", "javicoa@opendeusto.es");
	}				
	
	
	@Test
	public void testToString() {
		assertEquals("Usuario [nombre=Javier, apellidos=Contreras, nickname=j.contre, contrasenya=123, email=javicoa@opendeusto.es]", u.toString());
	}
					
	@Test
	public void testgetApellidos() {
		assertEquals("Contreras", u.getApellidos());
	}
	
	@Test
	public void testSetApellidos() {
		u.setApellidos("Garai");
		assertEquals("Garai", u.getApellidos());
	}
	
	@Test
	public void testGetContrasenya() {
		assertEquals("123", u.getContrasenya());
	}
	
	@Test
	public void testSetContrasenya() {
		u.setContrasenya("321");
		assertEquals("321", u.getContrasenya());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("javicoa@opendeusto.es", u.getEmail());
	}
	
	@Test
	public void testSetEmail() {
		u.setEmail("xabigarai@opendeusto.es");
		assertEquals("xabigarai@opendeusto.es", u.getEmail());
	}
	
	@Test
	public void testGetNomUsuario() {
		assertEquals("j.contre", u.getNomUsuario());
	}
	
	@Test
	public void testSetNomUsuario() {
		u.setNomUsuario("Xabi00");
		assertEquals("Xabi00", u.getNomUsuario());
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Javier", u.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		u.setNombre("Xabi");
		assertEquals("Xabi", u.getNombre());
	}
}

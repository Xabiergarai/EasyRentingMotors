package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.clasesBasicas.Usuario;


/**
 * 
 * Esta clase se encarga para hacer test de la clase basica, Usuario.
 * 
 */


public class UsuarioTest  {

	private Usuario u;
	private Usuario u1;
	private Usuario u2;	
	private Usuario u3;


	
	@BeforeEach
	public void setup() {
		 u=new Usuario("Javier", "Contreras", "j.contre", "123", "javicoa@opendeusto.es","192.72.54.1");
		 u1=new Usuario();
		 u2 = new Usuario("jc", "12", "jc@gmail.com");
		 u3 =new Usuario(01,"javier");
	}				

		
	@Test
	public void testGetNomUsuario() {
		assertEquals("j.contre", u.getNickname());
	}
	
	@Test
	public void testSetNomUsuario() {
		u.setNickname("Xabi00");
		assertEquals("Xabi00", u.getNickname());
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
	public void testGetDireccionIP() {
		assertEquals("192.72.54.1", u.getDireccionIP());
	}
	
	@Test
	public void testSetDireccionIP() {
		u.setDireccionIP("192.56.45.1");
		assertEquals("192.56.45.1", u.getDireccionIP());
	}
		
	@Test
	public void testGetId() {
		assertEquals(01, u3.getId());
	}
	
	@Test
	public void testSetId() {
		u3.setId(02);
		assertEquals(02, u3.getId());
	}
	
	@Test
	public void testToString() {
		assertEquals("Usuario [id=0, nombre=Javier, apellidos=Contreras, nickname=j.contre, contrasenya=123, email=javicoa@opendeusto.es, direccionIP=192.72.54.1]"
, u.toString());
	}
		
	
}
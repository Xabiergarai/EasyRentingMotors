package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.clasesBasicas.Administrador;
import erm.clasesBasicas.Alquiler;

class AdministradorTest {

	private Administrador a;
	private Administrador a1;

	
	@BeforeEach
	public void setUp() {
		 a = new Administrador("j.c", "12", "j@gmail.com", "javier", "contreras", "182.255.255.255", "12", "1", "2", "2");
		 a1 = new Administrador();
	}

	@Test
	public void testSetAdminUsuario() {
		a.setAdminUsuario("100");
		assertEquals("100", a.getAdminUsuario());
	}
	@Test
	public void testGetAdminUsuario() {
		assertEquals("12", a.getAdminUsuario());
	}
	
	
}

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import erm.clasesBasicas.Venta;

class VentaTest {

	private Venta v;
	private Venta v1;
	
	@BeforeEach
	public void setup() {
		 v=new Venta(01, 02, "Opel Astra", "Categoria A", null, "opel", "22-12-2021");
		 v1 = new Venta();
	}
	
	@Test
	public void testGetIdUsuario() {
		assertEquals(01, v.getIdUsuario());
	}
	

	@Test
	public void testSetIdUsuario() {
		v.setIdUsuario(01);
		assertEquals(01, v.getIdUsuario());
	}
	
	
	@Test
	public void testGetIdVenta() {
		assertEquals(02, v.getidVenta());
	}
	
	@Test
	public void testSetIdVenta() {
		v.setidVenta(02);
		assertEquals(02, v.getidVenta());
	}
	

}

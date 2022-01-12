package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.clasesBasicas.Carrito;
import erm.excepciones.ExcepcionExplicita;

class CarritoTest {

	private Carrito c;
	private Carrito c1;

	@BeforeEach
	public void setUp() throws ExcepcionExplicita {
		c = new Carrito("01", "1", "12-12-2012", 54);
		c1= new Carrito();
	}
		
	@Test
	public void testSetId() {
		c.setId("02");
		assertEquals("02", c.getId());
	}
			
	@Test
	public void testGetId() {	
		assertEquals("01", c.getId());		
	}
	
	@Test
	public void testSetNombre() {
		c.setNombre("2");
		assertEquals("2", c.getNombre());
	}
			
	@Test
	public void testGetNombre() {	
		assertEquals("1", c.getNombre());		
	}
	
	@Test
	public void testSetPrecio() {
		c.setPrecio(2000);
		assertEquals(2000, c.getPrecio());
	}
			
	@Test
	public void testGetPrecio() {	
		assertEquals(54, c.getPrecio());		
	}
	
	@Test
	public void testSetFecha() {
		c.setFecha("1-1-2010");
		assertEquals("1-1-2010", c.getFecha());
	}
			
	@Test
	public void testGetFecha() {	
		assertEquals("12-12-2012", c.getFecha());		
	}
	
	@Test
	public void testToString() {
		assertEquals("Carrito [id=01, nombre=1, precio=54.0, fecha=12-12-2012]"
, c.toString());
	}
	
	
	
}

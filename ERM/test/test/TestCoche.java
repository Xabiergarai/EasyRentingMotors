package test;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ERM.clasesBasicas.Coche;

class TestCoche {

	private Coche c;
	
	@BeforeEach
	void setUpCoche() {
		 c = new Coche("01", "A5", "A", "Audi", "2008-01-12", "10000", 50.000, "  ");	
	}

	
	@Test
	void testId() {
		assertEquals("01", c.getId());
	}

	
	@Test
	void testNombre() {
		assertEquals("A5", c.getNombre());
	}

	
	@Test
	void testPrecio() {
		assertEquals(50.000, c.getPrecio());
	}
				
}

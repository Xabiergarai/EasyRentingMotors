package test;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ERM.categoriasCoche.Coche;

class TestCoche extends GroupException {

	private Coche c;
	
	@BeforeEach
	void setUpCoche() {
		 c = new Coche("01", "A5", "A", "Audi", "2008-01-12", "Diesel", 50.000, "  ");	
	}

	
	@Test
	void testGetId() {
		assertEquals("01", c.getId());
	}
	
	@Test
	void testSetId() {
		c.setId("02");
		assertEquals("02", c.getId());		
	}
	
	@Test
	void testGetNombre() {
		assertEquals("A5", c.getNombre());
	}
	
	@Test
	void testSetNombre() {
		c.setNombre("A6");
		assertEquals("A6", c.getNombre());		
	}
	
	@Test
	void testGetClase() {
		assertEquals("A", c.getClase());
	}
	
	@Test
	void testSetClase() {
		c.setClase("X5");;
		assertEquals("X5", c.getClase());		
	}
	
	
	@Test
	void testGetMarca() {
		assertEquals("Audi", c.getMarca());
	}
	
	@Test
	void testSetMarca() {
		c.setClase("BMW");;
		assertEquals("Audi", c.getMarca());		
	}
	
	@Test
	void testGetFecha_matriculacion() {
		assertEquals("2008-01-12", c.getfecha_matriculacion());
	}
	
	@Test
	void testSetFecha_matriculacion() {
		c.setfecha_matriculacion("2010--02-00");;
		assertEquals("2010--02-00", c.getfecha_matriculacion());		
	}
	
	
	@Test
	void testGetcombustible() {
		assertEquals("Diesel", c.getCombustible());
	}
	
	@Test
	void testSetCombustible() {
		c.setCombustible("gasolina");
		assertEquals("gasolina", c.getCombustible());		
	}
	
	
	
	/*
	 * 
	 * Faltan mas
	 * 
	 * 
	 * 
	 */
	
	
				
}

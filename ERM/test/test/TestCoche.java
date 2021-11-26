package test;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ERM.categoriasCoche.Coche;

/**
 * 
 * Esta clase se encarga para hacer test de la clase basica, Coche.
 * 
 */


class TestCoche extends GroupException {

	private Coche c;
	
	@BeforeEach
	void setUpCoche() {
		 c = new Coche("01","Audi A5", "A5", "A", "Audi", "2008-01-12", "Diesel", 50.000, "  ");	
	}

	@Test
	void testToString() {
		assertEquals("Coche [id=01, nombre=A5, clase=A, marca=Audi, fecha_matriculacion=2008-01-12, combustible=Diesel, precio=50.0, rutaFoto=  ]"
		, c.toString());	
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
		c.setMarca("BMW");;
		assertEquals("BMW", c.getMarca());		
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
	
	
	@Test
	void testSetPrecio() {
		c.setPrecio(1);
		assertEquals(1, c.getPrecio());
	}

	@Test
	void testGetPrecio() {
		assertEquals(50.000, c.getPrecio());
	}
	
				
}

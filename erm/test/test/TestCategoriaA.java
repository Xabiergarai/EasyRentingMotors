package test;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.categoriasCoche.CategoriaA;


/**
 * 
 * Esta clase se encarga para hacer test de coches de categoria A.
 * 
 */


class TestCategoriaA extends GroupException {
	
	
	private CategoriaA a;
	
	@BeforeEach
	public void setUp() {
		 a= new CategoriaA("CA01", "Citroen C1", "A", "Citroen",
				"2019/06-05", "Diesel", 4999.99, " ", 3, true);
	}
	
	@Test
	public void testGetId() {
		assertEquals("CA01", a.getId());
	}
	
	
	@Test
	public void testSetId() {
		a.setId("01");
		assertEquals("01", a.getId());
	}
			
	@Test
	public void testSetNombre() {
		a.setNombre("camion");
		assertEquals("camion", a.getNombre());
	}
	
	
	
	@Test
	public void testGetNumPuertas() {	
		assertEquals(3, a.getNumPuertas());
	}
	
	@Test
	public void testSetNumPuertas() {	
		a.setNumPuertas(4);
		assertEquals(4, a.getNumPuertas());
	}
		
	@Test
	public void testGetMaletero() {				
		assertEquals(true, a.isMaletero());
	}		

}

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


class CategoriaATest{
	
	
	private CategoriaA a;
	private CategoriaA a1;
	private static final long serialVersionUID = 1L;

	
	@BeforeEach
	public void setUp() {
		 a= new CategoriaA("CA01", "Citroen C1", "A", "Citroen",
				"2019/06-05", "Diesel", 4999.99, " ", 3, true);
		 a1= new CategoriaA();
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

	@Test
	public void testToString() {
		assertEquals("CategoriaA [numPuertas=3, maletero=true]", a.toString());
	}
	
	@Test
	public void testGetSerialversionuid() {				
		assertEquals(serialVersionUID, a.getSerialversionuid());
	}
	
	@Test
	public void testSetDescapotable() {	
		a.setMaletero(false);
		assertFalse(a.isMaletero());
	}
	
	
	
}

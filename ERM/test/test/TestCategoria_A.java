package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ERM.categoriasCoche.Categoria_A;


/**
 * 
 * Esta clase se encarga para hacer test de coches de categoria A.
 * 
 */


class TestCategoria_A extends GroupException {
	
	
	private Categoria_A a;
	
	@BeforeEach
	public void setUp() {
		 a= new Categoria_A("CA01", "Citroen C1", "A", "Citroen",
				"2019/06-05", "Diesel", 4999.99, " ", 3, true);
	}
	
	

	@Test
	public void testGetNumPuertas() {	
		assertEquals(3, a.getNumPuertas());
	}
	
	@Test
	public void testGetMaletero() {				
		assertEquals(true, a.isMaletero());
	}
	

	

}

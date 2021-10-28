package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ERM.categoriasCoche.Categoria_A;

class TestCategoria_A extends GroupException {

	@Test
	public void testGetNumPuertas() {
		
		Categoria_A a = new Categoria_A("CA01", "Citroen C1", "A", "Citroen",
				"2019/06-05", "Diesel", 4999.99, " ", 3, true);
		
		assertEquals(3, a.getNumPuertas());
	}
	
	@Test
	public void testGetMaletero() {
		
		Categoria_A a = new Categoria_A("CA01", "Citroen C1", "A", "Citroen",
				"2019/06-05", "Diesel", 4999.99, " ", 3, true);
		
		assertEquals(true, a.isMaletero());
	}
	
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	

}

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ERM.categoriasCoche.Categoria_A;
import ERM.categoriasCoche.Categoria_B;

class TestCategoria_B {
	
	
	@Test
	public void testGetNumPuertas() {
		
		Categoria_B b = new Categoria_B("CB01", "Audi A3", "B", "Audi",
				"2020/01-05", "Gasolina", 19999.99, " ",5, false, false );
		
		assertEquals(5, b.getNumPuertas());
	}
	
	@Test
	public void testGetDescapotable() {
		
		Categoria_B b = new Categoria_B("CA01", "Citroen C1", "A", "Citroen",
				"2019/06-05", "Diesel", 4999.99, " ", 5, false, false);
		
		assertEquals(false,b.isdescapotable());
	} 
	 
	
	@Test
	public void testGetDeportivo() {
		
		Categoria_B b = new Categoria_B("CA01", "Citroen C1", "A", "Citroen",
				"2019/06-05", "Diesel", 4999.99, " ", 5, false, false);
		
		assertEquals(false,b.isDeportivo());
	} 
	
	
	

}

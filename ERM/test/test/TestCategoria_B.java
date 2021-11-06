package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ERM.categoriasCoche.Categoria_A;
import ERM.categoriasCoche.Categoria_B;



/**
 * 
 * Esta clase se encarga para hacer test de coches de categoria B.
 * 
 */



class TestCategoria_B {
	
	
	
private Categoria_B b;
	
	@BeforeEach
	public void setUp() {
		 b= new Categoria_B("CB01", "Audi A3", "B", "Audi",
					"2020/01-05", "Gasolina", 19999.99, " ",5, false, false );
	}
	
	
	@Test
	public void testGetNumPuertas() {				
		assertEquals(5, b.getNumPuertas());
	}
	
	@Test
	public void testSetNumPuertas() {		
		b.setNumPuertas(4);
		assertEquals(4,b.getNumPuertas());
	}	
	
	
	@Test
	public void testGetDescapotable() {				
		assertEquals(false,b.isdescapotable());
	} 
	 
	
	@Test
	public void testGetDeportivo() {						
		assertEquals(false,b.isDeportivo());
	} 			

}

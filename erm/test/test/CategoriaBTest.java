package test;

import static org.junit.jupiter.api.Assertions.*; 

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.categoriasCoche.CategoriaB;




/**
 * 
 * Esta clase se encarga para hacer test de coches de categoria B.
 * 
 */



class CategoriaBTest {
	
	
	
private CategoriaB b;
private CategoriaB b1;

	
	@BeforeEach
	public void setUp() {
		 b= new CategoriaB("CB01", "Audi A3", "B", "Audi",
					"2020/01-05", "Gasolina", 19999.99, " ",5, false, false );
		 b1 = new CategoriaB();
	}
		
	@Test
	public void testSetId() {		
		b.setId("1");
		assertEquals("1",b.getId());
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
		assertEquals(false,b.isDescapotable());
	} 
	 
	
	@Test
	public void testGetDeportivo() {						
		assertEquals(false,b.isDeportivo());
	} 			

	
	@Test
	public void testToString() {
		assertEquals("CategoriaB [descapotable=false, deportivo=false]"
, b.toString());
	}
	
	@Test
	public void testSetDescapotable() {	
		b.setDescapotable(false);
		assertFalse(b.isDescapotable());
	}
	
	
	@Test
	public void testSetDeportivo() {	
		b.setDeportivo(false);
		assertFalse(b.isDeportivo());
	}
	
	
	
	
}

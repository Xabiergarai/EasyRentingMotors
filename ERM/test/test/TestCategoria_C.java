package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ERM.categoriasCoche.Categoria_B;
import ERM.categoriasCoche.Categoria_C;


/**
 * 
 * Esta clase se encarga para hacer test de coches de categoria C.
 * 
 */


class TestCategoria_C {
	
	
	
private Categoria_C c;
	
	@BeforeEach
	public void setUp() {
		 c= new Categoria_C("CC01", "Suzuki Vitara", "C", "Suzuki",
					"2018/10-15", "Gasolina", 9999.99, " ", "cuatroxcuatro", true );
	}
	
	@Test
	public void testGetTipoTodoTerreno() {		
		assertEquals("cuatroxcuatro", c.getTipoTodoTerreno());
	}
	
	@Test
	public void testSetTipoTodoTerreno() {	
		c.setTipoTodoTerreno("vito");
		assertEquals("vito", c.getTipoTodoTerreno());
	}
	
	@Test
	public void testGetDescapotable() {				
		assertEquals(true, c.isDescapotable());
	}
	
	


}

package test;

import static org.junit.jupiter.api.Assertions. *;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.categoriasCoche.CategoriaC;




/**
 * 
 * Esta clase se encarga para hacer test de coches de categoria C.
 * 
 */


class CategoriaCTest {
	
	
	
private CategoriaC c;
	
	@BeforeEach
	public void setUp() {
		 c= new CategoriaC("CC01", "Suzuki Vitara", "C", "Suzuki",
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
	
	@Test
	public void testToString() {
		assertEquals("CategoriaC [tipoTodoTerreno=cuatroxcuatro, descapotable=true]"
, c.toString());
	}

	
	

}
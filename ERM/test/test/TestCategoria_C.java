package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ERM.categoriasCoche.Categoria_B;
import ERM.categoriasCoche.Categoria_C;

class TestCategoria_C {
	
	

	@Test
	public void testGetTipoTodoTerreno() {
		
		Categoria_C c = new Categoria_C("CC01", "Suzuki Vitara", "C", "Suzuki",
				"2018/10-15", "Gasolina", 9999.99, " ", "cuatroxcuatro", true );
		
		assertEquals("cuatroxcuatro", c.getTipoTodoTerreno());
	}
	
	@Test
	public void testGetDescapotable() {
		
		Categoria_C c = new Categoria_C("CC01", "Suzuki Vitara", "C", "Suzuki",
				"2018/10-15", "Gasolina", 9999.99, " ", "cuatroxcuatro", true );
		
		assertEquals(true, c.isDescapotable());
	}
	
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}

package test;
import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.clasesBasicas.Opinion;
import erm.clasesBasicas.Venta;

public class OpinionTest {
	
	private Opinion o;
	private Opinion o1;
	
	@BeforeEach
	void setup() {
		 o = new Opinion(01, "Genial", "Sensacional experiencia");
		 o1 = new Opinion();
	}

	@Test
	void testGetIdUsuario() {
		assertEquals(01, o.getIdUsuario());
	}

	@Test
	void testSetIdUsuario() {
		o.setIdUsuario(01);
		assertEquals(01, o.getIdUsuario());
	}
	
	@Test
	void testGetTitulo() {
		assertEquals("Genial", o.getTitulo());
	}
	
	@Test
	void testSetTitulo() {
		o.setTitulo("Muy bien");
		assertEquals("Muy bien", o.getTitulo());
	}
	
	@Test
	void testGetDescripcion() {
		assertEquals("Sensacional experiencia", o.getDescripcion());
	}
	
	@Test
	void testToString() {
		assertEquals("Opinion [idUsuario=1, titulo=Genial, descripcion=Sensacional experiencia]", o.toString());
	}
	
	@Test
	public void testSetDescripcion() {
		o.setDescripcion("Una maravillosa aplicacion web");
		assertEquals("Una maravillosa aplicacion web", o.getDescripcion());
	}

}



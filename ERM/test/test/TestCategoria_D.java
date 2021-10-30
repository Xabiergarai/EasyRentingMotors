package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ERM.categoriasCoche.Categoria_B;
import ERM.categoriasCoche.Categoria_D;

class TestCategoria_D {
	
	
	@Test
	public void testGetTipoFurgoneta() {
		
		Categoria_D d = new Categoria_D("CD01", "Volkswagen Transporter", "D", "Volkswagen",
				"2021/08-27", "Diesel", 7499.99," ", "Tipo transporter", true);
		
		assertEquals("Tipo transporter", d.getTipoFurgoneta());
	}
	
	@Test
	public void testGetDescapotable() {
		
		Categoria_D d = new Categoria_D("CD01", "Volkswagen Transporter", "D", "Volkswagen",
				"2021/08-27", "Diesel", 7499.99," ", "Tipo transporter", true);
		
		assertEquals(true, d.isDescapotable());
	}
	
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}

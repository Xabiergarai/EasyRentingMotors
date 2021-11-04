package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ERM.categoriasCoche.Categoria_D;

/**
 * 
 * Esta clase se encarga para hacer test de coches de categoria D.
 * 
 */



class TestCategoria_D {
	
	
private Categoria_D d;
	
	@BeforeEach
	public void setUp() {
		 d= new Categoria_D("CD01", "Volkswagen Transporter", "D", "Volkswagen",
					"2021/08-27", "Diesel", 7499.99," ", "Tipo transporter", true);
	}
	
	
	@Test
	public void testGetTipoFurgoneta() {					
		assertEquals("Tipo transporter", d.getTipoFurgoneta());
	}
	
	@Test
	public void testGetDescapotable() {		
		assertEquals(false, d.isDescapotable());
	}
		

}

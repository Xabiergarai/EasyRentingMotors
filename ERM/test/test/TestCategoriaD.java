package test;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ERM.categoriasCoche.CategoriaD;

/**
 * 
 * Esta clase se encarga para hacer test de coches de categoria D.
 * 
 */



class TestCategoriaD {
	
	
private CategoriaD d;
	
	@BeforeEach
	public void setUp() {
		 d= new CategoriaD("CD01", "Volkswagen Transporter", "D", "Volkswagen",
					"2021/08-27", "Diesel", 7499.99," ", "Tipo transporter", true);
	}
	
	@Test
	public void testGetId() {
		assertEquals("CD01", d.getId());
	}
	
	@Test
	public void testSetId() {
		d.setId("02");
		assertEquals("02", d.getId());
	}
	
	@Test
	public void testGetNombre() {
		assertEquals("Volkswagen Transporter", d.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		d.setNombre("Transp");
		assertEquals("Transp", d.getNombre());
	}
						
	@Test
	public void testGetTipoFurgoneta() {					
		assertEquals("Tipo transporter", d.getTipoFurgoneta());
	}
	
	@Test
	public void setTipoFurgoneta() {
		d.setTipoFurgoneta("Vito");
		assertEquals("Vito", d.getTipoFurgoneta());
	}
	
	
	@Test
	public void testGetDescapotable() {		
		assertEquals(false, d.isDescapotable());
	}
						

}

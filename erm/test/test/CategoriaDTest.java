package test;

import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.categoriasCoche.CategoriaD;

/**
 * 
 * Esta clase se encarga para hacer test de coches de categoria D.
 * 
 */



class CategoriaDTest {
	
	
private CategoriaD d;
private CategoriaD d1;
private static final long serialVersionUID = 1L;


	
	@BeforeEach
	public void setUp() {
		 d= new CategoriaD("CD01", "Volkswagen Transporter", "D", "Volkswagen",
					"2021/08-27", "Diesel", 7499.99," ", "Tipo transporter", true);
		 d1= new CategoriaD();
	}
	
	
	@Test
	public void testSetId() {
		d.setId("02");
		assertEquals("02", d.getId());
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
	public void testsetTipoFurgoneta() {
		d.setTipoFurgoneta("Vito");
		assertEquals("Vito", d.getTipoFurgoneta());
	}
		
	
	@Test
	public void testsetDescapotable() {
		d.setDescapotable(true); 
		assertTrue(d.isDescapotable());
	}

	@Test
	public void testToString() {
		assertEquals("CategoriaD [tipoFurgoneta=Tipo transporter, descapotable=true]"
, d.toString());
	}
	
	@Test
	public void testGetSerialversionuid() {				
		assertEquals(serialVersionUID, d.getSerialversionuid());
	}
	
	
}

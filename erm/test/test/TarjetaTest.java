package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.clasesBasicas.Opinion;
import erm.clasesBasicas.Tarjeta;

class TarjetaTest {

	
	private Tarjeta t;
	private Tarjeta t1;
	
	@BeforeEach
	void setup() {
		t1 = new Tarjeta();
		t = new Tarjeta("credit", "1", "12-12-12", "1", "2", "Javi Contre", "getxo", "getxo", "bilbao", "bizkaia", "488930", 1);
	}

	@Test
	public void testSetFecha() {
		t.setFecha("1-1-2010");
		assertEquals("1-1-2010", t.getFecha());
	}
					
	@Test
	public void testGetFecha() {	
		assertEquals("12-12-12", t.getFecha());		
	}
	
	@Test
	public void testGetTipo() {	
		assertEquals("credit", t.getTipo());		
	}
	
	@Test
	public void testSetTipo() {
		t.setTipo("debit");
		assertEquals("debit", t.getTipo());
	}
	
	@Test
	public void testGetNumeroTarjeta() {	
		assertEquals(1, t.getNumeroTarjeta());		
	}
	
	@Test
	public void testSetNumeroTarjeta() {
		t.setNumeroTarjeta("3");
		assertEquals("3", t.getNumeroTarjeta());
	}
	
}

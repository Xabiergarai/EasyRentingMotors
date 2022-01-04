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
		assertEquals("1", t.getNumeroTarjeta());		
	}
	
	@Test
	public void testSetNumeroTarjeta() {
		t.setNumeroTarjeta("3");
		assertEquals("3", t.getNumeroTarjeta());
	}
	
	@Test
	public void testGetCodigoDeSeguridad() {	
		assertEquals("1", t.getCodigoDeSeguridad());		
	}
	
	@Test
	public void testSetCodigoDeSeguridad() {
		t.setCodigoDeSeguridad("3");
		assertEquals("3", t.getCodigoDeSeguridad());
	}
	
	@Test
	public void testGetidTarjeta() {	
		assertEquals(0, t.getidTarjeta());		
	}
	
	@Test
	public void testSetidTarjeta() {
		t.setidTarjeta(4);
		assertEquals(4, t.getidTarjeta());
	}
	
	@Test
	public void testGetidUsuario() {	
		assertEquals(1, t.getidUsuario());		
	}
	
	@Test
	public void testSetidUsuario() {
		t.setidUsuario(5);
		assertEquals(5, t.getidUsuario());
	}
	
	@Test
	public void testGetCodigoPostal2() {	
		assertEquals("2", t.getCodigoPostal2());		
	}
	
	@Test
	public void testSetCodigoPostal2() {
		t.setCodigoPostal2("3");
		assertEquals("3", t.getCodigoPostal2());
	}
	
	@Test
	public void testGetNombreCompleto() {	
		assertEquals( "Javi Contre", t.getNombreCompleto());		
	}
	
	@Test
	public void testSetNombreCompleto() {
		t.setNombreCompleto("Javier");
		assertEquals("Javier", t.getNombreCompleto());
	}
	
	@Test
	public void testGetDireccion() {	
		assertEquals( "getxo", t.getDireccion());		
	}
	
	@Test
	public void testSetDireccion() {
		t.setDireccion("vitoria");
		assertEquals("vitoria", t.getDireccion());
	}
	
	@Test
	public void testGetCodigoPostal() {	
		assertEquals( "488930", t.getCodigoPostal());		
	}
	
	@Test
	public void testSetCodigoPostal() {
		t.setCodigoPostal("48");
		assertEquals("48", t.getCodigoPostal());
	}
	
	@Test
	public void testGetCiudad() {	
		assertEquals( "bilbao", t.getCiudad());		
	}
	
	@Test
	public void testSetCiudad() {
		t.setCiudad("vitoria");
		assertEquals("vitoria", t.getCiudad());
	}
	
	@Test
	public void testGetEstadoProvincia() {	
		assertEquals( "bizkaia", t.getEstadoProvincia());		
	}
	
	@Test
	public void testSetEstadoProvincia() {
		t.setEstadoProvincia("alava");
		assertEquals("alava", t.getEstadoProvincia());
	}
	
	@Test
	public void testGetLineaSegundaDireccion() {	
		assertEquals( "getxo", t.getLineaSegundaDireccion());		
	}
	
	@Test
	public void testSetLineaSegundaDireccion() {
		t.setLineaSegundaDireccion("areeta");
		assertEquals("areeta", t.getLineaSegundaDireccion());
	}
	
}

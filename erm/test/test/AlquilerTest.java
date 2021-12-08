package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.categoriasCoche.CategoriaA;
import erm.clasesBasicas.Alquiler;

/**
 * 
 * Esta clase se encarga para hacer test de coches de Alquiler
 * 
 */

class AlquilerTest {

	private Alquiler a;
	
	@BeforeEach
	public void setUp() {
		 a= new Alquiler("pepe019", "Fiat 500", "2021-12-20", "2021-12-31");
	}
	
	@Test
	public void testSetNomUsuario() {	
		a.setNomUsuario("luis01");
		assertEquals("luis01", a.getNomUsuario());
	}
	
	@Test
	public void testSetIdCoche() {	
		a.setIdCoche("Ford Tourneo");
		assertEquals("Ford Tourneo", a.getnomCoche());
	}
		
	@Test
	public void testGetFechaInicio() {
		assertEquals("2021-12-21", a.getFechaInicio());
	}
	
	@Test
	public void testGetFechaFin() {	
		assertEquals("2021-12-30", a.getFechaFin());
	}
	
	@Test
	public void testSetFechaInicio() {
		a.setFechaInicio("2021-12-12");
		assertEquals("2021-12-12", a.getFechaInicio());
	}
	
	@Test
	public void testSetFechaFin() {
		a.setFechaFin("2021-12-30");
		assertEquals("2021-12-30", a.getFechaFin());
	}
	@Test
	public void testGetNomCoche() {
		assertEquals("Fiat 500", a.getnomCoche());
	}
	
	

	@Test
	public void testToString() {
		assertEquals("Alquiler [nomUsuario= luis01, idCoche= Seat Ibiza, fechaInicio= 2021-12-23, fechaFin = 2021-12-30]", a.toString());
	}
	

}

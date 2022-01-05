package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.categoriasCoche.Coche;
import erm.clasesBasicas.ListaCoche;

class ListaCocheTest {
	

	ListaCoche listaCoche = new ListaCoche();
	Map<Integer, Coche> lista = listaCoche.getCoches();
	private Coche c;

	@BeforeEach
	public void setUp() {			
	lista.put(01, c);
	lista.get(01);
	c =new Coche("CCB", "Audi A3", "CategoriaB","Clase B",  "Audi", "2018-07-06", "Gasolina", 20.0000, "");
	}
	
	@Test
	public void testGetCoches() {
		assertEquals(lista, listaCoche.getCoches());
	}
	
	@Test
	public void testSetCoches() {
		listaCoche.setProductos(lista);
		assertEquals(lista, listaCoche.getCoches());
	}
	
	
	
}

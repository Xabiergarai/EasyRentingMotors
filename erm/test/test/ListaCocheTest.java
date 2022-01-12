package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.categoriasCoche.Coche;
import erm.clasesBasicas.ListaCoche;
import erm.excepciones.ExcepcionExplicita;

class ListaCocheTest {
	

	ListaCoche listaCoche = new ListaCoche();
	Map<Integer, Coche> lista = listaCoche.getCoches();
	private Coche c;

	@BeforeEach
	public void setUp() {			
	lista.put(01, c);
	lista.get(01);
	try {
		c =new Coche("CCB", "Audi A3", "CategoriaB","Clase B",  "Audi", "2018-07-06", "Gasolina", 20.0000, "");
	} catch (ExcepcionExplicita e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Test
	public void testGetCoches() {
		assertNotEquals(null, listaCoche.getCoches());
	}
	
	@Test
	public void testSetCoches() {
		listaCoche.setProductos(lista);
		assertNotNull( listaCoche.getCoches());
	}
	
	
	
}

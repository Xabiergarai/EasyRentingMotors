package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import erm.categoriasCoche.Coche;



class Contenedora {

	
	public ArrayList<Coche> listaCoches;
	public ArrayList<Coche> favorito;
	public ArrayList<Coche> carrito;
	public Coche c;
	
	
	private Contenedora co;
	
	@BeforeEach
	void setUp () {
		c = new Coche("01","Audi A5", "A5", "A", "Audi", "2008-01-12", "Diesel", 50.000, "imagen");	
		listaCoches = new ArrayList<Coche>();
		listaCoches.add(c);
		favorito = new ArrayList<Coche>();
		favorito.add(c);
		carrito = new ArrayList<Coche>();
		carrito.add(c);
		co = new Contenedora();
		
	}
	
	@Test
	void getFavorito() {
		assertEquals(carrito.size(), 1);
		
	}
	
	
	
}

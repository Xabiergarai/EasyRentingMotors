package erm.clasesBasicas;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import erm.categoriasCoche.Coche;
import erm.excepciones.ExcepcionExplicita;

public class ListaCoche extends Coche {

	private Map<Integer, Coche> coches = new TreeMap<>();


	public Map<Integer, Coche> getCoches() {

		return coches;
	}

	public void setProductos(Map<Integer, Coche> coches) {
		this.coches = coches;
	}

	public void listaCoche() {
		this.coches = new HashMap<Integer, Coche>();
	}
}

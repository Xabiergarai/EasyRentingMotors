package erm.clasesBasicas;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import erm.categoriasCoche.Coche;
import erm.excepciones.ExcepcionExplicita;

public class ListaCoche extends Coche {

	private Map<Integer, Coche> coches = new TreeMap<>();

	public static void main(String[] args) {

		ListaCoche listaCoche = new ListaCoche();

		Map<Integer, Coche> lista = listaCoche.getCoches();

		try {
			lista.put(01, new Coche("CCB", "Audi A3", "CategoriaB","Clase B",  "Audi", "2018-07-06", "Gasolina", 20.0000, ""));
		} catch (ExcepcionExplicita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		lista.get(01);

	}

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

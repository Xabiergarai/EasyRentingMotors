package ERM.clasesBasicas;

import java.util.HashMap;
import java.util.Map;

import ERM.categoriasCoche.Coche;

public class ListaCoche extends Coche {

	private Map<Integer, Coche> coches;

	public static void main(String[] args) {

		ListaCoche listaCoche = new ListaCoche();

		Map<Integer, Coche> lista = listaCoche.getCoches();

		lista.put(01, new Coche("CCB", "Audi A3", "CategoriaB", "Audi", "2018-07-06", "Gasolina", 20.0000, ""));

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

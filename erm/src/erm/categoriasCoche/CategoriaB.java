package erm.categoriasCoche;

public class CategoriaB extends Coche {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numPuertas;
	private boolean descapotable;
	private boolean deportivo;

	public CategoriaB(String id, String nombre, String categoria, String marca, String fecha_matriculacion,
			String combustible, double precio, String rutaFoto, int numPuertas, boolean descapotable,
			boolean deportivo) {
		
		this.numPuertas = numPuertas;
		this.descapotable = descapotable;
		this.deportivo = deportivo;
	}

	public CategoriaB() {
		super();
		this.numPuertas = 0;
		this.descapotable = false;
		this.deportivo = false;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public boolean isDescapotable() {
		return descapotable;
	}

	public void setDescapotable(boolean descapotable) {
		this.descapotable = descapotable;
	}

	public boolean isDeportivo() {
		return deportivo;
	}

	public void setDeportivo(boolean deportivo) {
		this.deportivo = deportivo;
	}

	@Override
	public String toString() {
		return "CategoriaB [descapotable=" + descapotable + ", deportivo=" + deportivo + "]";
	}

}

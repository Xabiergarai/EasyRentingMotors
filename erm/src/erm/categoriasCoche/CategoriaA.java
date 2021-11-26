package erm.categoriasCoche;

public class CategoriaA extends Coche {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numPuertas;
	private boolean maletero;

	public CategoriaA(String id, String nombre, String categoria, String marca, String fecha_matriculacion,
			String combustible, double precio, String rutaFoto, int numPuertas, boolean maletero) {
		
		this.numPuertas = numPuertas;
		this.maletero = maletero;
	}

	public CategoriaA() {
		super();
		this.numPuertas = 0;
		this.maletero = false;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	public boolean isMaletero() {
		return maletero;
	}

	public void setMaletero(boolean maletero) {
		this.maletero = maletero;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CategoriaA [numPuertas=" + numPuertas + ", maletero=" + maletero + "]";
	}

	
	
	
	
}
	
	
package ERM.categoriasCoche;

public class Categoria_A extends Coche{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numPuertas;
	private boolean maletero;

	public Categoria_A(String id, String nombre, String categoria, String marca, String fecha_matriculacion,
			String combustible, double precio, String rutaFoto, int numPuertas, boolean maletero) {
		super(id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto);
		this.numPuertas = numPuertas;
		this.maletero = maletero;
	}
	
	public Categoria_A() {
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
		return "Categoria_A [numPuertas=" + numPuertas + ", maletero=" + maletero + "]";
	}

	
	
	
	
}
	
	
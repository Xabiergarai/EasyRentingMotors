package ERM.categoriasCoche;

public class Categoria_B extends Coche{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numPuertas;
	private boolean descapotable;
	private boolean deportivo;
		
	public Categoria_B(String id, String nombre, String clase, String marca, String fecha_matriculacion,
			String combustible, double precio, String rutaFoto, int numPuertas, boolean descapotable,
			boolean deportivo) {
		super(id, nombre, clase, marca, fecha_matriculacion, combustible, precio, rutaFoto);
		this.numPuertas = numPuertas;
		this.descapotable = descapotable;
		this.deportivo = deportivo;
	}
	
	public Categoria_B() {
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

	public boolean isdescapotable() {
		return descapotable;
	}

	public void setdescapotable(boolean descapotable) {
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
		return "Categoria_B [descapotable=" + descapotable + ", deportivo="
				+ deportivo + "]";
	}
	
	

}

package ERM.categoriasCoche;

public class Categoria_D extends Coche {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoFurgoneta;
	
	public Categoria_D(String id, String nombre, String categoria, String marca, String fecha_creacion, String combustible,
			double precio, String rutaFoto, String tipoFurgoneta, boolean descapotable) {
		super(id, nombre, categoria, marca, fecha_creacion, combustible, precio, rutaFoto);
		this.tipoFurgoneta = tipoFurgoneta;
		
	}
	
	public Categoria_D() {
		super();
		this.tipoFurgoneta = "";
	}

	public String getTipoFurgoneta() {
		return tipoFurgoneta;
	}

	public void setTipoFurgoneta(String tipoFurgoneta) {
		this.tipoFurgoneta = tipoFurgoneta;
	}

	@Override
	public String toString() {
		return "Categoria_D [tipoFurgoneta=" + tipoFurgoneta + "]";
	}
	
	

}

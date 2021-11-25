package ERM.categoriasCoche;

public class CategoriaD extends Coche {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoFurgoneta;
	boolean descapotable;

	public CategoriaD(String id, String nombre, String categoria, String marca, String fecha_creacion,
			String combustible, double precio, String rutaFoto, String tipoFurgoneta, boolean descapotable) {

		super(id, nombre, categoria, marca, fecha_creacion, combustible, precio, rutaFoto);
		this.tipoFurgoneta = tipoFurgoneta;

	}

	public String getTipoFurgoneta() {
		return tipoFurgoneta;
	}

	public void setTipoFurgoneta(String tipoFurgoneta) {
		this.tipoFurgoneta = tipoFurgoneta;
	}

	public boolean isDescapotable() {
		return descapotable;
	}

	public void setDescapotable(boolean descapotable) {
		this.descapotable = descapotable;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "CategoriaD [tipoFurgoneta=" + tipoFurgoneta + ", descapotable=" + descapotable + "]";
	}

}

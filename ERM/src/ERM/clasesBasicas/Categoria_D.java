package ERM.clasesBasicas;

public class Categoria_D extends Coche {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoFurgoneta;
	private boolean descapotable;
	
	public Categoria_D(String id, String nombre, String clase, String marca, String fecha_creacion, String combustible,
			double precio, String rutaFoto, String tipoFurgoneta, boolean descapotable) {
		super(id, nombre, clase, marca, fecha_creacion, combustible, precio, rutaFoto);
		this.tipoFurgoneta = tipoFurgoneta;
		this.descapotable = descapotable;
	}
	
	public Categoria_D() {
		super();
		this.tipoFurgoneta = " ";
		this.descapotable = false;
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

	@Override
	public String toString() {
		return "Categoria_D [tipoFurgoneta=" + tipoFurgoneta + ", descapotable=" + descapotable + "]";
	}
	
	

}

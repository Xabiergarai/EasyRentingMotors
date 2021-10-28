package ERM.categoriasCoche;

public class Categoria_C extends Coche{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoTodoTerreno;
	private boolean descapotable;
	
	
	public Categoria_C(String id, String nombre, String categoria, String marca, String fecha_matriculacion,
			String combustible, double precio, String rutaFoto, String tipoTodoTerreno, boolean descapotable) {
		super(id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto);
		this.tipoTodoTerreno = tipoTodoTerreno;
		this.descapotable = descapotable;
	}
	
	
	public Categoria_C() {
		super();
		this.tipoTodoTerreno = " ";
		this.descapotable = false;
	}


	public String getTipoTodoTerreno() {
		return tipoTodoTerreno;
	}


	public void setTipoTodoTerreno(String tipoTodoTerreno) {
		this.tipoTodoTerreno = tipoTodoTerreno;
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
		return "Categoria_C [tipoTodoTerreno=" + tipoTodoTerreno + ", descapotable=" + descapotable + "]";
	}
	
	
	
}
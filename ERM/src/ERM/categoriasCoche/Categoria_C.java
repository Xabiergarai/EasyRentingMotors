package ERM.categoriasCoche;

public class Categoria_C extends Coche{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String tipoTodoTerreno;
	private boolean descapotable;
	
	
	public Categoria_C(String tipoTodoTerreno, boolean descapotable, String cincoPuertas, boolean deportivo) {
		super();
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

	@Override
	public String toString() {
		return "Categoria_C [tipoTodoTerreno=" + tipoTodoTerreno + ", descapotable=" + descapotable + "]";
	}
	
	
	

}

package ERM.clasesBasicas;

public class Categoria_C {
	
	private String tipoTodoTerreno;
	private boolean descapotable;
	private String cincoPuertas;
	private boolean deportivo;
	
	
	public Categoria_C(String tipoTodoTerreno, boolean descapotable, String cincoPuertas, boolean deportivo) {
		super();
		this.tipoTodoTerreno = tipoTodoTerreno;
		this.descapotable = descapotable;
		this.cincoPuertas = cincoPuertas;
		this.deportivo = deportivo;
	}
	
	public Categoria_C() {
		super();
		this.tipoTodoTerreno = " ";
		this.descapotable = false;
		this.cincoPuertas = " ";
		this.deportivo = false;
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

	public String getCincoPuertas() {
		return cincoPuertas;
	}

	public void setCincoPuertas(String cincoPuertas) {
		this.cincoPuertas = cincoPuertas;
	}

	public boolean isDeportivo() {
		return deportivo;
	}

	public void setDeportivo(boolean deportivo) {
		this.deportivo = deportivo;
	}

	@Override
	public String toString() {
		return "Categoria_C [tipoTodoTerreno=" + tipoTodoTerreno + ", descapotable=" + descapotable + ", cincoPuertas="
				+ cincoPuertas + ", deportivo=" + deportivo + "]";
	}
	
	
	

}

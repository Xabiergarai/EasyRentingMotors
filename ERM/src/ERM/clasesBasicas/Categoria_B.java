package ERM.clasesBasicas;

public class Categoria_B {
	
	private int numPuertas;
	private boolean descapotable;
	private boolean deportivo;
	
	
	public Categoria_B(String cincoPuertas, boolean descapotable, boolean deportivo) {
		super();
		this.descapotable = descapotable;
		this.deportivo = deportivo;
	}
	
	public Categoria_B() {
		super();
		this.descapotable = false;
		this.deportivo = false;
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

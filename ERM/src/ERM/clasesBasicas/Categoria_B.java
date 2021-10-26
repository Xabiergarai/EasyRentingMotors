package ERM.clasesBasicas;

public class Categoria_B {
	
	private String cincoPuertas;
	private boolean descaspotable;
	private boolean deportivo;
	
	
	public Categoria_B(String cincoPuertas, boolean descaspotable, boolean deportivo) {
		super();
		this.cincoPuertas = cincoPuertas;
		this.descaspotable = descaspotable;
		this.deportivo = deportivo;
	}
	
	public Categoria_B() {
		super();
		this.cincoPuertas = " ";
		this.descaspotable = false;
		this.deportivo = false;
	}

	public String getCincoPuertas() {
		return cincoPuertas;
	}

	public void setCincoPuertas(String cincoPuertas) {
		this.cincoPuertas = cincoPuertas;
	}

	public boolean isDescaspotable() {
		return descaspotable;
	}

	public void setDescaspotable(boolean descaspotable) {
		this.descaspotable = descaspotable;
	}

	public boolean isDeportivo() {
		return deportivo;
	}

	public void setDeportivo(boolean deportivo) {
		this.deportivo = deportivo;
	}

	@Override
	public String toString() {
		return "Categoria_B [cincoPuertas=" + cincoPuertas + ", descaspotable=" + descaspotable + ", deportivo="
				+ deportivo + "]";
	}
	
	

}

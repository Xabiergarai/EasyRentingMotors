package ERM.clasesBasicas;

public class Categoria_A extends Coche{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numPuertas;
	private boolean maletero;
	
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
	
	public Categoria_A(int numPuertas, boolean maletero) {
		super();
		this.numPuertas = numPuertas;
		this.maletero = maletero;
	}
	public Categoria_A() {
		this.numPuertas = 0;
		this.maletero = false;
	}
	
	@Override
	public String toString() {
		return "Categoria_A [numPuertas=" + numPuertas + ", maletero=" + maletero + "]";
	}
	
	
	
	
	
	 

}

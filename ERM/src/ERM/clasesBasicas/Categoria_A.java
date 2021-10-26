package ERM.clasesBasicas;

public class Categoria_A  {
	
	private String tipoCocheMini;
	private String maletero;
	
	
	public Categoria_A(String tipoCocheMini, String maletero) {
		super();
		this.tipoCocheMini = tipoCocheMini;
		this.maletero = maletero;
	}
	
	public Categoria_A() {
		super();
		this.tipoCocheMini = " ";
		this.maletero = " ";
	}

	public String getTipoCocheMini() {
		return tipoCocheMini;
	}

	public void setTipoCocheMini(String tipoCocheMini) {
		this.tipoCocheMini = tipoCocheMini;
	}

	public String getMaletero() {
		return maletero;
	}

	public void setMaletero(String maletero) {
		this.maletero = maletero;
	}

	@Override
	public String toString() {
		return "Categoria_A [tipoCocheMini=" + tipoCocheMini + ", maletero=" + maletero + "]";
	}
	
	

}

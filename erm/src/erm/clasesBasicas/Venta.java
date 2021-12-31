package erm.clasesBasicas;

public class Venta {
	
	
	private String nombre;
	private String categoria;
	private double precio;
	
	
	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public double getPrecio() {
		return precio;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public Venta(String nombre, String categoria, double precio) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}

	
	
	@Override
	public String toString() {
		return "Venta [nombre=" + nombre + ", categoria=" + categoria + ", precio=" + precio + "]";
	}


	

}

package erm.clasesBasicas;

public class Venta {

	public static int cont;
	private int idUsuario;
	private int idVenta;
	private String nombre;
	private String categoria;
	private double precio;
	
	public Venta(String nombre, String categoria, double precio) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
	}

	public Venta() {
		super();
		this.idUsuario = 0;
		this.nombre = "";
		this.categoria = "";
		this.precio = 0.0;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

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

	@Override
	public String toString() {
		return "Venta [idUsuario=" + idUsuario + ", nombre=" + nombre + ", categoria="
				+ categoria + ", precio=" + precio + "]";
	}
	
	

	

}

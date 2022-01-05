package erm.clasesBasicas;

import erm.excepciones.ExcepcionExplicita;

public class Carrito {
	private String id;
	private String nombre;
	private double precio;
	private String fecha;

	public Carrito(String id, String nombre, String fecha, double precio) throws ExcepcionExplicita {
		super();
		this.id = id;
		this.nombre = nombre;
		if(precio > 0.0)
			this.precio = precio;
		else
			throw new ExcepcionExplicita("El precio tiene que ser > 0");
			
		this.fecha = fecha;
	}

	public Carrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fecha=" + fecha + "]";
	}

}

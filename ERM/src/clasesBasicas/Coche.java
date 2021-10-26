package clasesBasicas;

import java.io.Serializable;

public class Coche implements Serializable {
	
	private String id;
	private String nombre;
	private String clase;
	private String marca;
	private String fecha_creacion;
	private String combustible;
	private double precio;
    private String rutaFoto;
    
    
	public Coche(String id, String nombre, String clase, String marca, String fecha_creacion, String combustible,
			double precio, String rutaFoto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clase = clase;
		this.marca = marca;
		this.fecha_creacion = fecha_creacion;
		this.combustible = combustible;
		this.precio = precio;
		this.rutaFoto = rutaFoto;
	}
	
	public Coche() {
		super();
		this.id = " ";
		this.nombre = " ";
		this.clase = " ";
		this.marca = " ";
		this.fecha_creacion = " ";
		this.combustible = " ";
		this.precio = 0.0;
		this.rutaFoto = " ";
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

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getCombustible() {
		return combustible;
	}

	public void setCombustible(String combustible) {
		this.combustible = combustible;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getRutaFoto() {
		return rutaFoto;
	}

	public void setRutaFoto(String rutaFoto) {
		this.rutaFoto = rutaFoto;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", nombre=" + nombre + ", clase=" + clase + ", marca=" + marca + ", fecha_creacion="
				+ fecha_creacion + ", combustible=" + combustible + ", precio=" + precio + ", rutaFoto=" + rutaFoto
				+ "]";
	}
	
	


}



package erm.categoriasCoche;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import erm.excepciones.ExcepcionExplicita;

public class Coche implements Serializable {

	private String id, nombre, categoria, marca, fecha_matriculacion, combustible, rutaFoto;
	private double precio;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Coche(String id, String nombre,String Categoria,  String clase, String marca, String fecha_matriculacion, String combustible,
			double precio, String rutaFoto) throws ExcepcionExplicita {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categoria = clase;
		this.marca = marca;
		this.fecha_matriculacion = fecha_matriculacion;
		try {
			Date f = sdf.parse(fecha_matriculacion);
			Date fechaLimite = sdf.parse("2000-01-01");
			if(f.before(fechaLimite))
				throw new ExcepcionExplicita("Es un coche demasiado antiguo");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.combustible = combustible;
		this.precio = precio;
		this.rutaFoto = rutaFoto;
	}
	
	public Coche() {
		super();
		this.id = " ";
		this.nombre = " ";
		this.categoria = " ";
		this.marca = " ";
		this.fecha_matriculacion = " ";
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
	
	public String getCategoria() {
		return nombre;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	

	public String getClase() {
		return categoria;
	}

	public void setClase(String clase) {
		this.categoria = clase;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getfecha_matriculacion() {
		return fecha_matriculacion;
	}

	public void setfecha_matriculacion(String fecha_matriculacion) {
		this.fecha_matriculacion = fecha_matriculacion;
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
		return "Coche [id=" + id + ", nombre=" + nombre + ", clase=" + categoria + ", marca=" + marca
				+ ", fecha_matriculacion=" + fecha_matriculacion + ", combustible=" + combustible + ", precio=" + precio
				+ ", rutaFoto=" + rutaFoto + "]";
	}
	

}


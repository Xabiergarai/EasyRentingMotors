package erm.clasesBasicas;

import java.util.Date;

import erm.excepciones.ExcepcionExplicita;

public class Alquiler {

	private String nomUsuario, nomCoche, fechaInicio,fechaFin;
	
	public Alquiler(){
		super();
	
	}

	public Alquiler(String nomUsuario, String nomCoche, String fechaInicio, String fechaFin) throws ExcepcionExplicita {
		super();
	
		this.nomUsuario=nomUsuario;
		this.nomCoche = nomCoche;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getnomCoche() {
		return nomCoche;
	}

	public void setIdCoche(String nomCoche) {
		this.nomCoche = nomCoche;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Alquiler [nomUsuario=" + nomUsuario + ", nomCoche=" + nomCoche + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + "]";
	}
	
}

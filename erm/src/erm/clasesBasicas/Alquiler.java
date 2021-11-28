package erm.clasesBasicas;

import java.util.Date;

public class Alquiler {

	private String nomUsuario;
	private String idCoche;
	private String fechaInicio,fechaFin;
	
	public Alquiler(){
		super();
	
	}

	public Alquiler(String nomUsuario, String idCoche, String fechaInicio, String fechaFin) {
		super();
		this.nomUsuario = nomUsuario;
		this.idCoche = idCoche;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public String getNomUsuario() {
		return nomUsuario;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}

	public String getIdCoche() {
		return idCoche;
	}

	public void setIdCoche(String idCoche) {
		this.idCoche = idCoche;
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
		return "Alquiler [nomUsuario=" + nomUsuario + ", idCoche=" + idCoche + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + "]";
	}
	
}

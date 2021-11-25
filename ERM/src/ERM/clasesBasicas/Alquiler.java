package ERM.clasesBasicas;

import java.util.Date;

public class Alquiler {

	private String nomUsuario;
	private String idCoche;
	private Date fechaInicio,fechaFin;
	
	public Alquiler(){
		super();
	
	}

	public Alquiler(String nomUsuario, String idCoche, Date fechaInicio, Date fechaFin) {
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

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Alquiler [nomUsuario=" + nomUsuario + ", idCoche=" + idCoche + ", fechaInicio=" + fechaInicio
				+ ", fechaFin=" + fechaFin + "]";
	}
	
}

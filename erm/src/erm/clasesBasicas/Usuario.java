package erm.clasesBasicas;

public class Usuario {

	public static int cont = 0;
	private int id;
	private String nombre, apellidos, nickname, contrasenya, email;

	public Usuario() {

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasenya() {
		return contrasenya;
	}

	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomUsuario() {
		return nickname;
	}

	public void setNomUsuario(String nomUsuario) {
		this.nickname = nomUsuario;
	}

	public Usuario(String nombre, String apellidos, String nickname, String contrasenya, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", nickname=" + nickname + ", contrasenya="
				+ contrasenya + ", email=" + email + "]";
	}

}

package erm.clasesBasicas;

public class Usuario {


	public static int cont = 0;
	private int id;
	private String nombre, apellidos, nickname, contrasenya, email, direccionIP;

	public Usuario() {

	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id=id;
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
	
	public String getDireccionIP() {
		return direccionIP;
	}
	
	public void setDireccionIP(String direccionIP) {
		this.direccionIP = direccionIP;
	}


	public Usuario(String nombre, String apellidos, String nickname, String contrasenya, String email, String direccionIP) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.email = email;
		this.direccionIP = direccionIP;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", apellidos=" + apellidos + ", nickname=" + nickname + ", contrasenya="
				+ contrasenya + ", email=" + email + ", direccionIP =" + direccionIP + "]";
	}

}

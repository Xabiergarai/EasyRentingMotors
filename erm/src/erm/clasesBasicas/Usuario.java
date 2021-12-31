package erm.clasesBasicas;

public class Usuario {


	public static int cont = 0;
	private int id;
	private String nombre, apellidos, nickname, contrasenya, email, direccionIP,saldo;

	public Usuario(String nombre, String apellidos, String nickname, String contrasenya, String email, String direccionIP,String saldo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.email = email;
		this.direccionIP = direccionIP;
		this.saldo=saldo;
		
	}
	
	public Usuario(String nickname, String contrasenya, String email) {
		super();
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.email = email;

	}
	
	
	
	public Usuario(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public Usuario() {
		
		super();
		this.nombre = "";
		this.apellidos = "";
		this.nickname = "";
		this.contrasenya = "";
		this.email = "";
		this.direccionIP = "";
		this.saldo="";
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getDireccionIP() {
		return direccionIP;
	}
	
	public void setDireccionIP(String direccionIP) {
		this.direccionIP = direccionIP;
	}
	public void setSaldo(String saldo) {
		this.saldo=saldo;
	}
	public String getSaldo() {
		return saldo;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nickname=" + nickname
				+ ", contrasenya=" + contrasenya + ", email=" + email + ", direccionIP=" + direccionIP + "]";
	}


	

	

}

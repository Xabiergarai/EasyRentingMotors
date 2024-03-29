package erm.clasesBasicas;

public class Usuario {


	private int id;
	private String nombre, apellidos, nickname, contrasenya, email, direccionIP;

	public Usuario(String nombre, String apellidos, String nickname, String contrasenya, String email, String direccionIP) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.email = email;
		this.direccionIP = direccionIP;
		
		
	}
	public Usuario(String nombre, String apellidos, String nickname, String contrasenya, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nickname = nickname;
		this.contrasenya = contrasenya;
		this.email = email;
		
		
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
	
	@Override
	public String toString() {		
		return "   Nombre: "+nombre+ " | Nickname: " + nickname+ " | Contraseņa: " + contrasenya;
	}


	

	

}

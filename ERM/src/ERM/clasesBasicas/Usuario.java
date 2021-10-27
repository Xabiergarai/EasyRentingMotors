package ERM.clasesBasicas;

public class Usuario {
	
	
	private String nombre;
	private String apellidos;
	private String nickname;
	private String contrasenya;
	private String email;
	
	
	
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

	
	
	
}

	



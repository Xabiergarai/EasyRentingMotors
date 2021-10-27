package ERM.clasesBasicas;

public class Usuario {
	
	
	private String nombre;
	private String apellidos;
	private String nomUsuario;
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
		return nomUsuario;
	}
	public void setNomUsuario(String nomUsuario) {
		this.nomUsuario = nomUsuario;
	}
	
	
	public Usuario(String nombre, String apellidos, String nomUsuario, String contrasenya, String email) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nomUsuario = nomUsuario;
		this.contrasenya = contrasenya;
		this.email = email;
	}

	
	
	
}

	



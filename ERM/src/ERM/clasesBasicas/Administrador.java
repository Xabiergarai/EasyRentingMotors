package ERM.clasesBasicas;

public class Administrador extends Usuario {

	private String AdminUsuario;
	private String AdminInterfaz;
	private String AdminVerificar;
	private String AdminRecuperacion;

	public Administrador(String nomUsuario, String contrasenya, String email, String nombre, String apellidos,
			String adminUsuario, String adminInterfaz, String adminVerificar, String adminRecuperacion) {
		super(nomUsuario, contrasenya, email, nombre, apellidos);
		AdminUsuario = adminUsuario;
		AdminInterfaz = adminInterfaz;
		AdminVerificar = adminVerificar;
		AdminRecuperacion = adminRecuperacion;
	}

	public Administrador() {
		super();
		AdminUsuario = "";
		AdminInterfaz = "";
		AdminVerificar = "";
		AdminRecuperacion = "";
	}

	public String getAdminUsuario() {
		return AdminUsuario;
	}

	public void setAdminUsuario(String adminUsuario) {
		AdminUsuario = adminUsuario;
	}

	public String getAdminInterfaz() {
		return AdminInterfaz;
	}

	public void setAdminInterfaz(String adminInterfaz) {
		AdminInterfaz = adminInterfaz;
	}

	public String getAdminVerificar() {
		return AdminVerificar;
	}

	public void setAdminVerificar(String adminVerificar) {
		AdminVerificar = adminVerificar;
	}

	public String getAdminRecuperacion() {
		return AdminRecuperacion;
	}

	public void setAdminRecuperacion(String adminRecuperacion) {
		AdminRecuperacion = adminRecuperacion;
	}

	@Override
	public String toString() {
		return "Administrador [AdminUsuario=" + AdminUsuario + ", AdminInterfaz=" + AdminInterfaz + ", AdminVerificar="
				+ AdminVerificar + ", AdminRecuperacion=" + AdminRecuperacion + "]";
	}

}

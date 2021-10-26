package ERM.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import ERM.clasesBasicas.Usuario;


public class DBManager {

private Connection conn = null; 
	
	//CREAR CONEXION CON BD

	public void connect() throws DBException { 
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data/BD2");
		} catch (ClassNotFoundException e) {
			throw new DBException("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new DBException("Error conectando a la BD", e);
		}
	}
	
	//CERRAR CONEXION CON BD
	public void disconnect() throws DBException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new DBException("Error cerrando la conexión con la BD", e);
		}
	}
	
	//REGISTRAR NUEVO USUARIO
		public void registrarUsuario(Usuario usuario) throws DBException{
			
			String nomUsuario = usuario.getNombre();
			String apellidosUsuario = usuario.getApellidos();
			String contrasenya = usuario.getContrasenya();
			String correo = usuario.getEmail();
			
			
			
			try (Statement stmt= conn.createStatement()) {
				stmt.executeUpdate("INSERT INTO usuario (nomUsuario, apellidosUsuario, contrasenya, correo) VALUES ('" + nomUsuario + "', '"+ apellidosUsuario + "', '" + contrasenya + "', '" + correo + "')");
			} catch (SQLException e) {
				throw new DBException("No ha sido posible ejecutar la query");
			}
			
		}
	
}

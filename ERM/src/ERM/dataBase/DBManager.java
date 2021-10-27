package ERM.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import ERM.clasesBasicas.Usuario;
import ERM.dataBase.*;
import baseDatos.BDException;



public class DBManager {

private Connection conn = null; 
private static Logger logger = Logger.getLogger(DBManager.class.getName());

	
	//CREAR CONEXION CON BD

	public void connect(String nombre) throws DBException { 
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data/BD2"+ nombre);
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
			throw new DBException("Error cerrando la conexiÃ³n con la BD", e);
		}
	}
	
	public static Statement usarCrearTablasBD(Connection con) throws DBException {
	try {
		Statement statement = con.createStatement();
		try {
			statement.executeUpdate("create table if not exists Usuario " + "(nick string, " + " con string)");

		} catch (SQLException ex) {
			logger.log(Level.WARNING, "Tabla Usuario ya existente");
			throw new DBException("Error creando tabla de usuario a la BD", ex);

		}
	
	}
	
	
	}
	public static int existeUsuario(String nick, String contrasenia) throws BDException {
		Connection con = connect("videoclub.sqlite3");
		String sql = "SELECT * FROM Usuario WHERE nick='" + nick + "'";
		logger.log(Level.INFO, "Seleccionando usuario: " + nick);
		Statement st = null;
		ResultSet rs = null;
		int resultado = 0;
		try {
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if (!rs.next()) {
				resultado = 0;
				logger.log(Level.WARNING, "Usuario no exixtente");

			} else {
				String c = rs.getString(2);
				if (c.equals(contrasenia)) {
					resultado = 2;
					logger.log(Level.FINE, "Usuario existente");

				} else {
					resultado = 1;
					logger.log(Level.WARNING, "Contraseña incorrecta");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new BDException("Error al mirar si existe usuarios en BD", e);
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (st != null)
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return resultado;
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

package ERM.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import ERM.clasesBasicas.Usuario;

public class DBManager {

	private Connection conn = null;
	private static Logger logger = Logger.getLogger(DBManager.class.getName());
	private static boolean LOGGING = true;
	private static PreparedStatement ps = null;

	// CREAR CONEXION CON BD
	/**
	 * Inicializa una BD SQLITE y devuelve una conexión con ella
	 * 
	 * @param nombreBD Nombre de fichero de la base de datos
	 * @return Conexión con la base de datos indicada. Si hay algún error, se
	 *         devuelve null
	 * @throws BDException
	 */
	public static Connection initBD(String nombre) throws DBException {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:usuarios.db");
			return conn;
		} catch (ClassNotFoundException e) {
			throw new DBException("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new DBException("Error conectando a la BD", e);
		}
	}

	/**
	 * Crea las tablas de la base de datos. Si ya existen, las deja tal cual.
	 * Devuelve un statement para trabajar con esa base de datos
	 * 
	 * @param con Conexi�n ya creada y abierta a la base de datos
	 * @return sentencia de trabajo si se crea correctamente, null si hay cualquier
	 *         error
	 * @throws BDException
	 */

	public static Statement usarCrearTablasBD(Connection con) throws DBException {
		logger.log(Level.INFO, "Creando tablas...");

		try {
			Statement statement = con.createStatement();
			try {
				statement.executeUpdate("create table if not exists Usuario " + "(nick string, " + " contrasenya string"
						+ " apellidos string, " + " email string) ");

			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Usuario ya existente");
				throw new DBException("Error creando tabla de usuario a la BD", ex);

			}
			return statement;
		} catch (SQLException e) {
			return null;
		}

	}

	/**
	 * Este metodo comprobara si existe el usuario en concre * @param nick
	 * 
	 * @param contrasenia
	 * @return
	 * @throws DBException
	 */

	public static int existeUsuario(String nick, String contrasenia) throws DBException {
		Connection con = initBD("usuarios.db");
		String sql = "SELECT * FROM Usuarios WHERE nickname='" + nick + "'";
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
				String c = rs.getString(4);
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
			throw new DBException("Error al mirar si existe usuarios en BD", e);
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

	private static void log(Level level, String msg, Throwable exception) {
		if (!LOGGING) {
			return;
		}
		if (logger == null) {
			logger = Logger.getLogger(DBManager.class.getName());
			logger.setLevel(level.ALL);
		}
		if (exception == null) {
			logger.log(level, msg);
		} else {
			logger.log(level, msg, exception);
		}
	}

	// REGISTRAR NUEVO USUARIO
	public boolean registrar(Usuario u) throws DBException {

		try {
			Connection con = initBD("usuarios.bd");
			String sql = "INSERT INTO usuarios (nombre,	apellidos, nickname, contrasenya, email) VALUES(?,?,?,?,?)";

			ps = con.prepareStatement(sql);

			ps.setString(1, u.getNombre());
			ps.setString(2, u.getApellidos());
			ps.setString(3, u.getNomUsuario());
			ps.setString(4, u.getContrasenya());
			ps.setString(5, u.getEmail());

			ps.execute();
			System.out.println("Usuario registrado");
			log(Level.INFO, "Usuario registrado", null);

			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log(Level.SEVERE, "Error al insertar usuario", e);
			return false;

		}

	}

	// CERRAR CONEXION CON BD
	public void disconnect() throws DBException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new DBException("Error cerrando la conexiÃ³n con la BD", e);
		}
	}

}

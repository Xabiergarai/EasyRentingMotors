package erm.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import erm.categoriasCoche.CategoriaA;
import erm.categoriasCoche.CategoriaB;
import erm.categoriasCoche.CategoriaC;
import erm.categoriasCoche.CategoriaD;
import erm.clasesBasicas.Usuario;
import erm.categoriasCoche.*;
import erm.ventanasPrimarias.*;

public class DBManager {

	private static Connection conn = null;
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
			Connection conn = DriverManager.getConnection("jdbc:sqlite:EasyRentingMotors.db");
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
		Connection con = initBD("EasyRentingMotors.db");
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
			//cambiar la conexion a la nueva bd
			Connection con = initBD("EasyRentingMotors.db");
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
	
	public static ArrayList<CategoriaA> listarCategoriaA() throws DBException {
		
		ArrayList <CategoriaA> CategoriaA = new ArrayList<>();
		Connection con = initBD("EasyRentingMotors.db");
		
		try(Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("Select id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto, numPuertas, maletero FROM CategoriaA");
			
			while(rs.next()) {
				 CategoriaA CategoriAs = new CategoriaA();
			  CategoriAs.setId(rs.getString("id"));
			  CategoriAs.setNombre(rs.getString("nombre"));
			  CategoriAs.setCategoria(rs.getString("Categoria"));
			  CategoriAs.setMarca(rs.getString("marca"));
			  CategoriAs.setfecha_matriculacion(rs.getString("fecha_matriculacion"));
			  CategoriAs.setCombustible(rs.getString("combustible"));
			  CategoriAs.setPrecio(rs.getInt("precio"));
			  CategoriAs.setRutaFoto(rs.getString("rutaFoto"));
			  CategoriAs.setNumPuertas(rs.getInt("numPuertas"));
			  if(rs.getInt("maletero") == 1) {
				  CategoriAs.setMaletero(true);
			  } else {
				  CategoriAs.setMaletero(false);
			  }
				CategoriaA.add(CategoriAs);
			}
 			
		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los coches de la Categoria A", e);
		}
		return CategoriaA;
	}
	
public static ArrayList<CategoriaB> listarCategoriaB() throws DBException {
		
		ArrayList <CategoriaB> CategoriaB = new ArrayList<>();
		Connection con = initBD("EasyRentingMotors.db");
		
		try(Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("Select id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto, numPuertas, descapotable FROM CategoriaB");
			
			while(rs.next()) {
				 CategoriaB CategoriBs = new CategoriaB();
			  CategoriBs.setId(rs.getString("id"));
			  CategoriBs.setNombre(rs.getString("nombre"));
			  CategoriBs.setCategoria(rs.getString("Categoria"));
			  CategoriBs.setMarca(rs.getString("marca"));
			  CategoriBs.setfecha_matriculacion(rs.getString("fecha_matriculacion"));
			  CategoriBs.setCombustible(rs.getString("combustible"));
			  CategoriBs.setPrecio(rs.getInt("precio"));
			  CategoriBs.setRutaFoto(rs.getString("rutaFoto"));
			  CategoriBs.setNumPuertas(rs.getInt("numPuertas"));
			  if(rs.getInt("descapotable") == 1) {
				  CategoriBs.setDescapotable(true);
			  } else {
				  CategoriBs.setDescapotable(false);
			  }
			  if(rs.getInt("deportivo") == 1) {
				  CategoriBs.setDeportivo(true);
			  } else {
				  CategoriBs.setDeportivo(false);;
			  }
				CategoriaB.add(CategoriBs);
			}
 			
		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los coches de la Categoria B", e);
		}
		return CategoriaB;
	}

public static ArrayList<CategoriaC> listarCategoriaC() throws DBException {
	
	ArrayList <CategoriaC> CategoriaC = new ArrayList<>();
	Connection con = initBD("EasyRentingMotors.db");
	
	try(Statement stmt = con.createStatement()) {
		ResultSet rs = stmt.executeQuery("Select id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto, tipoTodoTerreno, descapotable FROM CategoriaC");
		
		while(rs.next()) {
			 CategoriaC CategoriCs = new CategoriaC();
		  CategoriCs.setId(rs.getString("id"));
		  CategoriCs.setNombre(rs.getString("nombre"));
		  CategoriCs.setCategoria(rs.getString("Categoria"));
		  CategoriCs.setMarca(rs.getString("marca"));
		  CategoriCs.setfecha_matriculacion(rs.getString("fecha_matriculacion"));
		  CategoriCs.setCombustible(rs.getString("combustible"));
		  CategoriCs.setPrecio(rs.getInt("precio"));
		  CategoriCs.setRutaFoto(rs.getString("rutaFoto"));
		  CategoriCs.setTipoTodoTerreno(rs.getString("tipoTodoTerreno"));
		  if(rs.getInt("descapotable") == 1) {
			  CategoriCs.setDescapotable(true);
		  } else {
			   CategoriCs.setDescapotable(false);
		 }
		  CategoriaC.add(CategoriCs);
		} 
	}  catch (SQLException e) {
		throw new DBException("Error obteniendo todos los coches de la Categoria C", e);
	}
	return CategoriaC;
	}
	
public static ArrayList<CategoriaD> listarCategoriaD() throws DBException {
	
	ArrayList <CategoriaD> CategoriaD = new ArrayList<>();
	Connection con = initBD("EasyRentingMotors.db");
	
	try(Statement stmt = con.createStatement()) {
		ResultSet rs = stmt.executeQuery("Select id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto, tipoFurgoneta, descapotable FROM CategoriaD");
		
		while(rs.next()) {
			 CategoriaD CategoriDs = new CategoriaD();
		  CategoriDs.setId(rs.getString("id"));
		  CategoriDs.setNombre(rs.getString("nombre"));
		  CategoriDs.setCategoria(rs.getString("Categoria"));
		  CategoriDs.setMarca(rs.getString("marca"));
		  CategoriDs.setfecha_matriculacion(rs.getString("fecha_matriculacion"));
		  CategoriDs.setCombustible(rs.getString("combustible"));
		  CategoriDs.setPrecio(rs.getInt("precio"));
		  CategoriDs.setRutaFoto(rs.getString("rutaFoto"));
		  CategoriDs.setTipoFurgoneta(rs.getString("tipoFurgoneta"));
		  if(rs.getInt("descapotable") == 1) {
			  CategoriDs.setDescapotable(true);
		  } else {
			  CategoriDs.setDescapotable(false);
		  }
			CategoriaD.add(CategoriDs);
		}
			
	} catch (SQLException e) {
		throw new DBException("Error obteniendo todos los coches de la Categoria D", e);
	}
	return CategoriaD;
}


 
	// CERRAR CONEXION CON BD
	public static void disconnect() throws DBException {
		try {
			conn.close();
		} catch (SQLException e) {
			throw new DBException("Error cerrando la conexiÃ³n con la BD", e);
		}
	}

}
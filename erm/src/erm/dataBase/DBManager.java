package erm.dataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;


import erm.clasesBasicas.Opinion;
import erm.clasesBasicas.Tarjeta;
import erm.dataBase.DBException;
import erm.excepciones.ExcepcionExplicita;
import erm.categoriasCoche.CategoriaA;
import erm.categoriasCoche.CategoriaB;
import erm.categoriasCoche.CategoriaC;
import erm.categoriasCoche.CategoriaD;
import erm.clasesBasicas.Alquiler;
import erm.clasesBasicas.Carrito;
import erm.clasesBasicas.Usuario;
import erm.categoriasCoche.*;
import erm.ventanasPrimarias.*;

/**
 * Base de datos de Easy Renting Motors
 *
 */

public class DBManager {

	private static Connection conn = null;
	private static Logger logger = Logger.getLogger(DBManager.class.getName());
	private static boolean LOGGING = true;
	private static PreparedStatement ps = null;
	private static Properties properties = new Properties();
	
	/**
	 * Inicializa una BD SQLITE y devuelve una conexion con ella
	 * 
	 * @param nombreBD Nombre de fichero de la base de datos
	 * @return Conexion con la base de datos indicada. Si hay algÃºn error, se
	 *         devuelve null
	 * @throws FileNotFoundException 
	 * @throws BDException
	 */
			
	
	public static Connection initBD(String nombre) throws DBException {
		try {
		      properties.load(new FileInputStream(new File("config.properties")));
		    } catch (FileNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } 
		try {
			Class.forName(properties.getProperty("DRIVER"));		
			conn = DriverManager.getConnection(properties.getProperty("jdbc"));
			return conn;
		} catch (ClassNotFoundException e) {
			throw new DBException("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new DBException("Error conectando a la BD", e);
		}
	}

	/**
	 * Crea las tablas de la base de datos. Si ya existen, las deja tal cual.
	 * Devuelve un statement para trabajar con esa base de datos.
	 * 
	 * @param con ConexiÃ³n ya creada y abierta a la base de datos
	 * @return sentencia de trabajo si se crea correctamente, null si hay cualquier
	 *         error
	 * @throws DBException
	 */
	public static Statement usarCrearTablasBD(Connection con) throws DBException {

		// statement.executeUpdate : Cuando queramos hacer create, insert, delete,
		// update, drop
		// statement.executeQuery : Cuando queramos hacer select

		logger.log(Level.INFO, "Creando tablas...");
		try {
			Statement statement = con.createStatement();
			try {
				statement.executeUpdate("create table if not exists Coche " + "(id string, " + " nombre string, "
						+ " categoria string, " + " marca string, " + " fecha_matriculacion string, "
						+ " combustible string," + " precio double," + " rutaFoto string");

			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Coche ya existente");
				throw new DBException("Error creando tabla de coche a la BD", ex);
			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("create table if not exists alquileres " + "(nomUsuario string, "
						+ " nomCoche string, " + " fInicio string, " + " fFin string");

			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Alquileres ya existente");
				throw new DBException("Error creando tabla de alquileres a la BD", ex);

			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("create table if not exists CategoriaA " + "(id String, " + " nombre string, "
						+ " categoria string, " + " marca string, " + " fecha_matriculacion string, "
						+ " combustible string," + " precio double," + " rutaFoto string," + " numPuertas integer,"
						+ " maletero integer)");

			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla CategoriaA ya existente");
				throw new DBException("Error creando tabla de CatgeoriaA a la BD", ex);

			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("create table if not exists categoriab " + "(id String, " + " nombre string, "
						+ " categoria string, " + " marca string, " + " fecha_matriculacion string, "
						+ " combustible string," + " precio double," + " rutaFoto string," + " numPuertas integer,"
						+ " descapotable integer, " + " deportivo integer)");

			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla CategoriaB ya existente");
				throw new DBException("Error creando tabla de CategoriaB a la BD", ex);

			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("create table if not exists categoriac " + "(id String, " + " nombre string, "
						+ " categoria string, " + " marca string, " + " fecha_matriculacion string, "
						+ " combustible string," + " precio integer," + " rutaFoto string," + " tipoTodoTerreno string,"
						+ " descapotable integer)");
			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla CaategoriaC ya existente");
				throw new DBException("Error creando tabla de CategoriaC a la BD", ex);

			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("create table if not exists categoriad " + "(id String, " + " nombre string, "
						+ " categoria string, " + " marca string, " + " fecha_matriculacion string, "
						+ " combustible string," + " precio integer," + " rutaFoto string," + " tipoFurgoneta string,"
						+ " descapotable integer)");
			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla CategoriaD ya existente");
				throw new DBException("Error creando tabla de CategoriaD a la BD", ex);

			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("CREATE TABLE if not exists usuario "
						+ "(nombre String, apellidos string, nickname string, contrasenya string, email string");
			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Usuario ya existente");
				throw new DBException("Error creando tabla de Usuarios a la BD", ex);
			} // Si la tabla ya existe, no hacemos nada

			try {
				statement.executeUpdate("CREATE TABLE if not exists opinion "
						+ "(idUsuario INTEGER PRIMARY KEY AUTOINCREMENT, titulo string, descripcion string");
			} catch (SQLException ex) {
				logger.log(Level.WARNING, "Tabla Opinion ya existente");
				throw new DBException("Error creando tabla de Ventas a la BD", ex);
			} // Si la tabla ya existe, no hacemos nada

			return statement;
		} catch (SQLException e) {
			return null;
		}
	}

	/**
	 * Reinicia en blanco las tablas de la base de datos. UTILIZAR ESTE MÃ‹TODO CON
	 * PRECAUCIÃ“N. Borra todos los datos que hubiera ya en las tablas
	 * 
	 * @param con ConexiÃ³n ya creada y abierta a la base de datos
	 * @return sentencia de trabajo si se borra correctamente, null si hay cualquier
	 *         error
	 * @throws BDException
	 */
	public static Statement reiniciarBD(Connection con) throws DBException {
		logger.log(Level.INFO, "Reiniciando la base de datos...");

		try {
			Statement statement = con.createStatement();
			statement.executeUpdate("drop table if exists Coche");
			statement.executeUpdate("drop table if exists alquileres");
			statement.executeUpdate("drop table if exists categoriaA");
			statement.executeUpdate("drop table if exists categoriaB");
			statement.executeUpdate("drop table if exists categoriaC");
			statement.executeUpdate("drop table if exists categoriaD");
			statement.executeUpdate("drop table if exists usuarios");
			statement.executeUpdate("drop table if exists opinion");
			return usarCrearTablasBD(con);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, "No se ha podido reiniar la base de datos");
			throw new DBException("Error al reiniciar la BD", e);

		}
	}

	

	/**
	 * Logging
	 * 
	 * @param level
	 * @param msg
	 * @param exception
	 */
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

	/**
	 * Nos permite iniciar sesion en ERM
	 * 
	 * @param nomUsuario
	 * @param contrasenya
	 * @return
	 * @throws DBException
	 */
	public boolean loginUsuario(String nomUsuario, String contrasenya) throws DBException {

		boolean acceso = false;

		if (nomUsuario.contains("@")) {
			try (PreparedStatement stmt = conn.prepareStatement(
					"SELECT id, nickname, contrasenya, email FROM usuario WHERE email = ? AND contrasenya = ?")) {
				stmt.setString(1, nomUsuario);
				stmt.setString(2, contrasenya);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					acceso = true;
				} else {
					acceso = false;
				}

			} catch (SQLException e) {
				throw new DBException("Error obteniendo datos de la query", e);
			}

		} else {
			try (PreparedStatement stmt = conn.prepareStatement(
					"SELECT id, nickname, contrasenya, email FROM usuario WHERE nickname = ? AND contrasenya = ?")) {
				stmt.setString(1, nomUsuario);
				stmt.setString(2, contrasenya);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					acceso = true;
				} else {
					acceso = false;
				}

			} catch (SQLException e) {
				throw new DBException("Error obteniendo datos de la query", e);
			}
		}

		return acceso;
	}

	/**
	 * Este metodo nos permitirá poder registrarnos como usuarios de ERM
	 * 
	 * @param u
	 * @return
	 * @throws DBException
	 */

	public boolean registrar(Usuario u) throws DBException {

		try {

			// cambiar la conexion a la nueva bd
			Connection con = initBD("EasyRentingMotors.db");
			String sql = "INSERT INTO usuario (nombre,	apellidos, nickname, contrasenya, email, direccionIP) VALUES(?,?,?,?,?,?)";

			ps = con.prepareStatement(sql);

			ps.setString(1, u.getNombre());
			ps.setString(2, u.getApellidos());
			ps.setString(3, u.getNickname());
			ps.setString(4, u.getContrasenya());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getDireccionIP());

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

	/**
	 * Lista todos los coches de la Categoria A
	 * 
	 * @return
	 * @throws DBException
	 */

	public static ArrayList<CategoriaA> listarCategoriaA() throws DBException {

		ArrayList<CategoriaA> CategoriaA = new ArrayList<>();
		Connection conn = initBD("EasyRentingMotors.db");
		String sql = "Select id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto, numPuertas, maletero FROM CategoriaA";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
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
				if (rs.getInt("maletero") == 1) {
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

	/**
	 * Lista todos los coches de la Categoria B
	 * 
	 * @return
	 * @throws DBException
	 */

	public static ArrayList<CategoriaB> listarCategoriaB() throws DBException {

		ArrayList<CategoriaB> CategoriaB = new ArrayList<>();
		Connection conn = initBD("EasyRentingMotors.db");
		String sql = "Select id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto, numPuertas, descapotable, deportivo FROM CategoriaB";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
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
				if (rs.getInt("descapotable") == 1) {
					CategoriBs.setDescapotable(true);
				} else {
					CategoriBs.setDescapotable(false);
				}
				if (rs.getInt("deportivo") == 1) {
					CategoriBs.setDeportivo(true);
				} else {
					CategoriBs.setDeportivo(false);
					;
				}
				CategoriaB.add(CategoriBs);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los coches de la Categoria B", e);
		}
		return CategoriaB;
	}

	/**
	 * Lista todos los coches de la Categoria C
	 * 
	 * @return
	 * @throws DBException
	 */

	public static ArrayList<CategoriaC> listarCategoriaC() throws DBException {

		ArrayList<CategoriaC> CategoriaC = new ArrayList<>();
		Connection conn = initBD("EasyRentingMotors.db");
		String sql = "Select id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto, tipoTodoTerreno, descapotable FROM CategoriaC";

		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
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
				if (rs.getInt("descapotable") == 1) {
					CategoriCs.setDescapotable(true);
				} else {
					CategoriCs.setDescapotable(false);
				}
				CategoriaC.add(CategoriCs);
			}
		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los coches de la Categoria C", e);
		}
		return CategoriaC;
	}

	/**
	 * Lista todos los coches de la Categoria D
	 * 
	 * @return
	 * @throws DBException
	 */

	public static ArrayList<CategoriaD> listarCategoriaD() throws DBException {

		ArrayList<CategoriaD> CategoriaD = new ArrayList<>();
		Connection conn = initBD("EasyRentingMotors.db");
		String sql = "Select id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto, tipoFurgoneta, descapotable FROM CategoriaD";
		try (PreparedStatement stmt = conn.prepareStatement(sql)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
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
				if (rs.getInt("descapotable") == 1) {
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

	/**
	 * Obtiene todos los coches de ERM
	 * 
	 * @param con
	 * @return
	 */

	public static List<Coche> obtenerCoches(Connection con) {
		List<Coche> av = new ArrayList<>();
		String sent = "SELECT * FROM Coche";

		try (PreparedStatement stmt = conn.prepareStatement(sent)) {
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String id = rs.getString("id");
				String nombre = rs.getString("nombre");
				String Categoria = rs.getString("categoria");
				String clase = rs.getString("clase");
				String marca = rs.getString("marca");
				String fecha_matriculacion = rs.getString("fecha_matriculacion");
				String combustible = rs.getString("combustible");
				String rutaFoto = rs.getString("rutaFoto");

				double precio = rs.getDouble("precio");
				Coche v = new Coche(id, nombre, Categoria, clase, marca, fecha_matriculacion, combustible, precio,
						rutaFoto);
				av.add(v);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExcepcionExplicita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return av;
	}

	/**
	 * Obtiene los nombres de un conjunto de coches
	 * 
	 * @return
	 * @throws SQLException
	 */

	public static TreeSet<String> obtenerNombresCoches() throws SQLException {
		String sent = "SELECT nombre from Coche";
		PreparedStatement stmt = conn.prepareStatement(sent);
		TreeSet<String> tsnomb = new TreeSet<>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			String n = rs.getString("nombre");

			tsnomb.add(n);
		}
		rs.close();
		return tsnomb;
	}

	/**
	 * Nos permite meter el alquiler de coche que queremos hacer. En las fechas
	 * deseadas.
	 * 
	 * @param alquiler
	 * @throws DBException
	 * @throws SQLException
	 */

	public static void insertarAlquiler(Alquiler alquiler) throws DBException, SQLException {

		Connection con = initBD("EasyRentingMotors.db");
		String sql = "INSERT INTO Alquileres (nomUsuario, nomCoche, fInicio, fFin) VALUES(?,?,?,?)";

		ps = con.prepareStatement(sql);

		ps.setString(1, alquiler.getNomUsuario());
		ps.setString(2, alquiler.getnomCoche());
		ps.setString(3, alquiler.getFechaInicio());
		ps.setString(4, alquiler.getFechaFin());

		ps.execute();
	}

	/**
	 * Obtiene el id del usuario que ha iniciado sesión
	 * 
	 * @param nick
	 * @return
	 * @throws DBException
	 */
	public int obtenerId(String nick) throws DBException {
		int idUsuario = 0;
		if (!nick.contains("@")) {
			try (PreparedStatement stmt = conn.prepareStatement(
					"SELECT id, nombre, apellidos, nickname, contrasenya, email, direccionIP FROM usuario WHERE nickname = ?")) {
				stmt.setString(1, nick);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				idUsuario = rs.getInt("id");

			} catch (SQLException e) {
				throw new DBException("Error obteniendo todos los usuarios'", e);
			}
		} else {
			try (PreparedStatement stmt = conn.prepareStatement(
					"SELECT id, nombre, apellidos, nickname, contrasenya, email, direccionIP FROM usuario WHERE email = ?")) {
				stmt.setString(1, nick);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				idUsuario = rs.getInt("id");

			} catch (SQLException e) {
				throw new DBException("Error obteniendo todos los usuarios'", e);
			}
		}

		return idUsuario;
	}

	/**
	 * Busca el usuario por su id
	 * 
	 * @param id
	 * @return
	 * @throws DBException
	 */
	public Usuario buscarUsuarioId(int id) throws DBException {
		try (PreparedStatement stmt = conn.prepareStatement(
				"SELECT id, nombre, apellidos, nickname, contrasenya, email, direccionIP FROM usuario WHERE id = ?")) {
			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellidos(rs.getString("apellidos"));
				usuario.setNickname(rs.getString("nickname"));
				usuario.setContrasenya(rs.getString("contrasenya"));
				usuario.setEmail(rs.getString("email"));
				usuario.setDireccionIP(rs.getString("direccionIP"));
				return usuario;

			} else {
				return new Usuario();
			}
		} catch (SQLException e) {
			throw new DBException("Error obteniendo el usuario con id " + id, e);
		}
	}

	/**
	 * Cambiar contraseña para usuario
	 * 
	 * @param user
	 * @throws DBException
	 */
	public void cambiarContrasenya(Usuario user) throws DBException {

		try (PreparedStatement stmt = conn
				.prepareStatement("UPDATE usuario SET contrasenya= ? WHERE nickname ='" + user.getNickname() + "'")) {
			stmt.setString(1, user.getContrasenya());
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}

	/**
	 * Inserta una nueva opinion
	 * 
	 * @param opinion
	 * @throws DBException
	 */

	public static void insertarOpinion(Opinion opinion) throws DBException {

		Connection conn = initBD("EasyRentingMotors.db");
		try (Statement stmt = conn.createStatement()) {

			int idUsuario = opinion.getIdUsuario();
			String titulo = opinion.getTitulo();
			String descripcion = opinion.getDescripcion();

			stmt.executeUpdate("INSERT INTO opinion (idUsuario, titulo, descripcion) VALUES ('" + idUsuario + "', '"
					+ titulo + "', '" + descripcion + "')");

		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}

	/**
	 * Eliminar cuenta de usuario por id
	 * 
	 * @param idUsuario
	 * @throws DBException
	 */

	public void eliminarUsuario(int idUsuario) throws DBException {
		try (PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuario WHERE id = ?")) {
			stmt.setInt(1, idUsuario);
			stmt.executeUpdate();

		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}

	/**
	 * Borra de la base de datos un usuario dependiendo del email
	 * 
	 * @param u
	 * @throws SQLException
	 * @throws DBException
	 */

	public static void borrarUsuarioGestion(Usuario u) throws SQLException, DBException {
		Connection con = initBD("EasyRentingMotors.db");

		PreparedStatement ps = con.prepareStatement("DELETE FROM usuario WHERE email = ?");
		ps.setString(1, u.getEmail());
		ps.execute();

	}

	/**
	 * Insertar un usuario en la base de datos
	 * 
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param nickname
	 * @param email
	 * @param contrasenya
	 * @param direccionIP
	 * @throws DBException
	 */

	public static void insertarUsuario(String id, String nombre, String apellidos, String nickname, String email,
			String contrasenya, String direccionIP) throws DBException {

		String s = "INSERT INTO usuario VALUES(" + id + ",'" + nombre + "','" + email + "','" + contrasenya + "','"
				+ apellidos + "','" + nickname + "','" + direccionIP + "')";
		Connection c = DBManager.initBD("EasyRentingMotors.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
			logger.log(Level.INFO, "Statement correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}

	}

	/**
	 * Metodo para obtener un ArrayList de los usuarios guardados en la base de
	 * datos
	 * 
	 * @return
	 * @throws DBException
	 */

	public static ArrayList<Usuario> listarUsuarios() throws DBException {
		ArrayList<Usuario> usuarios = new ArrayList<>();
		Connection con = initBD("EasyRentingMotors.db");

		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(
					"SELECT id, nombre, apellidos, nickname, email,contrasenya, direccionIP FROM usuario");

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(Integer.parseInt(rs.getString("id")));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setApellidos(rs.getString("apellidos"));
				usuario.setNickname(rs.getString("nickname"));
				usuario.setEmail(rs.getString("email"));
				usuario.setContrasenya(rs.getString("contrasenya"));
				usuario.setDireccionIP(rs.getString("direccionIP"));
				usuarios.add(usuario);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo los usuarios", e);
		}

		return usuarios;

	}

	/**
	 * Metodo que devuelvelve un ArrayList de coches independientmente a que
	 * categoria pertenezca
	 * 
	 * @return
	 * @throws DBException
	 */

	public static ArrayList<String> listarcoches() throws DBException {
		ArrayList<String> coches = new ArrayList<>();
		Connection con = initBD("EasyRentingMotors.db");

		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM CategoriaA");

			while (rs.next()) {
				String coche = rs.getString("nombre");
				coches.add(coche);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los coches de Categoria A", e);
		}

		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM CategoriaB");

			while (rs.next()) {
				String coche = rs.getString("nombre");
				coches.add(coche);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los coches de Categoria B", e);
		}

		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM CategoriaC");

			while (rs.next()) {
				String coche = rs.getString("nombre");
				coches.add(coche);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los coches de Categoria C", e);
		}

		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery("SELECT nombre FROM CategoriaD");

			while (rs.next()) {
				String coche = rs.getString("nombre");
				coches.add(coche);
			}

		} catch (SQLException e) {
			throw new DBException("Error obteniendo todos los coches de Categoria D", e);
		}

		return coches;

	}

	/**
	 * Metodo que borra un coche de la base de datos
	 * 
	 * @param p
	 * @throws SQLException
	 * @throws DBException
	 */

	public static void borrarCoche(String p) throws SQLException, DBException {
		Connection con = initBD("EasyRentingMotors.db");

		PreparedStatement ps = con.prepareStatement("DELETE FROM CategoriaA WHERE nombre = ?");
		ps.setString(1, p);
		ps.execute();

		ps = con.prepareStatement("DELETE FROM CategoriaB WHERE nombre = ?");
		ps.setString(1, p);
		ps.execute();

		ps = con.prepareStatement("DELETE FROM CategoriaC WHERE nombre = ?");
		ps.setString(1, p);
		ps.execute();

		ps = con.prepareStatement("DELETE FROM CategoriaD WHERE nombre = ?");
		ps.setString(1, p);
		ps.execute();

	}

	/**
	 * Metodo para insertar un coche en categoriaA
	 * 
	 * @param id
	 * @param nombre
	 * @param categoria
	 * @param marca
	 * @param fecha_matriculacion
	 * @param combustible
	 * @param precio
	 * @param rutaFoto
	 * @throws DBException
	 */
	public static void insertarCategoriaA(String id, String nombre, String categoria, String marca,
			String fecha_matriculacion, String combustible, String precio, String rutaFoto) throws DBException {

		String s = "INSERT INTO CategoriaA (id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto) VALUES('"
				+ id + "','" + nombre + "','" + categoria + "', '" + marca + "','" + fecha_matriculacion + "', '"
				+ combustible + "', '" + precio + "','" + rutaFoto + "')";
		Connection c = DBManager.initBD("EasyRentingMotors.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
			logger.log(Level.INFO, "Statement correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}

	}

	/**
	 * Metodo para insertar un coche en categoriaB
	 * 
	 * @param id
	 * @param nombre
	 * @param categoria
	 * @param marca
	 * @param fecha_matriculacion
	 * @param combustible
	 * @param precio
	 * @param rutaFoto
	 * @throws DBException
	 */

	public static void insertarCategoriaB(String id, String nombre, String categoria, String marca,
			String fecha_matriculacion, String combustible, String precio, String rutaFoto) throws DBException {

		String s = "INSERT INTO CategoriaB (id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto) VALUES('"
				+ id + "','" + nombre + "','" + categoria + "', '" + marca + "','" + fecha_matriculacion + "', '"
				+ combustible + "', '" + precio + "','" + rutaFoto + "')";
		Connection c = DBManager.initBD("EasyRentingMotors.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
			logger.log(Level.INFO, "Statement correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}

	}

	/**
	 * Metodo para insertar un coche en categoriaC
	 * 
	 * @param id
	 * @param nombre
	 * @param categoria
	 * @param marca
	 * @param fecha_matriculacion
	 * @param combustible
	 * @param precio
	 * @param rutaFoto
	 * @throws DBException
	 */

	public static void insertarCategoriaC(String id, String nombre, String categoria, String marca,
			String fecha_matriculacion, String combustible, String precio, String rutaFoto) throws DBException {

		String s = "INSERT INTO CategoriaC (id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto) VALUES('"
				+ id + "','" + nombre + "','" + categoria + "', '" + marca + "','" + fecha_matriculacion + "', '"
				+ combustible + "', '" + precio + "','" + rutaFoto + "')";
		Connection c = DBManager.initBD("EasyRentingMotors.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
			logger.log(Level.INFO, "Statement correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}

	}

	/**
	 * Metodo para insertar un coche en categoriaD
	 * 
	 * @param id
	 * @param nombre
	 * @param categoria
	 * @param marca
	 * @param fecha_matriculacion
	 * @param combustible
	 * @param precio
	 * @param rutaFoto
	 * @throws DBException
	 */
	public static void insertarCategoriaD(String id, String nombre, String categoria, String marca,
			String fecha_matriculacion, String combustible, String precio, String rutaFoto) throws DBException {

		String s = "INSERT INTO CategoriaD (id, nombre, categoria, marca, fecha_matriculacion, combustible, precio, rutaFoto) VALUES('"
				+ id + "','" + nombre + "','" + categoria + "', '" + marca + "','" + fecha_matriculacion + "', '"
				+ combustible + "', '" + precio + "','" + rutaFoto + "')";
		Connection c = DBManager.initBD("EasyRentingMotors.db");
		try {
			Statement st = c.createStatement();
			st.executeUpdate(s);
			cerrarBD(c, st);
			logger.log(Level.INFO, "Statement correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}

	}

	/**
	 * Se encarga de poner una categoriaA en oferta
	 * 
	 * @throws SQLException
	 */

	public static void ponerCategoriaAEnOferta() throws SQLException {
		Connection c;
		try {
			c = DBManager.initBD("EasyRentingMotors.db");
			Statement statement = c.createStatement();
			String sent = "update categoriaa set precio = precio - 1000";
			statement.executeUpdate(sent);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Se encarga de quitar la oferta que hay en la categoriaA
	 * 
	 * @throws SQLException
	 */
	public static void seAcabaLaOferta() throws SQLException {
		Connection c;
		try {
			c = DBManager.initBD("EasyRentingMotors.db");
			Statement statement = c.createStatement();
			String sent = "update categoriaa set precio = precio + 1000";
			statement.executeUpdate(sent);
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void disconnect() throws DBException {
		try {
			conn = initBD("EasyRentingMotors.db");
			conn.close();
		} catch (SQLException e) {
			throw new DBException("Error cerrando la conexiÃƒÂ³n con la BD", e);
		}
	}
		
	/**
	 * Metodo que inseta un coche de la categoriaA en el carrtio
	 * 
	 * @param catA
	 * @throws DBException
	 */
	public void insertarCategoriaACarrito(CategoriaA catA) throws DBException {
		String id = catA.getId();
		String nombre = catA.getNombre();
		String fecha = catA.getfecha_matriculacion();
		double precio = catA.getPrecio();

		try (Statement stmt = conn.createStatement()) {

			stmt.executeUpdate("INSERT INTO carrito (id, nombre, fecha, precio) VALUES (' " + id + " ',  ' " + nombre
					+ "', ' " + fecha + ", '" + precio + "')");

		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}

	/**
	 * Metodo que recoje un Vector de Vectores y guarda en la base de datos la lista
	 * de los coches que habia en el carrito
	 * 
	 * @param carrito
	 * @throws SQLException
	 * @throws DBException
	 */

	@SuppressWarnings("rawtypes")
	public static void insetarCarrito(Vector<Vector> carrito) throws SQLException, DBException {

		Statement st = conn.createStatement();

		int max = carrito.size();
		for (int i = 0; i < max; i++) {
			String id = (String) carrito.elementAt(i).elementAt(0);
			String nombre = (String) carrito.elementAt(i).elementAt(1);
			String fecha = (String) (carrito.elementAt(i).elementAt(2));
			String precio = String.valueOf(carrito.elementAt(i).elementAt(3));

			String sql = "INSERT INTO Carrito (id, nombre, fecha, precio) VALUES('" + id + "','" + nombre + "','"
					+ fecha + "','" + precio + "')";
			st.executeUpdate(sql);

			System.out.println("llega");
		}
	}

	/**
	 * Metodo encargado de devolver el ArrayList que hay en ese momento de coches en
	 * el carrito
	 * 
	 * @param nom
	 * @return
	 * @throws ExcepcionExplicita
	 */
	public ArrayList<Carrito> obtenerCarrito(String nom) throws ExcepcionExplicita {
		String sentSQL = "SELECT * FROM carrito WHERE " + nom + "";
		ArrayList<Carrito> al = new ArrayList<>();
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sentSQL);
			while (rs.next()) {
				String id = rs.getString("id");
				String nombre = rs.getString("nombre");
				double precio = rs.getDouble("precio");
				String fecha = rs.getString("fecha");

				Carrito p = new Carrito(id, nombre, fecha, precio);
				al.add(p);
			}
			rs.close();
			st.close();
		} catch (SQLException e) { // TODO Auto-generated catch block
			e.printStackTrace();
			try {
				throw new DBException("No se han obtenido Coches", e);
			} catch (DBException e1) { // TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return al;
	}

	/**
	 * Metodo encargado de insertar los datos necesarios de una targeta de credito
	 * 
	 * @param tarjeta
	 * @throws DBException
	 */
	public void insertarDatosTarjeta(Tarjeta tarjeta) throws DBException {

		try (Statement stmt = conn.createStatement()) {

			int idUsuario = tarjeta.getidUsuario();
			String tipo = tarjeta.getTipo();
			String numeroTarjeta = tarjeta.getNumeroTarjeta();
			String fecha = tarjeta.getFecha();
			String codigoDeSeguridad = tarjeta.getCodigoDeSeguridad();
			String codigoPostal2 = tarjeta.getCodigoPostal2();
			String nombreCompleto = tarjeta.getNombreCompleto();
			String direccion = tarjeta.getDireccion();
			String lineaSegundaDireccion = tarjeta.getLineaSegundaDireccion();
			String ciudad = tarjeta.getCiudad();
			String estadoProvincia = tarjeta.getEstadoProvincia();
			String codigoPostal = tarjeta.getCodigoPostal();

			stmt.executeUpdate(
					"INSERT INTO tarjeta (idUsuario, tipo, numeroTarjeta, fecha, codigoDeSeguridad, codigoPostal2, nombreCompleto,direccion, lineaSegundaDireccion, ciudad, estadoProvincia, codigoPostal) VALUES ('"
							+ idUsuario + "', '" + tipo + "' , '" + numeroTarjeta + "', '" + fecha + "', '"
							+ codigoDeSeguridad + "', '" + nombreCompleto + "', '" + codigoPostal2 + "', '" + direccion
							+ "', '" + lineaSegundaDireccion + "', '" + ciudad + "', '" + estadoProvincia + "', '"
							+ codigoPostal + "')");

		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}

	/**
	 * Cerramos conexión con la BD
	 * 
	 * @throws DBException
	 */
	public static void cerrarBD(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
			logger.log(Level.INFO, "Se ha cerrado correctamente");
		} catch (SQLException e) {
			logger.log(Level.WARNING, e.getMessage());
		}
	}

}

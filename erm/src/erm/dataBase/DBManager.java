package erm.dataBase;

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
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import erm.clasesBasicas.Opinion;
import erm.dataBase.DBException;
import erm.categoriasCoche.CategoriaA;
import erm.categoriasCoche.CategoriaB;
import erm.categoriasCoche.CategoriaC;
import erm.categoriasCoche.CategoriaD;
import erm.clasesBasicas.Alquiler;
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

	
	/**
	 * Inicializa una BD SQLITE y devuelve una conexion con ella
	 * 
	 * @param nombreBD Nombre de fichero de la base de datos
	 * @return ConexiÃ³n con la base de datos indicada. Si hay algÃºn error, se
	 *         devuelve null
	 * @throws BDException
	 */
	
	public static Connection initBD(String nombre) throws DBException {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:data/EasyRentingMotors.db");
			return conn;
		} catch (ClassNotFoundException e) {
			throw new DBException("Error cargando el driver de la BD", e);
		} catch (SQLException e) {
			throw new DBException("Error conectando a la BD", e);
		}
	}

	/**
	 * Este metodo comprueba si existe un usuario en concreto 
	 * @param nick - Nick del usuario
	 * @param contrasenia - Contraseña del usuario
	 * @return
	 * @throws DBException
	 */

	public static int existeUsuario(String nick, String contrasenia) throws DBException {
		conn = initBD("EasyRentingMotors.db");
		String sql = "SELECT * FROM Usuarios WHERE nickname= ?";
		logger.log(Level.INFO, "Seleccionando usuario: " + nick);
		Statement st = null;
		ResultSet rs = null;
		int resultado = 0;
		
		try (PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, nick);
			rs = stmt.executeQuery();
			
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
					logger.log(Level.WARNING, "ContraseÃ±a incorrecta");
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
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return resultado;
	}

	/**
	 * Logging
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
	 * Nos permite meter el alquiler de coche que queremos hacer. En las fechas deseadas.
	 * @param alquiler
	 * @throws DBException
	 * @throws SQLException
	 */
	
	public static void insertarAlquiler(Alquiler alquiler)throws DBException, SQLException  {
		
		Connection con = initBD("EasyRentingMotors.db");
		String sql = "INSERT INTO Alquileres (nomUsuario,	nomCoche, fInicio, fFin) VALUES(?,?,?,?)";

		ps = con.prepareStatement(sql);

		ps.setString(1, alquiler.getNomUsuario());
		ps.setString(2, alquiler.getnomCoche());
		ps.setString(3, alquiler.getFechaInicio());
		ps.setString(4, alquiler.getFechaFin());
		

		ps.execute();
	}
	
	/**
	 * Cambiar contraseña para usuario
	 * @param user
	 * @throws DBException
	 */
		public void cambiarContrasenya(Usuario user) throws DBException {
			
			try (PreparedStatement stmt = conn.prepareStatement(
					"UPDATE usuario SET contrasenya= ? WHERE nomUsuario ='" + user.getNomUsuario() + "'")) {
				stmt.setString(1, user.getContrasenya());
				stmt.executeUpdate();

			} catch (SQLException e) {
				throw new DBException("No ha sido posible ejecutar la query");
			}
		}

		/**
		 * Inserta una nueva opinion
		 * @param opinion
		 * @throws DBException
		 */
		
		public static void insertarOpinion (Opinion opinion) throws DBException{
			

			Connection conn = initBD("EasyRentingMotors.db");
			try (Statement stmt= conn.createStatement()) {
				
				int idUsuario = opinion.getIdUsuario();
				String titulo = opinion.getTitulo();
				String descripcion = opinion.getDescripcion();
				
				stmt.executeUpdate("INSERT INTO opinion (idUsuario, titulo, descripcion) VALUES ('"+ idUsuario + "', '" + titulo + "', '" + descripcion + "')");
			
			} catch (SQLException e) {
				throw new DBException("No ha sido posible ejecutar la query");
			}
	}
	/*
	public void insertarVenta(Coche coche) throws DBException {
		String nombre = coche.getNombre();
		String categoria = coche.getCategoria();
		String marca = coche.getMarca();
		String combustible = coche.getCombustible();
		double precio = coche.getPrecio();

		try (Statement stmt = conn.createStatement()) {

			stmt.executeUpdate("INSERT INTO coche (nombre, categoria,marca, combustible, precio) VALUES (' " + nombre
					+ " ',  ' " + categoria + "', ' " + marca + "' ," + combustible + "' ," + precio + ")");

		} catch (SQLException e) {
			throw new DBException("No ha sido posible ejecutar la query");
		}
	}
	
	
	public ArrayList<Carrito> obtenerCarrito() {
	        String sentSQL = "SELECT * FROM carrito";
	        ArrayList<Carrito> al = new ArrayList<>();
	        try {
	            Statement st = conn.createStatement();
	            ResultSet rs = st.executeQuery(sentSQL);
	            while (rs.next()) {
	                String id = rs.getString("id");
	                String nombre = rs.getString("nombre");
	                double precio = rs.getDouble("precio");
	                String fecha = rs.getString("fecha");
	                
	                

	                Carrito p = new Carrito(id, nombre, precio, fecha);
	                al.add(p);
	            }
	            rs.close();
	            st.close();
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	            try {
	                throw new DBException("No se han obtenido Coches", e);
	            } catch (DBException e1) {
	                // TODO Auto-generated catch block
	                e1.printStackTrace();
	            }
	        }
	        return al;
	    } */
	
	/**
	 * Cerramos conexión con la BD
	 * 
	 * @throws DBException
	 */

	public static void disconnect() throws DBException {
		try {
			conn = initBD("EasyRentingMotors.db");
			conn.close();
		} catch (SQLException e) {
			throw new DBException("Error cerrando la conexiÃƒÂ³n con la BD", e);
		}
	}

	
}

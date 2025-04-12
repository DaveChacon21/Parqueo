package accesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
	
	private static final String DB_URL = "jdbc:sqlite::resource:dataBase/DBUsuarios.db"; // Ruta al archivo en resources
	private static DatabaseConnection instance = null;
	private Connection connection;
	private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

	// Constructor privado para evitar instanciación directa
	private DatabaseConnection() {
		try {
			// Establecer la conexión
			connection = DriverManager.getConnection(DB_URL);
			LOGGER.info("Conexión a SQLite establecida con éxito.");
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Error al conectar con la base de datos: ", e);
			throw new RuntimeException("No se pudo conectar a la base de datos", e);
		}
	}

	// Método para obtener la única instancia (Singleton)
	public static synchronized DatabaseConnection getInstance() {
		if (instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}

	// Método para obtener la conexión
	public Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(DB_URL);
				LOGGER.info("Conexión reestablecida.");
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Error al obtener la conexión: ", e);
			throw new RuntimeException("No se pudo obtener la conexión", e);
		}
		return connection;
	}

	// Método 1: Ejecutar consulta SELECT y devolver un ResultSet
	public ResultSet executeSelect(String query, Object... parameters) {
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			// Asignar parámetros si los hay
			for (int i = 0; i < parameters.length; i++) {
				stmt.setObject(i + 1, parameters[i]);
			}
			return stmt.executeQuery();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Error al ejecutar consulta SELECT: ", e);
			throw new RuntimeException("Error al ejecutar consulta", e);
		}
	}

	// Método 2: Insertar datos
	public int executeInsert(String query, Object... parameters) {
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			// Asignar parámetros si los hay
			for (int i = 0; i < parameters.length; i++) {
				stmt.setObject(i + 1, parameters[i]);
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Error al insertar datos: ", e);
			throw new RuntimeException("Error al insertar datos", e);
		}
	}

	// Método 3: Actualizar datos
	public int executeUpdate(String query, Object... parameters) {
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			// Asignar parámetros si los hay
			for (int i = 0; i < parameters.length; i++) {
				stmt.setObject(i + 1, parameters[i]);
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Error al actualizar datos: ", e);
			throw new RuntimeException("Error al actualizar datos", e);
		}
	}

	// Método 4: Eliminar datos
	public int executeDelete(String query, Object... parameters) {
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			// Asignar parámetros si los hay
			for (int i = 0; i < parameters.length; i++) {
				stmt.setObject(i + 1, parameters[i]);
			}
			return stmt.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Error al eliminar datos: ", e);
			throw new RuntimeException("Error al eliminar datos", e);
		}
	}

	// Método para cerrar la conexión
	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				LOGGER.info("Conexión cerrada.");
			}
		} catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Error al cerrar la conexión: ", e);
		}
	}
}
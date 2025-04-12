package logica;

import java.sql.ResultSet;

import entidades.*;

import accesoDatos.DatabaseConnection;

public class LogicaLogin {

	private DatabaseConnection dbConnection;

	public Usuario validarUsuario(String usuario, String contrasena) {
		Usuario usr;

		dbConnection = DatabaseConnection.getInstance();

		String sqlString = "SELECT Id, Usuario, Nombre, Contraseña, Rol FROM Usuarios WHERE Usuario = ? AND Contraseña = ?";

		try {

			ResultSet rs = dbConnection.executeSelect(sqlString, usuario, contrasena);

			if (rs.next()) {

				usr = new Usuario(rs.getInt("Id"), rs.getString("Nombre"), rs.getString("Usuario"),
						rs.getString("Contraseña"), rs.getString("Rol"));

			} else {
				usr= new Usuario();
				usr.setMensajeError("No se encontró el usuario \n usuario o contraseña invalidos");
			}

		} catch (Exception e) {
			System.err.println("Error al validar credenciales: " + e.getMessage());
			usr= new Usuario();
			usr.setMensajeError("Error de Conexión");
		}

		return usr;

	}

}

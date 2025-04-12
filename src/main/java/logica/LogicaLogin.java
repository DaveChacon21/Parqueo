package logica;

import java.sql.ResultSet;

import entidades.*;

import accesoDatos.DatabaseConnection;

public class LogicaLogin {

	private DatabaseConnection dbConnection;

	public Usuario validarUsuario(String usuario, String contrasena) {
		Usuario usr = new Usuario();

		dbConnection = DatabaseConnection.getInstance();

		String sqlString = "SELECT Id, Usuario, Nombre, Contraseña, Rol FROM Usuarios WHERE Usuario = ? AND Contraseña = ?";
		
		try {
			
			ResultSet rs = dbConnection.executeSelect(sqlString, usuario, contrasena);
			
			if(rs.next()) {

				usr.setIdUsuario(rs.getInt("Id"));
				usr.setUsuario(rs.getString("Usuario"));
				usr.setNombre(rs.getString("Nombre"));
				usr.setContrasena(rs.getString("Contraseña"));
				usr.setRol(rs.getString("Rol"));
				
			}else {
				usr.setMensajeError("No se encontró el usuario \n usuario o contraseña invalidos");
			}
			
		} catch (Exception e) {
			System.err.println("Error al validar credenciales: " + e.getMessage());
			usr.setMensajeError("Error de Conexión");
		}
		
		return usr;

	}

}

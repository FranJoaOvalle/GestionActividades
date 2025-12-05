package db;

import vista.PopUps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:sqlite:database.db";
    private static Connection conn = null;

    private Conexion() {
    }

    public static Connection getConexion() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(URL);
            conn.createStatement().execute("PRAGMA foreign_keys = ON");
        }
        return conn;
    }

    public static void cerrar() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            PopUps.ERROR("Error al cerrar la conexión: ", e);
        }
    }
}


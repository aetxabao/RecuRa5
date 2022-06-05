
package com.masanz.rr5.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

import static com.masanz.rr5.config.Ctes.PASSWORD;
import static com.masanz.rr5.config.Ctes.USUARIO;
import static com.masanz.rr5.config.Ctes.BD;

/**
 * Clase de utilidades con métodos estáticos
 */
public class DbConUtil {

    private static HashMap<String, Connection> mapa = new HashMap<>();

    public static Connection getConexion() throws SQLException {
        Connection con = mapa.get(BD);
        if (con == null){
            con = DriverManager.getConnection("jdbc:mysql://localhost/" + BD, USUARIO, PASSWORD);
            mapa.put(BD, con);
        }
        return con;
    }

    public static void closeConexion(Connection conexion) throws SQLException {
        if (!conexion.isClosed()) {
            conexion.close();
            mapa.remove(BD);
        }
    }

    public static void main(String[] args) {
        try {
            DbConUtil.getConexion();
            System.out.println("Conexión establecida");
        } catch (SQLException e) {
            System.out.println("Fallo al conectar " + e);
        }
    }
}



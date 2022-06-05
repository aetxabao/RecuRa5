package com.masanz.rr5.dao;

import com.masanz.rr5.modelo.Usuario;
import com.masanz.rr5.utils.DbConUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

    public Usuario getUsuario(String nombre) {
        Usuario usuario = null;
        String sql = "SELECT nombre, sal, hash FROM usuarios WHERE nombre LIKE BINARY ? ";

        Connection conexion = null;
        try {
            conexion = DbConUtil.getConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1,nombre);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    usuario = new Usuario();
                    usuario.setNombre(rs.getString(1));
                    usuario.setSal(rs.getString(2));
                    usuario.setHash(rs.getString(3));
                }
            }
            catch (SQLException e) {
                System.out.println("Error en consulta " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return usuario;
    }

}

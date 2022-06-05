package com.masanz.rr5.dao;

import com.masanz.rr5.utils.DbConUtil;
import com.masanz.rr5.modelo.Alumno;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AlumnosDao {

    public List<String> getListadoAlumnos(boolean tienenPendiente, boolean ordenAlfaTrueNotaFalse) {
        List<Alumno> list = getAlumnos(tienenPendiente, ordenAlfaTrueNotaFalse);
        List<String> strings = list.stream()
                .map(object -> Objects.toString(object, null))
                .collect(Collectors.toList());
        return strings;
    }

    public Alumno getAlumno(int index, boolean tienenPendiente, boolean ordenAlfaTrueNotaFalse) {
        List<Alumno> list = getAlumnos(tienenPendiente, ordenAlfaTrueNotaFalse);
        return list.get(index);
    }

    public List<Alumno> getAlumnos(boolean tienenPendiente, boolean ordenAlfaTrueNotaFalse) {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT idAlumno, nombre, apellido, nota, pendiente " +
                "FROM alumnos ";
        if (tienenPendiente) {
            sql = sql + "WHERE pendiente = 'SI' ";
        } else {
            sql = sql + "WHERE pendiente = 'NO' ";
        }
        if (ordenAlfaTrueNotaFalse) {
            sql += " ORDER BY apellido ";
            sql += "ASC";
        }else {
            sql += " ORDER BY nota ";
            sql += "DESC";
        }

        Connection conexion = null;
        try {
            conexion = DbConUtil.getConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (PreparedStatement pst = conexion.prepareStatement(sql)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int idAlumno = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String apellido = rs. getString(3);
                    int nota = rs.getInt(4);
                    String s = rs.getString(5);
                    boolean pendiente = s.toLowerCase().startsWith("s");
                    Alumno a = new Alumno(idAlumno, nombre, apellido, nota, pendiente);
                    lista.add(a);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<Alumno> getListadoAlumnos() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT idAlumno, nombre, apellido, nota, pendiente " +
                "FROM alumnos ORDER BY idAlumno ASC";
        Connection conexion = null;
        try {
            conexion = DbConUtil.getConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (PreparedStatement pst = conexion.prepareStatement(sql)) {
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    int idAlumno = rs.getInt(1);
                    String nombre = rs.getString(2);
                    String apellido = rs. getString(3);
                    int nota = rs.getInt(4);
                    String s = rs.getString(5);
                    boolean pendiente = s.toLowerCase().startsWith("s");
                    Alumno a = new Alumno(idAlumno, nombre, apellido, nota, pendiente);
                    lista.add(a);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public int getCountAlumnos() {
        int n = 0;
        String sql = "SELECT count(*) AS n FROM alumnos ";

        Connection conexion = null;
        try {
            conexion = DbConUtil.getConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (PreparedStatement pst = conexion.prepareStatement(sql)) {
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    n = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return n;
    }

    public boolean updateAlumno(Alumno a) {
        boolean b = false;
        String sql = "UPDATE alumnos SET nombre=?, apellido=?, nota=?, pendiente=? WHERE idAlumno=?";

        Connection conexion = null;
        try {
            conexion = DbConUtil.getConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getApellido());
            pst.setInt(3, a.getNota());
            String susp = a.isPendiente()?"si":"no";
            pst.setString(4, susp);
            pst.setInt(5, a.getIdAlumno());
            int i = pst.executeUpdate();
            return i>0;
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return b;
    }

    public int insertarAlumnos(List<Alumno> lista) {
        int n = 0;
        String sql = "INSERT INTO alumnos (idAlumno, nombre, apellido, nota, pendiente) " +
                "VALUES (?, ?, ?, ?, ?)";

        Connection conexion = null;
        try {
            conexion = DbConUtil.getConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (PreparedStatement pst = conexion.prepareStatement(sql)) {
            for (Alumno a : lista) {
                pst.setInt(1, a.getIdAlumno());
                pst.setString(2, a.getNombre());
                pst.setString(3, a.getApellido());
                pst.setInt(4, a.getNota());
                String susp = a.isPendiente()?"si":"no";
                pst.setString(5, susp);
                try {
                    pst.executeUpdate();
                }catch (SQLException e) {
                    n++;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return n;
    }

    public int borrarBd() {
        int n = 0;
        String sql = "DELETE FROM alumnos";

        Connection conexion = null;
        try {
            conexion = DbConUtil.getConexion();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try (PreparedStatement pst = conexion.prepareStatement(sql)) {
            pst.executeUpdate();
            n = getCountAlumnos();
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
        return n;
    }

}

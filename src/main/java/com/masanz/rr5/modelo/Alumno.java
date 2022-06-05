package com.masanz.rr5.modelo;

import com.masanz.rr5.excepciones.ExcepcionMarshall;

import java.util.Objects;

import static com.masanz.rr5.config.Ctes.SEPARADOR_CSV;

public class Alumno {

    private int idAlumno;
    private String nombre;
    private String apellido;
    private int nota;
    private boolean pendiente;

    public Alumno() {
        this.idAlumno = 0;
        this.nombre = "";
        this.apellido = "";
        this.nota = 0;
        this.pendiente = true;
    }

    public Alumno(int idAlumno, String nombre, String apellido, int nota, boolean pendiente) {
        this.idAlumno = idAlumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
        this.pendiente = pendiente;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public boolean isPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }

    public String toNombreApellidoNota() {
        return String.format("|%-20s|%-20s|%-10d|%10s|", apellido, nombre, nota, pendiente?"SI":"NO");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return idAlumno == alumno.idAlumno ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlumno, nombre, apellido, nota, pendiente);
    }

    @Override
    public String toString() {
        return String.format("%-10s, %-10s   %2d",
                apellido.substring(0,Math.min(apellido.length(), 10)),
                nombre.substring(0,Math.min(nombre.length(), 10)),
                nota);
    }

    public String toCsv() {
        return String.format("%d;%s;%s;%d;%s",
                idAlumno, nombre, apellido, nota, pendiente?"si":"no");
    }

    public void fromCsv(String linea) {
        //TODO: fromCsv
        String[] campos = linea.split(SEPARADOR_CSV);
        idAlumno = Integer.parseInt(campos[0]);
        nombre = campos[1];
        apellido = campos[2];
        nota = Integer.parseInt(campos[3]);
        String pend = campos[4];
        if (pend.toLowerCase().equals("si") || pend.toLowerCase().equals("sí")){
            pendiente = true;
        }else if (pend.toLowerCase().equals("no")){
            pendiente = false;
        }
    }

}

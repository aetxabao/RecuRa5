package com.masanz.rr5.modelo;

import java.util.Objects;

public class Usuario {

    private String nombre;
    private String sal;
    private String hash;

    public Usuario() {
        this.nombre = "";
        this.sal = "";
        this.hash = "";
    }

    public Usuario(String nombre, String sal, String hash) {
        this.nombre = nombre;
        this.sal = sal;
        this.hash = hash;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSal() {
        return sal;
    }

    public void setSal(String sal) {
        this.sal = sal;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash);
    }

    @Override
    public String toString() {
        return nombre;
    }

}

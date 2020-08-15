package com.example.proyectomascotas;

import java.io.Serializable;

public class Mascota implements Serializable {
    private String nombre;
    private String hards;
    private int foto;

    public Mascota(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
        this.hards = "0";
    }

    public Mascota(int foto, String nombre, String hards) {
        this.foto = foto;
        this.nombre = nombre;
        this.hards = hards;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHards() {
        return hards;
    }

    public void setHards(String hards) {
        this.hards = hards;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

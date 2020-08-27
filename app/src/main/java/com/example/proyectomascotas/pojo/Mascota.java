package com.example.proyectomascotas.pojo;

import java.io.Serializable;

public class Mascota implements Serializable {
    private String nombre;
    private int hards;
    private int foto;

    public Mascota(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
        this.hards = 0;
    }

    public Mascota(int foto, String nombre, int hards) {
        this.foto = foto;
        this.nombre = nombre;
        this.hards = hards;
    }

    public Mascota(int foto, int hards) {
        this.foto = foto;
        this.hards = hards;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHards() {
        return hards;
    }

    public void setHards(int hards) {
        this.hards = hards;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}

package com.example.proyectomascotas.pojo;

import java.io.Serializable;

public class Mascota implements Serializable {
    private int id;
    private String idP;
    private String nombre;
    private int hards;
    private int foto;
    private String fotoP;

    public Mascota(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
        this.hards = 0;
    }

    public Mascota(String fotoP, String nombre) {
        this.fotoP = fotoP;
        this.nombre = nombre;
        this.hards = 0;
    }

    public Mascota(int foto, String nombre, int hards) {
        this.foto = foto;
        this.nombre = nombre;
        this.hards = hards;
    }

    public Mascota(String fotoP, String nombre, int hards) {
        this.fotoP = fotoP;
        this.nombre = nombre;
        this.hards = hards;
    }

    public Mascota(int foto, int hards) {
        this.foto = foto;
        this.hards = hards;
    }

    public Mascota(String fotoP, int hards) {
        this.fotoP = fotoP;
        this.hards = hards;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getIdP() {
        return idP;
    }

    public void setIdP(String idP) {
        this.idP = idP;
    }

    public String getFotoP() {
        return fotoP;
    }

    public void setFotoP(String fotoP) {
        this.fotoP = fotoP;
    }
}

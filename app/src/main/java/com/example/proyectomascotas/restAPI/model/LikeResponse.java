package com.example.proyectomascotas.restAPI.model;

public class LikeResponse {
    private String id_firebase;
    private String id_foto_instagram;
    private String id_usuario_instagram;
    private String id_dispositivo;

    public LikeResponse(String id_firebase, String id_foto_instagram, String id_usuario_instagram, String id_dispositivo) {
        this.id_firebase = id_firebase;
        this.id_foto_instagram = id_foto_instagram;
        this.id_usuario_instagram = id_usuario_instagram;
        this.id_dispositivo = id_dispositivo;
    }

    public LikeResponse() {

    }

    public String getId_firebase() {
        return id_firebase;
    }

    public void setId_firebase(String id_firebase) {
        this.id_firebase = id_firebase;
    }

    public String getId_foto_instagram() {
        return id_foto_instagram;
    }

    public void setId_foto_instagram(String id_foto_instagram) {
        this.id_foto_instagram = id_foto_instagram;
    }

    public String getId_usuario_instagram() {
        return id_usuario_instagram;
    }

    public void setId_usuario_instagram(String id_usuario_instagram) {
        this.id_usuario_instagram = id_usuario_instagram;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }
}

package com.example.proyectomascotas.restAPI.model;

public class UsuarioResponse {
    private String id_firebase;
    private String id_dispositivo;
    private String id_usuario_instagram;

    public UsuarioResponse(String id_firebase, String id_dispositivo, String id_usuario_instagram) {
        this.id_firebase = id_firebase;
        this.id_dispositivo = id_dispositivo;
        this.id_usuario_instagram = id_usuario_instagram;
    }

    public UsuarioResponse() {

    }

    public String getId_firebase() {
        return id_firebase;
    }

    public void setId_firebase(String id_firebase) {
        this.id_firebase = id_firebase;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getId_usuario_instagram() {
        return id_usuario_instagram;
    }

    public void setId_usuario_instagram(String id_usuario_instagram) {
        this.id_usuario_instagram = id_usuario_instagram;
    }
}

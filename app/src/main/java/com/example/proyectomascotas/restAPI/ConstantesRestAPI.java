package com.example.proyectomascotas.restAPI;

public class ConstantesRestAPI {
    public static final String ROOT_URL = "https://graph.instagram.com/";
    public static final String ACCESS_TOKEN = "IGQVJXN0xQTkNFeE0yMGYyVkhBMXdMU21mLTJRemVpTWRvRS15cFFCQmJzYXVBcm9ldWFKaWpFcXJPZAm5fTXVpNTZACUnFoTHdkUXpvVnpjX2d4bEFsd3Q1YXU3UlExdWVNWC1vU0FoTjFCVVpqQnhZAagZDZD";
    public static final String KEY_ACCESS_TOKEN = "access_token=";
    public static final String KEY_GET_MEDIA_USER = "me/media?fields=id,media_type,media_url,username&";
    public static final String URL_GET_MEDIA_USER = KEY_GET_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;

    public static final String ROOT_URL_NOTIFICATION = "https://pacific-bastion-13781.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN = "registrar-usuario";
    public static final String KEY_POST_LIKE_FOTO = "registrar-like";
}

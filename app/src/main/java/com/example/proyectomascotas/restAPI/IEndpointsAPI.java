package com.example.proyectomascotas.restAPI;

import com.example.proyectomascotas.restAPI.model.MascotaResponse;
import com.example.proyectomascotas.restAPI.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface IEndpointsAPI {
    @GET(ConstantesRestAPI.URL_GET_MEDIA_USER)
    Call<MascotaResponse> getMedia();

    @FormUrlEncoded
    @POST(ConstantesRestAPI.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("user") String id_usuario_instagram, @Field("token") String id_dispositivo);
}

package com.example.proyectomascotas.restAPI;

import com.example.proyectomascotas.restAPI.model.MascotaResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IEndpointsAPI {
    @GET(ConstantesRestAPI.URL_GET_MEDIA_USER)
    Call<MascotaResponse> getMedia();
}

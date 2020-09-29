package com.example.proyectomascotas.restAPI.adapter;

import com.example.proyectomascotas.restAPI.ConstantesRestAPI;
import com.example.proyectomascotas.restAPI.IEndpointsAPI;
import com.example.proyectomascotas.restAPI.deserializador.MascotaDeserializador;
import com.example.proyectomascotas.restAPI.model.MascotaResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestAPIAdapter {
    public IEndpointsAPI establecerConexionRestAPIInstagram(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestAPI.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IEndpointsAPI.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        gsonBuilder.registerTypeAdapter(MascotaResponse.class, new MascotaDeserializador());

        return gsonBuilder.create();
    }

    public IEndpointsAPI establecerConexionRestAPI() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestAPI.ROOT_URL_NOTIFICATION)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IEndpointsAPI.class);
    }
}

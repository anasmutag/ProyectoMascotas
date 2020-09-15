package com.example.proyectomascotas.restAPI.deserializador;

import com.example.proyectomascotas.pojo.Mascota;
import com.example.proyectomascotas.restAPI.model.MascotaResponse;
import com.example.proyectomascotas.restAPI.JsonKeys;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MascotaDeserializador implements JsonDeserializer<MascotaResponse> {

    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        MascotaResponse mascotaResponse = gson.fromJson(json, MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserializarMascotaJson(mascotaResponseData));

        return mascotaResponse;
    }

    private ArrayList<Mascota> deserializarMascotaJson(JsonArray mascotaResponseData) {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        for (int i = 0; i < mascotaResponseData.size(); i++) {
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();
            String id = mascotaResponseDataObject.get(JsonKeys.USER_ID).getAsString();
            String nombre = mascotaResponseDataObject.get(JsonKeys.USER_NAME).getAsString();
            String urlFoto = mascotaResponseDataObject.get(JsonKeys.MEDIA_URL).getAsString();
            int likes = i;

            Mascota mascotaActual = new Mascota();

            mascotaActual.setIdP(id);
            mascotaActual.setNombre(nombre);
            mascotaActual.setFotoP(urlFoto);
            mascotaActual.setHards(likes);

            mascotas.add(mascotaActual);
        }

        return mascotas;
    }
}

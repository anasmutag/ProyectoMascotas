package com.example.proyectomascotas.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.proyectomascotas.fragment.IPerfilMascotaFragmentView;
import com.example.proyectomascotas.pojo.Mascota;
import com.example.proyectomascotas.restAPI.IEndpointsAPI;
import com.example.proyectomascotas.restAPI.adapter.RestAPIAdapter;
import com.example.proyectomascotas.restAPI.model.MascotaResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilMascotaFragmentPresenter implements IPerfilMascotaFragmentPresenter {
    private IPerfilMascotaFragmentView iPerfilMascotaFragmentView;
    private Context context;
    private ArrayList<Mascota> mascotas;

    public PerfilMascotaFragmentPresenter(IPerfilMascotaFragmentView iPerfilMascotaFragmentView, Context context) {
        this.iPerfilMascotaFragmentView = iPerfilMascotaFragmentView;
        this.context = context;

        obtenerMedios();
    }

    @Override
    public void obtenerMedios() {
        RestAPIAdapter restAPIAdapter = new RestAPIAdapter();
        Gson gsonMediaRecent = restAPIAdapter.construyeGsonDeserializadorMediaRecent();

        restAPIAdapter.establecerConexionRestAPIInstagram(gsonMediaRecent);

        IEndpointsAPI iEndpointsAPI = restAPIAdapter.establecerConexionRestAPIInstagram(gsonMediaRecent);
        Call<MascotaResponse> mascotaResponseCall = iEndpointsAPI.getMedia();

        mascotaResponseCall.enqueue(new Callback<MascotaResponse>() {
            @Override
            public void onResponse(Call<MascotaResponse> call, Response<MascotaResponse> response) {
                MascotaResponse mascotaResponse = response.body();

                mascotas = mascotaResponse.getMascotas();

                mostrarMascotasRV();
            }

            @Override
            public void onFailure(Call<MascotaResponse> call, Throwable t) {
                Toast.makeText(context, "¡Ocurrió un error en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();

                Log.e("Falló la conexión", t.toString());
            }
        });
    }

    @Override
    public void mostrarMascotasRV() {
        iPerfilMascotaFragmentView.inicializarAdaptadorRV(iPerfilMascotaFragmentView.crearAdaptador(mascotas));
        iPerfilMascotaFragmentView.generarGridLayout();
    }
}

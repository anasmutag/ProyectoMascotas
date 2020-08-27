package com.example.proyectomascotas.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectomascotas.R;
import com.example.proyectomascotas.adapter.MascotaAdapter;
import com.example.proyectomascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;
    public MascotaAdapter adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador() {
        adaptador = new MascotaAdapter(mascotas, getActivity());

        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota01, getResources().getString(R.string.nombre_mascota_01), 5));
        mascotas.add(new Mascota(R.drawable.mascota02, getResources().getString(R.string.nombre_mascota_02), 3));
        mascotas.add(new Mascota(R.drawable.mascota03, getResources().getString(R.string.nombre_mascota_03)));
        mascotas.add(new Mascota(R.drawable.mascota04, getResources().getString(R.string.nombre_mascota_04), 1));
        mascotas.add(new Mascota(R.drawable.mascota05, getResources().getString(R.string.nombre_mascota_05), 8));
        mascotas.add(new Mascota(R.drawable.mascota06, getResources().getString(R.string.nombre_mascota_06)));
        mascotas.add(new Mascota(R.drawable.mascota07, getResources().getString(R.string.nombre_mascota_07), 4));
        mascotas.add(new Mascota(R.drawable.mascota08, getResources().getString(R.string.nombre_mascota_08), 4));
    }
}
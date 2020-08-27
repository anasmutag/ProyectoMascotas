package com.example.proyectomascotas.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectomascotas.R;
import com.example.proyectomascotas.adapter.FotosAdapter;
import com.example.proyectomascotas.adapter.MascotaAdapter;
import com.example.proyectomascotas.pojo.Mascota;

import java.util.ArrayList;

public class PerfilMascotaFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvFotosPerfil;
    public FotosAdapter adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        rvFotosPerfil = (RecyclerView) v.findViewById(R.id.rvFotosPerfil);

        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);

        rvFotosPerfil.setLayoutManager(glm);

        inicializarListaFotos();
        inicializarAdaptadorFotos();

        return v;
    }

    public void inicializarAdaptadorFotos() {
        adaptador = new FotosAdapter(mascotas, getActivity());

        rvFotosPerfil.setAdapter(adaptador);
    }

    public void inicializarListaFotos() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota01,5));
        mascotas.add(new Mascota(R.drawable.mascota02,3));
        mascotas.add(new Mascota(R.drawable.mascota04,1));
        mascotas.add(new Mascota(R.drawable.mascota05,8));
        mascotas.add(new Mascota(R.drawable.mascota07,4));
        mascotas.add(new Mascota(R.drawable.mascota08,4));
    }
}
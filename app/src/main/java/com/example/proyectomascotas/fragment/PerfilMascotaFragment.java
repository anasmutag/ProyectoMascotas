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
import com.example.proyectomascotas.presentador.IPerfilMascotaFragmentPresenter;
import com.example.proyectomascotas.presentador.PerfilMascotaFragmentPresenter;

import java.util.ArrayList;

public class PerfilMascotaFragment extends Fragment implements IPerfilMascotaFragmentView {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvFotosPerfil;
    public FotosAdapter adaptador;
    private IPerfilMascotaFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        rvFotosPerfil = (RecyclerView) v.findViewById(R.id.rvFotosPerfil);
        presenter = new PerfilMascotaFragmentPresenter(this, getContext());

        return v;
    }

    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);

        rvFotosPerfil.setLayoutManager(gridLayoutManager);
    }

    @Override
    public FotosAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        FotosAdapter adaptador = new FotosAdapter(mascotas, getActivity());

        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(FotosAdapter adaptador) {
        rvFotosPerfil.setAdapter(adaptador);
    }
}
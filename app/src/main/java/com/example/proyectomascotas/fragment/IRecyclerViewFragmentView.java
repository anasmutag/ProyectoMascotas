package com.example.proyectomascotas.fragment;

import com.example.proyectomascotas.adapter.MascotaAdapter;
import com.example.proyectomascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdapter adaptador);
}

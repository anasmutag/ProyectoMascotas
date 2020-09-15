package com.example.proyectomascotas.fragment;

import com.example.proyectomascotas.adapter.FotosAdapter;
import com.example.proyectomascotas.pojo.Mascota;

import java.util.ArrayList;

public interface IPerfilMascotaFragmentView {
    public void generarGridLayout();
    public FotosAdapter crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(FotosAdapter adaptador);
}

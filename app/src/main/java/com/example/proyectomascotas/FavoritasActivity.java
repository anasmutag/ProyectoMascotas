package com.example.proyectomascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FavoritasActivity extends AppCompatActivity {
    ArrayList<Mascota> favortias;
    private RecyclerView rvFavoritas;
    public MascotaAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle parametros = getIntent().getExtras();

        favortias = (ArrayList<Mascota>) parametros.getSerializable(getResources().getString(R.string.mascotas_favoritas));

        rvFavoritas = (RecyclerView) findViewById(R.id.rvFavoritas);

        LinearLayoutManager llmf = new LinearLayoutManager(this);
        llmf.setOrientation(LinearLayoutManager.VERTICAL);

        rvFavoritas.setLayoutManager(llmf);

        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        adaptador = new MascotaAdapter(favortias, this);

        rvFavoritas.setAdapter(adaptador);
    }
}
package com.example.proyectomascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    ArrayList<Mascota> favoritas;
    private RecyclerView rvMascotas;
    public MascotaAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        adaptador = new MascotaAdapter(mascotas, this);

        rvMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.mascota01, getResources().getString(R.string.nombre_mascota_01), "5"));
        mascotas.add(new Mascota(R.drawable.mascota02, getResources().getString(R.string.nombre_mascota_02), "3"));
        mascotas.add(new Mascota(R.drawable.mascota03, getResources().getString(R.string.nombre_mascota_03)));
        mascotas.add(new Mascota(R.drawable.mascota04, getResources().getString(R.string.nombre_mascota_04), "1"));
        mascotas.add(new Mascota(R.drawable.mascota05, getResources().getString(R.string.nombre_mascota_05), "8"));
        mascotas.add(new Mascota(R.drawable.mascota06, getResources().getString(R.string.nombre_mascota_06)));
        mascotas.add(new Mascota(R.drawable.mascota07, getResources().getString(R.string.nombre_mascota_07), "4"));
        mascotas.add(new Mascota(R.drawable.mascota08, getResources().getString(R.string.nombre_mascota_08), "4"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mRanking:
                favoritas = new ArrayList<Mascota>();

                favoritas.add(new Mascota(R.drawable.mascota05, getResources().getString(R.string.nombre_mascota_05), "8"));
                favoritas.add(new Mascota(R.drawable.mascota01, getResources().getString(R.string.nombre_mascota_01), "5"));
                favoritas.add(new Mascota(R.drawable.mascota08, getResources().getString(R.string.nombre_mascota_08), "4"));
                favoritas.add(new Mascota(R.drawable.mascota02, getResources().getString(R.string.nombre_mascota_02), "3"));
                favoritas.add(new Mascota(R.drawable.mascota04, getResources().getString(R.string.nombre_mascota_04), "1"));

                Bundle f = new Bundle();

                f.putSerializable(getResources().getString(R.string.mascotas_favoritas), (Serializable) favoritas);

                Intent intent = new Intent(this, FavoritasActivity.class);

                intent.putExtras(f);

                startActivity(intent);

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
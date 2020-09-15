package com.example.proyectomascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ConfigurarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
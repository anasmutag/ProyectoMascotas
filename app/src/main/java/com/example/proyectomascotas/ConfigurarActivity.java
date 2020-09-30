package com.example.proyectomascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class ConfigurarActivity extends AppCompatActivity {
    private TextInputEditText etUsuarioCuenta;
    private Button btnGuardarCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnGuardarCuenta = (Button) findViewById(R.id.btnGuardarCuenta);
        etUsuarioCuenta = (TextInputEditText) findViewById(R.id.etUsuarioCuenta);

        SharedPreferences sharedPreferences = getSharedPreferences("UsuarioInstagram", Context.MODE_PRIVATE);
        String usuarioInstagram = sharedPreferences.getString("cuenta","");

        etUsuarioCuenta.setText(usuarioInstagram);

        btnGuardarCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cuenta = etUsuarioCuenta.getText().toString();
                SharedPreferences sharedPreferences1 = getSharedPreferences("UsuarioInstagram", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences1.edit();

                editor.putString("cuenta", cuenta);
                editor.commit();

                Toast.makeText(ConfigurarActivity.this, "Se guardó tu cuenta con exito", Toast.LENGTH_LONG).show();
            }
        });
    }
}
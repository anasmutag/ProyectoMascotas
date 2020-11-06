package com.example.proyectomascotas;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AccionMascota extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String accion = intent.getAction();

        switch (accion) {
            case "VER_PERFIL":
                MainActivity.indexTab = 1;
                Intent intentVP = new Intent(context.getApplicationContext(), MainActivity.class);
                intentVP.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intentVP);

                break;
            case "VER_USUARIO":
                MainActivity.indexTab = 1;
                Intent intentVU = new Intent(context.getApplicationContext(), MainActivity.class);
                intentVU.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intentVU);

                break;
        }
    }
}

package com.example.proyectomascotas;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;

public class NotificationIDTokenService extends FirebaseMessagingService {
    private static final String TAG = "NotificationIDToken";

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);

        enviarTokenRegistro(s);
    }

    private void enviarTokenRegistro(String token) {
        Log.d(TAG, token);
    }
}

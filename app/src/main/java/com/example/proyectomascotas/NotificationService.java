package com.example.proyectomascotas;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.app.NotificationCompat.WearableExtender;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class NotificationService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    private static final int NOTIFICATION_ID = 001;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);

        Log.d(TAG, "From: " + remoteMessage.getFrom());

        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        Intent i = new Intent(this, MainActivity.class);
        i.setAction("OPEN_TAB_PERFIL");
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_ONE_SHOT);

        Intent ivp = new Intent();
        ivp.setAction("VER_PERFIL");
        PendingIntent pendingIntentVP = PendingIntent.getBroadcast(this, 0, ivp, PendingIntent.FLAG_UPDATE_CURRENT);

        Intent ivu = new Intent();
        ivu.setAction("VER_USUARIO");
        PendingIntent pendingIntentVU = PendingIntent.getBroadcast(this, 0, ivu, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Action actionvp =
                new NotificationCompat.Action.Builder(R.drawable.home, getString(
                        R.string.texto_ver_perfil), pendingIntentVP)
                .build();

        NotificationCompat.Action actionvu =
                new NotificationCompat.Action.Builder(R.drawable.year_of_dog, getString(
                        R.string.texto_ver_usuario), pendingIntentVU)
                .build();

        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender();

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this, "0")
                .setSmallIcon(R.drawable.answers)
                .setContentTitle("Notificación")
                .setContentText(remoteMessage.getNotification().getBody())
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .extend(wearableExtender).addAction(actionvp)
                .extend(wearableExtender).addAction(actionvu);
                //.addAction(R.drawable.ic_full_hand_cursor, getString(R.string.texto_accion_toque), pendingIntent);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, notificacion.build());
    }

    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Token ID: " + token);

        sendRegistrationToServer(token);
    }

    private void sendRegistrationToServer(String token) {

    }
}

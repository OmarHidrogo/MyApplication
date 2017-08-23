package com.omar_hidrogo_local.notificacionfirebase;


import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
//se agregaron nuevas clases de Notificaciones
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;
import android.view.Gravity;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;


/**
 * Created by tmhidrooma on 10/08/2017.
 */

public class NotificationServices extends FirebaseMessagingService {

    public static final String TAG = "firebase";
    public static final int NOTIFICATION_ID = 001;

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());

        Intent i = new Intent();
        i.setAction("TOQUE_ANIMAL");

        PendingIntent pendingIntent =   PendingIntent.getBroadcast(this,0,i,PendingIntent.FLAG_UPDATE_CURRENT);

        Uri sonido = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Action action = new NotificationCompat.Action.Builder(R.drawable.ic_full_hand,
                getString(R.string.texto_accion_toque),pendingIntent)
                .build();

        NotificationCompat.WearableExtender wearableExtender =
                new NotificationCompat.WearableExtender()
                .setHintHideIcon(true)
                .setBackground(BitmapFactory.decodeResource(getResources(),
                        R.drawable.universo))
                .setGravity(Gravity.CENTER_VERTICAL)
                ;

        NotificationCompat.Builder notificacion = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("Notificacion")
                .setContentText(remoteMessage.getNotification().getBody())
                .setSound(sonido)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .extend(wearableExtender.addAction(action))
                //.addAction(R.drawable.ic_full_hand,getString(R.string.texto_accion_toque), pendingIntent)
                ;


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFICATION_ID, notificacion.build());

    }
}

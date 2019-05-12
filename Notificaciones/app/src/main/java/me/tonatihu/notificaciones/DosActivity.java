package me.tonatihu.notificaciones;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class DosActivity extends AppCompatActivity {
    int id = 1;
    public static final String TAG = DosActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);
    }
    public void onClick(View v){
        displayNotification();
    }

    protected void displayNotification(){
        Log.d(TAG, "displayNotification");
        Intent i = new Intent(this, NotificaionActivity.class);
        i.putExtra("notificationID", id);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, i, 0);
        NotificationManager nm = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        CharSequence ticker = "Nueva entrada en ESCOM";
        CharSequence contentTitle = "Notificaciones";
        CharSequence contentText = "Curso de Android";
        Notification noti = new NotificationCompat.Builder(this, "notify_001")
                .setContentIntent(pendingIntent)
                .setTicker(ticker)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(R.mipmap.ic_launcher)
                .addAction(R.mipmap.ic_launcher, ticker, pendingIntent)
                .setVibrate(new long[] {100, 250, 100, 500})
                .build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelId = "notify_001";
            NotificationChannel channel = new NotificationChannel(channelId,
                    "Channel human readable title", NotificationManager.IMPORTANCE_DEFAULT);
            nm.createNotificationChannel(channel);
        }
        nm.notify(id, noti);
    }
}

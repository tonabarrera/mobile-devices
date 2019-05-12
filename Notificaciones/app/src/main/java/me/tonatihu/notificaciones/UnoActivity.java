package me.tonatihu.notificaciones;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UnoActivity extends Activity {
    int t=200, i=0;
    boolean c=true;
    TextView jtv;
    Button jbnN;
    private static final int NOTIF_ALERTA_ID = 1;
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_uno);
        jtv = findViewById(R.id.xtv);
        jbnN = findViewById(R.id.xbnN);
        jbnN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                NotificationCompat.Builder ncb =
                        new NotificationCompat.Builder(UnoActivity.this, "notify_001")
                                .setSmallIcon(android.R.drawable.stat_sys_warning)
                                .setContentTitle("Alerta de Notificación")
                                .setContentText("Uso de la notificación." + "i=" + ++i)
                                .setContentInfo("Un valor")
                                .setTicker("Mensaje de Alerta!");
                Intent in = new Intent(UnoActivity.this, UnoActivity.class);
                PendingIntent pi = PendingIntent.getActivity(UnoActivity.this,0, in,0);
                ncb.setContentIntent(pi);
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);


                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    String channelId = "notify_001";
                    NotificationChannel channel = new NotificationChannel(channelId,
                            "Channel human readable title", NotificationManager.IMPORTANCE_DEFAULT);
                    nm.createNotificationChannel(channel);
                    ncb.setChannelId(channelId);

                }
                nm.notify(NOTIF_ALERTA_ID, ncb.build());
                jtv.setText("Cuenta: i=" + i);
            }
        });
    }
}
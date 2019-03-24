package me.tonatihu.servicios;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;

import java.util.Timer;
import java.util.TimerTask;

public class CronometroService extends Service {
    private Timer timer = new Timer();
    private static final long INTERVALO_ACTUALIZACION = 10;
    @SuppressLint("StaticFieldLeak")
    public static MainActivity UPDATE_LISTENER;
    private double n = 0;
    private Handler handler;

    public static void setUpdateListener(MainActivity sta) {
        UPDATE_LISTENER = sta;
    }

    public CronometroService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @SuppressLint("HandlerLeak")
    @Override
    public void onCreate() {
        super.onCreate();
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                UPDATE_LISTENER.refrescarCronometro(n);
            }
        };
        iniciarCronometro();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        pararCronometro();
    }

    private void iniciarCronometro() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (MainActivity.bandera)
                    n += 0.01;
                handler.sendEmptyMessage(0);
            }
        }, 0, INTERVALO_ACTUALIZACION);
    }

    private void pararCronometro() {
        if (timer != null)
            timer.cancel();
    }
}

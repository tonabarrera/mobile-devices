package me.tonatihu.notificaciones;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * @author tonatihu
 * Created on 5/23/19
 */
class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Entres","Entre");
        UnoActivity.actualizarI();
    }

}
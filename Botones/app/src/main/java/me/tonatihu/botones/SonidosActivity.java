package me.tonatihu.botones;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SonidosActivity extends Activity {
    MediaPlayer mediaPlayer;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonidos);

        button = findViewById(R.id.btn_sonido);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.main_theme);

    }

    @Override
    protected void onDestroy() {
        mediaPlayer.stop();
        super.onDestroy();
    }
}

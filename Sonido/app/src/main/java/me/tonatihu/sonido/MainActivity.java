package me.tonatihu.sonido;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSonidos(View view) {
        startActivity(new Intent(this, Sonidos.class));

    }

    public void onClickVideo(View view) {
        startActivity(new Intent(this, Video.class));
    }
}

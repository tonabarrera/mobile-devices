package me.tonatihu.extras;

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

    public void onClickListas(View view) {
        startActivity(new Intent(this, ListasActivity.class));
    }

    public void onClickFecha(View view) {
        startActivity(new Intent(this, FechaActivity.class));
    }

    public void onClickLampara(View view) {
        startActivity(new Intent(this, LamparaActivity.class));
    }

    public void onClickDibujo(View view) {
        startActivity(new Intent(this, DibujoActivity.class));

    }
}

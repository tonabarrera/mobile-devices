package me.tonatihu.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickEjemplo(View view) {
        Intent intent = new Intent(MainActivity.this, EjemploActivity.class);
        startActivity(intent);
    }

    public void onClickEcuacion(View view) {
        Intent intent = new Intent(MainActivity.this, EcuacionActivity.class);
        startActivity(intent);
    }
}

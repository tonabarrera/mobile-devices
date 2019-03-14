package me.tonatihu.botones;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickEjemploUno(View view) {
        startActivity(new Intent(MainActivity.this, EjemploActivity.class));
    }

    public void clickEjemploDos(View view) {
        startActivity(new Intent(MainActivity.this, EjemploDosActivity.class));
    }

    public void clickEjemploTres(View view) {
        startActivity(new Intent(MainActivity.this, EjemploTresActivity.class));
    }

    public void clickFloating(View view) {
        startActivity(new Intent(MainActivity.this, FloatingActivity.class));
    }

    public void clickSonidos(View view) {
        startActivity(new Intent(MainActivity.this, SonidosActivity.class));
    }
}

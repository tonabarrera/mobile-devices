package me.tonatihu.spinners;

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

    public void onClickDos(View view) {
        startActivity(new Intent(this, EjemploDosActivity.class));
    }

    public void onClickUno(View view) {
        startActivity(new Intent(this, EjemploUnoActivity.class));

    }
}

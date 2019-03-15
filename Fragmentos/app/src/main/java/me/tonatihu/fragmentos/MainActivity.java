package me.tonatihu.fragmentos;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import me.tonatihu.fragmentos.fragment.HorizontalFragment;
import me.tonatihu.fragmentos.fragment.VerticalFragment;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickEjemploUno(View view) {
        startActivity(new Intent(MainActivity.this, EjemploUnoActivity.class));
    }

    public void onClickEjemplo(View view) {
        startActivity(new Intent(MainActivity.this, EjemploActivity.class));
    }
}

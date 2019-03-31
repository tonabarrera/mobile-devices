package me.tonatihu.sharedpreferencences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickEjemplo(View view) {
        startActivity(new Intent(this, EjemploActivity.class));
    }

    public void onClickDos(View view) {
    }

    public void onClickUno(View view) {
        startActivity(new Intent(this, EjercicioUnoActivity.class));
    }
}

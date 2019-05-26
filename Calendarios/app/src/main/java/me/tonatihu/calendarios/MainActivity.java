package me.tonatihu.calendarios;

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
        startActivity(new Intent(this, DosActivity.class));
    }

    public void onClickUno(View view) {
        startActivity(new Intent(this, UnoActivity.class));
    }

    public void onClickTres(View view) {
        startActivity(new Intent(this, TresActivity.class));
    }
}

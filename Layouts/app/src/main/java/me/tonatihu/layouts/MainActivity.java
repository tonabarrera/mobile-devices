package me.tonatihu.layouts;

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

    public void onClicSiete(View view) {
        envio(7);

    }

    public void onClickSeis(View view) {
        envio(6);

    }

    public void onClickCinco(View view) {
        envio(5);

    }

    public void onClickCuatro(View view) {
        envio(4);

    }

    public void onClickTres(View view) {
        envio(3);

    }

    public void onClickDos(View view) {
        envio(2);

    }

    public void onClickUno(View view) {
        envio(1);
    }

    public void envio(int decision) {
        Bundle b = new Bundle();
        b.putInt("DECISION", decision);
        Intent i = new Intent(MainActivity.this, LayoutsActivity.class);
        i.putExtras(b);
        startActivity(i);
    }
}

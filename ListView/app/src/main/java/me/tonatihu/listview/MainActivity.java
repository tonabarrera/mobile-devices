package me.tonatihu.listview;

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

    public void onClickPajaros(View view) {
        Intent i = new Intent(MainActivity.this, EjercicioActivity.class);
        i.putExtra("TIPO", 1);
        startActivity(i);
    }

    public void onClickPerros(View view) {
        Intent i = new Intent(MainActivity.this, EjercicioActivity.class);
        i.putExtra("TIPO", 2);
        startActivity(i);
    }

    public void onClickOtro(View view) {
        startActivity(new Intent(MainActivity.this, RecicladorActivity.class));
    }
}

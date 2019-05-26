package me.tonatihu.barras;

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

    public void onClickBusqueda(View view) {
        startActivity(new Intent(this, BusquedaActivity.class));
    }

    public void onClickEvaluacion(View view) {
        startActivity(new Intent(this, EvaluacionActivity.class));
    }

    public void onClickProgreso(View view) {
        startActivity(new Intent(this, ProgresoActivity.class));
    }
}

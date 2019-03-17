package me.tonatihu.servicios;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView textViewCronometro;
    private Button buttonIniciar;
    private Button buttonTerminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewCronometro = findViewById(R.id.text_cronometro);
        buttonIniciar = findViewById(R.id.btn_iniciar);
        buttonTerminar = findViewById(R.id.btn_terminar);

        buttonIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarCronometro();
            }
        });

        buttonTerminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detenerCronometro();
            }
        });
        CronometroService.setUpdateListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detenerCronometro();
    }

    private void iniciarCronometro() {
        Intent intent = new Intent(this, CronometroService.class);
        startService(intent);
    }

    private void detenerCronometro() {
        Intent intent = new Intent(this, CronometroService.class);
        stopService(intent);
    }

    public void refrescarCronometro(double t) {
        String formato = String.format(Locale.getDefault(), "%.2f", t)  + " segs";
        textViewCronometro.setText(formato);
    }
}

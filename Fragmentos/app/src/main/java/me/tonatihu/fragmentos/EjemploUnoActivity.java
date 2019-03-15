package me.tonatihu.fragmentos;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import me.tonatihu.fragmentos.fragment.FormularioFragment;

public class EjemploUnoActivity extends Activity implements FragmentoListener{
    private TextView textViewHola;
    private Button buttonDigitar;
    public static final String TAG = EjemploUnoActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_uno);
        textViewHola = findViewById(R.id.tv_hola);
        buttonDigitar = findViewById(R.id.btn_digitar);
        buttonDigitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                Fragment f = fm.findFragmentByTag("editor");
                if (f == null) {
                    Log.d(TAG, "El fragmento es nulo");
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.add(R.id.fl_contenedor, new FormularioFragment(), "editor");
                    ft.commit();
                }
                textViewHola.setText("");
                Toast.makeText(EjemploUnoActivity.this, "Utilizando Fragment",
                        Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void digitado(int resultado, String texto) {
        if (resultado == FormularioFragment.OK) {
            textViewHola.setText(texto);
        }
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fe = fragmentManager.findFragmentByTag("editor");
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.remove(fe);
        ft.commit();
    }
}

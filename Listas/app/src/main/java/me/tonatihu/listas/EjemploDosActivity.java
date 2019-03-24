package me.tonatihu.listas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import me.tonatihu.listas.adapter.NuevaEntradaAdapter;
import me.tonatihu.listas.model.NuevaEntrada;

public class EjemploDosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_dos);
        ListView listView = findViewById(R.id.lv_uno);
        NuevaEntradaAdapter entradaAdapter = new NuevaEntradaAdapter(this, R.layout.item_dos);
        listView.setAdapter(entradaAdapter);

        for (NuevaEntrada entrada : getEntradas()) {
            entradaAdapter.add(entrada);
        }
    }

    private List<NuevaEntrada> getEntradas() {
        List<NuevaEntrada> datos = new ArrayList<>();
        for (int i = 1; i < 31; i++) {
            datos.add(new NuevaEntrada("Datos de entrada " + i,
                    "Alejandro ESCOM " + i,
                    new GregorianCalendar(2016, 12, i).getTime(),
                    i%2 == 0 ? R.drawable.ic_android : R.drawable.ic_phone));
        }
        return datos;
    }
}

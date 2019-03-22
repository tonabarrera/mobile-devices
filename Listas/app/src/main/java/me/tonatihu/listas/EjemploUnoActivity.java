package me.tonatihu.listas;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

public class EjemploUnoActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListAdapter adapter = crearAdapter();
        setListAdapter(adapter);
    }

    protected ListAdapter crearAdapter() {
        String[] s = new String[] {
                "Elemento 1", "Elemento 2", "Elemento 3"
        };
        return new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, s);
    }
}

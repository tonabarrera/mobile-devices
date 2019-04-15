package me.tonatihu.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

public class RecicladorActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reciclador);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new OtroAdapter(EjercicioActivity.obtenerPerros(), new OtroAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(ListaEntrada listaEntrada) {
                CharSequence cs = "Seleccionado: " + listaEntrada.getD();
                Toast t = Toast.makeText(RecicladorActivity.this, cs, Toast.LENGTH_LONG);
                t.show();
            }
        }));
    }
}

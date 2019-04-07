package me.tonatihu.sql;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText jetI, jetN;
    Button jbnA, jbnL;
    TextView jtvL;
    DbmsSQLiteHelper dsqlh;
    public static final String TAG = MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jetI = findViewById(R.id.xetI);
        jetN = findViewById(R.id.xetN);
        jbnA = findViewById(R.id.xbnA);
        jbnL = findViewById(R.id.xbnL);
        jtvL = findViewById(R.id.xtvL);
        dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        jbnA.setOnClickListener(v -> {
            String id = jetI.getText().toString();
            String nombre = jetN.getText().toString();
            Contacto c = new Contacto(Integer.valueOf(id), nombre);
            dsqlh.save(c);
            jetI.setText("");
            jetN.setText("");
            Toast.makeText(this, "Agregar", Toast.LENGTH_LONG).show();

        });
        jbnL.setOnClickListener(v -> {
            jtvL.setText("");
            List<Contacto> contactos = dsqlh.getAll();
            for (Contacto contacto : contactos) {
                jtvL.append(" " + contacto.getId() + "\t" + contacto.getNombre() + "\n");
            }
            Toast.makeText(this, "Listar", Toast.LENGTH_LONG).show();

        });
    }

    @Override
    protected void onDestroy() {
        dsqlh.close();
        super.onDestroy();
    }

    public void onClickActualizar(View view) {
        String id = jetI.getText().toString();
        String nombre = jetN.getText().toString();
        Contacto c = new Contacto(Integer.valueOf(id), nombre);
        dsqlh.update(c);
        Toast.makeText(this, "Actualizar", Toast.LENGTH_LONG).show();
    }

    public void onClickBuscar(View view) {
        String id = jetI.getText().toString();
        Contacto c = dsqlh.getContactoById(Integer.valueOf(id));

        jtvL.setText("");
        jetI.setText("");
        jetN.setText("");
        if (c.getNombre() != null) {
            jetI.setText(String.valueOf(c.getId()));
            jetN.setText(c.getNombre());
            jtvL.append(" " + c.getId() + "\t" + c.getNombre() + "\n");
        }
        Toast.makeText(this, "Buscar", Toast.LENGTH_LONG).show();
    }

    public void onClickBorrar(View view) {
        String id = jetI.getText().toString();
        dsqlh.deleteById(Integer.valueOf(id));
        Toast.makeText(this, "Eliminar", Toast.LENGTH_LONG).show();
        jtvL.setText("");
        jetI.setText("");
        jetN.setText("");
    }
}

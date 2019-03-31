package me.tonatihu.sql;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText jetI, jetN;
    Button jbnA, jbnL;
    TextView jtvL;
    SQLiteDatabase sqld;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jetI = findViewById(R.id.xetI);
        jetN = findViewById(R.id.xetN);
        jbnA = findViewById(R.id.xbnA);
        jbnL = findViewById(R.id.xbnL);
        jtvL = findViewById(R.id.xtvL);
        DbmsSQLiteHelper dsqlh = new DbmsSQLiteHelper(this, "DBContactos", null, 1);
        sqld = dsqlh.getWritableDatabase();
        jbnA.setOnClickListener(v -> {
            String id = jetI.getText().toString();
            String nombre = jetN.getText().toString();
            ContentValues cv = new ContentValues();
            cv.put("id", id);
            cv.put("nombre", nombre);
            sqld.insert("Contactos", null, cv);
            jetI.setText("");
            jetN.setText("");
        });
        jbnL.setOnClickListener(v -> {
            String id, nombre;
            @SuppressLint("Recycle")
            Cursor c = sqld.rawQuery("SELECT id,nombre FROM Contactos", null);
            jtvL.setText("");
            if (c.moveToFirst()) {
                do {
                    id = c.getString(0);
                    nombre = c.getString(1);
                    jtvL.append(" " + id + "\t" + nombre + "\n");
                } while (c.moveToNext());
            }
        });
    }
}

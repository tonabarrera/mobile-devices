package me.tonatihu.archivos;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ArchivosDosActivity extends AppCompatActivity {
    TextView jtv;
    File f, d, r;
    FileOutputStream fos;
    PrintWriter pw;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivos);
        jtv = findViewById(R.id.xtv);
        s = Environment.getExternalStorageState();    // Tarjeta SD disponible.
        jtv.append("\nEstado Actual: " + s);
        r = Environment.getExternalStorageDirectory();// Directorio en tarjeta SD.
        d = new File(r.getAbsolutePath() + "/datos"); // Crea carpeta datos en SD.
        d.mkdirs();
        jtv.append("\n\nNueva Carpeta: " + d + "\n\nContenido de la Carpeta " + r + ":");
        String[] lista = r.list();
        for (String aLista : lista) jtv.append("\n" + aLista);
        f = new File(d, "misdatos.txt");                  // Abre datos1.txt en carpeta datos.
        try {
            fos = new FileOutputStream(f);
            pw = new PrintWriter(fos);
            pw.println("Inicio del arhivo");            // Escribe cadena en datos1.txt.
            pw.flush();
            pw.close();
            jtv.append("\n\n Archivo: " + f + "\nGuardado.");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            jtv.append("\n\nEXCEPTION:\n" + fnfe);
        }
    }
}

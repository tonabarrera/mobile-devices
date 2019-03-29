package me.tonatihu.archivos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class ArchivosDosActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 1;
    TextView jtv;
    File f, nuevaCarpeta, r;
    FileOutputStream fos;
    PrintWriter pw;
    String estado;
    private static final String TAG = ArchivosDosActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archivos);
        // Check whether this app has write external storage permission or not.
        int writeExternalStoragePermission = ContextCompat
                .checkSelfPermission(ArchivosDosActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        // If do not grant write external storage permission.
        if(writeExternalStoragePermission!= PackageManager.PERMISSION_GRANTED) {
            // Request user to grant write external storage permission.
            ActivityCompat.requestPermissions(ArchivosDosActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION);
        }
        jtv = findViewById(R.id.xtv);
        estado = Environment.getExternalStorageState();    // Tarjeta SD disponible.
        jtv.append("\nEstado Actual: " + estado);
        r = Environment.getExternalStorageDirectory();// Directorio en tarjeta SD.
        nuevaCarpeta = new File(r, "dato"); // Crea carpeta datos en SD.
        Log.d(TAG, "Permisos de escritura: " + r.canWrite() + ": Permisos de lectura: " + r.canRead());

        if (nuevaCarpeta.mkdirs())
            Log.d(TAG, "Si se creo");
        else
            Log.d(TAG, "No se creo");
        jtv.append("\n\nNueva Carpeta: " + nuevaCarpeta + "\n\nContenido de la Carpeta " + r + ":");
       String[] lista = r.list();
        for (String aLista : lista) jtv.append("\n" + aLista);

        f = new File(nuevaCarpeta, "misdatos.txt");                  // Abre datos1.txt en carpeta datos.
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

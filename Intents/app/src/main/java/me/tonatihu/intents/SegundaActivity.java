package me.tonatihu.intents;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class SegundaActivity extends Activity {
    private EditText editTextNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        editTextNombre = findViewById(R.id.et_nombre_completo);
        Bundle b = getIntent().getExtras();
        String texto = "Hola " + b.getString("NOMBRE") + " " + b.getString("APELLIDO");
        editTextNombre.setText(texto);
    }
}

package me.tonatihu.intents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EjemploActivity extends Activity {
    private Button btnAceptar;
    private EditText editTextNombre;
    private EditText editTextApellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo);

        editTextNombre = findViewById(R.id.et_nombre);
        editTextApellido = findViewById(R.id.et_apellido);
        btnAceptar = findViewById(R.id.btn_aceptar);
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(EjemploActivity.this, SegundaActivity.class);
                Bundle b = new Bundle();
                b.putString("NOMBRE", editTextNombre.getText().toString());
                b.putString("APELLIDO", editTextApellido.getText().toString());
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
}

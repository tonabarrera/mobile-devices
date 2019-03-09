package me.tonatihu.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class ResultadoActivity extends AppCompatActivity {
    private EditText editTextRaiz1;
    private EditText editTextRaiz2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        editTextRaiz1 = findViewById(R.id.et_raiz);
        editTextRaiz2 = findViewById(R.id.et_raiz_dos);

        Bundle bundle = getIntent().getExtras();
        double a = bundle.getDouble("A");
        double b = bundle.getDouble("B");
        double c = bundle.getDouble("C");

        double raiz1 = (-b + Math.sqrt(b*b-4*a*c))/2;
        double raiz2 = (-b - Math.sqrt(b*b-4*a*c))/2;

        editTextRaiz1.setText(String.valueOf(raiz1));
        editTextRaiz2.setText(String.valueOf(raiz2));
    }
}

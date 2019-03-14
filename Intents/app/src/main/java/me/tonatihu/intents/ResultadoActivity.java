package me.tonatihu.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    private EditText editTextRaiz1;
    private EditText editTextRaiz2;
    private TextView textViewTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        editTextRaiz1 = findViewById(R.id.et_raiz);
        editTextRaiz2 = findViewById(R.id.et_raiz_dos);
        textViewTitulo = findViewById(R.id.tv_titulo);

        Bundle bundle = getIntent().getExtras();
        double a = 0;
        double b = 0;
        double c = 0;
        double raiz1;
        double raiz2;
        if (bundle != null) {
            a = bundle.getDouble("A");
            b = bundle.getDouble("B");
            c = bundle.getDouble("C");
        }

        String mensajeTitulo = textViewTitulo.getText().toString();
        String parteC = "";
        String parteB = "";
        if (a == 0) {
            if (c == 0)
                mensajeTitulo = mensajeTitulo + b + "X";
            if (c > 0)
                mensajeTitulo = mensajeTitulo + b + "X" + "+" + c;
            raiz1 = -c / b;
            editTextRaiz1.setText(String.valueOf(raiz1));
        } else {
            if (c > 0)
                parteC = "+" + c;
            else if (c < 0)
                parteC = "" + c;
            if (b > 0)
                parteB = "+" + b + "X";
            else if (b < 0)
                parteB = "" + b + "X";
            mensajeTitulo = mensajeTitulo + a + "X^2" + parteB + parteC;
            double interior = b*b - 4*a*c;
            if (interior < 0) {
                interior *= -1;
                interior = Math.sqrt(interior)/(2*a);
                b = -b/(2*a);
                editTextRaiz1.setText(b + " + " + interior + "i");
                editTextRaiz2.setText(b + " - " + interior + "i");
            } else {
                Log.d("AQUI", "El valor: " + interior);
                raiz1 = (-b + Math.sqrt(interior)) / (2 * a);
                raiz2 = (-b - Math.sqrt(interior)) / (2 * a);
                editTextRaiz1.setText(String.valueOf(raiz1));
                editTextRaiz2.setText(String.valueOf(raiz2));
            }
        }
        textViewTitulo.setText(mensajeTitulo);
    }
}

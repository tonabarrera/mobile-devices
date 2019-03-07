package me.tonatihu.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textViewResultado;
    private Button btnPrimo;
    Button btnFibo;
    Button btnMaravilloso;
    Button btnPalindromo;
    EditText editTextNumero;

    private int fn1 = 0;
    private int fn2 = 1;
    private static final int MAX_ITERACIONES = 70;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumero = findViewById(R.id.et_numero);
        textViewResultado = findViewById(R.id.tv_resultado);
        btnPrimo = findViewById(R.id.btn_primo);
        btnMaravilloso = findViewById(R.id.btn_maravilloso);
        btnFibo = findViewById(R.id.btn_fibonacci);
        btnPalindromo = findViewById(R.id.btn_palindromo);

        btnPrimo.setOnClickListener(this);
        btnFibo.setOnClickListener(this);
        btnPalindromo.setOnClickListener(this);
        btnMaravilloso.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int numero = Integer.valueOf(editTextNumero.getText().toString());
        String resultado = "El número " + numero;
        String mensaje;
        if (v.getId() == btnPalindromo.getId()) {
            if(verificarPalindromo(numero))
                mensaje = " es palindromo";
            else
                mensaje = " no es palindromo";
            resultado = resultado + mensaje;
        } else if (v.getId() == btnFibo.getId()) {
            resultado = verificarFibo(numero);
        } else if (v.getId() == btnMaravilloso.getId()) {
            resultado = verificarMaravilloso(numero);
        } else if (v.getId() == btnPrimo.getId()) {
            if(verificarPrimo(numero))
                mensaje = " es primo";
            else
                mensaje = " no es primo";
            resultado = resultado + mensaje;
        }
        textViewResultado.setText(resultado);
    }

    private boolean verificarPalindromo(int num) {
        String numero = String.valueOf(num);
        int longitud = numero.length();
        int i = 0;
        while ( i < longitud/2) {
            if (numero.charAt(i) != numero.charAt(longitud-i-1))
                return false;
            i++;
        }
        return true;
    }

    private String verificarFibo(int numero) {
        fn1 = 0;
        fn2 = 1;
        String resultado = "No es fibonacci";
        StringBuilder lista = new StringBuilder("0,1");
        while (calcularFibo() <= numero) {
            lista.append(",").append(fn2);
            if (fn2 == numero) {
                resultado = "Es fibonacci";
                break;
            }
        }
        lista.append("\n").append("El numero: ").append(numero).append(" ").append(resultado);
        return lista.toString();
    }

    private int calcularFibo() {
        int aux = fn1;
        fn1 = fn2;
        fn2 = aux + fn2;
        return fn2;
    }

    private String verificarMaravilloso(int numero) {
        int i = 0;
        String resultado = "No es maravilloso";
        StringBuilder lista = new StringBuilder();
        lista.append(numero);
        while (i < MAX_ITERACIONES) {
            if (numero == 1) {
                resultado = "Es maravilloso";
                break;
            }
            numero = (int) maravilloso(numero);
            lista.append(",").append(numero);
            i++;
        }
        lista.append("\n").append("El numero: ").append(numero).append(" ").append(resultado);
        return lista.toString();
    }

    public long  maravilloso(long x) {
        if (x % 2 == 0)
            return x/2;
        return 3*x+1;
    }

    private boolean verificarPrimo(int numero) {
        if (numero <= 1)
            return false;
        if (numero <= 3)
            return true;

        if (numero % 2 == 0 || numero % 3 == 0) return false;

        for (int i = 5; i * i <= numero; i = i + 6)
            if (numero % i == 0 || numero % (i + 2) == 0)
                return false;
        return true;
    }
}

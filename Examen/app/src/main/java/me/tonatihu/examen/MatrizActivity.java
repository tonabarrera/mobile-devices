package me.tonatihu.examen;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MatrizActivity extends AppCompatActivity {
    int AM, AN, BM, BN;
    private static final String TAG = MatrizActivity.class.getName();
    GridLayout gridLayoutMatrizA, gridLayoutMatrizB;
    List<EditText> matrizA, matrizB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matriz);
        AM = getIntent().getIntExtra("AM", 0);
        AN = getIntent().getIntExtra("AN", 0);
        BM = getIntent().getIntExtra("BM", 0);
        BN = getIntent().getIntExtra("BN", 0);
        Log.d(TAG, "A=" + AM + "x" + AN + " B=" + BM + "x" + BN);
        gridLayoutMatrizA = findViewById(R.id.gridlayout_a);
        gridLayoutMatrizB = findViewById(R.id.gridlayout_b);

        gridLayoutMatrizA.setColumnCount(AN);
        gridLayoutMatrizA.setRowCount(AM);
        gridLayoutMatrizB.setColumnCount(BN);
        gridLayoutMatrizB.setRowCount(BM);

        matrizA = new ArrayList<>();
        matrizB = new ArrayList<>();

        for (int i = 0; i < AM*AN; i++) {
            EditText editText = new EditText(this);
            editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            gridLayoutMatrizA.addView(editText);
            matrizA.add(editText);
        }

        for (int i = 0; i < BM*BN; i++) {
            EditText editText = new EditText(this);
            editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            gridLayoutMatrizB.addView(editText);
            matrizB.add(editText);
        }
    }


    public void onClickCalcular(View view) {
        double valoresA[][] = new double[AM][AN];
        double valoresB[][] = new double[BM][BN];
        double resultado[][] = new double[AM][BN];
        for (int i = 0; i < AM; i++)
            for (int j = 0; j < AN; j++)
                valoresA[i][j] = Double.parseDouble(matrizA.get(i*AN+j).getText().toString());

        for (int i = 0; i < BM; i++)
            for (int j = 0; j < BN; j++)
                valoresB[i][j] = Double.parseDouble(matrizB.get(i*BN+j).getText().toString());

        for (int i = 0; i < AM; i++) {
            for (int j = 0; j < BN; j++) {
                resultado[i][j] = 0;
                for (int k = 0; k < AN; k++) {
                    resultado[i][j] += valoresA[i][k]*valoresB[k][j];
                }
            }
        }

        FragmentManager fm = getSupportFragmentManager();
        ResultadoFragment resultadoFragment = new ResultadoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("RESULTADO", resultado);
        bundle.putSerializable("MATRIZ_A", resultado);
        bundle.putSerializable("MATRIZ_B", resultado);
        resultadoFragment.setArguments(bundle);

        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fl_contenedor, resultadoFragment, "editor");
        ft.commit();
    }

    public void onClickRegresar(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}

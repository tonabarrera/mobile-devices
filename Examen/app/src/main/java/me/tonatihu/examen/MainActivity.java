package me.tonatihu.examen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editTextMatrizA, editTextMatrizB;
    EditText editTextMatrizA2, editTextMatrizB2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMatrizA = findViewById(R.id.et_a);
        editTextMatrizB = findViewById(R.id.et_b);
        editTextMatrizA2 = findViewById(R.id.et_a2);
        editTextMatrizB2 = findViewById(R.id.et_b2);
    }

    public void onClickObtener(View view) {
        int tamA = Integer.parseInt(editTextMatrizA.getText().toString());
        int tamB = Integer.parseInt(editTextMatrizB.getText().toString());

        int tamA2 = Integer.parseInt(editTextMatrizA2.getText().toString());
        int tamB2 = Integer.parseInt(editTextMatrizB2.getText().toString());

        if (tamA2 != tamB)
            Toast.makeText(this,
                    "Las matrices no son compatibles, desea otro cálculo?",
                    Toast.LENGTH_LONG).show();
        else {
            Intent intent = new Intent(this, MatrizActivity.class);
            intent.putExtra("AM", tamA);
            intent.putExtra("AN", tamA2);
            intent.putExtra("BM", tamB);
            intent.putExtra("BN", tamB2);
            startActivity(intent);
        }
    }
}

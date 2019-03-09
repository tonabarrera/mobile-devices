package me.tonatihu.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EcuacionActivity extends AppCompatActivity {
    private EditText editTextA;
    private EditText editTextB;
    private EditText editTextC;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecuacion);
        editTextA = findViewById(R.id.et_a);
        editTextB = findViewById(R.id.et_b);
        editTextC = findViewById(R.id.et_c);

    }

    public void onClickCalcular(View view) {
        Bundle bundle = new Bundle();
        bundle.putDouble("A", Double.valueOf(editTextA.getText().toString()));
        bundle.putDouble("B", Double.valueOf(editTextB.getText().toString()));
        bundle.putDouble("C", Double.valueOf(editTextC.getText().toString()));
        Intent i = new Intent(EcuacionActivity.this, ResultadoActivity.class);
        i.putExtras(bundle);
        startActivity(i);
    }
}

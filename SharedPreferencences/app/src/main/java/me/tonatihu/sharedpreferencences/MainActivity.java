package me.tonatihu.sharedpreferencences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText jetn, jetx, jety;
    String s;
    Float x, y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jetn = findViewById(R.id.et_nombre);
        jetx = findViewById(R.id.et_x);
        jety = findViewById(R.id.et_y);
        sp = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        s = sp.getString("titulo", "ESCOM");
        x = sp.getFloat("x", 0);
        y = sp.getFloat("y", 0);
        jetn.setText(s);
        jetx.setText("" + x);
        jety.setText("" + y);
    }

    @Override
    protected void onPause() {
        super.onPause();

        s = jetn.getText().toString();
        x = Float.parseFloat(jetx.getText().toString());
        y = Float.parseFloat(jety.getText().toString());
        SharedPreferences.Editor miEditor = sp.edit();
        miEditor.putString("titulo", s);
        miEditor.putFloat("x", x);
        miEditor.putFloat("y", y);
        miEditor.apply();
        Toast.makeText(this, "Preferencias guardadas", Toast.LENGTH_LONG).show();
    }
}

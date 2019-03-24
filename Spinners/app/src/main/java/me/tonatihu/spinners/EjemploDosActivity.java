package me.tonatihu.spinners;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class EjemploDosActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    Button buttonGuardar;
    EditText editTextNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_dos);
        spinner = findViewById(R.id.spinner_dos);
        buttonGuardar = findViewById(R.id.btn_guardar);
        editTextNuevo = findViewById(R.id.et_nuevo);
        spinner.setOnItemSelectedListener(this);

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = editTextNuevo.getText().toString();
                if (s.trim().length() > 0) {
                    DataBaseHandler db = new DataBaseHandler(getApplicationContext());
                    db.insertLabel(s);
                    editTextNuevo.setText("");
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(editTextNuevo.getWindowToken(), 0);
                    cargaSpinner();
                } else {
                    Toast.makeText(getApplicationContext(), "Escribir elemento",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void cargaSpinner() {
        DataBaseHandler db = new DataBaseHandler(getApplicationContext());
        List<String> l = db.getAllLabels();
        ArrayAdapter<String> aa = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, l);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selección: " + s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

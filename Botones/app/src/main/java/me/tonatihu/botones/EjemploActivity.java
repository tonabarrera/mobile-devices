package me.tonatihu.botones;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class EjemploActivity extends Activity implements View.OnClickListener {
    private Button btnUno, btnDos, btnTres, btnCuatro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo);

        btnUno = findViewById(R.id.btn_uno);
        btnDos = findViewById(R.id.btn_dos);
        btnTres = findViewById(R.id.btn_tres);
        btnCuatro = findViewById(R.id.btn_cuatro);

        btnUno.setOnClickListener(btnListener);
        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToastMessage("Botón digitado: xbn2\nUtiliza: new OnclickListener()");
            }
        });

        btnTres.setOnClickListener(this);
    }

    // Metodo 1
    private View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showToastMessage("Botón digitado: xbn1\nUtiliza: clase btnListener");
        }
    };

    @Override
    public void onClick(View v) {
        showToastMessage("Botón digitado: xbn3\nUtiliza: implements OnClickListener");
    }

    public void clickEnXML(View v) {
        showToastMessage("Botón digitado: xbn4\nInvoca al método desde XML");
    }

    private void showToastMessage(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}

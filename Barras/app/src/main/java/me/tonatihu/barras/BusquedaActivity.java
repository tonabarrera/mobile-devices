package me.tonatihu.barras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.Toast;

public class BusquedaActivity extends AppCompatActivity {
    private SeekBar sb = null;

    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_busqueda);
        sb = findViewById(R.id.xsb2);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int i = 0;

            public void onProgressChanged(SeekBar sb, int n, boolean b) {
                i = n;
            }

            public void onStartTrackingTouch(SeekBar sb) {
            }

            public void onStopTrackingTouch(SeekBar sb) {
                Toast.makeText(BusquedaActivity.this, "Volumen: " + i, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
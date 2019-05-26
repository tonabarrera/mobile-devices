package me.tonatihu.calendarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CalendarView;
import android.widget.Toast;

public class UnoActivity extends AppCompatActivity {
    CalendarView cv;
    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_uno);
        cv = findViewById(R.id.xcv);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView cv, int y, int m, int d) {
                Toast.makeText(getBaseContext(), "Fecha seleccionada:\n\n" + d + " / " + (m+1) + " / " + y, Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
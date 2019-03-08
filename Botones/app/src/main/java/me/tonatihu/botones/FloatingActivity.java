package me.tonatihu.botones;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Toast;

public class FloatingActivity extends Activity {
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating);

        floatingActionButton = findViewById(R.id.floating_button);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FloatingActivity.this, "Soy un botón flotante",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}

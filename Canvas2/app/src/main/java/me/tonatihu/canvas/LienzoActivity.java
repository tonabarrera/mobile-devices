package me.tonatihu.canvas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LienzoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int dato = getIntent().getIntExtra("DATO", 1);
        if (dato == 1)
            setContentView(new Lienzo(this));
        else
            setContentView(new SenoLienzo(this));
    }
}

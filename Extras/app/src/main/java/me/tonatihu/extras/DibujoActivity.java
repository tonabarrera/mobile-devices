package me.tonatihu.extras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DibujoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        MiLienzo ml=new MiLienzo(this);
        setContentView(ml);
    }
}

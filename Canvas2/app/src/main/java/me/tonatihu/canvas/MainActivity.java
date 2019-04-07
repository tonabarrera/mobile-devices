package me.tonatihu.canvas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSeno(View view) {
        Intent i = new Intent(this, LienzoActivity.class);
        i.putExtra("DATO", 2);
        startActivity(i);
    }

    public void onClickLienzo(View view) {
        Intent i = new Intent(this, LienzoActivity.class);
        i.putExtra("DATO", 1);
        startActivity(i);
    }
}

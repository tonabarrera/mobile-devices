package me.tonatihu.layouts;

import android.app.Activity;
import android.os.Bundle;

public class LayoutsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getIntent().getExtras();
        int decision = 1;
        if (b != null)
            decision = b.getInt("DECISION");
        if (decision == 1)
            setContentView(R.layout.activity_relative);
        else if (decision == 2)
            setContentView(R.layout.activity_linear);
        else if (decision == 3)
            setContentView(R.layout.activity_linear_dos);
        else if (decision == 4)
            setContentView(R.layout.activity_frame);
        else if (decision == 5)
            setContentView(R.layout.activity_table);
        else if (decision == 6)
            setContentView(R.layout.activity_grid);
        else if (decision == 7)
            setContentView(R.layout.activity_scroll);
    }
}

package me.tonatihu.botones;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class EjemploDosActivity extends Activity implements View.OnClickListener {
    ImageButton imageButton;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_dos);

        imageButton = findViewById(R.id.image_button);
        imageButton.setOnClickListener(this);

        toggleButton = findViewById(R.id.toggle_button);
        toggleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.image_button)
            showToastMessage("Botón: ImageButton");
        else
            if (toggleButton.isChecked())
                showToastMessage("Botón: ToggleButton en ON");
            else
                showToastMessage("Botón: ToggleButton en OFF");
    }

    private void showToastMessage(String s) {
        Toast t = Toast.makeText(this, s, Toast.LENGTH_SHORT);
        t.show();
    }
}

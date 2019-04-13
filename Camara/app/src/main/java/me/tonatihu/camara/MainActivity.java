package me.tonatihu.camara;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private static final String RUTA = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misfotos/";
    private File file;
    private Button button;
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        file = new File(RUTA);
        file.mkdirs();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = RUTA + getCode() + ".jpg";
                File file1 = new File(s);
                try {
                    file1.createNewFile();
                } catch (IOException e) {
                    Log.e(TAG, "Error: ", e);
                }
                Uri u = Uri.fromFile(file1);
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, u);
                startActivityForResult(intent, 0);
            }
        });
    }

    private String getCode() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyymmddhhmmss");
        return "pic_" + sdf.format(new Date());
    }
}

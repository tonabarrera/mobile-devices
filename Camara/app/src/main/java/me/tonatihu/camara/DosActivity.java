package me.tonatihu.camara;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class DosActivity extends AppCompatActivity {
    Button buttonTomar;
    RadioButton radioButton1, radioButton2, radioButton3;
    private static final int TAKE_PICTURE = 1;
    private static final int SELECT_PICTURE = 2;
    ImageView imageView;
    private static final String TAG = DosActivity.class.getName();
    private File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dos);
        buttonTomar = findViewById(R.id.button2);
        radioButton1 = findViewById(R.id.xrb0);
        radioButton2 = findViewById(R.id.xrb1);
        radioButton3 = findViewById(R.id.xrb2);
        imageView = findViewById(R.id.imageView);
        file = new File(Environment.getExternalStorageDirectory(), "test.jpg");
        buttonTomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int code = TAKE_PICTURE;
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (radioButton2.isChecked()) {
                    Log.d(TAG, "RADIO 2");
                    Uri output = FileProvider.getUriForFile(DosActivity.this, BuildConfig.APPLICATION_ID + ".provider", file);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, output);
                } else if (radioButton3.isChecked()) {
                    Log.d(TAG, "RADIO 3");
                    code = SELECT_PICTURE;
                    intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                } else
                    Log.d(TAG, "RADIO 1");
                startActivityForResult(intent, code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PICTURE) {
            if (data != null) {
                Log.d(TAG, "OPCION 1");
                if (data.hasExtra("data")) {
                    imageView.setImageBitmap((Bitmap) data.getParcelableExtra("data"));
                }
            } else {
                Log.d(TAG, "OPCION 2");
                imageView.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
                new MediaScannerConnection.MediaScannerConnectionClient() {
                    private MediaScannerConnection msc;
                    {
                        msc = new MediaScannerConnection(getApplicationContext(), this);
                        msc.connect();
                    }
                    @Override
                    public void onMediaScannerConnected() {
                        msc.scanFile(file.getAbsolutePath(), null);
                        Log.d(TAG, "onMediaScannerConnected");

                    }

                    @Override
                    public void onScanCompleted(String path, Uri uri) {
                        msc.disconnect();
                        Log.d(TAG, "onScanCompleted");
                    }
                };
            }
        } else if (requestCode == SELECT_PICTURE) {
            Log.d(TAG, "OPCION 3");
            Uri image = data.getData();
            InputStream inputStream;
            try {
                inputStream = getContentResolver().openInputStream(image);
                BufferedInputStream bis = new BufferedInputStream(inputStream);
                Bitmap bitmap = BitmapFactory.decodeStream(bis);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                Log.e(TAG, "Error en SELECT_PICTURE", e);
            }

        }
    }
}

package me.tonatihu.extras;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LamparaActivity extends AppCompatActivity {
    private boolean isLighOn = false;
    private Button button;
    CameraManager camManager;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_lampara);
        button = findViewById(R.id.buttonFlashlight);
        camManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        String id = "";
        try {
            id = camManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        final String cameraId = id;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (isLighOn) {
                    Log.i("info", "torch is turn off!");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        try {
                            camManager.setTorchMode(cameraId, true);
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    isLighOn = false;

                } else {
                    Log.i("info", "torch is turn on!");
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        try {
                            camManager.setTorchMode(cameraId, false);
                        } catch (CameraAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    isLighOn = true;
                }
            }
        });
    }
}
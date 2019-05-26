package me.tonatihu.sonido;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Video extends AppCompatActivity {
    VideoView vvw;
    Uri uri;
    MediaController mcr;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_video);
        vvw = findViewById(R.id.xvv1);
        uri = Uri.parse("android.resource://me.tonatihu.sonido/" + R.raw.video);
        mcr = new MediaController(this);
        vvw.setMediaController(mcr);
        vvw.setVideoURI(uri);
        vvw.start();
    }
}

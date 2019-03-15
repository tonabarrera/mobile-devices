package me.tonatihu.fragmentos;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;

import me.tonatihu.fragmentos.fragment.HorizontalFragment;
import me.tonatihu.fragmentos.fragment.VerticalFragment;

public class EjemploActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo);
        Configuration c = getResources().getConfiguration();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (c.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            HorizontalFragment hf = new HorizontalFragment();
            ft.replace(android.R.id.content, hf);
        } else {
            VerticalFragment vf = new VerticalFragment();
            ft.replace(android.R.id.content, vf);
        }
        ft.commit();
    }
}

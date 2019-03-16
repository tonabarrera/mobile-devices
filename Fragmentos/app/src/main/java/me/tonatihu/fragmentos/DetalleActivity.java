package me.tonatihu.fragmentos;

import android.app.Activity;
import android.os.Bundle;

import me.tonatihu.fragmentos.fragment.DetalleFragment;

public class DetalleActivity extends Activity {
    public static final String EXTRA_TEXTO = "me.tonatihu.fragmentos.EXTRA_TEXTO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        DetalleFragment fragment = (DetalleFragment) getFragmentManager()
                .findFragmentById(R.id.fragment_detalle);
        fragment.mostrarDetalle(getIntent().getStringExtra(EXTRA_TEXTO));
    }
}

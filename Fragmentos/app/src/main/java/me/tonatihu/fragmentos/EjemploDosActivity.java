package me.tonatihu.fragmentos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import me.tonatihu.fragmentos.fragment.DetalleFragment;
import me.tonatihu.fragmentos.fragment.ListadoFragment;
import me.tonatihu.fragmentos.model.Grupo;

public class EjemploDosActivity extends Activity implements GrupoListener{
    ListadoFragment listadoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo_dos);
        listadoFragment = (ListadoFragment) getFragmentManager()
                .findFragmentById(R.id.fragment_listado);
        listadoFragment.setGrupoListener(this);
    }

    @Override
    public void onGrupoSeleccionado(Grupo grupo) {
        boolean bo = getFragmentManager().findFragmentById(R.id.fragment_detalle) != null;
        if (bo) {
            ((DetalleFragment) getFragmentManager().findFragmentById(R.id.fragment_detalle))
                    .mostrarDetalle(grupo.getTexto());
        } else {
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRA_TEXTO, grupo.getTexto());
            startActivity(i);
        }
    }
}

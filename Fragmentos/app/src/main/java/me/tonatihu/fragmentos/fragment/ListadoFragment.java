package me.tonatihu.fragmentos.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import me.tonatihu.fragmentos.GrupoListener;
import me.tonatihu.fragmentos.R;
import me.tonatihu.fragmentos.adapter.GrupoAdapter;
import me.tonatihu.fragmentos.model.Grupo;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListadoFragment extends Fragment {
    private static final String TAG = ListadoFragment.class.getName();
    private List<Grupo> grupos = new ArrayList<>();
    private ListView listView;
    private GrupoListener grupoListener;


    public ListadoFragment() {
        // Required empty public constructor
        grupos.add(new Grupo("Estudiante 1", "Calificacion 1", "Reporte de aprovechamiento 1"));
        grupos.add(new Grupo("Estudiante 2", "Calificacion 2", "Reporte de aprovechamiento 2"));
        grupos.add(new Grupo("Estudiante 3", "Calificacion 3", "Reporte de aprovechamiento 3"));
        grupos.add(new Grupo("Estudiante 4", "Calificacion 4", "Reporte de aprovechamiento 4"));
        grupos.add(new Grupo("Estudiante 5", "Calificacion 5", "Reporte de aprovechamiento 5"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listView = getView().findViewById(R.id.lv_listado);
        Log.d(TAG, "Cantidad: " + grupos.size());
        listView.setAdapter(new GrupoAdapter(this, grupos));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (grupoListener != null)
                    grupoListener.onGrupoSeleccionado((Grupo) listView.getAdapter().getItem(position));
            }
        });
    }

    public void setGrupoListener(GrupoListener listener) {
        this.grupoListener = listener;
    }
}

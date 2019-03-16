package me.tonatihu.fragmentos.adapter;

import android.app.Activity;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import me.tonatihu.fragmentos.R;
import me.tonatihu.fragmentos.fragment.ListadoFragment;
import me.tonatihu.fragmentos.model.Grupo;

/**
 * @author tonatihu
 * Created on 3/16/19
 */
public class GrupoAdapter extends ArrayAdapter<Grupo> {
    private static final String TAG = GrupoAdapter.class.getName();
    Activity activity;
    TextView textVieRemitente;
    TextView textViewAsunto;
    List<Grupo> grupos;

    public GrupoAdapter(Fragment fragment, List<Grupo> grupos) {
        super(fragment.getActivity(), R.layout.item_grupo, grupos);
        this.activity = fragment.getActivity();
        this.grupos = grupos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_grupo, null);
        textVieRemitente = v.findViewById(R.id.tv_remitente);
        textViewAsunto = v.findViewById(R.id.tv_asunto);

        textViewAsunto.setText(grupos.get(position).getAsunto());
        textVieRemitente.setText(grupos.get(position).getRemitente());
        Log.d(TAG, "getView(): " + position);
        return v;
    }
}

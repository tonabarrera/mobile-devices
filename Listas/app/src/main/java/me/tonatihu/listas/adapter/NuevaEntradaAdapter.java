package me.tonatihu.listas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;

import me.tonatihu.listas.R;
import me.tonatihu.listas.model.NuevaEntrada;

/**
 * @author tonatihu
 * Created on 3/21/19
 */
public class NuevaEntradaAdapter extends ArrayAdapter<NuevaEntrada> {
    private final int entradaLayoutRecurso;

    public NuevaEntradaAdapter(Context context, int resource) {
        super(context, resource);
        this.entradaLayoutRecurso = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view2 = getWorkingView(convertView);
        ViewHolder vh = getViewHolder(view2);
        NuevaEntrada nuevaEntrada = getItem(position);
        vh.textViewTitulo.setText(nuevaEntrada.getTitulo());
        String s = String.format("Por %s on %s", nuevaEntrada.getAutor(), DateFormat.getDateInstance(DateFormat.SHORT).format(nuevaEntrada.getFecha()));
        vh.textViewSubTitulo.setText(s);
        vh.imageView.setImageResource(nuevaEntrada.getIcono());
        return view2;
    }

    private View getWorkingView(View v3) {
        View workingView;
        if (v3 == null) {
            Context c2 = getContext();
            LayoutInflater inflater = (LayoutInflater) c2.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            workingView = inflater.inflate(entradaLayoutRecurso, null);
        } else {
            workingView = v3;
        }
        return workingView;
    }

    private ViewHolder getViewHolder(View workingView) {
        Object tag = workingView.getTag();
        ViewHolder vh = null;
        if (!(tag instanceof ViewHolder)) {
            vh = new ViewHolder();
            vh.textViewTitulo = workingView.findViewById(R.id.tv_titulo);
            vh.textViewSubTitulo = workingView.findViewById(R.id.tv_subtitulo);
            vh.imageView = workingView.findViewById(R.id.iv_icono);
            workingView.setTag(vh);
        } else {
            vh = (ViewHolder) tag;
        }
        return vh;
    }

    private class ViewHolder {
        TextView textViewTitulo;
        TextView textViewSubTitulo;
        ImageView imageView;
    }
}

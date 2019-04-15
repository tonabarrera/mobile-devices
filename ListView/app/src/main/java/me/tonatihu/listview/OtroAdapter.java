package me.tonatihu.listview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * @author tonatihu
 * Created on 4/14/19
 */
public class OtroAdapter extends RecyclerView.Adapter<OtroAdapter.ViewHolder> {
    private List<ListaEntrada> listaEntradas;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(ListaEntrada listaEntrada);
    }
    public OtroAdapter(List<ListaEntrada> listaEntradas, OnItemClickListener listener) {

        this.listaEntradas = listaEntradas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new ViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ListaEntrada item = listaEntradas.get(i);
        viewHolder.imageView.setImageResource(item.getIdim());
        viewHolder.textViewInferior.setText(item.getD());
        viewHolder.textViewSuperior.setText(item.getA());
        viewHolder.setClickListener(item, listener);
    }

    @Override
    public int getItemCount() {
        return listaEntradas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewSuperior;
        TextView textViewInferior;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.image_view);
            this.textViewSuperior = itemView.findViewById(R.id.tv_superior);
            this.textViewInferior = itemView.findViewById(R.id.tv_inferior);

        }

        public void setClickListener(final ListaEntrada item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}

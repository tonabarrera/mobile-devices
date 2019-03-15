package me.tonatihu.fragmentos.fragment;


import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import me.tonatihu.fragmentos.FragmentoListener;
import me.tonatihu.fragmentos.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FormularioFragment extends Fragment {
    public static final int OK = 0;
    public static final int CANCEL = 1;
    private FragmentoListener fragmentoListener;


    public FormularioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_formulario, container, false);
        view.findViewById(R.id.btn_aceptar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonDigitado(v);
                Toast.makeText(getActivity(), "Desde Mi Fragmento", Toast.LENGTH_LONG).show();
            }
        });

        view.findViewById(R.id.btn_cancelar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonDigitado(v);
            }
        });
        return view;
    }

    public void botonDigitado(View view) {
        if (fragmentoListener == null)
            return;
        if (((Button) view).getText().equals("Aceptar"))
            fragmentoListener.digitado(OK,
                    ((EditText) getActivity().findViewById(R.id.et_dato)).getText().toString());
        else
            fragmentoListener.digitado(CANCEL, "");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentoListener)
            fragmentoListener = (FragmentoListener) context;
    }
}

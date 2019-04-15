package me.tonatihu.examen;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoFragment extends Fragment {
    double resultados[][];
    double matrizA[][];
    double matrizB[][];
    private static final String TAG = ResultadoFragment.class.getName();
    GridLayout gridLayout, gridLayoutA, gridLayoutB;


    public ResultadoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado, container, false);
        gridLayout = view.findViewById(R.id.gridlayout_resultados);
        gridLayout.setRowCount(resultados.length);
        gridLayout.setColumnCount(resultados[0].length);

        /*
        gridLayoutA = view.findViewById(R.id.gridlayout_matriz_a);
        gridLayoutA.setRowCount(matrizA.length);
        gridLayoutA.setColumnCount(matrizA[0].length);

        gridLayoutB = view.findViewById(R.id.gridlayout_matriz_b);
        gridLayoutB.setRowCount(matrizB.length);
        gridLayoutB.setColumnCount(matrizB[0].length);
        */
        Log.d(TAG, resultados.length + " x" + resultados[0].length);

        for (int i = 0; i < resultados.length; i++) {
            for (int j = 0; j < resultados[0].length; j++) {
                EditText editText = new EditText(getActivity());
                editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                editText.setText(String.valueOf(resultados[i][j]));
                editText.setEnabled(false);
                gridLayout.addView(editText);
            }
        }
        /*
        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[0].length; j++) {
                EditText editText = new EditText(getActivity());
                editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                editText.setText(String.valueOf(matrizA[i][j]));
                editText.setEnabled(false);
                gridLayoutA.addView(editText);
            }
        }

        for (int i = 0; i < matrizB.length; i++) {
            for (int j = 0; j < matrizB[0].length; j++) {
                EditText editText = new EditText(getActivity());
                editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
                editText.setText(String.valueOf(matrizB[i][j]));
                editText.setEnabled(false);
                gridLayoutB.addView(editText);
            }
        }
        */
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            resultados = (double[][]) getArguments().getSerializable("RESULTADO");
            matrizA = (double[][]) getArguments().getSerializable("MATRIZ_A");
            matrizB = (double[][]) getArguments().getSerializable("MATRIZ_B");
        }
    }
}

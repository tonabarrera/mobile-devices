package me.tonatihu.fragmentos.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.tonatihu.fragmentos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerticalFragment extends Fragment {


    public VerticalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_vertical, container, false);
    }

}

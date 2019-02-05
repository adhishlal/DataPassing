package com.example.fragmenttofragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentOne extends Fragment {

    EditText etData;
    Button btnSend;

    Context context;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_one, container, false);


        context = view.getContext();
        etData = view.findViewById(R.id.etData);
        btnSend = view.findViewById(R.id.btnSend);



        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataPassInterface dataPassInterface = (MainActivity)getActivity();
                dataPassInterface.passData(etData.getText().toString());
            }
        });


        return view;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public void onDetach() {
        super.onDetach();

    }
}

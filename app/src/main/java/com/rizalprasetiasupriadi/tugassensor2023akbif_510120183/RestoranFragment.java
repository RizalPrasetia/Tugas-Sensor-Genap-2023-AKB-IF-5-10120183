package com.rizalprasetiasupriadi.tugassensor2023akbif_510120183;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//NIM     :   10120183
//NAMA    :   RIZAL PRASETIA SUPRIADI
//KELAS   :   IF-5


public class RestoranFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_restoran, container, false);

        Button cariRestoran = (Button) rootView.findViewById(R.id.cariRestoran);

        cariRestoran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RestoranActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
package com.example.vincenzorusso.tris;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import java.util.ArrayList;

public class TrisFragment extends Fragment implements View.OnClickListener {
    String simbolo;
    Communicator communicator;
    View v;

    public TrisFragment(String s){
        simbolo=s;
    }






    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }



    public interface Communicator {
        public void respond(Button index);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (simbolo.equals("X")) {
            v = inflater.inflate(R.layout.tris, container, false);
            ArrayList<View> allButtons;
            allButtons = (v.findViewById(R.id.table)).getTouchables();
            int i = 0;
            for (View element : allButtons) {
                Button b = (Button) element;
                b.setOnClickListener(this);
                b.setTag("X");

            }
            return v;
        } else {
            v = inflater.inflate(R.layout.tris, container, false);
            ArrayList<View> allButtons;
            allButtons = (v.findViewById(R.id.table)).getTouchables();
            int i=0;
            for (View element: allButtons) {
                Button b = (Button) element;
                b.setOnClickListener(this);
                b.setTag("O");

            }
            return v;
        }
    }



    @Override
    public void onClick(View v) {
        Button b = (Button) v;

        Object tag = b.getTag();
        if (tag == null || tag.toString().equals("X")) {

            b.setText("X");
        }
        else {
            b.setText("O");

        }


        communicator.respond(b);



    }


    public void mostraCitazione(Button newButton) {
        Button b=(Button) v.findViewById(newButton.getId());
        b.setText(newButton.getText().toString());
    }


}
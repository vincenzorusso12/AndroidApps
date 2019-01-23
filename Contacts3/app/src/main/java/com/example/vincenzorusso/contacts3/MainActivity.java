package com.example.vincenzorusso.contacts3;


import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public ListView listView;
    CustomAdapter customAdapter;
    EditText editNome;
    EditText editCognome;
    EditText editTel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNome=(EditText)findViewById(R.id.editNome);
         editCognome=(EditText)findViewById(R.id.editCognome);
         editTel=(EditText)findViewById(R.id.editTel);



        String [] nomi = {"Pasquale","Maria","Michele","Antonella", "Vincenzo",
                "Teresa", "Roberto", "Rossella", "Antonio", "Luca", "Liliana", "Stefania",
                "Francesca", "Andrea", "Marco", "Elisa", "Anna", "Lorenzo"};


        listView = (ListView)findViewById(R.id.mylistview);

        customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<Contatto>());

        listView.setAdapter(customAdapter);





/*		listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String  str  = listView.getItemAtPosition(position).toString();
              // Show Toast
              Toast.makeText(getApplicationContext(),
                "Click su posizione n."+position+": " +str, Toast.LENGTH_LONG)
                .show();
            }
       });
*/
    }

    public void onPictureClick(View v) {
        Log.d("DEBUG","Picture has been clicked: position="+v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(),
                "Click su Foto - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG)
                .show();
    }

    public void onNameClick(View v) {
        Log.d("DEBUG","Name has been clicked position="+v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(),
                "Click su Nome - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG)
                .show();
    }

    public void onTelClick(View v) {
        Log.d("DEBUG","Tel has been clicked position="+v.getTag());
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(getApplicationContext(),
                "Click su Tel - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG)
                .show();	}

    public void addContatto(View v){


        String nome=editNome.getText().toString();
        String cognome=editCognome.getText().toString();
        String tel=editTel.getText().toString();

        if (nome!=null && cognome!=null && tel!=null) {

            Contatto c = new Contatto(nome, cognome, tel, getResources().getDrawable(R.drawable.faceplaceholder));
            customAdapter.add(c);
        }

        Context context = getApplicationContext();
        CharSequence text = nome+cognome+tel;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }
}

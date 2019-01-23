package com.example.vincenzorusso.numeri;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et1, et2, et3, et4, et5, et6, et7, et8, et9;
    ArrayList<EditText> myEditTextList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        et4 = (EditText) findViewById(R.id.et4);
        et5 = (EditText) findViewById(R.id.et5);
        et6 = (EditText) findViewById(R.id.et6);
        et7 = (EditText) findViewById(R.id.et7);
        et8 = (EditText) findViewById(R.id.et8);
        et9 = (EditText) findViewById(R.id.et9);
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.table);

        myEditTextList = new ArrayList<EditText>();

        myEditTextList.add(et1);
        myEditTextList.add(et2);
        myEditTextList.add(et3);
        myEditTextList.add(et4);
        myEditTextList.add(et5);
        myEditTextList.add(et6);
        myEditTextList.add(et7);
        myEditTextList.add(et8);
        myEditTextList.add(et9);


    }

    @Override
    protected void onStart() {
        super.onStart();

        for (final EditText e : myEditTextList
                ) {

            e.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                @Override
                public void onFocusChange(View view, boolean hasFocus) {
                    if (hasFocus) {

                        EditText ex = (EditText) view;

                        if (!(ex.getText().toString().equals(""))) {

                            int i = Integer.parseInt(e.getText().toString());

                            for (EditText e2 : myEditTextList
                                    ) {
                                if (!(e2.getText().toString().equals(""))) {
                                    int k = Integer.parseInt(e2.getText().toString());
                                    int q = (k + i) % 10;
                                    e2.setText(q + "");
                                }
                            }

                        }


                        Toast.makeText(getApplicationContext(), "Got the focus", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Lost the focus", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }

    public void azzera(View v) {
        for (EditText e : myEditTextList
                ) {
            e.setText("");

        }

    }
}

package com.example.vincenzorusso.ordina;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int prim,sec,cont,frut,tot;
    TextView tvTot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTot=(TextView)findViewById(R.id.tvTot);
    }



    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();


        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.primo3:
                if (checked)
                    prim=3;
                    break;
            case R.id.primo5:
                if (checked)
                    prim=5;
                    break;
            case R.id.primo7:
                if (checked)
                    prim=7;
                break;

            case R.id.secondo3:
                if (checked)
                    sec=3;
                break;
            case R.id.secondo5:
                if (checked)
                    sec=5;
                break;
            case R.id.secondo7:
                if (checked)
                    sec=7;
                break;


            case R.id.cont3:
                if (checked)
                    cont=3;
                break;
            case R.id.cont5:
                if (checked)
                    cont=5;
                break;
            case R.id.cont7:
                if (checked)
                    cont=7;
                break;

            case R.id.frut3:
                if (checked)
                    frut=3;
                break;
            case R.id.frut5:
                if (checked)
                    frut=5;
                break;
            case R.id.frut7:
                if (checked)
                    frut=7;
                break;
        }

        tot=prim+sec+cont+frut;
        tvTot.setText(tot+"€");


    }

    public void onClickCassa(View v){

        Intent i=new Intent(this,ActivityCassa.class);
        i.putExtra("prim",prim);
        i.putExtra("sec",sec);
        i.putExtra("cont",cont);
        i.putExtra("frut",frut);
        i.putExtra("tot",tot);

        Log.d("VALS",prim+" "+sec+" "+cont+" "+frut+" "+tot);

        startActivity(i);

    }

}

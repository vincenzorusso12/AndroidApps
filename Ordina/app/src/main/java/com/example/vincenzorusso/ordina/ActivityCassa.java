package com.example.vincenzorusso.ordina;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class ActivityCassa extends AppCompatActivity {

    private int prim,sec,cont,frut,tot;
    TextView tvTotPasto;
    TextView tvPrim;
    TextView tvSec;
    TextView tvCont;
    TextView tvFrut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cassa);

        tvTotPasto=(TextView)findViewById(R.id.totPasto2);
        tvPrim=(TextView)findViewById(R.id.tvPrimo2);
        tvSec=(TextView)findViewById(R.id.tvSecondo2);
        tvCont=(TextView)findViewById(R.id.tvContorno2);
        tvFrut=(TextView)findViewById(R.id.tvFrut2);




    }

    @Override
    protected void onStart() {
        Intent i=getIntent();

        super.onStart();
        prim=i.getIntExtra("prim",0);
        sec=i.getIntExtra("sec",0);
        cont=i.getIntExtra("cont",0);
        frut=i.getIntExtra("frut",0);
        tot=i.getIntExtra("tot",0);

        Log.d("SECOND",prim+" "+sec+" "+cont+" "+frut+" "+tot);

        if(tvTotPasto!=null)
            tvTotPasto.setText(tot+"€");

        if(tvPrim!=null)
            tvPrim.setText(prim+"€");

        if(tvSec!=null)
            tvSec.setText(sec+"€");

        if(tvCont!=null)
            tvCont.setText(cont+"€");

        if(tvFrut!=null)
            tvFrut.setText(frut+"€");



    }
}

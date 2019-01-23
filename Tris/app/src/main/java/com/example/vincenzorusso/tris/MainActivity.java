package com.example.vincenzorusso.tris;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements TrisFragment.Communicator {

    TrisFragment fragmentX;
    TrisFragment fragmentO;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FrameLayout frameLayout1 = findViewById(R.id.f1);
        FrameLayout frameLayout2= findViewById(R.id.f2);
        fm = getFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
// add rowLayout to the root layout somewhere here

        fragmentX = new TrisFragment("X");
        fragmentO = new TrisFragment("O");

        fragmentX.setCommunicator(this);
        fragmentO.setCommunicator(this);


        ft.add(frameLayout1.getId(), fragmentX, "y");
        ft.add(frameLayout2.getId(), fragmentO, "z");



        ft.commit();

    }




    @Override
    public void respond(Button index) {
        fragmentO = (TrisFragment) fm.findFragmentByTag("z");
        if (fragmentO!=null) {
            fragmentO.mostraCitazione(index);

        }

        fragmentX = (TrisFragment) fm.findFragmentByTag("y");
        if (fragmentX!=null) {
            fragmentX.mostraCitazione(index);

        }




    }
}

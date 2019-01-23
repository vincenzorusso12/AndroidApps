package com.example.vincenzorusso.russovincenzo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    ProgressBar progressBar;
    CustomAdapter customAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=(ImageView)findViewById(R.id.immagine);
        progressBar=(ProgressBar)findViewById(R.id.progressBar5);

        String[] array = {"img1", "img2", "img3" , "img4" , "img5" , "img6" , "img7"};

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(getApplicationContext(), R.layout.list_layout,
                        R.id.textViewList, array);

        customAdapter = new CustomAdapter(this, R.layout.custom_element, new ArrayList<ImageHolder>());


        listView = (ListView) findViewById(R.id.listViewImg);

        listView.setAdapter(customAdapter);

        Drawable d=null;
        int resID=0;
        Context context = getApplicationContext();
        String path=null;

        for (int i=1; i<array.length; i++) {
        path="img"+i;

            resID = getResources().getIdentifier("img"+i , "drawable", getPackageName());

            Log.d("draw",path);
            d = ContextCompat.getDrawable(context, resID);


            ImageHolder c = new ImageHolder(array[i], d);
            customAdapter.add(c);
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageHolder ih = (ImageHolder) listView.getItemAtPosition(position);
                String str = ih.getName();

                Log.d("Val", "str " + str);
                Context context = getApplicationContext();


                int resID = getResources().getIdentifier(str, "drawable", getPackageName());

                Drawable d = ContextCompat.getDrawable(context, resID);

                if (progressBar != null)
                    new LoadIconTask().execute(resID);
            }
        });


    }



    class LoadIconTask extends AsyncTask<Integer, Integer, Bitmap> {
        private Integer index = 1;

        @Override
        protected void onPreExecute() {

            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... img_ids) {
            // Load bitmap
            Log.d("DEBUG","index="+index);
            Bitmap tmp = BitmapFactory.decodeResource(getResources(), img_ids[0]);

            /* Simuliamo il ritardo */
            for (int i = 1; i < 11; i++) {
                sleep();
                publishProgress(i * 10);
            }

            return tmp;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            progressBar.setProgress(0);
            imageView.setImageBitmap(result);
        }

        private void sleep() {
            /* Ritardo di 0,5 secondi */
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}


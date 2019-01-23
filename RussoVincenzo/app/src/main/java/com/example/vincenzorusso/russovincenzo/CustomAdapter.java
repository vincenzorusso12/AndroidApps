package com.example.vincenzorusso.russovincenzo;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<ImageHolder> {
    private int resource;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, int resourceId, List<ImageHolder> objects) {
        super(context, resourceId, objects);
        resource = resourceId;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        if (v == null) {
            Log.d("DEBUG", "Inflating view");
            v = inflater.inflate(R.layout.custom_element, null);
        }

        ImageHolder c = getItem(position);

        Log.d("DEBUG", "contact c=" + c);

        TextView nome;
        ImageView immagine;

        nome = (TextView) v.findViewById(R.id.custNome);
        immagine = (ImageView) v.findViewById(R.id.custImage);


        nome.setText(c.getName());
        immagine.setImageDrawable(c.getPicture());

        nome.setTag(position);
        immagine.setTag(position);

        return v;

    }

}



package com.example.rocky_pc.projectglobsyn;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rocky - PC on 7/27/2016.
 */
public class Custom_product_adapter extends ArrayAdapter<MovieItem> {
    Activity context;
    ArrayList<MovieItem> movies;
    View.OnClickListener click;
    public Custom_product_adapter(Activity context, ArrayList<MovieItem> objects,View.OnClickListener click) {
        super(context, R.layout.item_movies, objects);
        this.context=context;
        this.movies=objects;
        this.click=click;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View v = inflater.inflate(R.layout.item_movies,null,true);

        ImageView img = (ImageView) v.findViewById(R.id.imageButton);
        Button btn = (Button)v.findViewById(R.id.btn_booking);

        btn.setOnClickListener(click);
        btn.setTag(position);

        MovieItem p = movies.get(position);
        img.setImageResource(p.img);

        return v;
    }
}

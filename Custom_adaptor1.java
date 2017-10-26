package com.example.rocky_pc.projectglobsyn;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ARNAB CHOUDHURY on 27-07-2016.
 */
public class Custom_adaptor1 extends ArrayAdapter {
    Activity context;
    ArrayList<PRODUCT> products;


    public Custom_adaptor1(Activity context, ArrayList<PRODUCT> objects) {
        super(context, R.layout.item_products, objects);
        this.context = context;
        this.products = objects;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.item_products,null,true);
        TextView seat=(TextView)v.findViewById(R.id.hall);

        PRODUCT p=products.get(position);
        seat.setText(p.seat);
        return v;
    }
}

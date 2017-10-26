package com.example.rocky_pc.projectglobsyn;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ARNAB CHOUDHURY on 26-07-2016.
 */
public class Customer_Adapter extends ArrayAdapter {
    Activity context;
    ArrayList<PRODUCT> products;

    public Customer_Adapter(Activity context, ArrayList<PRODUCT> objects) {
        super(context, R.layout.item_products, objects);
        this.context = context;
        this.products = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.item_products,null,true);
        TextView hall=(TextView)v.findViewById(R.id.hall);
        TextView time1=(TextView)v.findViewById(R.id.time1);
        TextView time2=(TextView)v.findViewById(R.id.time2);
        TextView time3=(TextView)v.findViewById(R.id.time3);

        PRODUCT p=products.get(position);
        hall.setText(p.hall);

        time1.setText(p.time1);
        time2.setText(p.time2);
        time3.setText(p.time3);


        return v;
    }
}

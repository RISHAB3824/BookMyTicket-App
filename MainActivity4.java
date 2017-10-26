package com.example.rocky_pc.projectglobsyn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {
    RadioButton radio1,radio2,radio3;
    TextView txt_2;
    ArrayList<PRODUCT> products=new ArrayList<PRODUCT>();
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        radio1=(RadioButton)findViewById(R.id.radio_1);
        radio2=(RadioButton)findViewById(R.id.radio_2);
        radio3=(RadioButton)findViewById(R.id.radio_3);
        txt_2=(TextView)findViewById(R.id.txt_2);
        lv=(ListView)findViewById(R.id.lv);
        radio1.setOnClickListener(click);
        radio2.setOnClickListener(click);
        radio3.setOnClickListener(click);
       // Intent i=getIntent();
       // txt_2.setText(i.getStringExtra("ABC"));
        PRODUCT p1=new PRODUCT();
        p1.seat="PLATINUM";

        PRODUCT p2=new PRODUCT();
        p2.seat="GOLD";

        PRODUCT p3=new PRODUCT();
        p3.seat="SILVER";


        products.add(p1);
        products.add(p2);
        products.add(p3);


    }

    View.OnClickListener click=new View.OnClickListener(){
       @Override
       public void onClick(View v) {
            if (v.getId()==R.id.radio_1) {
         //       Custom_adaptor1 adpt = new Custom_adaptor1(MainActivity4.this, products);
          //      lv.setAdapter(adpt);
          //  }
          //  else if (v.getId()==R.id.radio_2) {
            //    Custom_adaptor1 adpt = new Custom_adaptor1(MainActivity4.this, products);
             //   lv.setAdapter(adpt);

           // }
          //  else if (v.getId()==R.id.radio_3) {
                Custom_adaptor1 adpt = new Custom_adaptor1(MainActivity4.this, products);
                lv.setAdapter(adpt);

            }

        }
    };
}

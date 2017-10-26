package com.example.rocky_pc.projectglobsyn;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    TextView txt_1,txt_2,txt_4,txt_pay;
    String s,s1,s2;
    ProgressDialog dialog;
    Button btn;
  ArrayList<String> seat_no =new ArrayList<>();
    ArrayAdapter<String> adapter;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main3);
            txt_1 = (TextView) findViewById(R.id.txt_1);
            txt_2 = (TextView) findViewById(R.id.txt_2);
            txt_pay=(TextView)findViewById(R.id.txt_pay);
            spn=(Spinner)findViewById(R.id.spn);

            txt_4=(TextView)findViewById(R.id.txt_4);
            Intent i2 = getIntent();
            s=i2.getStringExtra("ABC");
            btn=(Button)findViewById(R.id.btn);
            btn.setOnClickListener(click);

            spn = (Spinner) findViewById(R.id.spn);
            txt_1.setText(s);
            s1=i2.getStringExtra("CDE");
            s2=i2.getStringExtra("FGH");

            txt_2.setText(s1);
        txt_4.setText(s2);
            seat_no.add("1");
            seat_no.add("2");
            seat_no.add("3");
            seat_no.add("4");
            seat_no.add("5");
            seat_no.add("6");
            seat_no.add("7");

            adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_seat, seat_no);
           spn = (Spinner) findViewById(R.id.spn);
            spn.setAdapter(adapter);
            spn.setOnItemSelectedListener(click1);



    }


    View.OnClickListener click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            new abcd().execute();
        }
    };
    Spinner.OnItemSelectedListener click1=new Spinner.OnItemSelectedListener(){
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String text = spn.getSelectedItem().toString();
            Integer i;
            String s4;
            i=Integer.parseInt(text);
           // Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
            Integer p;
            if(s1.equals("PLATINUM")){
                p=i*500;
                s4=p.toString();
                txt_pay.setText(s4);

            }
            if (s1.equals("GOLD")){
                p=i*250;
                s4=p.toString();
                txt_pay.setText(s4);
            }
            if (s1.equals("SILVER")){
                p=i*100;
                s4=p.toString();
                txt_pay.setText(s4);
            }




        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
    class abcd extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(MainActivity3.this);
            dialog.setMessage("WAIT");
            dialog.setTitle("BOOKING");
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try{
                Thread.sleep(4000);

            }
            catch (Exception e){


            }
            return null;
        }
    }

}

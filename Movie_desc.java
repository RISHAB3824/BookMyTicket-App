package com.example.rocky_pc.projectglobsyn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Movie_desc extends AppCompatActivity {
    TextView txt_actor1,txt_actor2,txt_actress1,txt_actress2,txt_director1,txt_director2,txt_editor1,txt_editor2,txt_runtime1,txt_runtime2;
    Button btn_book;
    String movie_id;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_desc);
        txt_actor1=(TextView)findViewById(R.id.txt_actor1);
        txt_actor2=(TextView)findViewById(R.id.txt_actor2);
        txt_actress1=(TextView)findViewById(R.id.txt_actres1);
        txt_actress2=(TextView)findViewById(R.id.txt_actres2);
        txt_director1=(TextView)findViewById(R.id.txt_director1);
        txt_director2=(TextView)findViewById(R.id.txt_director2);
        txt_editor2=(TextView)findViewById(R.id.txt_editor2);
        txt_editor1=(TextView)findViewById(R.id.txt_editor1);
        txt_runtime1=(TextView)findViewById(R.id.txt_time1);
        txt_runtime2=(TextView)findViewById(R.id.txt_time2);
        btn_book=(Button)findViewById(R.id.btn_book);
        btn_book.setOnClickListener(click);
        img=(ImageView)findViewById(R.id.img_moviedesc);
        Intent i = getIntent();
        movie_id = i.getStringExtra("position");
        if(movie_id.equals("1")){
            txt_actor2.setText("Hrithik Roshan");
            txt_actress2.setText("Pooja Hegde");
            txt_director2.setText("Ashutosh Gowariker");
            txt_editor2.setText("Ashutosh Gowariker (story and screenplay), Preeti Mamgain (dialogue)");
            img.setBackgroundResource(R.drawable.mohen);
        }else if(movie_id.equals("2")){

            txt_actor2.setText("Akshay Kumar");
            txt_actress2.setText("Ileana");
            txt_director2.setText("Dharmendra Suresh Desai");
            txt_editor2.setText("Vipul K. Rawal");
            img.setBackgroundResource(R.drawable.rustom);
        }
        else if(movie_id.equals("3")){

            txt_actor2.setText("Rajinikanth");
            txt_actress2.setText("Radhika Apte");
            txt_director2.setText("Pa. Ranjith");
            txt_editor2.setText("Pa. Ranjith");
            img.setBackgroundResource(R.drawable.kabali);
        }
        else if(movie_id.equals("4")){

            txt_actor2.setText("Salman Khan");
            txt_actress2.setText("Anushka Sharma");
            txt_director2.setText("Ali Abbas Zafar");
            txt_editor2.setText("Ali Abbas Zafar");
            img.setBackgroundResource(R.drawable.sultan);
        }
        else if(movie_id.equals("5")){

            txt_actor2.setText("Shah Rukh Khan");
            txt_actress2.setText("Sunny Leone");
            txt_director2.setText("Rahul Dholakia");
            txt_editor2.setText("Rahul Dholakia");
            img.setBackgroundResource(R.drawable.raees);
        }
        else if(movie_id.equals("6")){

            txt_actor2.setText("Aamir Khan");
            txt_actress2.setText("Sakshi Tanwar");
            txt_director2.setText("Nitesh Tiwari");
            txt_editor2.setText("Piyush Gupta, Shreyas Jain");
            img.setBackgroundResource(R.drawable.dangal);
        }
        else{

            txt_actor2.setText("Prabhas");
            txt_actress2.setText("Rana Daggubati");
            txt_director2.setText("S.S. Rajamouli");
            txt_editor2.setText("Vijayendra Prasad");
            img.setBackgroundResource(R.drawable.bahubali);
        }



    }

    View.OnClickListener click=new  View.OnClickListener(){
        @Override
        public void onClick(View v) {
            if(v.getId()==R.id.btn_book)
            {
                Intent intent=new Intent(getApplicationContext(),MainActivity1.class);
                intent.putExtra("movie_id",movie_id);
                startActivity(intent);
            }
        }
    };
}

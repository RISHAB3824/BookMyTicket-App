package com.example.rishi_pc.projectglobsyn;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;

public class MenuHome extends AppCompatActivity {

    Intent intent;
    ImageButton imgbtn_movies,imgbtn_you,imgbtn_wallet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_home);
        //setTitle("Menu");
        setTitle(Html.fromHtml("<font color='#ffff00'>Home </font>"));
        imgbtn_movies = (ImageButton)findViewById(R.id.imgbtn_movies);
        imgbtn_you = (ImageButton)findViewById(R.id.imgbtn_you);
        imgbtn_wallet = (ImageButton)findViewById(R.id.imgbtn_wallet);

        imgbtn_movies.setOnClickListener(click);
        imgbtn_you.setOnClickListener(click);
        imgbtn_wallet.setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.imgbtn_movies)
            {
                intent = new Intent(getApplicationContext(),MovieMenu.class);
                startActivity(intent);

            }
            else if(v.getId() == R.id.imgbtn_you)
            {
                intent = new Intent(getApplicationContext(),DetailsYou.class);
                startActivity(intent);
            }
            else if(v.getId() == R.id.imgbtn_wallet)
            {
                intent = new Intent(getApplicationContext(),Wallet.class);
                startActivity(intent);

            }
        }
    };
}

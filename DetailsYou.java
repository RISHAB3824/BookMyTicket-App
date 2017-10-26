package com.example.rocky_pc.projectglobsyn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailsYou extends AppCompatActivity {
    Button btn_logout;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_you);
        btn_logout=(Button)findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(click);
        setTitle("User Details");

        SharedPreferences sh = getApplicationContext().getSharedPreferences("mydata1",MODE_PRIVATE);
        String eid = sh.getString("loginid","NA");
        if(eid.equals("NA"))
        {
            Intent intent = new Intent(getApplicationContext(),UserLogin.class);
            startActivity(intent);
            
        }
        else{
            //Show User Details From Database
        }


    }

    View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            if(view.getId()==R.id.btn_logout)
            {
                SharedPreferences sh = getApplicationContext().getSharedPreferences("mydata1",MODE_PRIVATE);
                SharedPreferences.Editor editor = sh.edit();
                editor.putString("loginid","");/////Set Cookie
                editor.commit();


                intent = new Intent(getApplicationContext(),UserLogin.class);
                startActivity(intent);
            }
        }
    };
}

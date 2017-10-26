package com.example.rocky_pc.projectglobsyn;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {
    Button btn_login,btn_signup;
    EditText txt_email,txt_pwd;
    CheckBox chk_rememberme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        setTitle("Login Form");

        txt_email = (EditText)findViewById(R.id.txt_eid);
        txt_pwd = (EditText)findViewById(R.id.txt_pwd);
        txt_email.setError("Please enter your Email id");
        txt_pwd.setError("Please enter your Password");
        chk_rememberme = (CheckBox)findViewById(R.id.chk_rememberme);

        btn_login = (Button)findViewById(R.id.btn_login);
        btn_signup = (Button)findViewById(R.id.btn_signup);

        btn_login.setOnClickListener(click);
        btn_signup.setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            if(v.getId()==R.id.btn_login)
            {
                if(chk_rememberme.isChecked())
                {
                    SharedPreferences sh = getApplicationContext().getSharedPreferences("mydata1",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sh.edit();
                    editor.putString("loginid",txt_email.toString());/////Set Cookie
                    editor.commit();

                }

                if(txt_email.getText().toString().equals("user") && txt_pwd.getText().toString().equals("123"))
                {
                    Toast.makeText(getApplicationContext(),"Succesfully login",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MenuHome.class);
                    startActivity(intent);

                }
                else {
                    Toast.makeText(getApplicationContext(),"Incorrect email or password",Toast.LENGTH_SHORT).show();
                }
                finish();


            }
            else if(v.getId() == R.id.btn_signup)
            {
                Intent intent = new Intent(getApplicationContext(),UserSignup.class);
                startActivity(intent);
            }

        }
    };
}

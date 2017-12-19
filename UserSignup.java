
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserSignup extends AppCompatActivity {

    Button btn_reg;
    EditText txt_name,txt_eid,txt_phno,txt_pwd,txt_rpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup);
        setTitle("Sign up page");
        btn_reg=(Button)findViewById(R.id.btn_reg);
        txt_eid=(EditText)findViewById((R.id.txt_eid));
        txt_name=(EditText)findViewById((R.id.txt_name));
        txt_phno=(EditText)findViewById((R.id.txt_phno));
        txt_pwd=(EditText)findViewById((R.id.txt_pwd));
        txt_rpwd=(EditText)findViewById((R.id.txt_rpwd));
        btn_reg.setOnClickListener(click);

        txt_name.setError("Please Enter your name");
        txt_phno.setError("Please Enter your Phone no");
        txt_eid.setError("Please Enter your Email id");
        txt_pwd.setError("Please Enter your Password");

        txt_rpwd.setError("Please Enter your Password");

    }

    View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
        /////do something
        }

    };
}

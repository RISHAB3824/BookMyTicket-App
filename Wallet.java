
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Wallet extends AppCompatActivity {

    EditText txt_addbal;
    TextView txt_bal,txt_name1,txt_id1,txt_id2,txt_name2,txt_bal2;
    Button btn_add;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        setTitle("Wallet");
        btn_add=(Button)findViewById(R.id.btn_add);
        txt_name1=(TextView) findViewById(R.id.txt_name1);
        txt_name2=(TextView) findViewById(R.id.txt_name2);
        txt_id1=(TextView)findViewById(R.id.txt_id1);
        txt_id2=(TextView)findViewById(R.id.txt_id2);
        txt_addbal=(EditText)findViewById(R.id.txt_addbal);
        txt_bal=(TextView)findViewById(R.id.txt_bal);
        txt_bal2=(TextView)findViewById(R.id.txt_bal2);
        btn_add.setOnClickListener(click);
    }

    View.OnClickListener click=new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            new ABC().execute();
            txt_bal2.setText(txt_addbal.getText().toString());



        }
    };
    class ABC extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog=new ProgressDialog(Wallet.this);
            dialog.setMessage("WAIT");
            dialog.setTitle("ADDING");
            dialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            dialog.dismiss();
            txt_addbal.setText(null);

        }

        @Override
        protected Void doInBackground(Void... params) {
            try
            {
                Thread.sleep(4000);

            }
            catch (Exception e){

            }

            return null;
        }
    }

}

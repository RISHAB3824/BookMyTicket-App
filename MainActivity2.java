
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    RadioButton radio1, radio2, radio3;
    TextView txt_2;
    String t;

    ListView lv;
    ArrayList<PRODUCT> products = new ArrayList<PRODUCT>();
    String hall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i1 = getIntent();
        Bundle b = i1.getExtras();
        hall = b.getString("hall");
        String time1 = b.getString("time1");
        String time2 = b.getString("time2");
        String time3 = b.getString("time3");
        radio1 = (RadioButton) findViewById(R.id.radio_1);
        radio2 = (RadioButton) findViewById(R.id.radio_2);
        radio3 = (RadioButton) findViewById(R.id.radio_3);
        txt_2 = (TextView) findViewById(R.id.txt_2);
        lv = (ListView) findViewById(R.id.lv);
        lv.setOnItemClickListener(click1);
      radio1.setOnClickListener(click);
        radio2.setOnClickListener(click);
        radio3.setOnClickListener(click);

       PRODUCT p1 = new PRODUCT();
        p1.seat = "PLATINUM";
        p1.price="Rs.500";

        PRODUCT p2 = new PRODUCT();
        p2.seat = "GOLD";
        p2.price="Rs.250";

        PRODUCT p3 = new PRODUCT();
        p3.seat = "SILVER";
        p3.price="Rs.150";


        products.add(p1);
        products.add(p2);
        products.add(p3);

        if(hall.equals("South City Mal")){
          //  Toast.makeText(getApplicationContext(),"ARDFG",Toast.LENGTH_SHORT).show();
        }
        else if(hall.equals("Anjana Hall")){
            radio1.setText(time1);
            radio2.setText(time2);
            radio3.setText(time3);
        }
        else if(hall.equals("ABCD Hall")){
            radio1.setText(time1);
            radio2.setText(time2);
            radio3.setText(time3);
        }
        else if(hall.equals("FAN Hall")){
            radio1.setText(time1);
            radio2.setText(time2);
            radio3.setText(time3);
        }


    }

   View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {

                if (v.getId() == R.id.radio_1) {
                    Custom_adaptor1 adpt = new Custom_adaptor1(MainActivity2.this, products);
                    lv.setAdapter(adpt);
                    t=radio1.getText().toString();


                } else if (v.getId() == R.id.radio_2) {
                    Custom_adaptor1 adpt = new Custom_adaptor1(MainActivity2.this, products);
                    lv.setAdapter(adpt);
                    t=radio2.getText().toString();

                } else if (v.getId() == R.id.radio_3) {
                    Custom_adaptor1 adpt = new Custom_adaptor1(MainActivity2.this, products);
                    lv.setAdapter(adpt);
                    t=radio3.getText().toString();

                }
            }
            catch (Exception e){
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }


    };
    AdapterView.OnItemClickListener click1=new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            if(position==0) {

                Intent i2 = new Intent(getApplicationContext(), MainActivity3.class);
                i2.putExtra("ABC", hall);
                i2.putExtra("CDE","PLATINUM");
                i2.putExtra("FGH",t);

                startActivity(i2);

            }
            else if(position==1){
                Intent i2 = new Intent(getApplicationContext(), MainActivity3.class);
                i2.putExtra("ABC", hall);
                i2.putExtra("CDE","GOLD");
                i2.putExtra("FGH",t);
                startActivity(i2);
            }
            else if(position==2){
                Intent i2 = new Intent(getApplicationContext(), MainActivity3.class);
                i2.putExtra("ABC",hall);
                i2.putExtra("CDE","SILVER");
                i2.putExtra("FGH",t);
                startActivity(i2);

            }

        }
    };
}

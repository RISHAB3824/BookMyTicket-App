
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity1 extends AppCompatActivity {

    ListView lv;
    int month,day1,day2,day3,day4,year;
    Spinner spn;
    TextView txt_show;
    ArrayList<String> date =new ArrayList<>();
    ArrayAdapter<String> adapter;
    Customer_Adapter adpt;
    ArrayList<PRODUCT> products=new ArrayList<PRODUCT>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        lv = (ListView) findViewById(R.id.lv);
        setTitle("BOOKING");
        month = Calendar.getInstance().get(Calendar.MONTH);
        day1 = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        year = Calendar.getInstance().get(Calendar.YEAR);
        lv.setOnItemClickListener(click);

        Calendar calendar = Calendar.getInstance();
        Date today = calendar.getTime();



        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow = calendar.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

        String t = dateFormat.format(today);
        String to = dateFormat.format(tomorrow);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date third = calendar.getTime();
        String th=dateFormat.format(third);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date fourth = calendar.getTime();
        String fr=dateFormat.format(fourth);





        txt_show = (TextView) findViewById(R.id.txt_show);

        date.add(t);
        date.add(to);
        date.add(th);
        date.add(fr);

        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.item_date, date);
        spn = (Spinner) findViewById(R.id.spn);
        spn.setAdapter(adapter);
        PRODUCT p1 = new PRODUCT();
        p1.hall = "South City Mall";
        p1.time1 = "9:30am";
        p1.time2 = "12:30am";
        p1.time3 = "2:00am";

        PRODUCT p2 = new PRODUCT();
        p2.hall = "Anjana Hall";
        p2.time1 = "12:30pm";
        p2.time2 = " 5:00pm";
        p2.time3 = "8:00pm";

        PRODUCT p3 = new PRODUCT();
        p3.hall = "ABCD Hall";
        p3.time1 = "10:00am";
        p3.time2 = "2:30";
        p3.time3 = "6:30";

        PRODUCT p4 = new PRODUCT();
        p4.hall = "FAN Hall";
        p4.time1 = "9:30am";
        p4.time2 = "12:00pm";
        p4.time3 = "9:00pm";
        products.add(p1);
        products.add(p2);
        products.add(p3);
        products.add(p4);
        adpt = new Customer_Adapter(MainActivity1.this, products);

        lv.setAdapter(adpt);


    }

    ListView.OnItemClickListener click=new ListView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            try {
                Bundle b = new Bundle();
                b.putString("hall", products.get(position).hall.toString());
                b.putString("time1", products.get(position).time1.toString());
                b.putString("time2", products.get(position).time2.toString());
                b.putString("time3", products.get(position).time3.toString());
                Intent i1 = new Intent(getApplicationContext(), MainActivity2.class);
                i1.putExtras(b);
                startActivity(i1);
            }catch (Exception e){
                Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }

    };




        }

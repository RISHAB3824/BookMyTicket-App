
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MovieMenu extends AppCompatActivity {

    ArrayList<MovieItem> products = new ArrayList<MovieItem>();
    ListView lv;
    Custom_product_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_menu);

        lv= (ListView)findViewById(R.id.lv_movies);
        lv.setOnItemClickListener(click_lv);

        setTitle("BookMyTicket");
        MovieItem m1 = new MovieItem();
        m1.movie_name = "MohenjoDaro";
        m1.img = R.drawable.mohen;
        m1.movie_id = "1";

        MovieItem m2 = new MovieItem();
        m2.img = R.drawable.rustom;
        m2.movie_name = "Rustom";
        m2.movie_id = "2";

        MovieItem m3 = new MovieItem();
        m3.img = R.drawable.kabali;
        m3.movie_id = "3";
        m3.movie_name = "Kabali";

        MovieItem m4 = new MovieItem();
        m4.img = R.drawable.sultan;
        m4.movie_id = "4";
        m4.movie_name = "Sultan";

        MovieItem m5 = new MovieItem();
        m5.img = R.drawable.raees;
        m5.movie_id = "5";
        m5.movie_name = "Raees";

        MovieItem m6 = new MovieItem();
        m6.img = R.drawable.dangal;
        m6.movie_id = "6";
        m6.movie_name = "Dangal";

        MovieItem m7 = new MovieItem();
        m7.img = R.drawable.bahubali;
        m7.movie_id = "7";
        m7.movie_name = "Bahubali 2";

        products.add(m1);
        products.add(m2);
        products.add(m3);
        products.add(m4);
        products.add(m5);
        products.add(m6);
        products.add(m7);

        adapter = new Custom_product_adapter(MovieMenu.this,products,click);
        //adapter = new Custom_product_adapter(MovieMenu.class, products,click);
        lv.setAdapter(adapter);


    }

    ListView.OnItemClickListener click_lv = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


            try {
                //Toast.makeText(getApplicationContext(), products.get(i).toString(), Toast.LENGTH_SHORT).show();
                String s = products.get(i).movie_id.toString();
                Intent i1 = new Intent(getApplicationContext(), Movie_desc.class);
                i1.putExtra("position", s);
                startActivity(i1);
            }catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            }

        }
    };

    View.OnClickListener click=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           // int pos=Integer.parseInt( view.getTag().toString());
          try {
              //Toast.makeText(getApplicationContext(),"Ngyf",Toast.LENGTH_SHORT).show();

            Intent intent=new Intent(getApplicationContext(),MainActivity1.class);
            startActivity(intent);
          }catch (Exception e)
          {
              Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
          }
        }
    };
}

package freedom.com.baitaplistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView1;
    ArrayList<Legend> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvents();
    }

    public void setControl() {
        listView1 = findViewById(R.id.listView1);
    }

    public void setEvents() {
        init();
        LegendAdapter adapter = new LegendAdapter(this, R.layout.listview_item_row, data);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Legend o = (Legend) parent.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, o.getName().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    void init() {
        data.add(new Legend(R.drawable.pele, "Pele", "Oct 23, 1940",R.drawable.br));
        data.add(new Legend(R.drawable.ronaldo, "Cristiano Ronaldo", "Feb 5, 1985",R.drawable.pt));
        data.add(new Legend(R.drawable.messi, "Lionel Messi", "June 24, 1987", R.drawable.ar));
        data.add(new Legend(R.drawable.mbappe, "Kylian Mbappé", "Dec 20, 1998", R.drawable.fr));
        data.add(new Legend(R.drawable.quanghai, "Nguyễn Quang Hải", "Apr 12, 1997", R.drawable.vn));
        data.add(new Legend(R.drawable.neuer,"Manuel Neuer", "Mar 27, 1986", R.drawable.de));
    }

}

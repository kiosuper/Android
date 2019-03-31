package freedom.com.baitaplistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView1;
    ArrayList<Country> data = new ArrayList<>();

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
        CountryAdapter adapter = new CountryAdapter(this, R.layout.listview_item_row, data);
        listView1.setAdapter(adapter);
    }

    void init() {
        data.add(new Country(R.drawable.vietnamflag, "Vietnam", 98000000));
        data.add(new Country(R.drawable.usflag, "United States", 320000000));
        data.add(new Country(R.drawable.russiaflag, "Russia", 14200000));
    }

}

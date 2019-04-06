package freedom.com.baitaptuan5_vidu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView1;
    ArrayList<SocialNetwork> data = new ArrayList<>();


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
        SocialNetworkAdapter adapter = new SocialNetworkAdapter(this, R.layout.listview_item_row, data);
        listView1.setAdapter(adapter);
    }

    void init() {
        data.add(new SocialNetwork(R.drawable.fb_icon, "Facebook"));
        data.add(new SocialNetwork(R.drawable.linkedin_icon, "Linkedin"));
        data.add(new SocialNetwork(R.drawable.msn_icon, "MSN"));
        data.add(new SocialNetwork(R.drawable.skype_icon, "Skype"));
        data.add(new SocialNetwork(R.drawable.yahoo_icon, "Yahoo"));
    }
}

package freedom.com.baitaptuan6_bai5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import freedom.com.baitaptuan6_bai5.model.MyContact;

public class MainActivity extends AppCompatActivity {

    private EditText editName;
    private EditText editPhone;
    private Button btnSave;

    ListView lvContact;

    ArrayList<MyContact> contactList = new ArrayList<MyContact>();
    ArrayAdapter<MyContact> adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setControl();
        setEvents();
    }

    public void setControl() {
        btnSave = findViewById(R.id.btnSaveContact);
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        lvContact = findViewById(R.id.lvContact);

        adapter = new ArrayAdapter<MyContact>(this, android.R.layout.simple_list_item_1, contactList);
        lvContact.setAdapter(adapter);
        registerForContextMenu(lvContact);
    }

    public void setEvents() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveContact();
            }
        });
    }

    public void saveContact() {
        MyContact myContact = new MyContact();
        myContact.setmName(editName.getText().toString());
        myContact.setmPhone(editPhone.getText().toString());
        contactList.add(myContact);
        adapter.notifyDataSetChanged();
    }
}

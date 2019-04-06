package com.example.bai5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DoUongActivity extends AppCompatActivity {
    private ListView listView1;
    private Button btn_chon;
    String msg;
    ArrayList<DoUong> douong =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_thucuong);
        setControl();
        setEvents();
        chose();
    }
    public void setControl() {
        listView1 = findViewById(R.id.listview_thucuong);
        btn_chon = findViewById(R.id.btn_chose);
    }
    public void chose(){
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DoUong o = (DoUong) parent.getItemAtPosition(position);
                msg = o.getName().toString();
            }
        });
        btn_chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DoUongActivity.this,MainActivity.class);
                intent.putExtra("Key_1",msg);
                startActivity(intent);
            }
        });
    }
    public void setEvents(){
        init();
        DoUong_Adapter adapter = new DoUong_Adapter(this, R.layout.item_row, douong);
        listView1.setAdapter(adapter);


    }

    void init() {
        douong.add(new DoUong(R.drawable.ic_aquafina, "Aquafina"));
        douong.add(new DoUong(R.drawable.ic_pepsi, "Pepsi"));
        douong.add(new DoUong(R.drawable.ic_heniken, "Heniken"));
        douong.add(new DoUong(R.drawable.ic_coca, "Coca"));
    }
}

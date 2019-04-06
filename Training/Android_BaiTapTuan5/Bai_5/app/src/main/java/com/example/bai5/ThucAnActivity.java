package com.example.bai5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ThucAnActivity extends AppCompatActivity {
    private ListView listView1;
    private Button btn_chose;
    String msg;
    ArrayList<ThucAn> thucan =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview_doan);
        setControl();
        setEvents();
        chose();
    }
    public void setControl() {
        listView1 = findViewById(R.id.listview_doan);
        btn_chose = findViewById(R.id.btn_chose);
    }
    public void setEvents(){
        init();
        ThucAn_Adapter adapter = new ThucAn_Adapter(this, R.layout.item_row, thucan);
        listView1.setAdapter(adapter);
    }
    public void chose(){
        btn_chose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThucAnActivity.this,MainActivity.class);
                intent.putExtra("Key_2",msg);
                startActivity(intent);
            }
        });
    }

    void init() {
        thucan.add(new ThucAn(R.drawable.ic_phn, "Phở Hà Nội"));
        thucan.add(new ThucAn(R.drawable.ic_bbh, "Bún Bò Huế"));
        thucan.add(new ThucAn(R.drawable.ic_mq, "Mì Quảng"));
        thucan.add(new ThucAn(R.drawable.ic_htnv, "Hủ Tíu Nam Vang"));
    }
}



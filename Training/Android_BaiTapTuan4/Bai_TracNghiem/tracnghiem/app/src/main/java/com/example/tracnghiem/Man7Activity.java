package com.example.tracnghiem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.List;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class Man7Activity extends AppCompatActivity {


    private ListView lvItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh_7);
        Intent intent = getIntent();
        String[] result = new String[8];
        String ket_qua_1 = intent.getStringExtra("Key_2");
        result[0] = ket_qua_1;
        String ket_qua_2 = intent.getStringExtra("Key_3");
        result[1] = ket_qua_2;
        String ket_qua_3 = intent.getStringExtra("Key_4");
        result[2] = ket_qua_3;
        String ket_qua_4 = intent.getStringExtra("Key_5");
        result[3] = ket_qua_4;
        String ket_qua_5 = intent.getStringExtra("Key_6");
        result[4] = ket_qua_5;

        lvItems = (ListView)findViewById(R.id.listView);
        List<String> data = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            data.add("Cau "+ (i + 1) +": " + result[i] + " cau dung");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        lvItems.setAdapter(adapter);
    }
}
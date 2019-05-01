package com.example.giuaky;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_sinhvien;
    private Button btn_giaovien;
    private Button btn_thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControls();
        setEvents();

    }

    public void setControls(){
        btn_sinhvien = findViewById(R.id.btn_sinhvien);
        btn_giaovien = findViewById(R.id.btn_giaovien);
        btn_thoat = findViewById(R.id.btn_thoat);
    }

    public void setEvents(){
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
        btn_sinhvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,IndexSinhVienActivity.class);
                startActivity(intent);
            }
        });
        btn_giaovien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,IndexGiaoVienActivity.class);
                startActivity(intent);
            }
        });
    }
}

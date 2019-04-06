package com.example.bai5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btn_douong;
    private Button btn_thucan;
    private Button btn_thoat;
    private TextView txt_resilt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String msg;
        msg = intent.getStringExtra("Key_1");
        msg += " - ";
        msg = intent.getStringExtra("Key_2");
        setControl();
        setEvent();
    }

    public void setControl(){
        btn_douong = findViewById(R.id.btn_douong);
        btn_thucan = findViewById(R.id.btn_thucan);
        btn_thoat = findViewById(R.id.btn_thoat);
    }
    public void setEvent(){
        btn_thucan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThucAnActivity.class);
                startActivity(intent);
            }
        });
        btn_douong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DoUongActivity.class);
                startActivity(intent);
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}

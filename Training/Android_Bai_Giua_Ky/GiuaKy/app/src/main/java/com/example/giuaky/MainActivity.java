package com.example.giuaky;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_xem;
    private Button btn_sua;
    private Button btn_dangki;
    private Button btn_thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControls();
        setEvents();

    }

    public void setControls(){
        btn_xem = findViewById(R.id.btn_xem);
        btn_dangki = findViewById(R.id.btn_dangki);
        btn_sua = findViewById(R.id.btn_sua);
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
        btn_xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,XemActivity.class);
                startActivity(intent);
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SuaActivity.class);
                startActivity(intent);
            }
        });
        btn_dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DangKyActivity.class);
                startActivity(intent);
            }
        });
    }
}

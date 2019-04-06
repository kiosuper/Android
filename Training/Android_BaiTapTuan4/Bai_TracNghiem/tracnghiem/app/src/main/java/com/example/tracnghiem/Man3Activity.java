package com.example.tracnghiem;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


public class Man3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh_3);
        setControl();
        setEvent();
        Translate();
    }

    private Button btn_back;
    private Button btn_next;
    private Button btn_submit;
    private RadioButton rad_4_4;
    private RadioButton rad_8_3;
    private RadioButton rad_10_3;
    private RadioButton rad_5_3;

    public void setControl() {
        btn_back = findViewById(R.id.btn_back);
        btn_submit = findViewById(R.id.btn_submit);
        btn_next = findViewById(R.id.btn_next);
        rad_4_4 = findViewById(R.id.rad_4_4);
        rad_5_3 = findViewById(R.id.rad_5_3);
        rad_8_3 = findViewById(R.id.rad_8_3);
        rad_10_3 = findViewById(R.id.rad_10_3);
    }

    public void setEvent() {
        rad_4_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rad_4_4.setChecked(true);
                rad_8_3.setChecked(false);
                rad_5_3.setChecked(false);
                rad_10_3.setChecked(false);
            }
        });
        rad_5_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rad_4_4.setChecked(false);
                rad_8_3.setChecked(false);
                rad_5_3.setChecked(true);
                rad_10_3.setChecked(false);
            }
        });
        rad_8_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rad_4_4.setChecked(false);
                rad_8_3.setChecked(true);
                rad_5_3.setChecked(false);
                rad_10_3.setChecked(false);
            }
        });
        rad_10_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rad_4_4.setChecked(false);
                rad_8_3.setChecked(false);
                rad_5_3.setChecked(false);
                rad_10_3.setChecked(true);
            }
        });
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder r = new AlertDialog.Builder(Man3Activity.this);
                String result = "";
                if(rad_8_3.isChecked()){
                    result = "Correct";
                }
                else{
                    result = "Incorrect";
                }
                r.setTitle("Result");
                r.setMessage(result);
                r.create().show();
            }
        });
    }

    public void Translate() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Man3Activity.this, Man2Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Man3Activity.this, Man4Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                String kq = "";
                if(rad_8_3.isChecked()){
                    kq = "1";
                }
                else{
                    kq = "0";
                }
                Intent intent_1 = getIntent();
                String Key_2 = intent_1.getStringExtra("Key_2");
                intent.putExtra("Key_2", Key_2);
                intent.putExtra("Key_3",kq);
                startActivity(intent);
            }
        });
    }
}

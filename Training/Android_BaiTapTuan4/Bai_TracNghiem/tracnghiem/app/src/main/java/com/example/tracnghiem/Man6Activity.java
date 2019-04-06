package com.example.tracnghiem;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class Man6Activity extends AppCompatActivity {
    Button btright, btnleft, btnKQ;
    TextView txtdapan;
    Switch checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh_6);
        setControl();
        setEvent();
        Translate();
    }
    public void setControl(){
        btright = findViewById(R.id.right);
        btnleft = findViewById(R.id.left);
        btnKQ = findViewById(R.id.KQ);
        txtdapan = findViewById(R.id.dapan);
        checked = findViewById(R.id.sw3);
    }
    public void setEvent() {
        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                AlertDialog.Builder r = new AlertDialog.Builder(Man6Activity.this);
                txtdapan.setTextColor(Color.parseColor("#ff0006"));
                if (checked.isChecked()) {
                    result = "Đúng";

                } else {
                    result = "Sai";
                }
                r.setTitle("RESULT");
                r.setMessage(result);
                r.create().show();

            }
        });
    }
    public void Translate(){
        btnleft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Man6Activity.this, Man5Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        btright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Man6Activity.this, Man7Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                String kq = "";
                txtdapan.setTextColor(Color.parseColor("#ff0006"));
                if (checked.isChecked()) {
                    kq = "1";

                } else {
                    kq = "0";
                }
                Intent intent_1 = getIntent();
                String Key_2 = intent_1.getStringExtra("Key_2");
                String Key_3 = intent_1.getStringExtra("Key_3");
                String Key_4 = intent_1.getStringExtra("Key_4");
                String Key_5 = intent_1.getStringExtra("Key_5");
                intent.putExtra("Key_2", Key_2);
                intent.putExtra( "Key_3", Key_3);
                intent.putExtra("Key_4", Key_4);
                intent.putExtra("Key_5", Key_5);
                intent.putExtra("Key_6", kq);
                startActivity(intent);
            }
        });

    }
}
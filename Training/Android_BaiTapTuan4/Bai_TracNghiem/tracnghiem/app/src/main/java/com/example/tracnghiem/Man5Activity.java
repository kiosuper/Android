package com.example.tracnghiem;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Man5Activity extends AppCompatActivity {
    Button btright, btnleft, btnKQ;
    TextView txtdapan;
    ToggleButton checked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh_5);
        setControl();
        setEvent();
        Translate();
    }
    public void setControl(){
        btright = findViewById(R.id.right);
        btnleft = findViewById(R.id.left);
        btnKQ = findViewById(R.id.KQ);
        checked = findViewById(R.id.tog3);
        txtdapan = findViewById(R.id.dapan);
    }
    public void setEvent() {

        btnKQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result ="";
                AlertDialog.Builder r = new AlertDialog.Builder(Man5Activity.this);

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
                Intent intent = new Intent(Man5Activity.this, Man4Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        btright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Man5Activity.this, Man6Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                String kq = "";

                if (checked.isChecked()) {
                    kq = "1";

                } else {
                    kq = "0";
                }
                Intent intent_1 = getIntent();
                String Key_2 = intent_1.getStringExtra("Key_2");
                String Key_3 = intent_1.getStringExtra("Key_3");
                String Key_4 = intent_1.getStringExtra("Key_4");
                intent.putExtra("Key_2", Key_2);
                intent.putExtra( "Key_3", Key_3);
                intent.putExtra("Key_4", Key_4);
                intent.putExtra("Key_5", kq);
                startActivity(intent);
            }
        });

    }
}
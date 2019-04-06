package com.example.tracnghiem;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Man4Activity extends AppCompatActivity{
    private Spinner option_answer_1, option_answer_2, option_answer_3;
    private Button btBack, btSubmit, btNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh_4);
        setControl();
        setEvent();
        Translate();
    }
    public void setControl(){
        option_answer_1 = findViewById(R.id.option_answer_1);
        option_answer_2 = findViewById(R.id.option_answer_2);
        option_answer_3 =  findViewById(R.id.option_answer_3);
        btBack = findViewById(R.id.btn_back);
        btSubmit = findViewById(R.id.btn_submit);
        btNext = findViewById(R.id.btn_next);
    }

    public void setEvent() {
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result="";
                String opAnswer_1 = option_answer_1.getSelectedItem().toString();
                String opAnswer_2 = option_answer_2.getSelectedItem().toString();
                String opAnswer_3 = option_answer_3.getSelectedItem().toString();
                if(opAnswer_1.equals("B"))
                {
                    result= result.concat("câu 1 đúng \r\n");
                }else {
                    result = result.concat("câu 1 sai \r\n");
                }
                if(opAnswer_2.equals("D"))
                {
                    result =  result.concat("câu 2 đúng \r\n");
                }else {
                    result = result.concat("câu 2 sai \r\n");
                }
                if(opAnswer_3.equals("D"))
                {
                    result = result.concat("câu 3 đúng \r\n");
                }else {
                    result = result.concat("câu 3 sai \r\n");
                }
                AlertDialog.Builder r = new AlertDialog.Builder(Man4Activity.this);
                r.setTitle("Result");
                r.setMessage(result);

                r.show();
            }
        });
    }

    public void Translate() {
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Man4Activity.this, Man3Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Man4Activity.this, Man5Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                String kq = "";
                int dem = 0;
                String opAnswer_1 = option_answer_1.getSelectedItem().toString();
                String opAnswer_2 = option_answer_2.getSelectedItem().toString();
                String opAnswer_3 = option_answer_3.getSelectedItem().toString();
                if(opAnswer_1.equals("B"))
                {
                    dem++;
                }
                if(opAnswer_2.equals("D"))
                {
                    dem++;
                }
                if(opAnswer_3.equals("D"))
                {
                    dem++;
                }
                kq = kq + dem;
                dem = 0;
                Intent intent_1 = getIntent();
                String Key_2 = intent_1.getStringExtra("Key_2");
                String Key_3 = intent_1.getStringExtra("Key_3");
                intent.putExtra("Key_2", Key_2);
                intent.putExtra("Key_3", Key_3);
                intent.putExtra( "Key_4", kq);
                startActivity(intent);
            }
        });
    }
}

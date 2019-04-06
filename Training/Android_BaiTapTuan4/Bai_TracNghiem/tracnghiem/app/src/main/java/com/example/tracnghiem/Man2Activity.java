package com.example.tracnghiem;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Man2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manhinh_2);
        setControl();
        setEvent();
        Translate();
    }

    private Button btn_back;
    private Button btn_next;
    private Button btn_result;
    private CheckBox cb_ga;
    private CheckBox cb_vit;
    private CheckBox cb_bo;
    private CheckBox cb_lon;

    public void setControl() {
        btn_back = findViewById(R.id.btn_back);
        btn_result = findViewById(R.id.btn_result);
        btn_next = findViewById(R.id.btn_next);
        cb_ga = findViewById(R.id.cb_ga);
        cb_vit = findViewById(R.id.cb_vit);
        cb_bo = findViewById(R.id.cb_bo);
        cb_lon = findViewById(R.id.cb_lon);
    }

    public void setEvent(){
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = "";
                AlertDialog.Builder r = new AlertDialog.Builder(Man2Activity.this);
                if(cb_ga.isChecked()  && cb_vit.isChecked()){
                    result = "2";
                }
                else if((!cb_ga.isChecked()  && cb_vit.isChecked()) || (cb_ga.isChecked()  && !cb_vit.isChecked())){
                        result = "1";
                    }
                else result = "0";
//                Toast.makeText(Man2Activity.this,result,Toast.LENGTH_SHORT).show();
                r.setTitle("RESULT");
                r.setMessage(result + " cau dung");
                r.create().show();
            }
        });
    }
    public void Translate() {
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Man2Activity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Man2Activity.this, Man3Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                String kq = "";
                if(cb_ga.isChecked()  && cb_vit.isChecked()){
                    kq = "2";
                }
                else if((!cb_ga.isChecked()  && cb_vit.isChecked()) || (cb_ga.isChecked()  && !cb_vit.isChecked())){
                    kq = "1";
                }
                else kq = "0";
                intent.putExtra("Key_2", kq);
                startActivity(intent);
            }
        });
    }
}

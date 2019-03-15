package com.example.bai4;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    CheckBox background, txtcolor, center;
    RadioButton odd, even, both;
    EditText txt_number;
    TextView result;
    Button btn_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();

    }


    private void setControl(){
        background = findViewById(R.id.cbx_background);
        txtcolor = findViewById(R.id.cbx_txtcolor);
        center = findViewById(R.id.cbx_center);

        odd = findViewById(R.id.rbtn_odd);
        even = findViewById(R.id.rbtn_even);
        both = findViewById(R.id.rbtn_both);

        txt_number = findViewById(R.id.number_type);

        result = findViewById(R.id.result);

        btn_result = findViewById(R.id.btn_result);
    }

    @SuppressLint("ResourceAsColor")
    private void setEvent() {
        background.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(background.isChecked()){
                   result.setBackgroundColor(getResources().getColor(R.color.colorBackground_change));
                }
                else{
                    result.setBackgroundColor(getResources().getColor(R.color.colorBackground));
                }
            }
        });

        txtcolor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(txtcolor.isChecked()){
                    result.setTextColor(getResources().getColor(R.color.txtcolor_change));
                }
                else{
                    result.setTextColor(getResources().getColor(R.color.txtcolor));
                }
            }
        });

        center.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(center.isChecked()){
                    result.setGravity(Gravity.CENTER);
                }
                else{
                    result.setGravity(Gravity.LEFT);
                }
            }
        });

        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    CheckNum();
                }
                catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this,"Please Enter the Number.",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void CheckNum(){
        String[] list_txt_num = txt_number.getText().toString().split(" ");
        String res = "";
        if(odd.isChecked()){
            for(int i = 0; i < list_txt_num.length; i++){
                if(Integer.parseInt(list_txt_num[i]) % 2 == 1){
                    res += list_txt_num[i] + " ";
                }
            }
            result.setText(res);
        }
        else if(even.isChecked()){
            for(int i = 0; i < list_txt_num.length; i++){
                if(Integer.parseInt(list_txt_num[i]) % 2 == 0
                ){
                    res += list_txt_num[i] + " ";
                }
            }
            result.setText(res);
        }
        else if(both.isChecked()){

            for(int i = 0; i < list_txt_num.length; i++){
                Integer.parseInt(list_txt_num[i]);
                res += list_txt_num[i] + " ";
            }
            result.setText(res);
        }
        else{
            Toast.makeText(MainActivity.this, "Please chose the Option.",Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    private Button btn_ok;
    private Button btn_cancel;
    private TextView txt_name;
    private EditText edit_team;
    private EditText edit_number;
    private ImageView avatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_player);
        setControl();
        setEvent();

    }
    public void setControl(){
        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        txt_name = findViewById(R.id.player_name);
        edit_team = findViewById(R.id.edit_team);
        edit_number = findViewById(R.id.edit_number);
        avatar = findViewById(R.id.img_avatar);

    }
    public void setEvent(){
        Intent get = getIntent();
        int icon = get.getIntExtra("icon",0);
        String name = get.getStringExtra("name");
        String number = get.getStringExtra("number");
        String team = get.getStringExtra("team");
        avatar.setImageResource(icon);
        txt_name.setText(name);
        edit_team.setText(team);
        edit_number.setText(number);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent push = new Intent(EditActivity.this,MainActivity.class);
                String number = edit_number.getText().toString();
                String team = edit_team.getText().toString();
                push.putExtra("number",number);
                push.putExtra("team",team);
                setResult(RESULT_OK,push);
                finish();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

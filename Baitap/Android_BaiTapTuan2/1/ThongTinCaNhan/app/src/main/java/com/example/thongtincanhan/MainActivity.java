package com.example.thongtincanhan;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txt_cmnd;
    private EditText txt_hoten;
    private RadioButton rad_TrungCap;
    private RadioButton rad_CaoDang;
    private RadioButton rad_DaiHoc;
    private CheckBox cb_DocBao;
    private CheckBox cb_DocSach;
    private CheckBox cb_DocCoding;
    private Button btn_send;
    private EditText txt_bonus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setEvent();
        setControl();
    }

    public void setEvent() {
        txt_hoten = findViewById(R.id.hoten_txt);
        txt_cmnd = findViewById(R.id.CMND_txt);
        rad_TrungCap = findViewById(R.id.rad_TrungCap);
        rad_CaoDang = findViewById(R.id.rad_CaoDang);
        rad_DaiHoc = findViewById(R.id.rad_DaiHoc);
        cb_DocBao = findViewById(R.id.cb_DocBao);
        cb_DocSach = findViewById(R.id.cb_DocSach);
        cb_DocCoding = findViewById(R.id.cb_DocCoding);
        btn_send = findViewById(R.id.btn_send);
        txt_bonus = findViewById(R.id.txt_bonus);
    }

    public void setControl() {
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = txt_hoten.getText().toString();
                String CMND = txt_cmnd.getText().toString();
                String msg;
                if (hoten.length() < 3) {
                    Toast.makeText(MainActivity.this, "Họ tên phải lớn hơn 3 kí tự", Toast.LENGTH_LONG).show();
                    return;
                } else {
                    msg = "Họ tên: " + hoten + "\n";
                }
                try {
                    int cmnd = Integer.parseInt(CMND);
                    if (CMND.length() != 9) {
                        Toast.makeText(MainActivity.this, "CMND phải có 9 số", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        msg += "CMND: " + CMND + "\n";
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "CMND phải là số", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (rad_TrungCap.isChecked()) {
                    msg += "Trình độ: " + rad_TrungCap.getText().toString() + "\n";
                }
                if (rad_CaoDang.isChecked()) {
                    msg += "Trình độ: " + rad_CaoDang.getText().toString() + "\n";
                }
                if (rad_DaiHoc.isChecked()) {
                    msg += "Trình độ: " + rad_DaiHoc.getText().toString() + "\n";
                }
                msg += "Sở thích: \n";
                if (cb_DocBao.isChecked()) {
                    msg += cb_DocBao.getText().toString() + "\n";
                }
                if (cb_DocSach.isChecked()) {
                    msg += cb_DocSach.getText().toString() + "\n";
                }
                if (cb_DocCoding.isChecked()) {
                    msg += cb_DocCoding.getText().toString() + "\n";
                }
                msg += "------------------------------------------------\nThông tin bổ sung: \n";
                msg += txt_bonus.getText().toString() + "\n";
                msg += "------------------------------------------------\n";
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Thông tin cá nhân");
                dialog.setMessage(msg);
                dialog.setPositiveButton("OK",null);
                dialog.create().show();
            }
        });
    }
}

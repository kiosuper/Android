package com.example.giuaky;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IndexGiaoVienActivity extends AppCompatActivity {
    final String database_name = "QLMH.sqlite";
    SQLiteDatabase database;

    private EditText edt_hoten;
    private EditText edt_mssv;
    private EditText edt_sdt;
    private EditText edt_mon_hoc;
    private EditText edt_sotien;
    private EditText edt_sotc;

    private Button btn_them_sv;
    private Button btn_them_mh;
    private Button btn_thoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_giaovien);
        initDatabase();
        setControl();
        setEvent();
    }

    private void setEvent() {
        btn_them_sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hoten = edt_hoten.getText().toString();
                if(check(hoten) == 0){
                    return;
                }
                String mssv = edt_mssv.getText().toString();
                if (check(mssv) == 0){
                    return;
                }
                String sdt = edt_sdt.getText().toString();
                if(check(sdt) == 0){
                    return;
                }
                String insert_sv = "INSERT INTO SINHVIEN (MSSV,SODT,HOTENSV) VALUES ("+"\""+mssv+"\""+","+"\""+sdt+"\""+","+"\""+hoten+"\""+ ")";
                try {
                    database.execSQL(insert_sv);
                }
                catch (SQLException e){
                    Toast.makeText(IndexGiaoVienActivity.this, "Sinh viên này đã có rồi", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(IndexGiaoVienActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        btn_them_mh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ten_mh = edt_mon_hoc.getText().toString();
                if(check(ten_mh) == 0){
                    return;
                }
                int sotc = Integer.parseInt(edt_sotc.getText().toString());
                if (check(edt_sotc.getText().toString()) == 0){
                    return;
                }
                String so_tien = edt_sotien.getText().toString();
                if (check(so_tien) == 0){
                    return;
                }
                String insert_mh = "INSERT INTO MONHOC (TENMH,SOTC,SOTIEN) VALUES ("+"\""+ten_mh+"\""+","+sotc+","+"\""+so_tien+"\""+ ")";
                try {
                    database.execSQL(insert_mh);
                }
                catch (SQLException e){
                    Toast.makeText(IndexGiaoVienActivity.this, "Fail", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(IndexGiaoVienActivity.this,"Thêm thành công",Toast.LENGTH_LONG).show();
                finish();
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private int check(String s){
        if (s.matches("")){
            Toast.makeText(IndexGiaoVienActivity.this,"Bạn không được để trống phần này",
                    Toast.LENGTH_LONG).show();
            return 0;
        }
        else{
            return 1;
        }
    }

    private void setControl() {
        btn_them_mh = findViewById(R.id.btn_them_mh);
        btn_them_sv = findViewById(R.id.btn_them_sv);
        btn_thoat = findViewById(R.id.btn_thoat);
        edt_hoten = findViewById(R.id.edt_hoten);
        edt_mssv = findViewById(R.id.edt_mssv);
        edt_sdt = findViewById(R.id.edt_sdt);
        edt_mon_hoc = findViewById(R.id.edt_ten_mh);
        edt_sotc = findViewById(R.id.edt_so_tc);
        edt_sotien = findViewById(R.id.edt_thanh_tien);
    }

    private void initDatabase() {
        database = Database.initDatabase(IndexGiaoVienActivity.this, database_name);
        Cursor cursor = database.rawQuery("SELECT * from SINHVIEN", null);
        if (!cursor.moveToFirst()) {
            Toast.makeText(IndexGiaoVienActivity.this, "Fail to connect to database", Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.giuaky;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class XemActivity extends AppCompatActivity {
    final String database_name = "QLMH.sqlite";
    SQLiteDatabase database;
    ArrayList<MonHoc> arraylist;
    private ListView listView;
    MonHocAdapter adapter;
    String mssv;

    private TextView txt_hoten;
    private TextView txt_so_dt;
    private TextView txt_mssv;
    private TextView txt_sobl;
    private TextView txt_ngay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xem_layout);
        initDatabase();
        setControl();
        setEvent();
    }

    public void setControl() {
        txt_hoten = findViewById(R.id.txt_hoten);
        txt_so_dt = findViewById(R.id.txt_so_dt);
        txt_mssv = findViewById(R.id.txt_mssv);
        txt_ngay = findViewById(R.id.txt_ngaydangki);
        txt_sobl = findViewById(R.id.txt_sobl);
    }

    public void setEvent() {
        Intent intent = getIntent();
        mssv = intent.getStringExtra("mssv");
        listView = findViewById(R.id.lv_xem);
        arraylist = new ArrayList<>();
        adapter = new MonHocAdapter(this, R.layout.xem_item, arraylist);
        listView.setAdapter(adapter);
        arraylist.clear();
        String query = "SELECT DISTINCT SINHVIEN.HOTENSV,SINHVIEN.SODT,MONHOC.MAMH,MONHOC.TENMH,MONHOC.SOTC,MONHOC.SOTIEN FROM MONHOC,THONGTINHOCPHI,BIENLAIHOCPHI,SINHVIEN WHERE THONGTINHOCPHI.MAMH = MONHOC.MAMH AND (((THONGTINHOCPHI.SOBL = BIENLAIHOCPHI.SOBL) AND BIENLAIHOCPHI.MSSV = SINHVIEN.MSSV) AND SINHVIEN.MSSV = " + "\"" + mssv + "\"" + ")";
        Cursor cursor = database.rawQuery(query, null);
        int count = cursor.getCount();
        cursor.moveToPosition(0);
        String name = cursor.getString(0);
        String sdt = cursor.getString(1);
        txt_hoten.setText(name);
        txt_mssv.setText(mssv);
        txt_so_dt.setText(sdt);
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            int id = cursor.getInt(2);
            String ten_mh = cursor.getString(3);
            int so_tc = cursor.getInt(4);
            String so_tien = cursor.getString(5);
            arraylist.add(new MonHoc(ten_mh, id, so_tc, so_tien));
        }
        cursor.close();
        String get_info_bl = "SELECT * FROM BIENLAIHOCPHI WHERE MSSV = " + "\"" + mssv +"\"";
        cursor = database.rawQuery(get_info_bl,null);
        cursor.moveToFirst();
        String sobl = cursor.getString(0);
        String ngay = cursor.getString(1);
        txt_sobl.setText(sobl);
        txt_ngay.setText(ngay);
        adapter.notifyDataSetChanged();
    }

    public void initDatabase() {
        database = Database.initDatabase(XemActivity.this, database_name);
        Cursor cursor = database.rawQuery("SELECT * from SINHVIEN", null);
        if (!cursor.moveToFirst()) {
            Toast.makeText(XemActivity.this, "Fail to connect to database", Toast.LENGTH_SHORT).show();
        }
    }
}

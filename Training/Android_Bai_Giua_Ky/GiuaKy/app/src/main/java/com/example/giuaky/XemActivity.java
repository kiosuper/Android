package com.example.giuaky;

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

    private Button btn_thoat;
    private Button btn_xem;
    private EditText edt_mssv;
    private TextView txt_hoten;
    private TextView txt_so_dt;
    private TextView txt_mssv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xem_layout);
        initDatabase();
        setControl();
        setEvent();
    }

    public void setControl(){
        btn_xem = findViewById(R.id.btn_xem);
        edt_mssv = findViewById(R.id.edt_mssv);
        txt_hoten = findViewById(R.id.txt_hoten);
        txt_so_dt = findViewById(R.id.txt_so_dt);
        txt_mssv = findViewById(R.id.txt_mssv);
        btn_thoat = findViewById(R.id.btn_thoat);
    }

    public void setEvent(){
        listView = findViewById(R.id.lv_xem);
        arraylist = new ArrayList<>();
        adapter = new MonHocAdapter(this,R.layout.xem_item,arraylist);
        listView.setAdapter(adapter);
        btn_xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arraylist.clear();
                String mssv = edt_mssv.getText().toString();
                if (mssv.matches("")){
                    Toast.makeText(XemActivity.this,"Hãy nhập mssv",Toast.LENGTH_SHORT).show();
                    return;
                }
                //lấy thông tin sv + môn học
                String query = "SELECT DISTINCT SINHVIEN.HOTENSV,SINHVIEN.SODT,MONHOC.MAMH,MONHOC.TENMH,MONHOC.SOTC,MONHOC.SOTIEN FROM MONHOC,THONGTINHOCPHI,BIENLAIHOCPHI,SINHVIEN WHERE THONGTINHOCPHI.MAMH = MONHOC.MAMH AND (((THONGTINHOCPHI.SOBL = BIENLAIHOCPHI.SOBL) AND BIENLAIHOCPHI.MSSV = SINHVIEN.MSSV) AND SINHVIEN.MSSV = "+ "\""+mssv+"\"" +")";
                Cursor cursor = database.rawQuery(query,null);
                int count = cursor.getCount();
                cursor.moveToPosition(0);
                if (cursor.getCount() == 0){
                    Toast.makeText(XemActivity.this,"Bạn chưa đăng kí học phần",Toast.LENGTH_SHORT).show();
                    return;
                }
                String name = cursor.getString(0);
                String sdt = cursor.getString(1);
                txt_hoten.setText(name);
                txt_mssv.setText(mssv);
                txt_so_dt.setText(sdt);
                if (count == 0){
                    Toast.makeText(XemActivity.this, "Chỉ sinh viên đã đăng kí có thể xem học phần", Toast.LENGTH_SHORT).show();
                    return;
                }
                for (int i=0;i<count;i++){
                    cursor.moveToPosition(i);
                    int id = cursor.getInt(2);
                    String ten_mh = cursor.getString(3);
                    int so_tc = cursor.getInt(4);
                    String so_tien = cursor.getString(5);
                    arraylist.add(new MonHoc(ten_mh,id,so_tc,so_tien));
                }
                adapter.notifyDataSetChanged();
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void initDatabase(){
        database = Database.initDatabase(XemActivity.this,database_name);
        Cursor cursor = database.rawQuery("SELECT * from SINHVIEN",null);
        if(!cursor.moveToFirst()){
            Toast.makeText(XemActivity.this, "Fail to connect to database", Toast.LENGTH_SHORT).show();
        }
    }
}

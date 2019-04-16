package com.example.giuaky;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class DangKyActivity extends AppCompatActivity {
    final String database_name = "QLMH.sqlite";
    SQLiteDatabase database;
    ArrayList<MonHoc> arraylist = new ArrayList<>();
    SuaMonAdapter adapter;

    private EditText edt_hoten;
    private EditText edt_mssv;
    private EditText edt_sdt;
    private Button btn_dangky;
    private Button btn_huy;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky_layout);
        initDatabase();
        setControl();
        readData();
        setEvent();
    }

    private void setEvent() {
        btn_dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> check_mon = new ArrayList<>();
                for (int i=0;i<arraylist.size();i++){
                    if (arraylist.get(i).isSelected()){
                        check_mon.add(arraylist.get(i).ma_mh);
                    }
                }
                //lấy họ tên
                String ho_ten = edt_hoten.getText().toString();
                if (ho_ten.matches("")){
                    Toast.makeText(DangKyActivity.this, "Hãy nhập vào họ và tên", Toast.LENGTH_SHORT).show();
                    return;
                }
                //lấy mssv
                String mssv = (edt_mssv.getText().toString());
                if (edt_mssv.getText().toString().matches("")){
                    Toast.makeText(DangKyActivity.this, "Hãy nhập vào mã số sinh viên", Toast.LENGTH_SHORT).show();
                    return;
                }
                //lấy sdt
                String sdt = edt_sdt.getText().toString();
                if (sdt.matches("")){
                    Toast.makeText(DangKyActivity.this, "Hãy nhập vào số điện thoại", Toast.LENGTH_SHORT).show();
                    return;
                }
                //check nếu không tích vào môn học
                if (check_mon.isEmpty()){
                    Toast.makeText(DangKyActivity.this, "Bạn phải chọn môn học", Toast.LENGTH_SHORT).show();
                    return;
                }
                //check xem đã đăng kí chưa
                String check_querr = "SELECT * FROM SINHVIEN WHERE SINHVIEN.MSSV = ("+ "\""+mssv+"\"" +")";
                Cursor cursor = database.rawQuery(check_querr,null);
                if (cursor.getCount() != 0){
                    Toast.makeText(DangKyActivity.this, "Bạn đã đăng kí rồi, hãy vào mục sửa để sửa", Toast.LENGTH_SHORT).show();
                    return;
                }
                cursor.close();
                String insert_query = "INSERT INTO SINHVIEN(MSSV,SODT,HOTENSV) VALUES ("+ "\""+mssv+"\"" +","+sdt+","+"\"" + ho_ten + "\""+")";
                Log.d("query",insert_query);
                database.execSQL(insert_query);
                String insert_query_2 = "INSERT INTO BIENLAIHOCPHI (NGAYHP,MSSV) VALUES (date('now')," + "\""+mssv+"\"" + ")";
                database.execSQL(insert_query_2);
                cursor = database.rawQuery("SELECT * FROM BIENLAIHOCPHI WHERE MSSV = ("+"\""+mssv+"\""+")",null);
                cursor.moveToFirst();
                int so_bl = cursor.getInt(0);
                Log.d("so bien lai", String.valueOf(so_bl));
                for (int mon:check_mon){
                    database.execSQL("INSERT INTO THONGTINHOCPHI (SOBL,MAMH) VALUES("+so_bl+"," + mon+ ")");
                }
                database.execSQL("UPDATE THONGTINHOCPHI SET SOTIEN = (SELECT MONHOC.SOTIEN FROM MONHOC WHERE MONHOC.MAMH = THONGTINHOCPHI.MAMH) WHERE EXISTS(SELECT * FROM MONHOC WHERE MONHOC.MAMH = THONGTINHOCPHI.MAMH)");
                finish();
                Toast.makeText(DangKyActivity.this,"Đăng kí môn thành công",Toast.LENGTH_SHORT).show();

            }
        });
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void setControl() {
        edt_hoten = findViewById(R.id.edt_hoten);
        edt_mssv = findViewById(R.id.edt_mssv);
        edt_sdt = findViewById(R.id.edt_sdt);
        btn_dangky = findViewById(R.id.btn_dangky);
        btn_huy = findViewById(R.id.btn_huy);
        listView = findViewById(R.id.lv_dangky);
    }

    private void initDatabase() {
        database = Database.initDatabase(DangKyActivity.this, database_name);
        Cursor cursor = database.rawQuery("SELECT * from SINHVIEN", null);
        if (!cursor.moveToFirst()) {
            Toast.makeText(DangKyActivity.this, "Fail to connect to database", Toast.LENGTH_SHORT).show();
        }
    }

    private void readData() {

        arraylist = new ArrayList<>();
        adapter = new SuaMonAdapter(this, R.layout.sua_item, arraylist);
        listView.setAdapter(adapter);
        //lấy môn học từ bảng MONHOC
        Cursor cursor = database.rawQuery("SELECT * FROM MONHOC", null);
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            int ma_mh = cursor.getInt(0);
            String ten_mh = cursor.getString(1);
            int so_tc = cursor.getInt(2);
            String so_tien = cursor.getString(3);
            arraylist.add(new MonHoc(ten_mh,ma_mh,so_tc,so_tien,false));
        }
        adapter.notifyDataSetChanged();
    }
}

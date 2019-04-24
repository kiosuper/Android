package com.example.giuaky;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SuaActivity extends AppCompatActivity {
    final String database_name = "QLMH.sqlite";
    SQLiteDatabase database;
    ArrayList<MonHoc> arraylist;
    private ListView listView;
    SuaMonAdapter adapter;


    private EditText edt_mssv;
    private TextView txt_hoten;
    private TextView txt_so_dt;
    private TextView txt_mssv;
    private Button btn_sua;
    private Button btn_huy;
    private Button btn_capnhat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_layout);
        initDatabase();
        setControls();
        readData();
        setEvents();

    }

    private void setEvents() {
        btn_capnhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> check_mon = new ArrayList<>();
                //lấy các môn kèm giá trị checkbox
                for (int i=0;i<arraylist.size();i++){
                    if (arraylist.get(i).isSelected()){
                        check_mon.add(arraylist.get(i).ma_mh);
                    }
                }
                final String mssv = edt_mssv.getText().toString();
                if (mssv.matches("")){
                    Toast.makeText(SuaActivity.this,"Hãy nhập mssv",Toast.LENGTH_SHORT).show();
                    return;
                }
                //lấy số biên lai
                String get_so_bl_query = "SELECT * FROM BIENLAIHOCPHI WHERE MSSV = ?";
                Cursor cursor = database.rawQuery(get_so_bl_query,new String[]{mssv});
                cursor.moveToPosition(0);
                if (cursor.getCount() == 0){
                    Toast.makeText(SuaActivity.this,"Chỉ sinh viên đã đăng kí được sửa",Toast.LENGTH_SHORT).show();
                    return;
                }
                //lấy số biên lai của user
                final int so_bl = cursor.getInt(0);
                //Delete số biên lai cũ bảng
                cursor.close();
                String del_query = "DELETE FROM THONGTINHOCPHI WHERE SOBL = " + so_bl;
                database.execSQL(del_query);
                //Insert database theo các môn user đã tích ở trên
                if (check_mon.isEmpty()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SuaActivity.this);
                    builder.setTitle("Cảnh báo !!");
                    builder.setMessage("Bạn có muốn xóa học phần không ?");
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            database.execSQL("DELETE FROM THONGTINHOCPHI WHERE SOBL = "+ so_bl);
                            database.execSQL("DELETE FROM BIENLAIHOCPHI WHERE SOBL = "+so_bl);
                            database.execSQL("DELETE FROM SINHVIEN WHERE MSSV = ("+ "\""+mssv+"\"" +")");
                            finish();
                            Toast.makeText(SuaActivity.this,"Bạn đã xóa học phần !!",Toast.LENGTH_SHORT).show();
                        }
                    });
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    });
                    builder.create().show();
                }
                else {
                    for (int mon : check_mon) {
                        String insert_query = "INSERT INTO THONGTINHOCPHI (SOBL,MAMH) VALUES (" + so_bl + "," + mon + ")";
                        database.execSQL(insert_query);
                        //Update giá tiền
                        database.execSQL("UPDATE THONGTINHOCPHI SET SOTIEN = (SELECT MONHOC.SOTIEN FROM MONHOC WHERE MONHOC.MAMH = THONGTINHOCPHI.MAMH) WHERE EXISTS(SELECT * FROM MONHOC WHERE MONHOC.MAMH = THONGTINHOCPHI.MAMH)");
                        finish();
                        Toast.makeText(SuaActivity.this,"Cập nhật môn thành công",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void readData() {
        //đọc data + đổ lên màn hình
        listView = findViewById(R.id.lv_xem);
        arraylist = new ArrayList<>();
        adapter = new SuaMonAdapter(this, R.layout.sua_item, arraylist);
        listView.setAdapter(adapter);
        //btn_lấy thông tin
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arraylist.clear();
                ArrayList<Integer> checklist = new ArrayList<>();
                String mssv = edt_mssv.getText().toString();
                //check edit text null
                if (mssv.matches("")){
                    Toast.makeText(SuaActivity.this,"Hãy nhập mssv",Toast.LENGTH_SHORT).show();
                    return;
                }
                //lấy  tên + sdt sinh viên
                String query = "SELECT SINHVIEN.HOTENSV,SINHVIEN.SODT FROM SINHVIEN WHERE SINHVIEN.MSSV = ("+ "\""+mssv+"\"" +")";
                Cursor cursor = database.rawQuery(query,null);
                if (cursor.getCount() == 0){
                    Toast.makeText(SuaActivity.this,"Chỉ sinh viên đã đăng kí được sửa",Toast.LENGTH_SHORT).show();
                    return;
                }
                cursor.moveToFirst();
                String name = cursor.getString(0);
                String sdt = cursor.getString(1);
                txt_hoten.setText(name);
                txt_mssv.setText(mssv);
                txt_so_dt.setText(sdt);
                cursor.close();
                String query_2 = "SELECT DISTINCT MONHOC.MAMH FROM MONHOC,THONGTINHOCPHI,BIENLAIHOCPHI,SINHVIEN WHERE THONGTINHOCPHI.MAMH = MONHOC.MAMH AND (((THONGTINHOCPHI.SOBL = BIENLAIHOCPHI.SOBL) AND BIENLAIHOCPHI.MSSV = SINHVIEN.MSSV) AND SINHVIEN.MSSV = (" + "\""+mssv+"\"" + "))";
                //check xem mssv có trong database không
                cursor = database.rawQuery(query_2, null);
                for (int j = 0; j < cursor.getCount(); j++) {
                    cursor.moveToPosition(j);
                    int id = cursor.getInt(0);
                    checklist.add(id);
                }
                cursor.close();
                //lấy dữ liệu môn học
                String get_MONHOC_query = "SELECT * FROM MONHOC";
                cursor = database.rawQuery(get_MONHOC_query, null);
                for (int i = 0; i < cursor.getCount(); i++) {
                    cursor.moveToPosition(i);
                    boolean checked = false;
                    int ma_mh = cursor.getInt(0);
                    String ten_mh = cursor.getString(1);
                    int so_tc = cursor.getInt(2);
                    String so_tien = cursor.getString(3);
                    int len = 0;
                    while (len < checklist.size()) {
                        if (checklist.get(len) == ma_mh) {
                            checked = true;
                            break;
                        }
                        len += 1;
                    }
                    arraylist.add(new MonHoc(ten_mh, ma_mh, so_tc, so_tien, checked));
                }
                cursor.close();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void setControls() {
        edt_mssv = findViewById(R.id.edt_mssv);
        txt_hoten = findViewById(R.id.txt_hoten);
        txt_mssv = findViewById(R.id.txt_mssv);
        txt_so_dt = findViewById(R.id.txt_so_dt);
        btn_huy = findViewById(R.id.btn_huy);
        btn_sua = findViewById(R.id.btn_sua);
        btn_capnhat = findViewById(R.id.btn_capnhat);
    }

    public void initDatabase() {
        //khởi tạo database
        database = Database.initDatabase(SuaActivity.this, database_name);
        Cursor cursor = database.rawQuery("SELECT * from SINHVIEN", null);
        if (!cursor.moveToFirst()) {
            Toast.makeText(SuaActivity.this, "Fail to connect to database", Toast.LENGTH_SHORT).show();
        }
    }
}

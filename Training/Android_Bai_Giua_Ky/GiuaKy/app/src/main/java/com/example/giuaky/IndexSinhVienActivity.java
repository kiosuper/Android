package com.example.giuaky;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class IndexSinhVienActivity extends AppCompatActivity {
    final String database_name = "QLMH.sqlite";
    SQLiteDatabase database;
    String mssv;

    private Spinner spinner_mssv;
    private Button btn_dangki;
    private Button btn_sua;
    private Button btn_thoat;
    private Button btn_xem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_sinhvien);
        initDatabase();
        setControl();
        setEvent();
    }

    private void setControl() {
        btn_dangki = findViewById(R.id.btn_dangki);
        btn_sua = findViewById(R.id.btn_sua);
        btn_thoat = findViewById(R.id.btn_thoat);
        spinner_mssv = findViewById(R.id.spinner_mssv);
        btn_xem = findViewById(R.id.btn_xem);
    }

    private void initDatabase() {
        database = Database.initDatabase(IndexSinhVienActivity.this, database_name);
        Cursor cursor = database.rawQuery("SELECT * from SINHVIEN", null);
        if (!cursor.moveToFirst()) {
            Toast.makeText(IndexSinhVienActivity.this, "Fail to connect to database", Toast.LENGTH_SHORT).show();
        }
    }

    private void setEvent() {
        //lấy mssv đặt vào drop down list
        ArrayList<String> array_mssv = new ArrayList<>();
        final String mssv_query = "SELECT MSSV FROM SINHVIEN";
        Cursor cursor = database.rawQuery(mssv_query,null);
        for (int i =0;i<cursor.getCount();i++){
            cursor.moveToPosition(i);
            String mssv = cursor.getString(0);
            array_mssv.add(mssv);
        }
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(IndexSinhVienActivity.this,R.layout.spinner_item,array_mssv);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        spinner_mssv.setAdapter(adapter);
        spinner_mssv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mssv = spinner_mssv.getSelectedItem().toString();
                Log.d("mssv",mssv);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn_dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check xem có đăng kí chưa, nếu có rồi thì không cho đăng kí nữa
                String check_querr = "SELECT * FROM BIENLAIHOCPHI WHERE MSSV = ("+ "\""+mssv+"\"" +")";
                Cursor cursor = database.rawQuery(check_querr,null);
                if (cursor.getCount() != 0){
                    Toast.makeText(IndexSinhVienActivity.this, "Bạn đã đăng kí rồi, hãy vào mục sửa để sửa", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(IndexSinhVienActivity.this,DangKyActivity.class);
                intent.putExtra("mssv", mssv);
                startActivity(intent);
            }
        });
        btn_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check_querr = "SELECT * FROM BIENLAIHOCPHI WHERE MSSV = ("+ "\""+mssv+"\"" +")";
                Cursor cursor = database.rawQuery(check_querr,null);
                if (cursor.getCount() == 0){
                    Toast.makeText(IndexSinhVienActivity.this, "Bạn chưa đăng kí học phần, hãy đăng kí", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(IndexSinhVienActivity.this,SuaActivity.class);
                intent.putExtra("mssv", mssv);
                startActivity(intent);
            }
        });
        btn_xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check_querr = "SELECT * FROM BIENLAIHOCPHI WHERE MSSV = ("+ "\""+mssv+"\"" +")";
                Cursor cursor = database.rawQuery(check_querr,null);
                if (cursor.getCount() == 0){
                    Toast.makeText(IndexSinhVienActivity.this, "Bạn chưa đăng kí học phần, hãy đăng kí", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(IndexSinhVienActivity.this,XemActivity.class);
                intent.putExtra("mssv", mssv);
                startActivity(intent);
            }
        });
        btn_thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}

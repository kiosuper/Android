package com.example.tuan6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView1;
    ArrayList<MonHoc> data = new ArrayList<>();
    MonHocAdapter adapter = null;
    Button btnInsert, btnDelete, btnExit, btnUpdate;
    EditText mamh, tenmh, sotiet;
    int index=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvents();
    }

    public void setControl() {
        listView1 = findViewById(R.id.listView1);
        btnDelete = findViewById(R.id.delete);
        btnExit = findViewById(R.id.exit);
        btnInsert = findViewById(R.id.insert);
        btnUpdate = findViewById(R.id.update);
        mamh = findViewById(R.id.maMH);
        tenmh = findViewById(R.id.tenMH);
        sotiet = findViewById(R.id.soTiet);
    }

    public void setEvents() {
        adapter = new MonHocAdapter(this, R.layout.listview_item_row, data);
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MonHoc mh = data.get(position);
                index=position;
                mamh.setText(mh.getMaMH());
                tenmh.setText(mh.getTenMH());
                sotiet.setText(mh.getSoTiet());
            }
        });

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InsertMH();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateMH();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteMH();
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    private MonHoc getMonHoc() {
        MonHoc monHoc = new MonHoc();
        monHoc.setMaMH(mamh.getText().toString());
        monHoc.setTenMH(tenmh.getText().toString());
        monHoc.setSoTiet(sotiet.getText().toString());
        return monHoc;
    }

    public void InsertMH() {
        MonHoc monHoc = getMonHoc();
        data.add(monHoc);
        adapter.notifyDataSetChanged();
    }

    public void DeleteMH() {
        if(index>=0) {
            data.remove(index);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Xóa không thành công", Toast.LENGTH_SHORT).show();
    }

    public void updateMH()
    {
        String ma = mamh.getText().toString();
        String ten = tenmh.getText().toString();
        String st = sotiet.getText().toString();
        data.get(index).setMaMH(ma);
        data.get(index).setTenMH(ten);
        data.get(index).setSoTiet(st);
        Toast.makeText(this, "Update Thành Công!", Toast.LENGTH_SHORT).show();
        adapter.notifyDataSetChanged();
    }
}

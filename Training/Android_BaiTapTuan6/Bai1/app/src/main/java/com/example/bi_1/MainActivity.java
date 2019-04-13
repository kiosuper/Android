package com.example.bi_1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText maNV;
    private EditText tenNV;

    private RadioGroup choose_sex;
    private RadioButton male;
    private RadioButton female;

    private Button btnSubmit;
    private Button btnRemove;

    private ListView listView;
    private ImageView icon;
    private CheckBox checkBox;


    ArrayList<nhan_vien> data = new ArrayList<>();
    NvAdapter adapter = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();


    }

    public void setControl() {

        tenNV = findViewById(R.id.TenNV);
        maNV = findViewById(R.id.MaNV);
        choose_sex = findViewById(R.id.radioGroup);
        male = findViewById(R.id.radioBtnmale);
        female = findViewById(R.id.radioBtnfemale);

        btnRemove = findViewById(R.id.remove);
        btnSubmit = findViewById(R.id.submit);

        listView = findViewById(R.id.listView);
        data = new ArrayList<nhan_vien>();
        icon = findViewById(R.id.avatar);

        listView.setAdapter(adapter);


    }

    public void setEvent() {

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delete();

            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                for(int i=0; i < listView.getChildCount() ;i++){
                    if(position == i)
                    {
                        listView.getChildAt(i).setBackgroundColor(Color.parseColor("#92F2C2"));
                    }
                }

            }
        });


    }

    public void input() {
        String getMaNV = maNV.getText() + "";
        String getTenNV = tenNV.getText() + "";
        String infoNV = getMaNV.concat("-").concat(getTenNV);

        if (choose_sex.getCheckedRadioButtonId() == R.id.radioBtnmale) {
            data.add(new nhan_vien(R.drawable.boy, infoNV, false));

        } else {
            data.add(new nhan_vien(R.drawable.girl, infoNV, false));

        }

        NvAdapter adapter = new NvAdapter(this, R.layout.row, data);
        listView.setAdapter(adapter);

        adapter.notifyDataSetChanged();
        tenNV.setText("");
        maNV.setText("");
        maNV.requestFocus();
    }

    public void delete() {


        for (int i = listView.getChildCount() - 1; i >= 0; i--) {
            View view = listView.getChildAt(i);
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.Check);
            if (checkBox.isChecked()) {
                data.remove(i);
            }
        }
        NvAdapter adapter = new NvAdapter(this, R.layout.row, data);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}

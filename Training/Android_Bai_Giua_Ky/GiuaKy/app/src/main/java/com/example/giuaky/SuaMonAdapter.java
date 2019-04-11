package com.example.giuaky;

import android.app.Activity;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class SuaMonAdapter extends ArrayAdapter <MonHoc>{
    Context context;
    int layoutResourceId;
    ArrayList<MonHoc> data = null;
    SparseBooleanArray mCheckStates;

    public SuaMonAdapter(Context context, int layoutResourceId, ArrayList<MonHoc> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
        mCheckStates = new SparseBooleanArray(data.size());
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MonHocHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new MonHocHolder();
            holder.ma_mh = row.findViewById(R.id.txt_ma_mh);
            holder.ten_mh = row.findViewById(R.id.txt_ten_mh);
            holder.so_tc = row.findViewById(R.id.txt_so_tc);
            holder.so_tien = row.findViewById(R.id.txt_thanhtien);
            holder.cb_chon = row.findViewById(R.id.cb_chon);
            row.setTag(holder);

        } else {
            holder = (MonHocHolder) row.getTag();
        }

        MonHoc item = data.get(position);
        holder.ma_mh.setText(String.valueOf(item.ma_mh));
        holder.ten_mh.setText(item.ten_mh);
        holder.so_tc.setText(String.valueOf(item.so_tc));
        holder.so_tien.setText(String.valueOf(item.so_tien));
        holder.cb_chon.setChecked(item.isSelected());
        holder.cb_chon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data.get(position).isSelected()){
                    data.get(position).setSelected(false);
                }
                else {
                    data.get(position).setSelected(true);
                }
            }
        });
        return row;

    }

    static class MonHocHolder {
        TextView ma_mh;
        TextView ten_mh;
        TextView so_tc;
        TextView so_tien;
        CheckBox cb_chon;
    }
}
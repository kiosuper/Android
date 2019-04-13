package com.example.bi_1;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NvAdapter extends ArrayAdapter<nhan_vien> {
    Context context;
    int layoutResoureid;
    ArrayList<nhan_vien> data = null;


    public NvAdapter(Context context, int layoutResoureid, List<nhan_vien> data) {
        super(context, layoutResoureid, data);
        this.context = context;
        this.layoutResoureid = layoutResoureid;
        this.data = (ArrayList<nhan_vien>) data;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        HolderNhanVien holder = null;


        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResoureid, parent, false);
            holder = new HolderNhanVien();
            holder.holderIcon = row.findViewById(R.id.avatar);
            holder.holderInfo = row.findViewById(R.id.infoNhanVien);
            holder.holderCheck = row.findViewById(R.id.Check);

            row.setTag(holder);
        } else {
            holder = (HolderNhanVien) row.getTag();


        }
        nhan_vien item = data.get(position);

        holder.holderIcon.setImageResource(item.icon);
        holder.holderInfo.setText(item.info);
        holder.holderCheck.setChecked(item.checkBox);

        return row;
    }

    static class HolderNhanVien {
        ImageView holderIcon;
        TextView holderInfo;
        CheckBox holderCheck;

    }
}

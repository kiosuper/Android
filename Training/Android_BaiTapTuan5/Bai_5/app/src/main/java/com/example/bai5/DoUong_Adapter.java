package com.example.bai5;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DoUong_Adapter extends ArrayAdapter<DoUong> {
    Context context;
    int layoutResourceId;
    ArrayList<DoUong> data = null;

    public DoUong_Adapter(Context context, int layoutResourceId, ArrayList<DoUong> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        DoUong_Holder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);


            holder = new DoUong_Holder();
            holder.imgIcon = row.findViewById(R.id.imgIcon);
            holder.txtCountry = row.findViewById(R.id.txt_item);

            row.setTag(holder);
        } else {
            holder = (DoUong_Holder) row.getTag();
        }

        DoUong item = data.get(position);
        holder.txtCountry.setText(item.name);
        holder.imgIcon.setImageResource(item.icon);

        return row;
    }

    static class DoUong_Holder {
        ImageView imgIcon;
        TextView txtCountry;
    }
}

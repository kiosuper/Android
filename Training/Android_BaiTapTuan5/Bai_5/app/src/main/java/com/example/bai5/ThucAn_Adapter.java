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

public class ThucAn_Adapter extends ArrayAdapter<ThucAn> {
    Context context;
    int layoutResourceId;
    ArrayList<ThucAn> data = null;

    public ThucAn_Adapter(Context context, int layoutResourceId, ArrayList<ThucAn> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ThucAn_Holder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new ThucAn_Holder();
            holder.imgIcon = row.findViewById(R.id.imgIcon);
            holder.txtCountry = row.findViewById(R.id.txt_item);

            row.setTag(holder);
        } else {
            holder = (ThucAn_Holder) row.getTag();
        }

        ThucAn item = data.get(position);
        holder.txtCountry.setText(item.name);
        holder.imgIcon.setImageResource(item.icon);

        return row;
    }

    static class ThucAn_Holder {
        ImageView imgIcon;
        TextView txtCountry;
    }
}
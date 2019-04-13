package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerAdapter extends ArrayAdapter<Player> {
    Context context;
    int layoutResourceId;
    ArrayList<Player> data = null;
    public PlayerAdapter(Context context, int layoutResourceId, ArrayList<Player> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PlayerHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new PlayerHolder();
            holder.img_avatar = row.findViewById(R.id.img_avatar);
            holder.txt_name = row.findViewById(R.id.player_name);
            holder.txt_team = row.findViewById(R.id.txt_team);
            holder.txt_number = row.findViewById(R.id.txt_number);

            row.setTag(holder);
        } else {
            holder = (PlayerHolder) row.getTag();
        }

        Player item = data.get(position);
        holder.txt_name.setText(item.name);
        holder.img_avatar.setImageResource(item.avatar);
        holder.txt_number.setText(item.number);
        holder.txt_team.setText(item.team);
        return row;
    }
    static class PlayerHolder {
        ImageView img_avatar;
        TextView txt_name;
        TextView txt_team;
        TextView txt_number;
    }
}

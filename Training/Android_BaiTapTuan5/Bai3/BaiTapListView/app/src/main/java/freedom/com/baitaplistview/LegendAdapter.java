package freedom.com.baitaplistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LegendAdapter extends ArrayAdapter<Legend> {
    Context context;
    int layoutResourceId;
    ArrayList<Legend> data = null;

    public LegendAdapter(Context context, int layoutResourceId, ArrayList<Legend> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LegendHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new LegendHolder();
            holder.img = row.findViewById(R.id.imgLegend);
            holder.txtName = row.findViewById(R.id.name);
            holder.txtBorn = row.findViewById(R.id.born);
            holder.nation = row.findViewById(R.id.nation);

            row.setTag(holder);
        } else {
            holder = (LegendHolder) row.getTag();
        }

        Legend item = data.get(position);
        holder.img.setImageResource(item.img);
        holder.txtName.setText(item.name);
        holder.txtBorn.setText(item.born);
        holder.nation.setImageResource(item.nation);

        return row;
    }

    static class LegendHolder {
        ImageView img;
        TextView txtName;
        TextView txtBorn;
        ImageView nation;
    }
}

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

public class CountryAdapter extends ArrayAdapter<Country> {
    Context context;
    int layoutResourceId;
    ArrayList<Country> data = null;

    public CountryAdapter(Context context, int layoutResourceId, ArrayList<Country> data) {
        super(context, layoutResourceId, data);
        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CountryHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);


            holder = new CountryHolder();
            holder.imgIcon = row.findViewById(R.id.imgIcon);
            holder.txtCountry = row.findViewById(R.id.txtCountry);
            holder.txtPopulation = row.findViewById(R.id.txtPopulation);

            row.setTag(holder);
        } else {
            holder = (CountryHolder) row.getTag();
        }

        Country item = data.get(position);
        holder.txtCountry.setText(item.name);
        holder.imgIcon.setImageResource(item.icon);
        holder.txtPopulation.setText("Population: " + String.valueOf(item.populations));

        return row;
    }

    static class CountryHolder {
        ImageView imgIcon;
        TextView txtCountry;
        TextView txtPopulation;
    }
}

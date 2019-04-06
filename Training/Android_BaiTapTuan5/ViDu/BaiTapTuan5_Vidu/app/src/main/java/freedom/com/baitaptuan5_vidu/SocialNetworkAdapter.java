package freedom.com.baitaptuan5_vidu;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SocialNetworkAdapter extends ArrayAdapter<SocialNetwork> {

    Context context;
    int layoutResourceId;
    ArrayList<SocialNetwork> data = null;

    public SocialNetworkAdapter(Context context, int layoutResourceId, ArrayList<SocialNetwork> data) {
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
            holder.txtCountry = row.findViewById(R.id.txtTitle);


            row.setTag(holder);
        } else {
            holder = (CountryHolder) row.getTag();
        }

        SocialNetwork item = data.get(position);
        holder.txtCountry.setText(item.title);
        holder.imgIcon.setImageResource(item.icon);

        return row;
    }

    static class CountryHolder {
        ImageView imgIcon;
        TextView txtCountry;
    }
}

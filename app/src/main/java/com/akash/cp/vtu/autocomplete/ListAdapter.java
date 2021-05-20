package com.akash.cp.vtu.autocomplete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListAdapter /*extends ArrayAdapter<User>*/ {
   /* private int resourceLayout;
    private Context mContext;

    public ListAdapter(Context context, int resource, List<User> items) {
        super(context, resource, items);
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        User p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.name);
            ImageView imageView=(ImageView)v.findViewById(R.id.profileimage);

            if (tt1 != null) {
                tt1.setText(p.getName());
            }
            if(imageView!=null)
            {
                Glide.with(mContext).load(p.getProfileUrl()).into(imageView);
            }

        }

        return v;
    }*/
}

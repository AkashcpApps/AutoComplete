package com.akash.cp.vtu.autocomplete;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


    public class CustomListAdapter extends ArrayAdapter<User> {

        private List<User> dataList;
        private Context mContext;
        private int itemLayout;

        private ListFilter listFilter = new ListFilter();
        private List<User> dataListAllItems;



        public CustomListAdapter(Context context, int resource, List<User> storeDataLst) {
            super(context, resource, storeDataLst);
            dataList = storeDataLst;
            mContext = context;
            itemLayout = resource;
        }

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public User getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public View getView(int position, View view, @NonNull ViewGroup parent) {

            if (view == null) {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(itemLayout, parent, false);
            }

            TextView strName = (TextView) view.findViewById(R.id.user_name);
            strName.setText(getItem(position).getName());
            ImageView imageView=(ImageView)view.findViewById(R.id.profileimage);
            Glide.with(mContext).load(getItem(position).getProfileUrl()).circleCrop().into(imageView);
            return view;
        }

        @NonNull
        @Override
        public Filter getFilter() {
            return listFilter;
        }

        public class ListFilter extends Filter {
            private Object lock = new Object();

            @Override
            protected FilterResults performFiltering(CharSequence prefix) {
                FilterResults results = new FilterResults();
                if (dataListAllItems == null) {
                    synchronized (lock) {
                        dataListAllItems = new ArrayList<User>(dataList);
                    }
                }

                if (prefix == null || prefix.length() == 0) {
                    synchronized (lock) {
                        results.values = dataListAllItems;
                        results.count = dataListAllItems.size();
                    }
                } else {
                    final String searchStrLowerCase = prefix.toString().toLowerCase();

                    ArrayList<User> matchValues = new ArrayList<User>();

                    for (User dataItem : dataListAllItems) {
                        if (dataItem.getName().toLowerCase().startsWith(searchStrLowerCase)) {
                            matchValues.add(dataItem);
                        }
                    }

                    results.values = matchValues;
                    results.count = matchValues.size();
                }

                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results.values != null) {
                    dataList = (ArrayList<User>)results.values;
                } else {
                    dataList = null;
                }
                if (results.count > 0) {
                    notifyDataSetChanged();
                } else {
                    notifyDataSetInvalidated();
                }
            }
            @Override
            public CharSequence convertResultToString(Object resultValue) {
                return ((User) resultValue).getName();
            }

        }
    }

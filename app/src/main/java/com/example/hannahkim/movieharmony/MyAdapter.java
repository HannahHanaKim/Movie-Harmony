package com.example.hannahkim.movieharmony;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
    Context mContext;

    public String[] movie_names = {"데드풀", "독전", "버닝", "어벤져스:인피니티 워", "피터 래빗"};

    public MyAdapter(Context context) {
        mContext = context;
    }

    public int getCount() {
        return movie_names.length;
    }

    public Object getItem(int position) {
        return movie_names[position];
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = new TextView(mContext);
        view.setText(movie_names[position]);
        return view;
    }
}

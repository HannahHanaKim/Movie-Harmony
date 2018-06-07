package com.example.hannahkim.movieharmony;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater;
    ArrayList<MovieItem> data;
    //ImageLoader imageLoader;

    HashMap<String, String> resultp = new HashMap<String, String>();

    public MovieAdapter(Context context, ArrayList<MovieItem> arrayList) {
        this.context = context;
        data = arrayList;
        //imageLoader = new ImageLoader(context);
    }

    public int getCount() {
        return data.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        TextView textView;

        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.listview_item, parent, false);

        //resultp = data.get(position);

        imageView = (ImageView)itemView.findViewById(R.id.imageView);
        textView = (TextView)itemView.findViewById(R.id.textView);

        //textView.setText(resultp.get(MainActivity.MOVIE_NAME));

        return itemView;

    }
}

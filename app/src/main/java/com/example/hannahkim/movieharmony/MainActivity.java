package com.example.hannahkim.movieharmony;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        ArrayList<String> data = new ArrayList<>();

        data.add("movie_1");
        data.add("movie_2");
        data.add("movie_3");
        data.add("movie_4");
        data.add("movie_5");



        CustomAdapter adapter = new CustomAdapter(this, 0, data);
        listView.setAdapter(adapter);

        /*listView.setOnItemClickListener(new AdapterView.OnClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView1 = (ListView) parent;


            }
        });*/
    }

    private class CustomAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;

        public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;

            if (v==null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.item, null);
            }

            ImageView imageView = (ImageView)v.findViewById(R.id.imageView);

            if("movie_1".equals(items.get(position)))
                imageView.setImageResource(R.drawable.movie_1);
            else if("movie_2".equals(items.get(position)))
                imageView.setImageResource(R.drawable.movie_2);
            else if("movie_3".equals(items.get(position)))
                imageView.setImageResource(R.drawable.movie_3);
            else if("movie_4".equals(items.get(position)))
                imageView.setImageResource(R.drawable.movie_4);
            else if("movie_5".equals(items.get(position)))
                imageView.setImageResource(R.drawable.movie_5);

            TextView textView = (TextView)v.findViewById(R.id.textView);
            textView.setText(items.get(position));

            final String text = items.get(position);

            return v;
        }
    }

}

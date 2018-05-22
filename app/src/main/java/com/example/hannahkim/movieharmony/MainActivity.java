package com.example.hannahkim.movieharmony;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ListViewItem> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        data.add(new ListViewItem(R.drawable.movie_1, "movie_1"));
        data.add(new ListViewItem(R.drawable.movie_2, "movie_2"));
        data.add(new ListViewItem(R.drawable.movie_3, "movie_3"));
        data.add(new ListViewItem(R.drawable.movie_4, "movie_4"));
        data.add(new ListViewItem(R.drawable.movie_5, "movie_5"));

        MyAdapter adapter = new MyAdapter(this, R.layout.item, data);
        listView.setAdapter(adapter);

        //listView click event handling
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Theater.class);
                intent.putExtra("movie_name", data.get(position).getName());
                startActivity(intent);
            }
        });
    }
}

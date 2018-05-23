package com.example.hannahkim.movieharmony;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ListViewItem> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        data.add(new ListViewItem(R.drawable.movie_1, "데드풀 2"));
        data.add(new ListViewItem(R.drawable.movie_2, "어벤져스: 인피니티 워"));
        data.add(new ListViewItem(R.drawable.movie_3, "버닝"));
        data.add(new ListViewItem(R.drawable.movie_4, "피터 래빗"));
        data.add(new ListViewItem(R.drawable.movie_5, "독전"));

        MyAdapter adapter = new MyAdapter(this, R.layout.item, data);
        listView.setAdapter(adapter);

        //listView click event handling
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "send msg: " + data.get(position).name, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Theater.class);
                intent.putExtra("image", data.get(position).image);
                intent.putExtra("movie_name", data.get(position).name);
                startActivity(intent);
            }
        });
    }
}

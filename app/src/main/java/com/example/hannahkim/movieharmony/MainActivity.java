package com.example.hannahkim.movieharmony;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.movie_name);
        MyAdapter adapter = new MyAdapter(this);
        listView.setAdapter(adapter);

        Intent intent = new Intent();

        /*listView.setOnItemClickListener(new AdapterView.OnClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView1 = (ListView) parent;


            }
        });*/
    }
}

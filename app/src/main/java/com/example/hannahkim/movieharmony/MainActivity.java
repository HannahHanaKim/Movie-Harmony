package com.example.hannahkim.movieharmony;

import android.content.Context;
import android.os.AsyncTask;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainActivity extends BaseActivity {
    //파싱할 홈페이지 주소
    private String url = "http://www.cgv.co.kr/movies/";
    Elements content;
    ArrayList<HashMap<ImageView, String>>arrayList;

    MovieAdapter adapter;
    ListView listView;
    ArrayList<MovieItem> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsoupListView().execute();
        listView = (ListView)findViewById(R.id.listView);

        /*data.add(new MovieItem(R.drawable.movie_1, "데드풀 2"));*/

        //listView click event handling
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), TheaterActivity.class);
                intent.putExtra("image", data.get(position).imgSrc);
                intent.putExtra("movie_name", data.get(position).name);
                startActivity(intent);
            }
        });
    } //onCreate

    private class JsoupListView extends AsyncTask<Void, Void, Void> {
        protected void onPreExecute() {
            super.onPreExecute();
        }

        protected Void doInBackground(Void...params) {
           // arrayList = new ArrayList<HashMap<String, String>>();

            try {
                //connect to the Website URL
                Document doc = Jsoup.connect(url).get();
                content = doc.select("div.sect-movie-chart");

                for(Element movies : content) { //only top 5 movies
                    String imgSrc = doc.select("img").attr("src");
                    String name = doc.select("strong").text();
                    //String src = movies.absUrl("src");

                    //change image element to imageView
                    data.add(new MovieItem(imgSrc, name));

                }
                //Elements image = doc.select("span.thumb-image img");

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    protected void onPostExecute(Void result) {
        listView = (ListView)findViewById(R.id.listView);
        adapter = new MovieAdapter(MainActivity.this, data);
        listView.setAdapter(adapter);
    }
}

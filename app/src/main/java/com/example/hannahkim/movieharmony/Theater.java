package com.example.hannahkim.movieharmony;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Theater extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theater);

        ImageView imageView = (ImageView)findViewById(R.id.selectedImage);
        TextView textView = (TextView)findViewById(R.id.selectedMovie);

        Intent intent = getIntent();
        imageView.setImageResource(intent.getIntExtra("image", 0));
        textView.setText("movie_name");
    }
}

package com.example.hannahkim.movieharmony;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class SelectTheater extends AppCompatActivity {

    ImageButton cgvBtn, megaboxBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_theater);

        cgvBtn = (ImageButton)findViewById(R.id.cgvBtn);
        megaboxBtn = (ImageButton)findViewById(R.id.megaboxBtn);

    }
}

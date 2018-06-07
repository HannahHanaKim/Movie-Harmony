package com.example.hannahkim.movieharmony;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    Button closeTheaterBtn;
    Button selectTheaterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        closeTheaterBtn = (Button)findViewById(R.id.closeTheaterBtn);
        selectTheaterBtn = (Button)findViewById(R.id.selectTheaterBtn);

        closeTheaterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Fragments.class);
                startActivity(intent);
            }
        });

        selectTheaterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SelectTheater.class);
                startActivity(intent);
            }
        });

    } //onCreate



}

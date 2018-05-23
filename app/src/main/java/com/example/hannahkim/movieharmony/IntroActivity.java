package com.example.hannahkim.movieharmony;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class IntroActivity extends AppCompatActivity {
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        progressBar.setMax(100);
        progressBar.setProgress(0);

        Thread introThread = new Thread() {
            public void run() {
                try {
                    // time = 20*100 = 2000milliseconds = seconds
                    for (int i = 0; i < 100; i++) {
                        progressBar.setProgress(i);
                        sleep(20);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };

        introThread.start();
    }
}

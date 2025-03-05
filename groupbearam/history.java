package com.example.groupbearam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class history extends AppCompatActivity {

    private ProgressBar progressBar, progressBar2, progressBar3, progressBar4, progressBar5, progressBar6;
    private ImageButton back, profile, steps, running, sleep, drinking, screenTime, biking, calendar, activity, achieve, clock;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar4 = findViewById(R.id.progressBar4);
        progressBar5 = findViewById(R.id.progressBar5);
        progressBar6 = findViewById(R.id.progressBar6);
        calendar = findViewById(R.id.calendar);
        activity = findViewById(R.id.activity);
        achieve = findViewById(R.id.achieve);
        clock = findViewById(R.id.clock);
        running = findViewById(R.id.running);
        sleep = findViewById(R.id.sleep);
        drinking = findViewById(R.id.drinking);
        screenTime = findViewById(R.id.screenTime);
        biking = findViewById(R.id.biking);
        steps = findViewById(R.id.steps);
        back = findViewById(R.id.back);
        profile = findViewById(R.id.profile);

        progressBar.setVisibility(View.INVISIBLE);
        progressBar2.setVisibility(View.INVISIBLE);
        progressBar3.setVisibility(View.INVISIBLE);
        progressBar4.setVisibility(View.INVISIBLE);
        progressBar5.setVisibility(View.INVISIBLE);
        progressBar6.setVisibility(View.INVISIBLE);

        steps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                progressBar.incrementProgressBy(15);
            }
        });

        running.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar2.setVisibility(View.VISIBLE);
                progressBar2.incrementProgressBy(15);
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar3.setVisibility(View.VISIBLE);
                progressBar3.incrementProgressBy(15);
            }
        });

        drinking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar4.setVisibility(View.VISIBLE);
                progressBar4.incrementProgressBy(15);
            }
        });

        screenTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar5.setVisibility(View.VISIBLE);
                progressBar5.incrementProgressBy(15);
            }
        });

        biking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar6.setVisibility(View.VISIBLE);
                progressBar6.incrementProgressBy(15);
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(history.this, calendar.class);
                startActivity(intent);
            }
        });

        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(history.this, activity.class);
                startActivity(intent);
            }
        });

        achieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(history.this, history.class);
                startActivity(intent);
            }
        });

        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(history.this, time.class);
                startActivity(intent);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(history.this, home.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(history.this, profile.class);
                startActivity(intent);
            }
        });

    }
}
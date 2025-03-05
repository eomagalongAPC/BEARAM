package com.example.groupbearam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Time;

public class activity extends AppCompatActivity {

    private ProgressBar progressBar, progressBar2, progressBar3, progressBar4, progressBar5;
    private ImageButton back, profile, run, sleeping, drink, eat, exercise, calendar, activity, achieve, clock;
    private TextView textViewProgressBar2, textViewProgressBar3, textViewProgressBar4, textViewProgressBar5, textViewProgressBar6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_); // Make sure your layout file is named accordingly

        // Initialize ImageButtons
        calendar = findViewById(R.id.calendar);
        activity = findViewById(R.id.activity);
        achieve = findViewById(R.id.achieve);
        clock = findViewById(R.id.clock);
        drink = findViewById(R.id.drink);
        eat = findViewById(R.id.eat);
        exercise = findViewById(R.id.exercise);
        sleeping = findViewById(R.id.sleeping);
        run = findViewById(R.id.run);
        back = findViewById(R.id.back);
        profile = findViewById(R.id.profile);

        // Initialize ProgressBars
        progressBar = findViewById(R.id.progressBar);
        progressBar2 = findViewById(R.id.progressBar2);
        progressBar3 = findViewById(R.id.progressBar3);
        progressBar4 = findViewById(R.id.progressBar4);
        progressBar5 = findViewById(R.id.progressBar5);

        // Initialize TextViews for ProgressBars
        textViewProgressBar2 = findViewById(R.id.textViewProgressBar2);
        textViewProgressBar3 = findViewById(R.id.textViewProgressBar3);
        textViewProgressBar4 = findViewById(R.id.textViewProgressBar4);
        textViewProgressBar5 = findViewById(R.id.textViewProgressBar5);
        textViewProgressBar6 = findViewById(R.id.textViewProgressBar6);

        // Set onClickListeners for buttons
        run.setOnClickListener(view -> incrementProgress(progressBar, textViewProgressBar2));
        eat.setOnClickListener(view -> incrementProgress(progressBar2, textViewProgressBar3));
        sleeping.setOnClickListener(view -> incrementProgress(progressBar3, textViewProgressBar4));
        exercise.setOnClickListener(view -> incrementProgress(progressBar4, textViewProgressBar5));
        drink.setOnClickListener(view -> incrementProgress(progressBar5, textViewProgressBar6));

        back.setOnClickListener(view -> startActivity(new Intent(activity.this, home.class)));
        profile.setOnClickListener(view -> startActivity(new Intent(activity.this, profile.class)));
        calendar.setOnClickListener(view -> startActivity(new Intent(activity.this, calendar.class)));
        activity.setOnClickListener(view -> startActivity(new Intent(activity.this, activity.class))); // Consider changing this
        achieve.setOnClickListener(view -> startActivity(new Intent(activity.this, history.class)));
        clock.setOnClickListener(view -> startActivity(new Intent(activity.this, time.class)));
    }

    private void incrementProgress(ProgressBar progressBar, TextView textView) {
        progressBar.setVisibility(View.VISIBLE);
        if (progressBar.getProgress() < 100) {
            progressBar.incrementProgressBy(15); // Increment by 15
            if (progressBar.getProgress() > 100) {
                progressBar.setProgress(100); // Ensure it doesn't exceed 100
            }
            updateProgressText(progressBar, textView);
        }
    }

    private void updateProgressText(ProgressBar progressBar, TextView textView) {
        int progress = progressBar.getProgress();
        textView.setText(progress + "%");
    }
}
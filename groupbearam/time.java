package com.example.groupbearam;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class time extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button start, thirty_sec;
    private ImageButton back, profile, calendar, activity, achieve, clock;
    private TextView timerView;
    private EditText timeInput;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        calendar = findViewById(R.id.calendar);
        activity = findViewById(R.id.activity);
        achieve = findViewById(R.id.achieve);
        clock = findViewById(R.id.clock);
        progressBar = findViewById(R.id.progressBar);
        back = findViewById(R.id.back);
        profile = findViewById(R.id.profile);
        start = findViewById(R.id.startBtn);
        thirty_sec = findViewById(R.id.thirty);
        timerView = findViewById(R.id.timeView);
        timeInput = findViewById(R.id.time);

        thirty_sec.setOnClickListener(v -> setTime(30));

        progressBar.setVisibility(View.INVISIBLE);

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(time.this, calendar.class);
                startActivity(intent);
            }
        });

        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(time.this, activity.class);
                startActivity(intent);
            }
        });

        achieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(time.this, history.class);
                startActivity(intent);
            }
        });

        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(time.this, time.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(time.this, home.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(time.this, profile.class);
                startActivity(intent);
            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                startAlert();
            }
        });

    }

    private void setTime(int seconds) {
        timeInput.setText(String.valueOf(seconds));
    }

    // Method to start the alert with the time in EditText
    private void startAlert() {
        int i;
        try {
            i = Integer.parseInt(timeInput.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(time.this, "Please enter a valid time", Toast.LENGTH_SHORT).show();
            return;
        }

        // Start the countdown timer
        startCountdown(i);

        Intent intent = new Intent(time.this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(time.this.getApplicationContext(), 234324243, intent, PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i * 1000L), pendingIntent);
        Toast.makeText(time.this, "Alarm set in " + i + " seconds", Toast.LENGTH_LONG).show();
    }

    // Method to start the countdown timer
    private void startCountdown(int seconds) {
        timerView.setVisibility(View.VISIBLE); // Show the timer view

        new CountDownTimer(seconds * 1000L, 1000) {
            public void onTick(long millisUntilFinished) {
                timerView.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timerView.setText("Time is up!");
                timerView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
                progressBar.setVisibility(View.INVISIBLE);
            }
        }.start();
    }
}

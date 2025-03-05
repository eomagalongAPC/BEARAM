package com.example.groupbearam;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class calendar extends AppCompatActivity {

    private CalendarView calendarView;
    private TextView selected_date;
    private ImageButton back, profile, calendar, activity, achieve, clock;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendar = findViewById(R.id.calendar);
        activity = findViewById(R.id.activity);
        achieve = findViewById(R.id.achieve);
        clock = findViewById(R.id.clock);
        calendarView = findViewById(R.id.calendarView);
        selected_date = findViewById(R.id.selected_date);
        back = findViewById(R.id.back);
        profile = findViewById(R.id.profile);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            // Create a date object from the selected date
            Date date = new Date(year - 1900, month, dayOfMonth);
            // Format the date to a readable string
            SimpleDateFormat sdf = new SimpleDateFormat("MMMM/dd/yyyy", Locale.getDefault());
            String formattedDate = sdf.format(date);
            // Set the formatted date to the TextView
            selected_date.setText(formattedDate);
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(calendar.this, home.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(calendar.this, profile.class);
                startActivity(intent);
            }
        });

        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(calendar.this, calendar.class);
                startActivity(intent);
            }
        });

        activity.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(calendar.this, activity.class);
                        startActivity(intent);
                    }
                });

        achieve.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(calendar.this, history.class);
                        startActivity(intent);
                    }
                });

        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(calendar.this, time.class);
                startActivity(intent);
            }
        });

    }
}
package com.example.groupbearam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class forgotPassword extends AppCompatActivity {

    private TextView email, contact, sign_in, sign_up;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        sign_in = findViewById(R.id.sign_in);
        sign_up = findViewById(R.id.sign_up);

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(forgotPassword.this, MainActivity.class);
                startActivity(intent);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(forgotPassword.this, signup.class);
                startActivity(intent);
            }
        });

    }
}
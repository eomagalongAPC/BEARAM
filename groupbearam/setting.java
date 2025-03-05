package com.example.groupbearam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class setting extends AppCompatActivity {

    private ImageButton account, privacy, language;
    private TextView Logout;
    private Button back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        language = findViewById(R.id.language);
        account = findViewById(R.id.account);
        privacy = findViewById(R.id.privacy);
        Logout = findViewById(R.id.Logout);
        back = findViewById(R.id.back);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(setting.this, home.class);
                startActivity(intent);
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(setting.this, MainActivity.class);
                startActivity(intent);
            }
        });

        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(setting.this, language);
                popup.getMenuInflater().inflate(R.menu.setting_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.English) {
                            // Change language to English
                            Locale locale = new Locale("en");
                            Locale.setDefault(locale);
                            Configuration config = new Configuration();
                            config.locale = locale;
                            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                            // Restart the activity to apply the language change
                            Intent intent = new Intent(setting.this, setting.class);
                            startActivity(intent);
                            finish();
                        } else if (menuItem.getItemId() == R.id.Filipino) {
                            // Change language to Filipino
                            Locale locale = new Locale("fil");
                            Locale.setDefault(locale);
                            Configuration config = new Configuration();
                            config.locale = locale;
                            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
                            // Restart the activity to apply the language change
                            Intent intent = new Intent(setting.this, setting.class);
                            startActivity(intent);
                            finish();
                        } else {
                            return false;
                        }
                        return true;
                    }
                });
                popup.show();
            }
        });
    }
}

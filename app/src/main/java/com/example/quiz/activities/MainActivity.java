package com.example.quiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz.R;
import com.example.quiz.utils.Constants;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button startButton;
    private Button leaderboardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        startButton = findViewById(R.id.startButton);
        leaderboardButton = findViewById(R.id.leaderboardButton);

        startButton.setOnClickListener(v -> {
            String userName = nameEditText.getText().toString().trim();

            if (userName.isEmpty()) {
                nameEditText.setError("Please enter your name");
                return;
            }

            Intent intent = new Intent(MainActivity.this, CategoryActivity.class);
            intent.putExtra(Constants.EXTRA_USER_NAME, userName);
            startActivity(intent);
        });

        leaderboardButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LeaderboardActivity.class);
            startActivity(intent);
        });
    }
}
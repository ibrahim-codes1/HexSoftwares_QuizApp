package com.example.quiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz.R;
import com.example.quiz.data.LeaderboardStorage;
import com.example.quiz.models.UserScore;
import com.example.quiz.utils.Constants;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTitleText;
    private TextView scoreText;
    private TextView messageText;

    private Button playAgainButton;
    private Button leaderboardButton;
    private Button homeButton;

    private String userName;
    private String categoryName;
    private int score;
    private int totalQuestions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTitleText = findViewById(R.id.resultTitleText);
        scoreText = findViewById(R.id.scoreText);
        messageText = findViewById(R.id.messageText);

        playAgainButton = findViewById(R.id.playAgainButton);
        leaderboardButton = findViewById(R.id.leaderboardButton);
        homeButton = findViewById(R.id.homeButton);

        userName = getIntent().getStringExtra(Constants.EXTRA_USER_NAME);
        categoryName = getIntent().getStringExtra(Constants.EXTRA_CATEGORY);
        score = getIntent().getIntExtra(Constants.EXTRA_SCORE, 0);
        totalQuestions = getIntent().getIntExtra(Constants.EXTRA_TOTAL_QUESTIONS, 0);

        if (userName == null || userName.trim().isEmpty()) {
            userName = "Guest";
        }

        if (categoryName == null || categoryName.trim().isEmpty()) {
            categoryName = "Unknown";
        }

        resultTitleText.setText("Quiz Completed!");
        scoreText.setText("Your Score: " + score + "/" + totalQuestions);

        if (score == totalQuestions) {
            messageText.setText("Excellent work, " + userName + "!");
        } else if (score >= totalQuestions / 2) {
            messageText.setText("Good job, " + userName + "!");
        } else {
            messageText.setText("Keep practicing, " + userName + "!");
        }

        UserScore userScore = new UserScore(
                userName,
                categoryName,
                score,
                totalQuestions,
                System.currentTimeMillis()
        );

        LeaderboardStorage.saveScore(this, userScore);

        playAgainButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, CategoryActivity.class);
            intent.putExtra(Constants.EXTRA_USER_NAME, userName);
            startActivity(intent);
            finish();
        });

        leaderboardButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, LeaderboardActivity.class);
            startActivity(intent);
        });

        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}

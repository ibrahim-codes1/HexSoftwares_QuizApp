package com.example.quiz.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.R;
import com.example.quiz.adapters.LeaderboardAdapter;
import com.example.quiz.data.LeaderboardStorage;
import com.example.quiz.models.UserScore;

import java.util.ArrayList;

public class LeaderboardActivity extends AppCompatActivity {

    private RecyclerView leaderboardRecyclerView;
    private TextView emptyText;
    private Button backButton;

    private ArrayList<UserScore> scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        leaderboardRecyclerView = findViewById(R.id.leaderboardRecyclerView);
        emptyText = findViewById(R.id.emptyText);
        backButton = findViewById(R.id.backButton);

        scores = LeaderboardStorage.getScores(this);

        if (scores.isEmpty()) {
            emptyText.setVisibility(View.VISIBLE);
            leaderboardRecyclerView.setVisibility(View.GONE);
        } else {
            emptyText.setVisibility(View.GONE);
            leaderboardRecyclerView.setVisibility(View.VISIBLE);

            LeaderboardAdapter adapter = new LeaderboardAdapter(scores);
            leaderboardRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            leaderboardRecyclerView.setAdapter(adapter);
        }

        backButton.setOnClickListener(v -> finish());
    }
}
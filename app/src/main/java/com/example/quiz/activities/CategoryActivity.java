package com.example.quiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.R;
import com.example.quiz.adapters.CategoryAdapter;
import com.example.quiz.data.QuizData;
import com.example.quiz.models.Category;
import com.example.quiz.utils.Constants;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    private TextView welcomeText;
    private RecyclerView categoryRecyclerView;
    private Button leaderboardButton;

    private String userName;
    private ArrayList<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        welcomeText = findViewById(R.id.welcomeText);
        categoryRecyclerView = findViewById(R.id.categoryRecyclerView);
        leaderboardButton = findViewById(R.id.leaderboardButton);

        userName = getIntent().getStringExtra(Constants.EXTRA_USER_NAME);

        if (userName == null || userName.trim().isEmpty()) {
            userName = "Guest";
        }

        welcomeText.setText("Welcome, " + userName + "\nChoose a quiz category");

        categories = QuizData.getCategories();

        CategoryAdapter adapter = new CategoryAdapter(categories, new CategoryAdapter.OnCategoryClickListener() {
            @Override
            public void onCategoryClick(Category category) {
                Intent intent = new Intent(CategoryActivity.this, QuizActivity.class);
                intent.putExtra(Constants.EXTRA_USER_NAME, userName);
                intent.putExtra(Constants.EXTRA_CATEGORY, category.getName());
                startActivity(intent);
            }
        });

        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryRecyclerView.setAdapter(adapter);

        leaderboardButton.setOnClickListener(v -> {
            Intent intent = new Intent(CategoryActivity.this, LeaderboardActivity.class);
            startActivity(intent);
        });
    }
}
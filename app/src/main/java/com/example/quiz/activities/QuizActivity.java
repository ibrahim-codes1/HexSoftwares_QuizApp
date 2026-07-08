package com.example.quiz.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz.R;
import com.example.quiz.data.QuizData;
import com.example.quiz.models.Question;
import com.example.quiz.utils.Constants;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    private TextView categoryText;
    private TextView progressText;
    private TextView questionText;
    private TextView feedbackText;

    private Button optionButton1;
    private Button optionButton2;
    private Button optionButton3;
    private Button optionButton4;
    private Button nextButton;

    private String userName;
    private String categoryName;

    private ArrayList<Question> questions;
    private int currentQuestionIndex = 0;
    private int score = 0;
    private boolean answered = false;

    private Button[] optionButtons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        categoryText = findViewById(R.id.categoryText);
        progressText = findViewById(R.id.progressText);
        questionText = findViewById(R.id.questionText);
        feedbackText = findViewById(R.id.feedbackText);

        optionButton1 = findViewById(R.id.optionButton1);
        optionButton2 = findViewById(R.id.optionButton2);
        optionButton3 = findViewById(R.id.optionButton3);
        optionButton4 = findViewById(R.id.optionButton4);
        nextButton = findViewById(R.id.nextButton);

        optionButtons = new Button[]{
                optionButton1,
                optionButton2,
                optionButton3,
                optionButton4
        };

        userName = getIntent().getStringExtra(Constants.EXTRA_USER_NAME);
        categoryName = getIntent().getStringExtra(Constants.EXTRA_CATEGORY);

        if (userName == null || userName.trim().isEmpty()) {
            userName = "Guest";
        }

        if (categoryName == null || categoryName.trim().isEmpty()) {
            categoryName = "History";
        }

        questions = QuizData.getQuestionsByCategory(categoryName);

        categoryText.setText(categoryName);

        optionButton1.setOnClickListener(v -> checkAnswer(0));
        optionButton2.setOnClickListener(v -> checkAnswer(1));
        optionButton3.setOnClickListener(v -> checkAnswer(2));
        optionButton4.setOnClickListener(v -> checkAnswer(3));

        nextButton.setOnClickListener(v -> {
            currentQuestionIndex++;

            if (currentQuestionIndex < questions.size()) {
                showQuestion();
            } else {
                openResultScreen();
            }
        });

        showQuestion();
    }

    private void showQuestion() {
        answered = false;
        feedbackText.setText("");
        nextButton.setEnabled(false);

        Question currentQuestion = questions.get(currentQuestionIndex);

        progressText.setText("Question " + (currentQuestionIndex + 1) + " of " + questions.size());
        questionText.setText(currentQuestion.getQuestionText());

        String[] options = currentQuestion.getOptions();

        for (int i = 0; i < optionButtons.length; i++) {
            optionButtons[i].setText(options[i]);
            optionButtons[i].setEnabled(true);
            optionButtons[i].setBackgroundResource(R.drawable.bg_option_default);
        }

        if (currentQuestionIndex == questions.size() - 1) {
            nextButton.setText("Finish");
        } else {
            nextButton.setText("Next");
        }
    }

    private void checkAnswer(int selectedIndex) {
        if (answered) {
            return;
        }

        answered = true;

        Question currentQuestion = questions.get(currentQuestionIndex);
        int correctIndex = currentQuestion.getCorrectAnswerIndex();

        for (Button button : optionButtons) {
            button.setEnabled(false);
        }

        optionButtons[correctIndex].setBackgroundResource(R.drawable.bg_option_correct);

        if (selectedIndex == correctIndex) {
            score++;
            feedbackText.setText("Correct Answer!");
        } else {
            optionButtons[selectedIndex].setBackgroundResource(R.drawable.bg_option_wrong);
            feedbackText.setText("Wrong Answer!");
        }

        nextButton.setEnabled(true);
    }

    private void openResultScreen() {
        Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
        intent.putExtra(Constants.EXTRA_USER_NAME, userName);
        intent.putExtra(Constants.EXTRA_CATEGORY, categoryName);
        intent.putExtra(Constants.EXTRA_SCORE, score);
        intent.putExtra(Constants.EXTRA_TOTAL_QUESTIONS, questions.size());
        startActivity(intent);
        finish();
    }
}
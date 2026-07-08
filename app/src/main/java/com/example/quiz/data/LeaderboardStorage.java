package com.example.quiz.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.quiz.models.UserScore;
import com.example.quiz.utils.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LeaderboardStorage {

    public static void saveScore(Context context, UserScore newScore) {
        ArrayList<UserScore> scores = getScores(context);
        scores.add(newScore);

        Collections.sort(scores, new Comparator<UserScore>() {
            @Override
            public int compare(UserScore s1, UserScore s2) {
                return Integer.compare(s2.getScore(), s1.getScore());
            }
        });

        if (scores.size() > 10) {
            scores = new ArrayList<>(scores.subList(0, 10));
        }

        StringBuilder builder = new StringBuilder();

        for (UserScore score : scores) {
            builder.append(cleanText(score.getUserName()))
                    .append("|")
                    .append(cleanText(score.getCategory()))
                    .append("|")
                    .append(score.getScore())
                    .append("|")
                    .append(score.getTotalQuestions())
                    .append("|")
                    .append(score.getTimestamp())
                    .append("\n");
        }

        SharedPreferences preferences = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
        preferences.edit()
                .putString(Constants.KEY_LEADERBOARD, builder.toString())
                .apply();
    }

    public static ArrayList<UserScore> getScores(Context context) {
        ArrayList<UserScore> scores = new ArrayList<>();

        SharedPreferences preferences = context.getSharedPreferences(Constants.PREF_NAME, Context.MODE_PRIVATE);
        String savedData = preferences.getString(Constants.KEY_LEADERBOARD, "");

        if (savedData == null || savedData.trim().isEmpty()) {
            return scores;
        }

        String[] lines = savedData.split("\n");

        for (String line : lines) {
            try {
                String[] parts = line.split("\\|");

                if (parts.length == 5) {
                    String userName = parts[0];
                    String category = parts[1];
                    int score = Integer.parseInt(parts[2]);
                    int totalQuestions = Integer.parseInt(parts[3]);
                    long timestamp = Long.parseLong(parts[4]);

                    scores.add(new UserScore(userName, category, score, totalQuestions, timestamp));
                }
            } catch (Exception ignored) {
            }
        }

        Collections.sort(scores, new Comparator<UserScore>() {
            @Override
            public int compare(UserScore s1, UserScore s2) {
                return Integer.compare(s2.getScore(), s1.getScore());
            }
        });

        return scores;
    }

    private static String cleanText(String text) {
        if (text == null) {
            return "";
        }

        return text.replace("|", "")
                .replace("\n", "")
                .trim();
    }
}
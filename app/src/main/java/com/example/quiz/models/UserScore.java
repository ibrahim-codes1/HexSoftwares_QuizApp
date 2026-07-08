package com.example.quiz.models;

public class UserScore {
    private String userName;
    private String category;
    private int score;
    private int totalQuestions;
    private long timestamp;

    public UserScore(String userName, String category, int score, int totalQuestions, long timestamp) {
        this.userName = userName;
        this.category = category;
        this.score = score;
        this.totalQuestions = totalQuestions;
        this.timestamp = timestamp;
    }

    public String getUserName() {
        return userName;
    }

    public String getCategory() {
        return category;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
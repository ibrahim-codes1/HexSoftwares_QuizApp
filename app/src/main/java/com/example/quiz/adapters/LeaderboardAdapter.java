package com.example.quiz.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.R;
import com.example.quiz.models.UserScore;

import java.util.ArrayList;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.LeaderboardViewHolder> {

    private ArrayList<UserScore> scores;

    public LeaderboardAdapter(ArrayList<UserScore> scores) {
        this.scores = scores;
    }

    @NonNull
    @Override
    public LeaderboardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_leaderboard, parent, false);

        return new LeaderboardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardViewHolder holder, int position) {
        UserScore userScore = scores.get(position);

        holder.rankText.setText(String.valueOf(position + 1));
        holder.nameText.setText(userScore.getUserName());
        holder.categoryText.setText(userScore.getCategory());
        holder.scoreText.setText(userScore.getScore() + "/" + userScore.getTotalQuestions());
    }

    @Override
    public int getItemCount() {
        return scores.size();
    }

    static class LeaderboardViewHolder extends RecyclerView.ViewHolder {
        TextView rankText;
        TextView nameText;
        TextView categoryText;
        TextView scoreText;

        public LeaderboardViewHolder(@NonNull View itemView) {
            super(itemView);

            rankText = itemView.findViewById(R.id.rankText);
            nameText = itemView.findViewById(R.id.nameText);
            categoryText = itemView.findViewById(R.id.categoryText);
            scoreText = itemView.findViewById(R.id.scoreText);
        }
    }
}
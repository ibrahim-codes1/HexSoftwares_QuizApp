package com.example.quiz.data;



import com.example.quiz.models.Category;
import com.example.quiz.models.Question;

import java.util.ArrayList;

public class QuizData {

    public static ArrayList<Category> getCategories() {
        ArrayList<Category> categories = new ArrayList<>();

        categories.add(new Category("History", "Test your history knowledge"));
        categories.add(new Category("Science", "Questions about science"));
        categories.add(new Category("Sports", "Sports related questions"));
        categories.add(new Category("Music", "Music and artists quiz"));

        return categories;
    }

    public static ArrayList<Question> getQuestionsByCategory(String category) {
        ArrayList<Question> questions = new ArrayList<>();

        if (category.equals("History")) {
            questions.add(new Question(
                    "Who was the first President of the United States?",
                    new String[]{"Abraham Lincoln", "George Washington", "John Adams", "Thomas Jefferson"},
                    1
            ));

            questions.add(new Question(
                    "In which year did World War II end?",
                    new String[]{"1940", "1942", "1945", "1950"},
                    2
            ));

            questions.add(new Question(
                    "The pyramids are located in which country?",
                    new String[]{"Egypt", "India", "China", "Italy"},
                    0
            ));

            questions.add(new Question(
                    "Who discovered America in 1492?",
                    new String[]{"Christopher Columbus", "Albert Einstein", "Napoleon", "Isaac Newton"},
                    0
            ));
        }

        else if (category.equals("Science")) {
            questions.add(new Question(
                    "What planet is known as the Red Planet?",
                    new String[]{"Earth", "Mars", "Venus", "Jupiter"},
                    1
            ));

            questions.add(new Question(
                    "What gas do plants absorb from the atmosphere?",
                    new String[]{"Oxygen", "Carbon Dioxide", "Nitrogen", "Hydrogen"},
                    1
            ));

            questions.add(new Question(
                    "What is H2O commonly known as?",
                    new String[]{"Salt", "Water", "Oxygen", "Sugar"},
                    1
            ));

            questions.add(new Question(
                    "How many bones are there in the adult human body?",
                    new String[]{"106", "206", "306", "406"},
                    1
            ));
        }

        else if (category.equals("Sports")) {
            questions.add(new Question(
                    "How many players are there in a football/soccer team on the field?",
                    new String[]{"9", "10", "11", "12"},
                    2
            ));

            questions.add(new Question(
                    "Which sport uses a bat and ball?",
                    new String[]{"Cricket", "Swimming", "Boxing", "Tennis"},
                    0
            ));

            questions.add(new Question(
                    "The Olympics are held after every how many years?",
                    new String[]{"2", "3", "4", "5"},
                    2
            ));

            questions.add(new Question(
                    "Which country is famous for sumo wrestling?",
                    new String[]{"China", "Japan", "Pakistan", "Brazil"},
                    1
            ));
        }

        else if (category.equals("Music")) {
            questions.add(new Question(
                    "Which instrument has black and white keys?",
                    new String[]{"Guitar", "Piano", "Drums", "Flute"},
                    1
            ));

            questions.add(new Question(
                    "Who is known as the King of Pop?",
                    new String[]{"Michael Jackson", "Justin Bieber", "Ed Sheeran", "Drake"},
                    0
            ));

            questions.add(new Question(
                    "How many strings does a standard guitar usually have?",
                    new String[]{"4", "5", "6", "7"},
                    2
            ));

            questions.add(new Question(
                    "Which of these is a music genre?",
                    new String[]{"Rock", "Table", "Chair", "Window"},
                    0
            ));
        }

        return questions;
    }
}
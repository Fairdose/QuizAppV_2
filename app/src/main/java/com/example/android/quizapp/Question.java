package com.example.android.quizapp;

import android.support.annotation.Nullable;

import java.util.ArrayList;


public class Question {

    private int pQuestionNumber;

    private String pQuestionType;

    private String pQuestionAnswer;

    private ArrayList<Boolean> pQuestionOptions;

    private ArrayList<String> pCorrectAnswers;

    private ArrayList<Boolean> pCorrectOptions;

    public Question(int questionNumber, String questionType, @Nullable String questionAnswers, @Nullable ArrayList<Boolean> questionOptions, @Nullable ArrayList<String> correctAnswers, @Nullable ArrayList<Boolean> correctOptions) {
        pQuestionNumber = questionNumber;
        pQuestionType = questionType;
        pQuestionAnswer = questionAnswers;
        pQuestionOptions = questionOptions;
        pCorrectAnswers = correctAnswers;
        pCorrectOptions = correctOptions;
    }

    public int checkQuestion() {
        return pQuestionNumber;
    }

    public String getQuestionType() {
        return pQuestionType;
    }

    public String checkAnswerText() {
        return pQuestionAnswer;
    }

    public ArrayList<Boolean> checkAnswerOptions() {
        return pQuestionOptions;
    }

    public ArrayList<String> getAnswerTexts() {
        return pCorrectAnswers;
    }

    public ArrayList<Boolean> getAnswerOptions() {
        return pCorrectOptions;
    }

}

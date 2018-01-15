package com.example.android.quizapp;

import android.support.annotation.Nullable;

import java.util.ArrayList;

public class Question {

    private int pQuestionNumber;

    private String pQuestionType;

    private ArrayList<String> pQuestionAnswer;

    private ArrayList<Boolean> pQuestionOptions;

    private ArrayList<String> pCorrectAnswers;

    private ArrayList<Boolean> pCorrectOptions;

    public Question(int questionNumber, String questionType, @Nullable ArrayList<String> questionAnswers, @Nullable ArrayList<Boolean> questionOptions, @Nullable  ArrayList<String> correctAnswers, @Nullable  ArrayList<Boolean> correctOptions) {
        pQuestionNumber = questionNumber;
        pQuestionType = questionType;
        pQuestionAnswer = questionAnswers;
        pQuestionOptions = questionOptions;
        pCorrectAnswers = correctAnswers;
        pCorrectOptions = correctOptions;
    }

    private int checkQuestion() { return pQuestionNumber; }

    private String getQuestionType() { return  pQuestionType; }

    private ArrayList<String> checkAnswerText() { return pQuestionAnswer; }

    private ArrayList<Boolean> checkAnswerOptions(){ return pQuestionOptions; }

    public static boolean checkAnswers (Question question) {
        switch (question.getQuestionType()) {

            case "radio":
            case "check":
                if(question.checkAnswerOptions().equals(question.pCorrectOptions)) {
                    return true;
                }

            break;

            case "text":
                for (int defVal = 1; defVal <= question.checkAnswerText().size(); defVal++){
                    if(question.pCorrectAnswers.contains(question.checkAnswerText().get(defVal))) {
                        return true;
                    }
                }

            break;

            default: return false;
        }

        return true;
    }

}

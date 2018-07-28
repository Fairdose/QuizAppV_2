package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class AnswerChecker extends AppCompatActivity {

    public static ArrayList<Boolean> checkedAnswers = new ArrayList<Boolean>();

    public static int scoreSum = 0;

    protected static String calculateExamV2() {

        checkedAnswers.clear();

        for (int i = 0; i < QuizActivity.questions.size(); i++) {
            if (checkAnswers(QuizActivity.questions.get(i))) {
                scoreSum += 1;
                checkedAnswers.add(i, true);
            } else {
                checkedAnswers.add(i, false);
            }
            Log.v("Size of list ", String.valueOf(checkedAnswers.size()));
        }

        QuizActivity.questions.clear();

        return String.valueOf(scoreSum) + String.valueOf("/10");

    }

    public static boolean checkAnswers(Question question) {

        boolean point = false;

        if (question.getQuestionType().equals("radio") || question.getQuestionType().equals("check")) {

            if (question.getAnswerOptions().equals(question.checkAnswerOptions())) {
                point = true;
            }
        }

        if (question.getQuestionType().equals("text")) {
            if (question.getAnswerTexts().contains(question.checkAnswerText())) {
                point = true;
            }
        }

        return point;
    }

}

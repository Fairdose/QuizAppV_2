package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class AnswerChecker extends AppCompatActivity {

    public static ArrayList<Boolean> checkedAnswers = new ArrayList<Boolean>();

    private boolean isTimeUp = QuizActivity.timeStatus;

    private String calculateExamV2() {

        int totalScore = 0;

        checkedAnswers.clear();

        for (int i = 0; i < QuizActivity.questions.size(); i++) {
            if (checkAnswers(QuizActivity.questions.get(i))) {
                totalScore += 1;
                checkedAnswers.add(i, true);
            } else {
                checkedAnswers.add(i, false);
            }
            Log.v("Size of list ", String.valueOf(checkedAnswers.size()));
        }

        QuizActivity.questions.clear();

        return String.valueOf(totalScore) + getString(R.string.max_score);

    }

    private boolean checkAnswers(Question question) {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView timeUpView = (TextView) findViewById(R.id.time_up_prompt);
        TextView applicantName = (TextView) findViewById(R.id.applicant_addressing);
        TextView totalScore = (TextView) findViewById(R.id.total_score);

        if (isTimeUp) {
            timeUpView.setVisibility(View.INVISIBLE);
        }

        String applicant = getString(R.string.addressing) + " " + UserInfo.userName;
        applicantName.setText(applicant);

        totalScore.setText(calculateExamV2());

    }

}

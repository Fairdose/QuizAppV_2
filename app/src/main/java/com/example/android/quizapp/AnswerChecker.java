package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AnswerChecker extends AppCompatActivity {

    public static ArrayList<Boolean> checkedAnswers = new ArrayList<Boolean>();

    private boolean isTimeUp = QuizActivity.timeStatus;

    private String calculateExamV2(){
        String totalScoreText;

        int totalScore = 0;

        for(int defVal_1 = 0; defVal_1 <= QuizActivity.questions.size(); defVal_1++) {
            if(Question.checkAnswers(QuizActivity.questions.get(defVal_1))){
                totalScore += 1;
            }
        }

        totalScoreText = String.valueOf(totalScore);
        return totalScoreText;
    }

//    private String calculateExam() {
//
//        String totalScoreText;
//
//        int totalScore = 0;
//
//        if (QuizActivity.answered_1_2) {
//            totalScore += 1;
//            checkedAnswers.add(1,true);
//        } else {
//            checkedAnswers.add(1,false);
//        }
//
//        if (QuizActivity.answered_2_1 && QuizActivity.answered_2_2 && QuizActivity.answered_2_3 && !QuizActivity.answered_2_4) {
//            totalScore += 1;
//            checkedAnswers.add(2,true);
//        } else {
//            checkedAnswers.add(2,false);
//        }
//
//        if (QuizActivity.answered_3_1.equals("document.getElementsByTagName(\"header\")") || QuizActivity.answered_3_1.equals("document.getElementsByTagName(\"header\");")) {
//            totalScore += 1;
//            checkedAnswers.add(3,true);
//        } else {
//            checkedAnswers.add(3,false);
//        }
//
//        if (QuizActivity.answered_4_1.equals("50")) {
//            totalScore += 1;
//            checkedAnswers.add(4,true);
//        } else {
//            checkedAnswers.add(4,false);
//        }
//
//        if (QuizActivity.answered_5_2) {
//            totalScore += 1;
//            checkedAnswers.add(5,true);
//        } else {
//            checkedAnswers.add(5,false);
//        }
//
//        if (QuizActivity.answered_6_1) {
//            totalScore += 1;
//            checkedAnswers.add(6,true);
//        } else {
//            checkedAnswers.add(6,false);
//        }
//
//        if (QuizActivity.answered_7_1.equals("200")) {
//            totalScore += 1;
//            checkedAnswers.add(7,true);
//        } else {
//            checkedAnswers.add(7,false);
//        }
//
//
//        if (QuizActivity.answered_8_1 && !QuizActivity.answered_8_2 && !QuizActivity.answered_8_3 && QuizActivity.answered_8_4) {
//            totalScore += 1;
//            checkedAnswers.add(8,true);
//        } else {
//            checkedAnswers.add(8,false);
//        }
//
//        if (QuizActivity.answered_9_3) {
//            totalScore += 1;
//            checkedAnswers.add(9,true);
//        } else {
//            checkedAnswers.add(9,false);
//        }
//
//        String html_up_case = getString(R.string.html_correct_answer);
//        if (QuizActivity.answered_10_1.toUpperCase().equals(html_up_case)) {
//            totalScore += 1;
//            checkedAnswers.add(10,true);
//        } else {
//            checkedAnswers.add(10,false);
//        }
//
//        totalScoreText = String.valueOf(totalScore);
//
//        return totalScoreText;
//
//    }

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

        applicantName.setText(getString(R.string.addressing) + " " + UserInfo.userName);

        totalScore.setText(calculateExamV2() + getString(R.string.max_score));

    }

}

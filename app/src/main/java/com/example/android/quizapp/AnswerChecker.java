package com.example.android.quizapp;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AnswerChecker extends AppCompatActivity {

    public static ArrayList<Boolean> checkedAnswers = new ArrayList<Boolean>();

    public MediaPlayer timeUpBell;

    private boolean isTimeUp = QuizActivity.timeStatus;

    public static int scoreSum = 0;

    TextView timeUpView;
    TextView applicantName;
    TextView totalScore;

    public void startChecking(){
        calculateExamV2();
    }

/*    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        timeUpView = (TextView) findViewById(R.id.time_up_prompt);
        applicantName = (TextView) findViewById(R.id.applicant_addressing);
        totalScore = (TextView) findViewById(R.id.total_score);
        timeUpBell = MediaPlayer.create(this, R.raw.bell);

        if (isTimeUp) {
            timeUpView.setVisibility(View.VISIBLE);
            tiltTimeUp();
            timeUpBell.start();
        } else {
            timeUpView.setVisibility(View.INVISIBLE);
        }

        String applicant = getString(R.string.addressing) + " " + UserInfo.userName;
        applicantName.setText(applicant);

        setTextAndColor();

    }*/

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

/*    private void setTextAndColor() {

        totalScore.setText(calculateExamV2());

        if (scoreSum <= 2) {
            totalScore.setTextColor(getResources().getColor(R.color.low_score_color));
        } else if (scoreSum <= 9) {
            totalScore.setTextColor(getResources().getColor(R.color.def_text_color));
        } else if (scoreSum == 10) {
            totalScore.setTextColor(getResources().getColor(R.color.top_score_color));
        }

        scoreSum = 0;
    }

    private void tiltTimeUp (){
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.tilt);
        timeUpView.startAnimation(animation1);
    }*/

}

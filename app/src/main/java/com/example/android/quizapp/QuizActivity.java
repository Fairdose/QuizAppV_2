package com.example.android.quizapp;

import android.content.Intent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class QuizActivity extends AppCompatActivity {

    private final String FORMAT = "%02d:%02d";

    //Declare the pseudo variables for views --Start--

    RadioButton answer_1_1;
    RadioButton answer_1_2;
    RadioButton answer_1_3;
    RadioButton answer_1_4;
    CheckBox answer_2_1;
    CheckBox answer_2_2;
    CheckBox answer_2_3;
    CheckBox answer_2_4;
    EditText answer_3_1;
    EditText answer_4_1;
    RadioButton answer_5_1;
    RadioButton answer_5_2;
    RadioButton answer_5_3;
    RadioButton answer_6_1;
    RadioButton answer_6_2;
    RadioButton answer_6_3;
    RadioButton answer_6_4;
    EditText answer_7_1;
    CheckBox answer_8_1;
    CheckBox answer_8_2;
    CheckBox answer_8_3;
    CheckBox answer_8_4;
    RadioButton answer_9_1;
    RadioButton answer_9_2;
    RadioButton answer_9_3;
    EditText answer_10_1;

    // --End--

    //Declare if times up or not

    public static boolean timeStatus = true;

    //Declare all the answers as variables --Start--

//    public static boolean
//            answered_1_1,
//            answered_1_2,
//            answered_1_3,
//            answered_1_4,
//            answered_2_1,
//            answered_2_2,
//            answered_2_3,
//            answered_2_4,
//            answered_5_1,
//            answered_5_2,
//            answered_5_3,
//            answered_6_1,
//            answered_6_2,
//            answered_6_3,
//            answered_6_4,
//            answered_8_1,
//            answered_8_2,
//            answered_8_3,
//            answered_8_4,
//            answered_9_1,
//            answered_9_2,
//            answered_9_3;
//
//    public static String
//            answered_3_1,
//            answered_4_1,
//            answered_7_1,
//            answered_10_1;

    public static ArrayList <Question> questions = new ArrayList<Question>();

    Question question_1;
    Question question_2;
    Question question_3;
    Question question_4;
    Question question_5;
    Question question_6;
    Question question_7;
    Question question_8;
    Question question_9;
    Question question_10;

    // --End--

    String[][] answerInputs = new String[10][4];

    @Override
    public void onBackPressed() { }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        final TextView text1 = (TextView) findViewById(R.id.remaining_time);

        final TextView submit = (TextView) findViewById(R.id.submit_exam);

        final TextView retry = (TextView) findViewById(R.id.retry);

        TextView applicantView = (TextView) findViewById(R.id.applicant_name);

        retry.setVisibility(View.GONE);

        //Assign views to their variables --Start--

        answer_1_1 = findViewById(R.id.answer_1_1);
        answer_1_2 = findViewById(R.id.answer_1_2);
        answer_1_3 = findViewById(R.id.answer_1_3);
        answer_1_4 = findViewById(R.id.answer_1_4);
        answer_2_1 = findViewById(R.id.answer_2_1);
        answer_2_2 = findViewById(R.id.answer_2_2);
        answer_2_3 = findViewById(R.id.answer_2_3);
        answer_2_4 = findViewById(R.id.answer_2_4);
        answer_3_1 = (EditText) findViewById(R.id.answer_3_1);
        answer_4_1 = (EditText) findViewById(R.id.answer_4_1);
        answer_5_1 = findViewById(R.id.answer_5_1);
        answer_5_2 = findViewById(R.id.answer_5_2);
        answer_5_3 = findViewById(R.id.answer_5_3);
        answer_6_1 = findViewById(R.id.answer_6_1);
        answer_6_2 = findViewById(R.id.answer_6_2);
        answer_6_3 = findViewById(R.id.answer_6_3);
        answer_6_4 = findViewById(R.id.answer_6_4);
        answer_7_1 = (EditText) findViewById(R.id.answer_7_1);
        answer_8_1 = findViewById(R.id.answer_8_1);
        answer_8_2 = findViewById(R.id.answer_8_2);
        answer_8_3 = findViewById(R.id.answer_8_3);
        answer_8_4 = findViewById(R.id.answer_8_4);
        answer_9_1 = findViewById(R.id.answer_9_1);
        answer_9_2 = findViewById(R.id.answer_9_2);
        answer_9_3 = findViewById(R.id.answer_9_3);
        answer_10_1 = (EditText) findViewById(R.id.answer_10_1);

        // --End--

        final CountDownTimer timer = new CountDownTimer(601000, 1000) {

            public void onTick(long timeRemaining) {

                long minutes = TimeUnit.MILLISECONDS.toMinutes(timeRemaining) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeRemaining));
                long seconds = TimeUnit.MILLISECONDS.toSeconds(timeRemaining) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeRemaining));

                text1.setText(String.format(FORMAT, minutes, seconds));
            }

            public void onFinish() {
                submit.setVisibility(View.GONE);
                retry.setVisibility(View.VISIBLE);
                timeStatus = false;
                submitExamValues();
            }

        };

        applicantView.setText(UserInfo.userName);

        timer.start();

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                submit.setVisibility(View.GONE);
                retry.setVisibility(View.VISIBLE);
                timer.cancel();
                submitExamValues();
            }
        });

        retry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent retry = new Intent(QuizActivity.this, QuizActivity.class);
                startActivity(retry);
            }
        });
    }

    public void submitExamValues () {

        //Start the new calculating activity

        Intent quizIntent = new Intent(this, AnswerChecker.class);

        startActivity(quizIntent);

        //At the background, get all the answers and pass values to their respected variables
        //and set them disabled so the user could compare the answers --Start--

        ArrayList<Boolean> question_1_arr = new ArrayList<Boolean>();
        ArrayList<Boolean> question_2_arr = new ArrayList<Boolean>();
        ArrayList<String> question_3_arr = new ArrayList<String>();
        ArrayList<String> question_4_arr = new ArrayList<String>();
        ArrayList<Boolean> question_5_arr = new ArrayList<Boolean>();
        ArrayList<Boolean> question_6_arr = new ArrayList<Boolean>();
        ArrayList<String> question_7_arr = new ArrayList<String>();
        ArrayList<Boolean> question_8_arr = new ArrayList<Boolean>();
        ArrayList<Boolean> question_9_arr = new ArrayList<Boolean>();
        ArrayList<String> question_10_arr = new ArrayList<String>();

        ArrayList<Boolean> answers_1_arr = new ArrayList<Boolean>(Arrays.asList(false,true,false,false));
        ArrayList<Boolean> answers_2_arr = new ArrayList<Boolean>(Arrays.asList(true,true,true,false));
        ArrayList<String> answers_3_arr = new ArrayList<String>(Arrays.asList("document.getElementsByTagName(\"header\")","document.getElementsByTagName(\"header\");"));
        ArrayList<String> answers_4_arr = new ArrayList<String>(Arrays.asList("50"));
        ArrayList<Boolean> answers_5_arr = new ArrayList<Boolean>(Arrays.asList(false,true,false));
        ArrayList<Boolean> answers_6_arr = new ArrayList<Boolean>(Arrays.asList(true,false,false,false));
        ArrayList<String> answers_7_arr = new ArrayList<String>(Arrays.asList("200"));
        ArrayList<Boolean> answers_8_arr = new ArrayList<Boolean>(Arrays.asList(true,false,false,false));
        ArrayList<Boolean> answers_9_arr = new ArrayList<Boolean>(Arrays.asList(true,false,false,true));
        ArrayList<String> answers_10_arr = new ArrayList<String>(Arrays.asList("HYPER TEXT MARKUP LANGUAGE"));

        question_1_arr.add(answer_1_1.isChecked());
        question_1_arr.add(answer_1_2.isChecked());
        question_1_arr.add(answer_1_3.isChecked());
        question_1_arr.add(answer_1_4.isChecked());

        question_2_arr.add(answer_2_1.isChecked());
        question_2_arr.add(answer_2_2.isChecked());
        question_2_arr.add(answer_2_3.isChecked());
        question_2_arr.add(answer_2_4.isChecked());

        question_3_arr.add(answer_3_1.getText().toString());

        question_4_arr.add(answer_4_1.getText().toString());

        question_5_arr.add(answer_5_1.isChecked());
        question_5_arr.add(answer_5_2.isChecked());
        question_5_arr.add(answer_5_3.isChecked());

        question_6_arr.add(answer_6_1.isChecked());
        question_6_arr.add(answer_6_2.isChecked());
        question_6_arr.add(answer_6_3.isChecked());
        question_6_arr.add(answer_6_4.isChecked());

        question_7_arr.add(answer_7_1.getText().toString());

        question_2_arr.add(answer_8_1.isChecked());
        question_2_arr.add(answer_8_2.isChecked());
        question_2_arr.add(answer_8_3.isChecked());
        question_2_arr.add(answer_8_4.isChecked());

        question_2_arr.add(answer_9_1.isChecked());
        question_2_arr.add(answer_9_2.isChecked());
        question_2_arr.add(answer_9_3.isChecked());

        question_10_arr.add(answer_10_1.getText().toString().toUpperCase());

        question_1 = new Question(1, "radio", null, question_1_arr, null, answers_1_arr);
        question_2 = new Question(2, "check", null, question_2_arr, null, answers_2_arr);
        question_3 = new Question(3, "text", question_3_arr, null, answers_3_arr, null);
        question_4 = new Question(4, "text", question_4_arr, null, answers_4_arr, null);
        question_5 = new Question(5, "radio", null, question_5_arr, null, answers_5_arr);
        question_6 = new Question(6, "radio", null, question_6_arr, null, answers_6_arr);
        question_7 = new Question(7, "text", question_7_arr, null, answers_7_arr, null);
        question_8 = new Question(8, "check", null, question_8_arr, null, answers_8_arr);
        question_9 = new Question(9, "radio", null, question_9_arr, null, answers_9_arr);
        question_10 = new Question(10, "text", question_10_arr, null, answers_10_arr, null);

        answer_1_1.setEnabled(false);
        answer_1_2.setEnabled(false);
        answer_1_3.setEnabled(false);
        answer_1_4.setEnabled(false);
        answer_2_1.setEnabled(false);
        answer_2_2.setEnabled(false);
        answer_2_3.setEnabled(false);
        answer_2_4.setEnabled(false);
        answer_3_1.setEnabled(false);
        answer_4_1.setEnabled(false);
        answer_5_1.setEnabled(false);
        answer_5_2.setEnabled(false);
        answer_5_3.setEnabled(false);
        answer_6_1.setEnabled(false);
        answer_6_2.setEnabled(false);
        answer_6_3.setEnabled(false);
        answer_6_4.setEnabled(false);
        answer_7_1.setEnabled(false);
        answer_8_1.setEnabled(false);
        answer_8_2.setEnabled(false);
        answer_8_3.setEnabled(false);
        answer_8_4.setEnabled(false);
        answer_9_1.setEnabled(false);
        answer_9_2.setEnabled(false);
        answer_9_3.setEnabled(false);
        answer_10_1.setEnabled(false);

        // --End--

    }

}
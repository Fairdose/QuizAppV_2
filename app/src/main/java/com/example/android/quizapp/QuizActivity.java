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

    public static boolean timeStatus = true;

    public static ArrayList<Question> questions = new ArrayList<Question>();

    public static ArrayList<TextView> answerCompare;

    private final String FORMAT = "%02d:%02d";

    private ArrayList<TextView> choices;

    private boolean retryValue = false;

    //Declare the pseudo variables for views --Start--

    RadioButton answer_1_1;
    RadioButton answer_1_2;
    RadioButton answer_1_3;
    RadioButton answer_1_4;
    RadioButton answer_5_1;
    RadioButton answer_5_2;
    RadioButton answer_5_3;
    RadioButton answer_6_1;
    RadioButton answer_6_2;
    RadioButton answer_6_3;
    RadioButton answer_6_4;
    RadioButton answer_9_1;
    RadioButton answer_9_2;
    RadioButton answer_9_3;
    CheckBox answer_2_1;
    CheckBox answer_2_2;
    CheckBox answer_2_3;
    CheckBox answer_2_4;
    CheckBox answer_8_1;
    CheckBox answer_8_2;
    CheckBox answer_8_3;
    CheckBox answer_8_4;
    EditText answer_3_1;
    EditText answer_4_1;
    EditText answer_7_1;
    EditText answer_10_1;
    TextView correct_answer_1;
    TextView correct_answer_2;
    TextView correct_answer_3;
    TextView correct_answer_4;
    TextView correct_answer_5;
    TextView correct_answer_6;
    TextView correct_answer_7;
    TextView correct_answer_8;
    TextView correct_answer_9;
    TextView correct_answer_10;

    @Override
    public void onBackPressed() {
    }

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
        answer_5_1 = findViewById(R.id.answer_5_1);
        answer_5_2 = findViewById(R.id.answer_5_2);
        answer_5_3 = findViewById(R.id.answer_5_3);
        answer_6_1 = findViewById(R.id.answer_6_1);
        answer_6_2 = findViewById(R.id.answer_6_2);
        answer_6_3 = findViewById(R.id.answer_6_3);
        answer_6_4 = findViewById(R.id.answer_6_4);
        answer_8_1 = findViewById(R.id.answer_8_1);
        answer_8_2 = findViewById(R.id.answer_8_2);
        answer_8_3 = findViewById(R.id.answer_8_3);
        answer_8_4 = findViewById(R.id.answer_8_4);
        answer_9_1 = findViewById(R.id.answer_9_1);
        answer_9_2 = findViewById(R.id.answer_9_2);
        answer_9_3 = findViewById(R.id.answer_9_3);
        answer_3_1 = (EditText) findViewById(R.id.answer_3_1);
        answer_4_1 = (EditText) findViewById(R.id.answer_4_1);
        answer_7_1 = (EditText) findViewById(R.id.answer_7_1);
        answer_10_1 = (EditText) findViewById(R.id.answer_10_1);

        correct_answer_1 = (TextView) findViewById(R.id.correct_answer_1);
        correct_answer_2 = (TextView) findViewById(R.id.correct_answer_2);
        correct_answer_3 = (TextView) findViewById(R.id.correct_answer_3);
        correct_answer_4 = (TextView) findViewById(R.id.correct_answer_4);
        correct_answer_5 = (TextView) findViewById(R.id.correct_answer_5);
        correct_answer_6 = (TextView) findViewById(R.id.correct_answer_6);
        correct_answer_7 = (TextView) findViewById(R.id.correct_answer_7);
        correct_answer_8 = (TextView) findViewById(R.id.correct_answer_8);
        correct_answer_9 = (TextView) findViewById(R.id.correct_answer_9);
        correct_answer_10 = (TextView) findViewById(R.id.correct_answer_10);

        answerCompare = new ArrayList<TextView>(Arrays.asList(correct_answer_1, correct_answer_2, correct_answer_3, correct_answer_4, correct_answer_5, correct_answer_6, correct_answer_7, correct_answer_8, correct_answer_9, correct_answer_10));

        for (int i = 0; i < answerCompare.size(); i++)
            answerCompare.get(i).setVisibility(View.GONE);


        final CountDownTimer timer = new CountDownTimer(301000, 1000) {

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
                retryValue = true;
                submitExamValues();
            }
        });

        retry.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                for (int i = 0; i < answerCompare.size(); i++)
                    answerCompare.get(i).setVisibility(View.GONE);

                Intent retry = new Intent(QuizActivity.this, QuizActivity.class);
                startActivity(retry);
            }
        });

    }

    protected void onResume() {
        super.onResume();
        if (retryValue){
            retryValue = false;
            showTheAnswers();
        }
    }

    public void submitExamValues() {

        //Get all the answers and pass values to their respected variables
        //and set them disabled so the user could compare the answers --Start--

        ArrayList<Boolean> question_1_arr = new ArrayList<Boolean>(Arrays.asList(answer_1_1.isChecked(), answer_1_2.isChecked(), answer_1_3.isChecked(), answer_1_4.isChecked()));
        ArrayList<Boolean> question_2_arr = new ArrayList<Boolean>(Arrays.asList(answer_2_1.isChecked(), answer_2_2.isChecked(), answer_2_3.isChecked(), answer_2_4.isChecked()));
        ArrayList<Boolean> question_5_arr = new ArrayList<Boolean>(Arrays.asList(answer_5_1.isChecked(), answer_5_2.isChecked(), answer_5_3.isChecked()));
        ArrayList<Boolean> question_6_arr = new ArrayList<Boolean>(Arrays.asList(answer_6_1.isChecked(), answer_6_2.isChecked(), answer_6_3.isChecked(), answer_6_4.isChecked()));
        ArrayList<Boolean> question_8_arr = new ArrayList<Boolean>(Arrays.asList(answer_8_1.isChecked(), answer_8_2.isChecked(), answer_8_3.isChecked(), answer_8_4.isChecked()));
        ArrayList<Boolean> question_9_arr = new ArrayList<Boolean>(Arrays.asList(answer_9_1.isChecked(), answer_9_2.isChecked(), answer_9_3.isChecked()));
        String question_3_arr = answer_3_1.getText().toString();
        String question_4_arr = answer_4_1.getText().toString();
        String question_7_arr = answer_7_1.getText().toString();
        String question_10_arr = answer_10_1.getText().toString().toUpperCase();

        ArrayList<Boolean> answers_1_arr = new ArrayList<Boolean>(Arrays.asList(false, true, false, false));
        ArrayList<Boolean> answers_2_arr = new ArrayList<Boolean>(Arrays.asList(true, true, true, false));
        ArrayList<Boolean> answers_5_arr = new ArrayList<Boolean>(Arrays.asList(false, true, false));
        ArrayList<Boolean> answers_6_arr = new ArrayList<Boolean>(Arrays.asList(true, false, false, false));
        ArrayList<Boolean> answers_8_arr = new ArrayList<Boolean>(Arrays.asList(true, false, false, true));
        ArrayList<Boolean> answers_9_arr = new ArrayList<Boolean>(Arrays.asList(false, false, true));
        ArrayList<String> answers_3_arr = new ArrayList<String>(Arrays.asList("document.getElementsByTagName(\"header\");", "document.getElementsByTagName(\'header\');", "document.getElementsByTagName(\"header\")", "document.getElementsByTagName(\'header\')"));
        ArrayList<String> answers_4_arr = new ArrayList<String>(Arrays.asList("50", "\"50\"", "\'50\'"));
        ArrayList<String> answers_7_arr = new ArrayList<String>(Arrays.asList("200", "\"200\"", "\'200\'"));
        ArrayList<String> answers_10_arr = new ArrayList<String>(Arrays.asList("HYPER TEXT MARKUP LANGUAGE", "Hyper Text Markup Language"));

        questions.add(0, new Question(1, "radio", null, question_1_arr, null, answers_1_arr));
        questions.add(1, new Question(2, "check", null, question_2_arr, null, answers_2_arr));
        questions.add(2, new Question(3, "text", question_3_arr, null, answers_3_arr, null));
        questions.add(3, new Question(4, "text", question_4_arr, null, answers_4_arr, null));
        questions.add(4, new Question(5, "radio", null, question_5_arr, null, answers_5_arr));
        questions.add(5, new Question(6, "radio", null, question_6_arr, null, answers_6_arr));
        questions.add(6, new Question(7, "text", question_7_arr, null, answers_7_arr, null));
        questions.add(7, new Question(8, "check", null, question_8_arr, null, answers_8_arr));
        questions.add(8, new Question(9, "radio", null, question_9_arr, null, answers_9_arr));
        questions.add(9, new Question(10, "text", question_10_arr, null, answers_10_arr, null));

        choices = new ArrayList<TextView>(Arrays.asList(answer_1_1, answer_1_2, answer_1_3, answer_1_4, answer_2_1, answer_2_2, answer_2_3, answer_2_4, answer_3_1, answer_4_1, answer_5_1, answer_5_2, answer_5_3, answer_6_1, answer_6_2, answer_6_3, answer_6_4, answer_7_1, answer_8_1, answer_8_2, answer_8_3, answer_8_4, answer_9_1, answer_9_2, answer_9_3, answer_10_1));

        for (int i = 0; i < choices.size(); i++)
            choices.get(i).setEnabled(false);

        for (int i = 0; i < answerCompare.size(); i++)
            answerCompare.get(i).setVisibility(View.VISIBLE);

        //Start the new calculating activity

        Intent quizIntent = new Intent(this, AnswerChecker.class);

        startActivity(quizIntent);

    }

    public void showTheAnswers() {
        for (int i = 0; i < AnswerChecker.checkedAnswers.size(); i++) {
            if (AnswerChecker.checkedAnswers.get(i)) {
                answerCompare.get(i).setBackgroundResource(R.drawable.correct_answer);
            } else if (!AnswerChecker.checkedAnswers.get(i)) {
                answerCompare.get(i).setBackgroundResource(R.drawable.wrong_answer);
            }
            answerCompare.get(i).setVisibility(View.VISIBLE);
        }
    }

}
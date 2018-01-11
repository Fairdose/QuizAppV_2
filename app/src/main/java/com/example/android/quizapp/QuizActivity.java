package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get user name from the first screen
        Bundle data = getIntent().getExtras();

        final String userName = data.getString("user_name");

        TextView applicantView = (TextView) findViewById(R.id.applicant_name);
        applicantView.setText(userName);

//         answered_1_1;
//         answered_1_2;
//         answered_1_3;
//         answered_1_4;
//         answered_2_1;
//         answered_2_2;
//         answered_2_3;
//         answered_2_4;
//         answered_3_1;
//         answered_4_1;
//         answered_5_1;
//         answered_5_2;
//         answered_5_3;
//         answered_6_1;
//         answered_6_2;
//         answered_6_3;
//         answered_6_4;
//         answered_7_1;
//         answered_8_1;
//         answered_8_2;
//         answered_8_3;
//         answered_8_4;
//         answered_9_1;
//         answered_9_2;
//         answered_9_3;
//         answered_10_1;

        TextView submit = (TextView) findViewById(R.id.submit_exam);
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent quizIntent = new Intent(QuizActivity.this, AnswerChecker.class);

                //Get all the answers and their states

                RadioButton answer_1_1 = findViewById(R.id.answer_1_1);
                boolean answered_1_1 = answer_1_1.isChecked();

                RadioButton answer_1_2 = findViewById(R.id.answer_1_2);
                boolean answered_1_2 = answer_1_2.isChecked();

                RadioButton answer_1_3 = findViewById(R.id.answer_1_3);
                boolean answered_1_3 = answer_1_3.isChecked();

                RadioButton answer_1_4 = findViewById(R.id.answer_1_4);
                boolean answered_1_4 = answer_1_4.isChecked();

                CheckBox answer_2_1 = findViewById(R.id.answer_2_1);
                boolean answered_2_1 = answer_2_1.isChecked();

                CheckBox answer_2_2 = findViewById(R.id.answer_2_2);
                boolean answered_2_2 = answer_2_2.isChecked();

                CheckBox answer_2_3 = findViewById(R.id.answer_2_3);
                boolean answered_2_3 = answer_2_3.isChecked();

                CheckBox answer_2_4 = findViewById(R.id.answer_2_4);
                boolean answered_2_4 = answer_2_4.isChecked();

                EditText answer_3_1 = (EditText) findViewById(R.id.answer_3_1);
                String answered_3_1 = answer_3_1.getText().toString();

                EditText answer_4_1 = (EditText) findViewById(R.id.answer_4_1);
                String answered_4_1 = answer_4_1.getText().toString();

                RadioButton answer_5_1 = findViewById(R.id.answer_5_1);
                boolean answered_5_1 = answer_5_1.isChecked();

                RadioButton answer_5_2 = findViewById(R.id.answer_5_2);
                boolean answered_5_2 = answer_5_2.isChecked();

                RadioButton answer_5_3 = findViewById(R.id.answer_5_3);
                boolean answered_5_3 = answer_5_3.isChecked();

                RadioButton answer_6_1 = findViewById(R.id.answer_6_1);
                boolean answered_6_1 = answer_6_1.isChecked();

                RadioButton answer_6_2 = findViewById(R.id.answer_6_2);
                boolean answered_6_2 = answer_6_2.isChecked();

                RadioButton answer_6_3 = findViewById(R.id.answer_6_3);
                boolean answered_6_3 = answer_6_3.isChecked();

                RadioButton answer_6_4 = findViewById(R.id.answer_6_4);
                boolean answered_6_4 = answer_6_4.isChecked();

                EditText answer_7_1 = (EditText) findViewById(R.id.answer_7_1);
                String answered_7_1 = answer_7_1.getText().toString();

                CheckBox answer_8_1 = findViewById(R.id.answer_8_1);
                boolean answered_8_1 = answer_8_1.isChecked();

                CheckBox answer_8_2 = findViewById(R.id.answer_8_2);
                boolean answered_8_2 = answer_8_2.isChecked();

                CheckBox answer_8_3 = findViewById(R.id.answer_8_3);
                boolean answered_8_3 = answer_8_3.isChecked();

                CheckBox answer_8_4 = findViewById(R.id.answer_8_4);
                boolean answered_8_4 = answer_8_4.isChecked();

                RadioButton answer_9_1 = findViewById(R.id.answer_9_1);
                boolean answered_9_1 = answer_9_1.isChecked();

                RadioButton answer_9_2 = findViewById(R.id.answer_9_2);
                boolean answered_9_2 = answer_9_2.isChecked();

                RadioButton answer_9_3 = findViewById(R.id.answer_9_3);
                boolean answered_9_3 = answer_9_3.isChecked();

                EditText answer_10_1 = (EditText) findViewById(R.id.answer_10_1);
                String answered_10_1 = answer_10_1.getText().toString();

                //Push the data to the new activity

                quizIntent.putExtra("answer_1_1", answered_1_1);
                quizIntent.putExtra("answer_1_2", answered_1_2);
                quizIntent.putExtra("answer_1_3", answered_1_3);
                quizIntent.putExtra("answer_1_4", answered_1_4);
                quizIntent.putExtra("answer_2_1", answered_2_1);
                quizIntent.putExtra("answer_2_2", answered_2_2);
                quizIntent.putExtra("answer_2_3", answered_2_3);
                quizIntent.putExtra("answer_2_4", answered_2_4);
                quizIntent.putExtra("answer_3_1", answered_3_1);
                quizIntent.putExtra("answer_4_1", answered_4_1);
                quizIntent.putExtra("answer_5_1", answered_5_1);
                quizIntent.putExtra("answer_5_2", answered_5_2);
                quizIntent.putExtra("answer_5_3", answered_5_3);
                quizIntent.putExtra("answer_6_1", answered_6_1);
                quizIntent.putExtra("answer_6_2", answered_6_2);
                quizIntent.putExtra("answer_6_3", answered_6_3);
                quizIntent.putExtra("answer_6_4", answered_6_4);
                quizIntent.putExtra("answer_7_1", answered_7_1);
                quizIntent.putExtra("answer_8_1", answered_8_1);
                quizIntent.putExtra("answer_8_2", answered_8_2);
                quizIntent.putExtra("answer_8_3", answered_8_3);
                quizIntent.putExtra("answer_8_4", answered_8_4);
                quizIntent.putExtra("answer_9_1", answered_9_1);
                quizIntent.putExtra("answer_9_2", answered_9_2);
                quizIntent.putExtra("answer_9_3", answered_9_3);
                quizIntent.putExtra("answer_10_1", answered_10_1);
                quizIntent.putExtra("user_name", userName);

                startActivity(quizIntent);

            }
        });


    }

}
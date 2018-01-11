package com.example.android.quizapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_name);

        TextView start = (TextView) findViewById(R.id.startQuiz);

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText userName = (EditText) findViewById(R.id.userNameVal);
                String value = userName.getText().toString();

                if (TextUtils.isEmpty(value)) {

                    Context context = getApplicationContext();
                    CharSequence text = "Name field cannot be empty";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                } else {

                    Intent quizIntent = new Intent(UserInfo.this, QuizActivity.class);
                    quizIntent.putExtra("user_name", value);

                    startActivity(quizIntent);
                }

            }
        });

    }

}

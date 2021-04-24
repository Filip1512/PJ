package com.example.bmi_calculator;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class activity_welcome extends AppCompatActivity {
    Button buttonBmi;
    Button buttonQuiz;
    Button buttonGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        buttonBmi = (Button) findViewById(R.id.button_bmi);
        buttonQuiz = (Button) findViewById(R.id.button_quiz);
        buttonGraph = (Button) findViewById(R.id.button_graph);

        buttonBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBmiActivity();
            }
        });

        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuizActivity();
            }
        });

        buttonGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGraphActivity();
            }
        });
    }

    public void openBmiActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openQuizActivity(){
        Intent intent = new Intent(this, activity_quiz.class);
        startActivity(intent);
    }

    public void openGraphActivity(){
        Intent intent = new Intent(this, activity_graph.class);
        startActivity(intent);
    }
}
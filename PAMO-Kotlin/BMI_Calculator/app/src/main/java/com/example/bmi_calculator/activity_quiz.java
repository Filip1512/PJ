package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class activity_quiz extends AppCompatActivity {

    Button answer1, answer2, answer3, answer4;

    TextView score, question;

    private Questions mQuestions = new Questions();

    private String mAnswer;
    private int mScore = 0;
    private int questionNumber = 0;
    private int mQuestionsLength = mQuestions.mQuestions.length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        answer1 = (Button) findViewById(R.id.answer1);
        answer2 = (Button) findViewById(R.id.answer2);
        answer3 = (Button) findViewById(R.id.answer3);
        answer4 = (Button) findViewById(R.id.answer4);

        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);

        score.setText("Score: " + mScore);

        updateQuestion(questionNumber);

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(answer1.getText() == mAnswer){
                    mScore++;
                    updateQuestion(questionNumber);
                }
                else{
                    gameOver();
                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(answer2.getText() == mAnswer){
                    mScore++;
                    updateQuestion(questionNumber);
                }
                else{
                    gameOver();
                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(answer3.getText() == mAnswer){
                    mScore++;
                    updateQuestion(questionNumber);
                }
                else{
                    gameOver();
                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(answer4.getText() == mAnswer){
                    mScore++;
                    updateQuestion(questionNumber);
                }
                else{
                    gameOver();
                }
            }
        });
    }

    private void updateQuestion(int num){
        if (questionNumber < mQuestionsLength){
            score.setText("Score: " + mScore);
            question.setText(mQuestions.getQuestion(num));
            answer1.setText(mQuestions.getChoice1(num));
            answer2.setText(mQuestions.getChoice2(num));
            answer3.setText(mQuestions.getChoice3(num));
            answer4.setText(mQuestions.getChoice4(num));

            mAnswer = mQuestions.getCorrectAnswer(num);
            questionNumber++;
        }
        else {
            score.setText("Score: " + mScore);
            gameWon();
        }
    }

    private void gameOver(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity_quiz.this);
        alertDialogBuilder
                .setMessage("You lose! Your score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), activity_quiz.class));
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void gameWon(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity_quiz.this);
        alertDialogBuilder
                .setMessage("You won! Your score is " + mScore + " points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                startActivity(new Intent(getApplicationContext(), activity_quiz.class));
                            }
                        })
                .setNegativeButton("EXIT",
                        new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i){
                                finish();
                            }
                        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
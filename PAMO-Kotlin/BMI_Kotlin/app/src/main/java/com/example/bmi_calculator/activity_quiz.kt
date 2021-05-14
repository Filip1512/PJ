package com.example.bmi_calculator

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bmi_calculator.activity_quiz

class activity_quiz : AppCompatActivity() {
    var answer1: Button? = null
    var answer2: Button? = null
    var answer3: Button? = null
    var answer4: Button? = null
    var score: TextView? = null
    var question: TextView? = null
    private val mQuestions = Questions()
    private var mAnswer: String? = null
    private var mScore = 0
    private var questionNumber = 0
    private val mQuestionsLength = mQuestions.mQuestions.size
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        answer1 = findViewById<View>(R.id.answer1) as Button
        answer2 = findViewById<View>(R.id.answer2) as Button
        answer3 = findViewById<View>(R.id.answer3) as Button
        answer4 = findViewById<View>(R.id.answer4) as Button
        score = findViewById<View>(R.id.score) as TextView
        question = findViewById<View>(R.id.question) as TextView
        score!!.text = "Score: $mScore"
        updateQuestion(questionNumber)
        answer1!!.setOnClickListener {
            if (answer1!!.text === mAnswer) {
                mScore++
                updateQuestion(questionNumber)
            } else {
                gameOver()
            }
        }
        answer2!!.setOnClickListener {
            if (answer2!!.text === mAnswer) {
                mScore++
                updateQuestion(questionNumber)
            } else {
                gameOver()
            }
        }
        answer3!!.setOnClickListener {
            if (answer3!!.text === mAnswer) {
                mScore++
                updateQuestion(questionNumber)
            } else {
                gameOver()
            }
        }
        answer4!!.setOnClickListener {
            if (answer4!!.text === mAnswer) {
                mScore++
                updateQuestion(questionNumber)
            } else {
                gameOver()
            }
        }
    }

    private fun updateQuestion(num: Int) {
        if (questionNumber < mQuestionsLength) {
            score!!.text = "Score: $mScore"
            question!!.text = mQuestions.getQuestion(num)
            answer1!!.text = mQuestions.getChoice1(num)
            answer2!!.text = mQuestions.getChoice2(num)
            answer3!!.text = mQuestions.getChoice3(num)
            answer4!!.text = mQuestions.getChoice4(num)
            mAnswer = mQuestions.getCorrectAnswer(num)
            questionNumber++
        } else {
            score!!.text = "Score: $mScore"
            gameWon()
        }
    }

    private fun gameOver() {
        val alertDialogBuilder = AlertDialog.Builder(this@activity_quiz)
        alertDialogBuilder
                .setMessage("You lose! Your score is $mScore points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME"
                ) { dialogInterface, i -> startActivity(Intent(applicationContext, activity_quiz::class.java)) }
                .setNegativeButton("EXIT"
                ) { dialogInterface, i -> finish() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun gameWon() {
        val alertDialogBuilder = AlertDialog.Builder(this@activity_quiz)
        alertDialogBuilder
                .setMessage("You won! Your score is $mScore points.")
                .setCancelable(false)
                .setPositiveButton("NEW GAME"
                ) { dialogInterface, i -> startActivity(Intent(applicationContext, activity_quiz::class.java)) }
                .setNegativeButton("EXIT"
                ) { dialogInterface, i -> finish() }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
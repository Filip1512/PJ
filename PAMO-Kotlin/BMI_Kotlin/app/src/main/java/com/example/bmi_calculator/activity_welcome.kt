package com.example.bmi_calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class activity_welcome : AppCompatActivity() {
    var buttonBmi: Button? = null
    var buttonQuiz: Button? = null
    var buttonGraph: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        buttonBmi = findViewById<View>(R.id.button_bmi) as Button
        buttonQuiz = findViewById<View>(R.id.button_quiz) as Button
        buttonGraph = findViewById<View>(R.id.button_graph) as Button
        buttonBmi!!.setOnClickListener { openBmiActivity() }
        buttonQuiz!!.setOnClickListener { openQuizActivity() }
        buttonGraph!!.setOnClickListener { openGraphActivity() }
    }

    fun openBmiActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun openQuizActivity() {
        val intent = Intent(this, activity_quiz::class.java)
        startActivity(intent)
    }

    fun openGraphActivity() {
        val intent = Intent(this, activity_graph::class.java)
        startActivity(intent)
    }
}
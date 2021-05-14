package com.example.bmi_calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var height: EditText? = null
    private var weight: EditText? = null
    private var result: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        height = findViewById<View>(R.id.height) as EditText
        weight = findViewById<View>(R.id.weight) as EditText
        result = findViewById<View>(R.id.result) as TextView
    }

    fun calcBMI(v: View?) {
        val heightStr = height!!.text.toString()
        val weightStr = weight!!.text.toString()
        if ("" != heightStr && weightStr != null && "" != weightStr) {
            val heightValue = heightStr.toFloat()
            val weightValue = weightStr.toFloat()
            val bmi = weightValue / (heightValue * heightValue) * (100 * 100)
            // 100*100 -> to count BMI we need height in meters, so I do recalculate from centimeters
            displayBMI(bmi)
        }
    }

    var dietToGainWeight = """
You should gain you weight! Here is example diet:
Posiłek 1
 Omlet, Płatki owsiane, Rodzynki
Posiłek 2
 Pierś z kurczaka, Ryż brązowy, Olej kokosowy, Świeże pomidory
Posiłek 3
 Pierś z kurczaka, Kasza jaglana, Olej kokosowy, Świeży ogórek
Posiłek 4
 Polędwica wołowa, Ryż biały, Ogórki kiszone
Posiłek 5
 Twaróg chudy, Olej kokosowy, Świeża papryka, rzodkiewka, szczypiorek (łącznie) 250g"""
    var dietIsOk = "\r\nYour diet is pretty good!"
    var dietToLoseWeight = """
You should lose some weight! Here is example diet:
Posiłek 1
 Jogurt naturalny, 2 kanapki z przysmakiem wołowym, pomidorem i sałatą, herbata lub kawa bez cukru albo 2 kanapki ze schabem i papryką
Posiłek 2
 2 kanapki z szynką i żółtym serem, ogórek, banan albo kanapka z bułki grahamki ze schabem, sałata i kiwiPosiłek 3
 Plaster szynki pieczonej, ziemniaki, marchewka z groszkiem, surówka (np. z cykorii) albo zraz z kaszą jęczmienną, fasolka szparagowa, surówka (np. z kapusty pekińskiej)posiłek 4
 Jogurt owocowy, 2 kanapki z polędwicą, owoce albo jogurt naturalny, 2 kanapki z przysmakiem wołowym i pomidorem"""

    fun displayBMI(bmi: Float) {
        var bmiLabel = ""
        bmiLabel = if (java.lang.Float.compare(bmi, 15f) <= 0) {
            getString(R.string.very_severely_underweight) + dietToGainWeight
        } else if (java.lang.Float.compare(bmi, 15f) > 0 && java.lang.Float.compare(bmi, 16f) <= 0) {
            getString(R.string.severely_underweight) + dietToGainWeight
        } else if (java.lang.Float.compare(bmi, 16f) > 0 && java.lang.Float.compare(bmi, 18.5f) <= 0) {
            getString(R.string.underweight) + dietToGainWeight
        } else if (java.lang.Float.compare(bmi, 18.5f) > 0 && java.lang.Float.compare(bmi, 25f) <= 0) {
            getString(R.string.normal) + dietIsOk
        } else if (java.lang.Float.compare(bmi, 25f) > 0 && java.lang.Float.compare(bmi, 30f) <= 0) {
            getString(R.string.overweight) + dietToLoseWeight
        } else if (java.lang.Float.compare(bmi, 30f) > 0 && java.lang.Float.compare(bmi, 35f) <= 0) {
            getString(R.string.obese_class_i) + dietToLoseWeight
        } else if (java.lang.Float.compare(bmi, 35f) > 0 && java.lang.Float.compare(bmi, 40f) <= 0) {
            getString(R.string.obese_class_ii) + dietToLoseWeight
        } else {
            getString(R.string.obese_class_iii)
        }
        bmiLabel = """
               $bmi
               
               $bmiLabel
               """.trimIndent()
        result!!.text = bmiLabel
    }

    fun openSummaryActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_MESSAGE = "com.example.bmi_calculator.MESSAGE"
    }
}
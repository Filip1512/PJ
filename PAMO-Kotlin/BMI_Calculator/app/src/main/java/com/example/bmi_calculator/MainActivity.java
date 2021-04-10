package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.bmi_calculator.MESSAGE";

    private EditText height;
    private EditText weight;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        height = (EditText) findViewById(R.id.height);
        weight = (EditText) findViewById(R.id.weight);
        result = (TextView) findViewById(R.id.result);
    }

    public void calcBMI(View v){
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null & !"".equals(heightStr)
                && weightStr != null && !"".equals(weightStr)){
            float heightValue = Float.parseFloat(heightStr);
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue) * (100*100);
            // 100*100 -> to count BMI we need height in meters, so I do recalculate from centimeters

            displayBMI(bmi);
        }
    }

    String dietToGainWeight = "\r\nYou should gain you weight! Here is example diet:\n"
            + "Posiłek 1\n Omlet, Płatki owsiane, Rodzynki\n"
            + "Posiłek 2\n Pierś z kurczaka, Ryż brązowy, Olej kokosowy, Świeże pomidory\n"
            + "Posiłek 3\n Pierś z kurczaka, Kasza jaglana, Olej kokosowy, Świeży ogórek\n"
            + "Posiłek 4\n Polędwica wołowa, Ryż biały, Ogórki kiszone\n"
            + "Posiłek 5\n Twaróg chudy, Olej kokosowy, Świeża papryka, rzodkiewka, szczypiorek (łącznie) 250g";

    String dietIsOk = "\r\nYour diet is pretty good!";

    String dietToLoseWeight = "\r\nYou should lose some weight! Here is example diet:\n"
            + "Posiłek 1\n Jogurt naturalny, 2 kanapki z przysmakiem wołowym, pomidorem i sałatą, herbata lub kawa bez cukru albo 2 kanapki ze schabem i papryką\n"
            + "Posiłek 2\n 2 kanapki z szynką i żółtym serem, ogórek, banan albo kanapka z bułki grahamki ze schabem, sałata i kiwi"
            + "Posiłek 3\n Plaster szynki pieczonej, ziemniaki, marchewka z groszkiem, surówka (np. z cykorii) albo zraz z kaszą jęczmienną, fasolka szparagowa, surówka (np. z kapusty pekińskiej)"
            + "posiłek 4\n Jogurt owocowy, 2 kanapki z polędwicą, owoce albo jogurt naturalny, 2 kanapki z przysmakiem wołowym i pomidorem";


    public void displayBMI(float bmi){
        String bmiLabel = "";

        if (Float.compare(bmi,15f) <= 0){ bmiLabel = getString(R.string.very_severely_underweight) + dietToGainWeight; }
        else if (Float.compare(bmi,15f) > 0 && Float.compare(bmi,16f) <= 0)
        { bmiLabel = getString((R.string.severely_underweight)) + dietToGainWeight; }
        else if (Float.compare(bmi,16f) > 0 && Float.compare(bmi,18.5f) <= 0)
        { bmiLabel = getString((R.string.underweight)) + dietToGainWeight; }
        else if (Float.compare(bmi,18.5f) > 0 && Float.compare(bmi,25f) <= 0)
        { bmiLabel = getString((R.string.normal)) + dietIsOk; }
        else if (Float.compare(bmi,25f) > 0 && Float.compare(bmi,30f) <= 0)
        { bmiLabel = getString((R.string.overweight)) + dietToLoseWeight; }
        else if (Float.compare(bmi,30f) > 0 && Float.compare(bmi,35f) <= 0)
        { bmiLabel = getString((R.string.obese_class_i)) + dietToLoseWeight; }
        else if (Float.compare(bmi,35f) > 0 && Float.compare(bmi,40f) <= 0)
        { bmiLabel = getString((R.string.obese_class_ii)) + dietToLoseWeight; }
        else
        { bmiLabel = getString((R.string.obese_class_iii)); }

        bmiLabel = bmi + "\n\n" + bmiLabel;
        result.setText(bmiLabel);

    }

    public void openSummaryActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
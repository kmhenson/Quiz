package com.example.kmhenson.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateScore(View view) {
        RadioGroup[] questions = allRadioGroups();
        //this part looks to make sure all the questions have been answered
        for (int i = 0; i < 7; i++) {
            if (questions[i].getCheckedRadioButtonId() == -1) {
                int time = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(getApplicationContext(), "Please Answer All the Questions", time);
                toast.show();
                return;
            }
        }
        //now we have to go through and make sure all the questions are correct
        int numCorrect = 0;
        if (checkOne())
            numCorrect++;
        if (checkTwo())
            numCorrect++;
        if (checkThree())
            numCorrect++;
        if (checkFour())
            numCorrect++;
        if (checkFive())
            numCorrect++;
        if (checkSix())
            numCorrect++;
        if(checkSeven())
            numCorrect++;
        int score = (int)(((double)numCorrect/7.0)*100.0);
        String answer = "You answered "+numCorrect+" out of 7 correctly. Your score is "+score+"%";
        TextView textViewToChange = (TextView) findViewById(R.id.finalscore);
        textViewToChange.setText(answer);
    }

    public boolean checkOne() {
        RadioButton correct = (RadioButton) findViewById(R.id.hollow);
        if (correct.isChecked())
            return true;
        return false;
    }

    public boolean checkTwo() {
        RadioButton correct = (RadioButton) findViewById(R.id.buckbeak);
        if (correct.isChecked())
            return true;
        return false;
    }

    public boolean checkThree() {
        RadioButton correct = (RadioButton) findViewById(R.id.ollivander);
        if (correct.isChecked())
            return true;
        return false;
    }

    public boolean checkFour() {
        RadioButton correct = (RadioButton) findViewById(R.id.otter);
        if (correct.isChecked())
            return true;
        return false;
    }

    public boolean checkFive() {
        RadioButton correct = (RadioButton) findViewById(R.id.jerk);
        if (correct.isChecked())
            return true;
        return false;
    }

    public boolean checkSix() {
        RadioButton correct = (RadioButton) findViewById(R.id.fluff);
        if (correct.isChecked())
            return true;
        return false;
    }

    public boolean checkSeven() {
        RadioButton correct = (RadioButton) findViewById(R.id.padma);
        if (correct.isChecked())
            return true;
        return false;
    }

    //puts all the radio groups into an array together
    public RadioGroup[] allRadioGroups() {
        RadioGroup[] RadioArray = new RadioGroup[7];
        RadioArray[0] = (RadioGroup) findViewById(R.id.birthradio);
        RadioArray[1] = (RadioGroup) findViewById(R.id.hippogriffgroup);
        RadioArray[2] = (RadioGroup) findViewById(R.id.wandRadio);
        RadioArray[3] = (RadioGroup) findViewById(R.id.patronus);
        RadioArray[4] = (RadioGroup) findViewById(R.id.snape);
        RadioArray[5] = (RadioGroup) findViewById(R.id.crookshanks);
        RadioArray[6] = (RadioGroup) findViewById(R.id.ron);
        return RadioArray;
    }


}


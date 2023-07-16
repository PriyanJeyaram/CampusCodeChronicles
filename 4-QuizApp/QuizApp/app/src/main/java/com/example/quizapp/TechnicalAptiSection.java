package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class TechnicalAptiSection extends AppCompatActivity{

    TextView qn;
    RadioGroup rg;
    RadioButton opt1, opt2, opt3, opt4, rb;
    Button next;

    String[] questions = {
            "80, 10, 70, 15, 60, … ",
            "AMB, CLB, BKC, DJC, ______",
            "Paw : Cat :: Hoof : ?"
    };

    String[][] answers = {
            {"20", "25", "30", "50"}, //20
            {"EIF", "CJD", "EID", "EIA"}, //3:2
            {"Lamb", "Horse", "Elephant", "Tiger"} //4
    };

    String[] correctAns  = {
            "20",
            "EID",
            "Horse"
    };
    int totalQns = questions.length;
    int count = 0;
    int score = 0;
    String userName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.technical_aptitude_activity);

        // Get from Intent
        Bundle b = getIntent().getExtras();
        userName = b.getString("userName");
        score = b.getInt("scoreCard");

        setQnAndAns(count);

        next = findViewById(R.id.button4);
        next.setOnClickListener(view -> {
            //Check for correct Ans, update the score, if totalQns == count move to next activity, else increment count and setQnAndAns
            if (checkAns(count)) {
                score++;
                Toast.makeText(getApplicationContext(), userName + "'s Score: " + score, Toast.LENGTH_SHORT).show();
            }
            if (count < totalQns - 1) {
                setQnAndAns(++count);
            } else {
                Intent i5 = new Intent(getApplicationContext(), FinalScoreSection.class);
                i5.putExtra("userName", userName);
                i5.putExtra("scoreCard", score);
                startActivity(i5);
//                    Toast.makeText(getApplicationContext(), userName + "'s Score: " + score, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void setQnAndAns(int i) {
        qn = findViewById(R.id.textView10);
        opt1 = findViewById(R.id.radioButton);
        opt2 = findViewById(R.id.radioButton2);
        opt3 = findViewById(R.id.radioButton3);
        opt4 = findViewById(R.id.radioButton4);

        qn.setText(questions[i]);
        opt1.setText(answers[i][0]);
        opt2.setText(answers[i][1]);
        opt3.setText(answers[i][2]);
        opt4.setText(answers[i][3]);

    }

    public boolean checkAns(int i) {
        rg = findViewById(R.id.radioGroup);
        rb = findViewById(rg.getCheckedRadioButtonId());
        return (correctAns[i].contentEquals(rb.getText()));
    }
}
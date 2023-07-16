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

public class GeneralAptiSection extends AppCompatActivity{

    TextView qn;
    RadioGroup rg;
    RadioButton opt1, opt2, opt3, opt4, rb;
    Button next;

    String[] questions = {
            "A train running at the speed of 60 km/hr crosses a pole in 9 seconds. What is the length of the train?",
            "Two trains running in opposite directions cross a man standing on the platform in 27 seconds and 17 seconds respectively and they cross each other in 23 seconds. The ratio of their speeds is:",
            "The sum of ages of 5 children born at the intervals of 3 years each is 50 years. What is the age of the youngest child?"
    };

    String[][] answers = {
            {"120 metres", "324 metres", "150 metres", "180 metres"}, //150
            {"1:3", "3:2", "3:4", "None of these"}, //3:2
            {"4 years", "8 years", "10 years", "None of these"} //4
    };

    String[] correctAns  = {
            "150 metres",
            "3:2",
            "4 years"
    };
    int totalQns = questions.length;
    int count = 0;
    int score = 0;
    String userName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_aptitude_activity);

        // Get from Intent
        Bundle b = getIntent().getExtras();
        userName = b.getString("userName");
        score = b.getInt("scoreCard");

        setQnAndAns(count);

        next = findViewById(R.id.button3);
        next.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                //Check for correct Ans, update the score, if totalQns == count move to next activity, else increment count and setQnAndAns
                if (checkAns(count)) {
                    score++;
                    Toast.makeText(getApplicationContext(), userName + "'s Score: " + score, Toast.LENGTH_SHORT).show();
                }
                if (count < totalQns - 1) {
                    setQnAndAns(++count);
                } else {
                    Intent i3 = new Intent(getApplicationContext(), LogicalAptiSection.class);
                    i3.putExtra("userName", userName);
                    i3.putExtra("scoreCard", score);
                    startActivity(i3);
                    Toast.makeText(getApplicationContext(), userName + "'s Score: " + score, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void setQnAndAns(int i) {
        qn = findViewById(R.id.textView8);
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

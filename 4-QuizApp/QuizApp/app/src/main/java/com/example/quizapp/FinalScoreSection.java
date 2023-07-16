package com.example.quizapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
public class FinalScoreSection extends AppCompatActivity{
    String userName;
    int score;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_score_activity);

        Bundle b = getIntent().getExtras();
        userName = b.getString("userName");
        score = b.getInt("scoreCard");

        new AlertDialog.Builder(this)
                .setMessage("User: " + userName + "Score: " + score)
                .setTitle("Quiz Attempted")
                .setPositiveButton("Restart Quiz", (dialogInterface, i) -> {
                    Intent in = new Intent(getApplicationContext(), HomeActivity.class);
                    in.putExtra("userName", userName);
                    in.putExtra("scoreCard", score);
                    startActivity(in);
                })
                .setNegativeButton("Retry Later", (dialogInterface, i) -> {
                    Intent in1 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(in1);
                })
                .setCancelable(false)
                .show();
    }
 }

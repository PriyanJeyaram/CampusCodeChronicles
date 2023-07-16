package com.example.quizapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity{
    String userName;
    int score = 0;

    @SuppressLint("SetTextI18n")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        TextView e1 = findViewById(R.id.textView6);
        TextView e2 = findViewById(R.id.textView7);
        Button startQuiz = findViewById(R.id.button2);

        Bundle b = getIntent().getExtras();
        userName = b.getString("userName");
        score = b.getInt("scoreCard");

        e2.setText("0" + String.valueOf(score));
        e1.append(userName);

        startQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(HomeActivity.this.getApplicationContext(), GeneralAptiSection.class);
                i2.putExtra("userName", userName);
                i2.putExtra("scoreCard", 0);
                HomeActivity.this.startActivity(i2);
            }
        });
    }
}

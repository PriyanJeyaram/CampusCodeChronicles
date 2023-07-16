package com.example.mediaplayerservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton, stopButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.button);
        stopButton = findViewById(R.id.button2);

        startButton.setOnClickListener(view -> {
            startService(new Intent(this, MyService.class));
        });

        stopButton.setOnClickListener(view -> {
            stopService(new Intent(this, MyService.class));
        });
    }
}
package com.Priyan.athletemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edName, edAge, edHeight, edWeight, edGame;
    Button addButton;
    TextView tvDisplayRecords;
    CustomDbHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        So lets instantiate the components declared
        edName = findViewById(R.id.editTextTextPersonName);
        edGame = findViewById(R.id.editTextTextPersonName2);
        edAge = findViewById(R.id.editTextNumber);
        edHeight = findViewById(R.id.editTextNumber2);
        edWeight = findViewById(R.id.editTextNumber3);
        addButton = findViewById(R.id.button3);
        tvDisplayRecords = findViewById(R.id.textView6);
        handler = new CustomDbHandler(this);

        addButton.setOnClickListener(view -> {
            String name = edName.getText().toString().trim();
            String game = edGame.getText().toString().trim();
            String age = edAge.getText().toString().trim();
            String height = edHeight.getText().toString().trim();
            String weight = edWeight.getText().toString().trim();
            if(name.isEmpty() || game.isEmpty() || age.isEmpty() || height.isEmpty() || weight.isEmpty()) {
                addButton.setBackgroundColor(Color.RED);
                Toast.makeText(this, "Some Fields Empty", Toast.LENGTH_SHORT).show();
            }else {
                if (handler.addAthlete(name, Integer.parseInt(age), Double.parseDouble(height), Double.parseDouble(weight), game)) {
                    addButton.setBackgroundColor(Color.rgb(245, 124, 0));
                    Toast.makeText(this, "Insertion Success!!", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(this, "Insertion Failure!!", Toast.LENGTH_SHORT).show();
            }
        });

        tvDisplayRecords.setOnClickListener(view -> {
            startActivity(new Intent(this, PlayerActivity.class));
        });
    }
}
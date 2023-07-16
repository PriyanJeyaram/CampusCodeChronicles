package com.priyan.ordermypizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    Button customizeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Link to XML
        ed1 = findViewById(R.id.editTextTextPersonName);
        ed2 = findViewById(R.id.editTextTextPersonName2);
        customizeButton = findViewById(R.id.button);

        customizeButton.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, Customizer.class);
            i.putExtra("CustomerName", ed1.getText().toString());
            i.putExtra("CustomerPhone", ed2.getText().toString());
            startActivity(i);
        });

    }
}
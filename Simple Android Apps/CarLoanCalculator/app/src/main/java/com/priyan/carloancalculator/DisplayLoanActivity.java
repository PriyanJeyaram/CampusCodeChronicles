package com.priyan.carloancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class DisplayLoanActivity extends AppCompatActivity {

    TextView tv;
    Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_loan);

//        Get from Bundle
        Bundle bundle = getIntent().getExtras();
        String emi = String.valueOf(bundle.getDouble("emi"));
//        Link to XML
        tv = findViewById(R.id.textView6);
        backButton = findViewById(R.id.button2);
        tv.setText(emi);
        backButton.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}
package com.priyan.carloancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] tenureArr = {"2", "3", "4"};
    int n;
    double r = 0.09;
    long carPrice, downPayment, P;
    EditText ed1, ed2;
    Spinner s1;
    Button calcButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Link to XML
        ed1 = findViewById(R.id.editTextNumber);
        ed2 = findViewById(R.id.editTextNumber2);
        s1 = findViewById(R.id.spinner);
        calcButton = findViewById(R.id.button);

//        Set the spinners
        ArrayAdapter<String> a1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tenureArr);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(a1);

        calcButton.setOnClickListener(view -> {
            carPrice = Long.parseLong(ed1.getText().toString());
            downPayment = Long.parseLong(ed2.getText().toString());
            P = carPrice - downPayment;
            Toast.makeText(this, "Loan Amt:" + P, Toast.LENGTH_SHORT).show();
            n = Integer.parseInt(String.valueOf(s1.getSelectedItem()));
            n *= 12; //Number of Months;
            double v = Math.pow((1 + r), n) / (Math.pow((1 + r), n) - 1);
            double emi = P*r*v;
            Intent i = new Intent(MainActivity.this, DisplayLoanActivity.class);
            i.putExtra("emi", emi);
            startActivity(i);
        });
    }
}
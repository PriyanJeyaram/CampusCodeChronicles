package com.priyan.ordermypizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class DisplayCustomerOrderActivity extends AppCompatActivity {

    Button okayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_customer_order);

        Bundle b = getIntent().getExtras();
        String msg = "Order Details: \n"
                + "Customer Name: " + b.getString("CustomerName") + "\n"
                + "Customer Phone: " + b.getString("CustomerPhone") + "\n"
                + "Shape: " + b.getString("Shape") + "\n"
                + "Sauce: "+ b.getString("Sauce") + "\n"
                + "Cheese: " + b.getString("Cheese") + "\n"
                + "Toppings: " + b.getString("Toppings") + "\n"
                + "Meat: " + b.getString("Meat") + "\n";
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

        okayButton = findViewById(R.id.button4);
        okayButton.setOnClickListener(view -> {
            startActivity(new Intent(this, MainActivity.class));
        });
    }
}
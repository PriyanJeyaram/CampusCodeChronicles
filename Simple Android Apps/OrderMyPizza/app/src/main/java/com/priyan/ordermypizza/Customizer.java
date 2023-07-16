package com.priyan.ordermypizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Customizer extends AppCompatActivity {

    Spinner s1,s2,s3,s4,s5;
    Button b1;
    String cusName, cusPhone;

    //    Source: https://pieology.com/menu/create-your-own-custom-pizza/
    String[] shapeArr = {"Circle", "Square", "Rectangle"};
    String[] sauceArr = {"Ranch", "Garlic", "Marinara", "BBQ", "Hot Sauce"};
    String[] cheeseArr = {"Mozzarella", "Ricotta", "Gorgonzola", "Parmesan", "Daiya Mozzarella(vegan)"};
    String[] toppingsArr = {"Artichokes", "Banana peppers", "black olives", "grape tomatoes", "green peppers", "jalapenos", "mushrooms", "pineapple", "Roasted red peppers", "garlic", "red onions", "cilantro and spinach"};
    String[] meatArr = {"Meatballs", "All-Natural Chicken", "bacon", "pepperoni", "spicy italian sausage", "sausage", "“Beef” Meatballs(Vegan)", "Spicy Italian “Sausage” Rounds (Vegan)"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customizer);

//        Get Data from Bundle
        Bundle b = getIntent().getExtras();
        cusName = b.getString("CustomerName");
        cusPhone = b.getString("CustomerPhone");

//        Link with XML
        s1 = findViewById(R.id.spinner);
        s2 = findViewById(R.id.spinner2);
        s3 = findViewById(R.id.spinner3);
        s4 = findViewById(R.id.spinner4);
        s5 = findViewById(R.id.spinner5);
        b1 = findViewById(R.id.button2);

        ArrayAdapter<String> a1 = new ArrayAdapter<>(this, R.layout.spinner_item, shapeArr);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(a1);

        ArrayAdapter<String> a2 = new ArrayAdapter<>(this, R.layout.spinner_item, sauceArr);
        a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(a2);

        ArrayAdapter<String> a3 = new ArrayAdapter<>(this, R.layout.spinner_item, cheeseArr);
        a3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(a3);

        ArrayAdapter<String> a4 = new ArrayAdapter<>(this, R.layout.spinner_item, toppingsArr);
        a4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s4.setAdapter(a4);

        ArrayAdapter<String> a5 = new ArrayAdapter<>(this, R.layout.spinner_item, meatArr);
        a5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s5.setAdapter(a5);

        b1.setOnClickListener(view -> {
            Intent i = new Intent(Customizer.this, DisplayCustomerOrderActivity.class);
            i.putExtra("Shape", String.valueOf(s1.getSelectedItem()));
            i.putExtra("Sauce", String.valueOf(s2.getSelectedItem()));
            i.putExtra("Cheese", String.valueOf(s3.getSelectedItem()));
            i.putExtra("Toppings", String.valueOf(s4.getSelectedItem()));
            i.putExtra("Meat", String.valueOf(s5.getSelectedItem()));
            i.putExtra("CustomerName", cusName);
            i.putExtra("CustomerPhone", cusPhone);

            startActivity(i);
        });

    }
}
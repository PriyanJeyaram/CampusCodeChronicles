package com.priyan.carspecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner brandSpinner, modelSpinner;
    Button displayButton;
    String[] brandArr = {"--Choose brand name--", "Honda", "Toyota", "Chevrolet", "Ford"};
    ArrayList<String> modelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Init modelList
        modelList.add("--Choose model name--");
//        Link to XML
        brandSpinner = findViewById(R.id.spinner);
        modelSpinner = findViewById(R.id.spinner2);
        displayButton = findViewById(R.id.button);

//        Set the Spinners
        ArrayAdapter<String> brandAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, brandArr);
        brandAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        brandSpinner.setAdapter(brandAdapter);
        brandSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String chosenBrand = String.valueOf(brandSpinner.getSelectedItem());
                switch(chosenBrand) {
                    case "Honda":
                        modelList.clear();
                        modelList.add("--Choose model name--");
                        modelList.add("Honda Accord");
                        modelList.add("Honda Civic");
                        break;
                    case "Toyota":
                        modelList.clear();
                        modelList.add("--Choose model name--");
                        modelList.add("Toyota Corolla");
                        break;
                    case "Chevrolet":
                        modelList.clear();
                        modelList.add("--Choose model name--");
                        modelList.add("Chevrolet Corvette");
                        break;
                    case "Ford":
                        modelList.clear();
                        modelList.add("--Choose model name--");
                        modelList.add("Ford Taurus");
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ArrayAdapter<String> modelAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, modelList);
        modelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modelSpinner.setAdapter(modelAdapter);

        displayButton.setOnClickListener(view -> {
            Intent i = new Intent(MainActivity.this, DisplayActivity.class);
            i.putExtra("BrandName", String.valueOf(brandSpinner.getSelectedItem()));
            i.putExtra("ModelName", String.valueOf(modelSpinner.getSelectedItem()));
            startActivity(i);
        });

    }
}
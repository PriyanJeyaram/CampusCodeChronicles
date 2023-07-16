package com.priyan.cabbooking;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner s1,s2,s3;
    EditText e1;
    Button b;
    String[] places = {"Madurai", "Theni", "Chennai", "Coimbatore", "Rajapalayam", "Thirunelveli"};
    ArrayList<String> to = new ArrayList<>();
    String[] type = {"Micro", "Mini", "Prime"};
    static String prev = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to.add("Madurai");
        to.add("Theni");
        to.add("Chennai");
        to.add("Coimbatore");
        to.add("Rajapalayam");
        to.add("Thirunelveli");
//        Get References
        s1 = findViewById(R.id.spinner2);
        s2 = findViewById(R.id.spinner);
        s3 = findViewById(R.id.spinner3);
        e1 = findViewById(R.id.editTextTextPersonName);
        b = findViewById(R.id.button);

//        Set the spinners
        ArrayAdapter<String> a1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, places);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(a1);
        s1.setOnItemSelectedListener(this);

        ArrayAdapter<String> a3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, type);
        a3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s3.setAdapter(a3);

        b.setOnClickListener(view -> {
//            Get the details
            String from = String.valueOf(s1.getSelectedItem());
            String to = String.valueOf(s2.getSelectedItem());
            String type = String.valueOf(s3.getSelectedItem());
            String time = String.valueOf(e1.getText());
            String message = "Booking Confirmed!\nFrom: " + from + "\nTo: " + to + "\nType: " + type + "\nTime: " + time;
            Uri uri=Uri.parse("smsto:7010129936");
            Intent intent=new Intent(Intent.ACTION_SENDTO,uri);
            intent.putExtra("sms_body", message);
            startActivity(intent);
        });



    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        to.add(prev);
        String f = String.valueOf(s1.getSelectedItem());
        prev = f;
        to.remove(f);
        ArrayAdapter<String> a2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, to);
        a2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(a2);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
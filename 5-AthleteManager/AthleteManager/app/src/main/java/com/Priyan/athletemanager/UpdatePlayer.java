package com.Priyan.athletemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdatePlayer extends AppCompatActivity {

    int tempId;
    EditText tv1,tv2,tv3,tv4,tv5;
    CustomDbHandler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);

        Bundle bundle = getIntent().getExtras();
        tempId = bundle.getInt("id");
        handler = new CustomDbHandler(this);
         tv1 = findViewById(R.id.editTextTextPersonName);
         tv2 = findViewById(R.id.editTextNumber);
         tv3 = findViewById(R.id.editTextNumber2);
         tv4 = findViewById(R.id.editTextNumber3);
         tv5 = findViewById(R.id.editTextTextPersonName2);
        Button updateButton = findViewById(R.id.button3);



        updateButton.setOnClickListener(view -> {
            String name = tv1.getText().toString();
            int age= Integer.parseInt(tv2.getText().toString());
            double ht= Double.parseDouble( tv3.getText().toString());
            double wt= Double.parseDouble(tv4.getText().toString());
            String game =  tv5.getText().toString();
            if(handler.updateAthlete(tempId, name, age, ht, wt, game)){
                Toast.makeText(this, "Updating Success", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this,"Failure", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
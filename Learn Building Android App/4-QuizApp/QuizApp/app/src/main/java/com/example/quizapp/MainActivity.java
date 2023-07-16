package com.example.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String, String> loginCredentials = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText e1 = findViewById(R.id.editTextTextPersonName);
        EditText e2 = findViewById(R.id.editTextTextPassword);
        Button b = findViewById(R.id.button);

        loginCredentials.put("priyan", "priyan1804");
        loginCredentials.put("admin", "admin@123");

        b.setOnClickListener(view -> {

            String userName = String.valueOf(e1.getText());
            String password = String.valueOf(e2.getText());

            if(loginCredentials.containsKey(userName) && password.equals(loginCredentials.get(userName))) {
//                    Move to next Activity
                Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                i.putExtra("userName", userName);
                i.putExtra("scoreCard", 0);
                startActivity(i);

            }else {
                AlertDialog.Builder b1 = new AlertDialog.Builder(MainActivity.this);
                b1.setTitle("Invalid Credentials");
                b1.setMessage("UserName or Password is incorrect!");
                b1.setCancelable(false);
                b1.setPositiveButton("Retry", (dialogInterface, i) -> dialogInterface.cancel());
                AlertDialog a = b1.create();
                e1.setText("");
                e2.setText("");
                a.show();
            }
        });
    }
}